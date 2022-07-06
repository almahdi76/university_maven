package com.almahdi.university.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


    public class DBconnection {
        private static final String HOST = "127.0.0.1";
        private static final int PORT = 5432;
        private static final String DB_NAME = "univerdityDB";
        private static final String USERNAME = "postgres";
        private static final String PASSWORD = "abdo";
        static String url = "jdbc:postgresql://localhost:5432/univerdityDB";
        static String userName = "postgres";
        static String password = "abdo";

        private static Connection connection;

        public static Connection getConnection() {
            try {
                //connection=DriverManager.getConnection(url,userName,password);
                connection = DriverManager.getConnection(String.format("jdbc:postgresql://%s:%d/%s", HOST, PORT, DB_NAME), USERNAME, PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }


