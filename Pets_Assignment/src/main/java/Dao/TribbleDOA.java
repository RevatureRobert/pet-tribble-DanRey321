package Dao;

import model.Tribble;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.jdbcConnect;

public class TribbleDOA {

    public List<Tribble> viewAll() throws SQLException {
        String sqlQuery = "select * from tribble";
        List<Tribble> tribbleList = new ArrayList<>();

        try(Connection connection = jdbcConnect.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String color = rs.getString(3);
                String noise = rs.getString(4);
                String description = rs.getString(5);

                Tribble tribble = new Tribble(id, name, color, noise, description);
                tribbleList.add(tribble);

            }
            for (Tribble value : tribbleList) {
                System.out.println(value);
            }
            return tribbleList;

        }

    }

    public Tribble deleteTribble(String name){
        String sqlQuery = "Delete from tribble where name = ?";
        try(Connection connection = jdbcConnect.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, name);
            if (stmt.executeUpdate() < 1) {
                throw new SQLException("Deleting failed, no rows affected");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }



    public Tribble addTribble(String name, String color, String noise, String description){
        String sqlQuery = "Insert into tribble(name, color, noise, description)"
                + "Values (?, ?, ? , ?)";

        try(Connection connection = jdbcConnect.getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, name);
            pstmt.setString(2, color);
            pstmt.setString(3, noise);
            pstmt.setString(4, description);

            if(pstmt.executeUpdate() != 1){
                throw new SQLException("Insert Failed");
            }
            connection.commit();
            return new Tribble(name, color, noise, description);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public Tribble addTribble(Tribble tribble){
        String sqlQuery = "Insert into tribble(name, color, noise, description)"
                + "Values (?, ?, ? , ?)";

        try(Connection connection = jdbcConnect.getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, tribble.getName());
            pstmt.setString(2, tribble.getColor());
            pstmt.setString(3, tribble.getNoise());
            pstmt.setString(4, tribble.getDescription());

            if(pstmt.executeUpdate() != 1){
                throw new SQLException("Insert Failed");
            }
            connection.commit();
            return new Tribble(tribble.getName(), tribble.getColor(), tribble.getNoise(), tribble.getDescription());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }

    public Tribble updateName(int id, String newName){
        String sqlQuery = "update tribble set name = ? where id = ?";

        try(Connection connection = jdbcConnect.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sqlQuery);
            stmt.setInt(2, id);
            stmt.setString(1, newName);

            if(stmt.executeUpdate() < 1){
                throw new SQLException("Update Failed");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
