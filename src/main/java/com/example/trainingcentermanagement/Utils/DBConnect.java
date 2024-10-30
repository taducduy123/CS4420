package com.example.trainingcentermanagement.Utils;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class DBConnect {

    private static DBConnect instance;

    private static Connection connection;           // To create connection between Java and MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/training_center";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "duy732003";

    private QueryRunner queryRunner;                // To use QueryRunner => include library of it into pom.xml

    //--------------------------------------------------------------------

    // Private Contructor (=> Singleton)
    private DBConnect() {
        System.out.println("DBConnect Constructor is created.............");
        try {
            // Register the Oracle JDBC driver with DriverManager
            Class.forName("com.mysql.jdbc.Driver");

            // Create connection between Java and Database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize QueryRunner
        queryRunner = new QueryRunner();
    }


    // In order for codes outside this class to initialize a DBConnect object, they must use this function.
    // This function ensures that there is AT MOST 1 object DBConnect being existed during the
    // lifetime of the application.
    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }


    // Close Connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.........");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    // Show connection details
    public static void showDatabaseDetails() {
        if (connection != null) {
            try {
                System.out.println("connection established........");
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
                System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
                System.out.println("Driver Name: " + metaData.getDriverName());
                System.out.println("Driver Version: " + metaData.getDriverVersion());
                System.out.println("URL: " + metaData.getURL());
                System.out.println("Username: " + metaData.getUserName());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    // Execute SQLs WITH having return values (return Model data type only)
    public <T> List<T> executeReturnQuery(String sql, Class<T> type, Object... parameters){

        BasicRowProcessor rowProcess = new BasicRowProcessor();
        BeanListHandler<T> handler = new BeanListHandler<T>(type, rowProcess);
        try {
            return queryRunner.query(connection, sql, handler, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    // Execute SQLs WITH having return values (return primitive data type only)
    public <T> List<T> executeReturnPrimitiveTypeQuery(String sql, Class<T> type, Object... parameters) {
        ColumnListHandler<T> handler = new ColumnListHandler<>();
        try {
            return queryRunner.query(connection, sql, handler, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Execute SQLs WITHOUT having return values
    public int executeVoidQuery(String sql, Object... parameters){

        try {
            return queryRunner.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    // Embedded Main for Testing if the connection is successful
    public static void main(String[] args) {
        DBConnect.instance = new DBConnect();
        instance.showDatabaseDetails();
        instance.closeConnection();
    }
}
