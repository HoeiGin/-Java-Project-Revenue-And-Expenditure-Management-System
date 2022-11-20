package com.ProjectPracitce.java;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginFrame {
    private static User once = null;

    public static User getOnce() {
        if (once == null) {
            once = new User();
        }
        return once;
    }

    /**
     * 获取管理员数据库中的数据
     * @return 返回管理员资料数组
     */
    private static List<User> getSQL() {
        List<User> userList = new ArrayList<User>();
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM billbook.users");
            while (rs.next()) {
                User person = new User();
                person.setId(rs.getInt("id"));
                person.setFindId(rs.getString("findid"));
                person.setUsername(rs.getString("username"));
                person.setPassword(rs.getString("password"));
                person.setTelephone(rs.getString("telephone"));
                userList.add(person);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    /**
     * 登录函数
     * @param UsN 输入的用户名
     * @param PsW 输入的密码
     * @return 登录与否的标志（布尔值）
     */
    public static boolean Login(String UsN, String PsW) {
        List<User> user = getSQL();
        for (User person: user) {
            if (person.returnUsername().equals(UsN)) {
                if (person.returnPassword().equals(PsW)) {
                    System.out.println("Login successful!");
                    return true;
                }
                else {
                    System.out.println("Wrong password! Do you want to try again?(1.Yes / 2.No)");
                    Scanner Input = new Scanner(System.in);
                    int index = Input.nextInt();
                    if (index == 1) {
                        String skip = Input.nextLine();
                        int times = 4;
                        while (times > 0) {
                            System.out.println("Please enter the password again!(Now you only have " + times + " chances)");

                            String againPsW = Input.nextLine();
                            if (person.returnPassword().equals(againPsW)) {
                                System.out.println("Login successful!");
                                return true;
                            }
                            else {
                                times -= 1;
                                if (times == 0) {
                                    return false;
                                }
                                System.out.println("Wrong password! Do you want to try again?(1.Yes / 2.No)");
                                int newIndex = Input.nextInt();
                                if (newIndex == 2) {
                                    return false;
                                }
                                String newSkip = Input.nextLine();
                            }
                        }
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static boolean toLogin(String UsN, String PsW) {
        List<User> userList = getSQL();
        for (User factor: userList) {
            // factor.print();
            if (factor.returnUsername().equals(UsN)) {
                if (factor.returnPassword().equals(PsW)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 注册函数
     */
    public static void SignIn() {
        User toIn = new User();
        Scanner key = new Scanner(System.in);
        int realId = findMax().returnId() + 1;
        System.out.println("Your id in SQL: " + realId);
        toIn.setId(findMax().returnId() + 1);
        System.out.print("Please enter your findid: ");
        toIn.setFindId(key.nextLine());
        System.out.print("Please enter your username: ");
        toIn.setUsername(key.nextLine());
        System.out.print("Please enter your password: ");
        toIn.setPassword(key.nextLine());
        System.out.print("Please enter your telephone: ");
        toIn.setTelephone(key.nextLine());
        boolean flag = addToSQL(toIn);
        if (flag) {
            System.out.println("Success to sign up!");
        }
    }

    /**
     * 添加管理员函数
     * @param toAdd 待注册管理员的资料（User类型）
     * @return 注册成功与否的标志（布尔类型）
     */
    public static boolean addToSQL(User toAdd) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "INSERT INTO billbook.users(id, findid, username, password, telephone) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, toAdd.returnId());
            stmt.setString(2, toAdd.returnFindId());
            stmt.setString(3, toAdd.returnUsername());
            stmt.setString(4, toAdd.returnPassword());
            stmt.setString(5, toAdd.returnTelephone());
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 寻找数据库中管理员的最大id
     * @return 返回最大id的管理员
     */
    public static User findMax() {
        User max = new User();
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "SELECT * FROM billbook.users WHERE id = (SELECT MAX(id) FROM billbook.users) LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                max.setId(rs.getInt("id"));
                max.setFindId(rs.getString("findid"));
                max.setUsername(rs.getString("username"));
                max.setPassword(rs.getString("password"));
                max.setTelephone(rs.getString("telephone"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return max;
    }


}
