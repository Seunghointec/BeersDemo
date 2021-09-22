package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {

    public static Connection getConnection() throws SQLException {
        return DriverManager
                .getConnection
                        ("jdbc:mysql://85.28.108.212:33062/suengho", "suengho123", "suengho123");
    }
}