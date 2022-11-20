package com.ProjectPracitce.java;
import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class getConnection {
    private static Connection conn = null;

    /**
     * 连接数据库
     * @return
     */
    public static Connection getConn() {

        String license = "License.txt";
        // System.out.println("Required file: License.txt");
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(license));
        }
        catch (FileNotFoundException e) {
            System.out.println("You do not have sufficient permission to use the Software!");
            System.out.println("Please contact the service!");
            System.exit(-1);
        }
        String Username = inputStream.nextLine();
        String Password = inputStream.nextLine();

        // System.out.println("Username: " + Username);
        // System.out.println("Password: " + Password);

        inputStream.close();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/billbook";
            conn = DriverManager.getConnection(url, Username, Password);
        }
        catch (Exception e) {
            System.out.println("Fail to link the database!");
            e.printStackTrace();
        }
        return conn;
    }
}

