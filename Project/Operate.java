package com.ProjectPracitce.java;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.util.Date;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.filechooser.FileSystemView;

public class Operate {
    private static Operate instance = null;
    static ChartPanel jframe;

    public static Operate getInstance() {
        if (instance == null) {
            instance = new Operate();
        }
        return instance;
    }

    /**
     * 增添
     * @param toAdd 待添加的数据
     * @return 返回成功与否的标志
     */
    public static boolean saveOperate(DateReady toAdd) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sqllnset = "INSERT INTO billbook.spend(id, type, datetime, cost, notes) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sqllnset);
            stmt.setInt(1, toAdd.returnID());
            stmt.setString(2, toAdd.returnType());
            stmt.setString(3, toAdd.returnDate());
            stmt.setDouble(4, toAdd.returnCost());
            stmt.setString(5, toAdd.returnNotes());
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
     * 获取数据库数据
     * @return 返回含有所有数据的数组
     */
    public static List<DateReady> selectInfo() {
        List<DateReady> InfoList = new ArrayList<DateReady>();
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM billbook.spend");
            while (rs.next()) {
                DateReady toPrint = new DateReady();
                toPrint.setID(rs.getInt("id"));
                toPrint.setType(rs.getString("type"));
                toPrint.setDate(rs.getString("datetime"));
                toPrint.setCost(rs.getDouble("cost"));
                toPrint.setNotes(rs.getString("notes"));
                InfoList.add(toPrint);
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
        return InfoList;
    }

    /**
     * 修改耗费值
     * @param uid 要修改的数据的id
     * @param uCost 修改后的耗费值
     * @return 返回成功与否的标志
     */
    public static boolean updateCost(int uid, double uCost) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "UPDATE billbook.spend SET cost = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, uCost);
            stmt.setInt(2, uid);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                result = true;
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
        return result;
    }

    /**
     * 修改类型
     * @param uid 要修改的数据的id
     * @param uType 修改后的类型
     * @return 返回成功与否的标志
     */
    public static boolean updateType(int uid, String uType) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "UPDATE billbook.spend SET type = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, uType);
            stmt.setInt(2, uid);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                return true;
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
        return result;
    }

    /**
     * 修改日期
     * @param uid 要修改的数据的id
     * @param uDate 修改后的日期
     * @return 返回成功与否的标志
     */
    public static boolean updateDate(int uid, String uDate) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "UPDATE billbook.spend SET datetime = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, uDate);
            stmt.setInt(2, uid);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                return true;
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
        return result;
    }

    /**
     * 修改注释
     * @param uid 要修改的数据的id
     * @param uNote 修改后的注释
     * @return 返回成功与否的标志
     */
    public static boolean updateNote(int uid, String uNote) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "UPDATE billbook.spend SET notes = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, uNote);
            stmt.setInt(2, uid);
            int flag = stmt.executeUpdate();
            if (flag == 1) {
                return true;
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
        return result;
    }

    /**
     * 获取账本数据库内的最大id
     * @return 返回最大id值的所有数据
     */
    public static DateReady maxId() {
        DateReady max = new DateReady();
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "SELECT * FROM billbook.spend WHERE id = (SELECT MAX(id) FROM billbook.spend) LIMIT 1";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                max.setID(rs.getInt("id"));
                max.setType(rs.getString("type"));
                max.setDate(rs.getString("datetime"));
                max.setCost(rs.getDouble("cost"));
                max.setNotes(rs.getString("notes"));
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

    /**
     * 删除数据库条目
     * @param uid 要删除的条目的id
     * @return 返回成功与否的标志
     */
    public static boolean deleteInfo(int uid) {
        boolean result = false;
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "DELETE FROM billbook.spend WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, uid);
            int i = stmt.executeUpdate();
            if (i == 1) {
                result = true;
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
        return result;
    }

    /**
     * 打印数据库内的所有数据
     */
    public static void Table() {
        Connection conn = null;
        try {
            conn = getConnection.getConn();
            String sql = "SELECT id, type, datetime, cost, notes FROM billbook.spend";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("id \t type \t datetime \t cost \t notes");
            DateReady receive = new DateReady();
            while (rs.next()) {
                receive.setID(rs.getInt("id"));
                receive.setType(rs.getString("type"));
                receive.setDate(rs.getString("datetime"));
                receive.setCost(rs.getDouble("cost"));
                receive.setNotes(rs.getString("notes"));
                receive.Output();
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
    }

    /**
     * 将数据库表输出到桌面，以csv格式保存
     */
    public static void Export() {
        List<DateReady> aList = selectInfo();
        File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
        String dir = desktopDir.getAbsolutePath();
        String filePath = dir + "\\";
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String time = formatter.format(date);
        String fileName = "Data.csv";

        CSVPrinter printer = null;
        String toPath = filePath + time + " " + fileName;

        try {
            FileWriter writer = new FileWriter(toPath);
            printer = CSVFormat.EXCEL.print(writer);
            Object[] cells = {"id", "type", "datetime", "cost", "notes"};
            printer.printRecord(cells);
            for (DateReady factor: aList) {

                String[] sorted = factor.returnType().split("");
                String toPutIn = factor.cmp(sorted[0], sorted[1]);
                Object[] unit = {factor.returnID(),
                                 toPutIn,
                                 factor.returnDate(),
                                 factor.returnCost(),
                                 factor.returnNotes()};
                printer.printRecord(unit);
            }
            printer.flush();
            printer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 求费用总和
     * @param index 值为1 -> 求收入    值为0 -> 求指出
     * @param flag 值为true -> 精确到月份    值为false -> 精确到年份
     * @param year 年的限制
     * @param month 月的限制
     * @return 返回时间段内的费用总和
     */
    public static double Process(int index, boolean flag, String year, String month) {
        List<DateReady> uList = selectInfo();
        if (index == 1) {   // index = 1:income
            double monthIncome = 0;
            double yearIncome = 0;
            for (DateReady factor: uList) {
                String[] date = DateReady.turnData(factor);
                String[] type = (factor.returnType()).split("");
                if (type[0].equals("A")) {
                    if (flag) { // flag->true: month   ->false: year
                        if (date[0].equals(year)) {
                            if (date[1].equals(month)) {
                                monthIncome += factor.returnCost();
                            }
                        }
                    }
                    else {
                        if (date[0].equals(year)) {
                            yearIncome += factor.returnCost();
                        }
                    }
                }
            }
            if (flag) {
                return monthIncome;
            }
            return yearIncome;
        }
        else if (index == 0) {  // index = 2:spending
            double monthSpending = 0;
            double yearSpending = 0;
            for (DateReady factor: uList) {
                String[] date = DateReady.turnData(factor);
                String[] type = (factor.returnType()).split("");
                if (type[0].equals("a")) {
                    if (flag) { // flag->true: month   ->false: year
                        if (date[0].equals(year)) {
                            if (date[1].equals(month)) {
                                monthSpending += factor.returnCost();
                            }
                        }
                    }
                    else {
                        if (date[0].equals(year)) {
                            yearSpending += factor.returnCost();
                        }
                    }
                }
            }
            if (flag) {
                return monthSpending;
            }
            return yearSpending;
        }
        return -1;
    }

    /**
     * 求月度使用情况，带有简易的进度条
     * @param year 年份
     * @param month 月份
     */
    public static void Balance(String year, String month) {
        double In = Process(1, true, year, month);
        double Out = Process(0, true, year, month);

        System.out.println((In - Out) + " Yuan remaining this month");
        double used = Out / In;
        double unused = (In - Out) / In;
        int upBIT = (int) (used * 50);
        int downBIT = (int) (unused * 50);

        StringBuilder Pre = new StringBuilder();
        StringBuilder Sub = new StringBuilder();
        Pre.append("#".repeat(Math.max(0, upBIT)));
        Sub.append("-".repeat(Math.max(0, downBIT)));
        System.out.println(Pre + Sub.toString());
        System.out.println((Out) + " Used" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + (In - Out) + " Left");
    }

    /**
     * 月度账单
     * @param year 年份
     * @param month 月份
     */
    public static void MonthSummary(String year, String month) {
        List<DateReady> aList = selectInfo();

        System.out.println("id" + "\t" + "type" + "\t" + "datetime" + "\t" + "cost" + "\t" + "notes");
        for (DateReady factor: aList) {
            String[] date = DateReady.turnData(factor);
            if (date[0].equals(year) && date[1].equals(month)) {
                factor.Output();
            }
        }
    }









}
