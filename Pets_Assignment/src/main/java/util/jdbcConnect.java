package util;

import org.postgresql.Driver;

import java.sql.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcConnect {
    public  static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://samplecar.csuhfolohico.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=public";
        String username = "danrey321";
        String password = "password";

        Connection connection = null;

        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(url, username, password);



        return connection;
    }

}
