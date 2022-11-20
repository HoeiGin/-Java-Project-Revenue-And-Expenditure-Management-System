package com.ProjectPracitce.java;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class DateReady {

    /**
     * 类型翻译函数
     * @param Pre 类型第一个字符对应收入或支出
     * @param Sub 类型第二个字符对应收入或支出的详细方式
     * @return 返回翻译后的使用类型
     */
    public static String cmp(String Pre, String Sub) {
        String reason = "";
        switch (Pre) {
            case "A" -> {
                reason += "Income -> ";
                switch (Sub) {
                    case "A" -> {
                        reason += "Salary";
                        return reason;
                    }
                    case "B" -> {
                        reason += "Pocket Money";
                        return reason;
                    }
                    case "C" -> {
                        reason += "Bonus";
                        return reason;
                    }
                    case "D" -> {
                        reason += "Others";
                        return reason;
                    }
                }
            }
            case "a" -> {
                reason += "Spending -> ";
                switch (Sub) {
                    case "a" -> {
                        reason += "Eating";
                        return reason;
                    }
                    case "b" -> {
                        reason += "Necessity";
                        return reason;
                    }
                    case "c" -> {
                        reason += "Donate";
                        return reason;
                    }
                    case "d" -> {
                        reason += "Study";
                        return reason;
                    }
                    case "e" -> {
                        reason += "Health";
                        return reason;
                    }
                    case "f" -> {
                        reason += "Sport";
                        return reason;
                    }
                    case "g" -> {
                        reason += "Vacations";
                        return reason;
                    }
                    case "h" -> {
                        reason += "Fun";
                        return reason;
                    }
                    case "i" -> {
                        reason += "Digital";
                        return reason;
                    }
                    case "j" -> {
                        reason += "Shop";
                        return reason;
                    }
                    case "k" -> {
                        reason += "Dress";
                        return reason;
                    }
                }
            }
        }
        return "NAN";
    }

    /**
     * 时间解析
     * @param factor DateReady类型 用于提取日期
     * @return 一个含有年月日的 长度为3 的String数组
     */
    public static String[] turnData(DateReady factor) {
        return (factor.returnDate()).split("-");
    }

    private int id = 0;
    private String type = "NAN";
    private String date = "1970-01-01";
    private double cost = 0.0;
    private String notes = "NAN";

    public void setID(int id) {
        this.id = id;
    }

    public void setType(String type) {

        this.type = type;
    }

    /**
     * 日期赋值
     * @param date 日期
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 耗费赋值
     * @param cost 耗费
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * 注释赋值
     * @param notes 注释
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * 返回ID值
     * @return int类型
     */
    public int returnID() {
        return (this.id);
    }

    /**
     * 返回类别
     * @return String类型
     */
    public String returnType() {
        return (this.type);
    }

    /**
     * 返回日期
     * @return String类型
     */
    public String returnDate() {
        return (this.date);
    }

    /**
     * 返回耗费值
     * @return double类型
     */
    public double returnCost() {
        return (this.cost);
    }

    /**
     * 返回注释
     * @return String类型
     */
    public String returnNotes() {
        return (this.notes);
    }

    /**
     * 输出函数
     */
    public void Output() {
        String[] showType = this.type.split("");
        String usage = cmp(showType[0], showType[1]);
        System.out.println(this.id + "\t"
                         + usage + "\t"
                         + this.date + "\t"
                         + this.cost + "\t"
                         + this.notes);
    }

}
