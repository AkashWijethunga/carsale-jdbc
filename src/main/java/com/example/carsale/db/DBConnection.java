package com.example.carsale.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private final Connection connection;
    private DBConnection() throws SQLException, ClassNotFoundException {
        //load driver class to ram
        Class.forName("com.mysql.cj.jdbc.Driver");
        //establish connection with DB
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/afsd_06","root","1234");
    }

    public static DBConnection getDbConnection() throws SQLException, ClassNotFoundException {
        if(dbConnection==null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
