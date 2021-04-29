package Dao;

import model.Labs;
import model.Tribble;
import util.jdbcConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LabsDAO {

    public List<Labs> viewAll() throws SQLException{
        String sqlQuery = "select * from labs";
        List<Labs> labsList = new ArrayList<>();
        try(Connection connection = jdbcConnect.getConnection()){
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);

            while(rs.next()){
                int id = rs.getInt(1);
                String labName = rs.getString(2);
                int tribbleID = rs.getInt(3);

                Labs labs = new Labs(labName, tribbleID);
                labsList.add(labs);

            }
            for (Labs value : labsList) {
                System.out.println(value);
            }
            return labsList;

        }
    }

    public Labs deleteLab(String name){
        String sqlQuery = "Delete from labs where labName = ?";
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

    public Labs addLab(Labs lab){
        String sqlQuery = "Insert into labs(labname, tribbleID)"
                + "Values (?, ?)";

        try(Connection connection = jdbcConnect.getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
            pstmt.setString(1, lab.getLabName());
            pstmt.setInt(2, lab.getTribbleId());


            if(pstmt.executeUpdate() != 1){
                throw new SQLException("Insert Failed");
            }
            connection.commit();
            return new Labs( lab.getLabName(), lab.getTribbleId());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;


    }

    public Labs updateName(int id, String newName){
        String sqlQuery = "update lab set name = ? where id = ?";

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
