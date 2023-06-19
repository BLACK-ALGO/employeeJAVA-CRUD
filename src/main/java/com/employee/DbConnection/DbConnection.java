package com.employee.DbConnection;

// 
import java.sql.Connection;
// import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
// import java.sql.ResultSet;
import java.sql.SQLException;
// import java.sql.DriverManager;

public class DbConnection {
    private static String HOST ="localhost";
    private static int PORT = 3306;
    private static String DB_NAME = "employee";
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    

    /**
     * @return
     * @throws SQLException
     */
    public static Connection getConnect() throws SQLException{
        
        Connection connection =DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s",HOST,PORT,DB_NAME),USERNAME,PASSWORD) ;

        return connection;
      
        
    }




}
