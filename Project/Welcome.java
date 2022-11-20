package com.ProjectPracitce.java;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Welcome {

    /**
     * 展示所有账目类型
     */
    public static void typeInfo() {
        System.out.println("A:Income");
        System.out.println("|   ├─ A.Salary");
        System.out.println("|   ├─ B.Pocket Money");
        System.out.println("|   ├─ C.Bonus");
        System.out.println("|   └─ D.Others");
        System.out.println("a.Spending");
        System.out.println("\t├─ a.Eating");
        System.out.println("\t├─ b.Necessity");
        System.out.println("\t├─ c.Donate");
        System.out.println("\t├─ d.Study");
        System.out.println("\t├─ e.Health");
        System.out.println("\t├─ f.Sport");
        System.out.println("\t├─ g.Vacation");
        System.out.println("\t├─ h.Fun");
        System.out.println("\t├─ i.Digital");
        System.out.println("\t├─ j.Shop");
        System.out.println("\t└─ k.Dress");
        System.out.println();
        System.out.println("PS:Income -> Bonus, Please enter \"AC\"");
    }

    /**
     * 创建新的账目数据
     */
    public static void CreateData() {
        Operate max = new Operate();
        DateReady maxUid =  max.maxId();

        Scanner userInput = new Scanner(System.in);

        int uid = maxUid.returnID() + 1;
        System.out.println("-----------------------------");
        System.out.println("This operation's uid: " + uid);
        System.out.println("-----------------------------");

        typeInfo();
        System.out.print("Please enter the type: ");
        String uType = userInput.nextLine();

        System.out.print("Please enter the date(yyyy-MM-dd): " );
        String uDate = userInput.nextLine();

        System.out.print("Please enter the cost: ");
        double uCost = userInput.nextDouble();

        String nextSkip = userInput.nextLine();

        System.out.print("Please enter the notes: ");
        String uNotes = userInput.nextLine();

        DateReady toAdd = new DateReady();
        toAdd.setID(uid);
        toAdd.setType(uType);
        toAdd.setDate(uDate);
        toAdd.setCost(uCost);
        toAdd.setNotes(uNotes);

        Operate container = new Operate();
        container.saveOperate(toAdd);
        System.out.println("Success!");

    }

    /**
     * 数据可视化（查看特定月份内消费项目）
     * @param year  该年内的所有消费项目
     * @param month  该月内的所有消费项目
     */
    public static void VisualChart(String year, String month) {
        Operate.MonthSummary(year, month);
        JFrame j = new JFrame();
        JDialog jd = new JDialog();
        jd.setBounds(50, 50, 600, 600);
        jd.add(new Visual(year, month).getPanel());
        jd.setVisible(true);
    }

    /**
     * 打印数据库（账本）内的所有数据
     */
    public static void Print() {
        Operate.Table();
    }

    /**
     * 将数据库的数据以csv的格式保存到桌面上
     */
    public static void toExcel() {
        Operate.Export();
        System.out.println("Success to output the file! Please check your Desktop!");
    }

    /**
     * 修改数据库中的条目
     * @param index 选择修改的项目（a修改账目类型 b修改日期 c修改账目大小 d修改注释）
     */
    public static void Revise(String index) {
        Scanner revInput = new Scanner(System.in);
        if (index.equals("a")) {
            System.out.print("Please enter the id which you want to revise: ");
            int uid = revInput.nextInt();
            String skip = revInput.nextLine();
            typeInfo();
            System.out.print("Please enter the correct item: ");
            String uType = revInput.nextLine();
            boolean flag = Operate.updateType(uid, uType);
            if (flag) {
                System.out.println("Revise successfully!");
            }
        }
        else if (index.equals("b")) {
            System.out.print("Please enter the id which you want to revise: ");
            int uid = revInput.nextInt();
            String skip = revInput.nextLine();
            System.out.print("Please enter the correct item: ");
            String uDate = revInput.nextLine();
            boolean flag = Operate.updateDate(uid, uDate);
            if (flag) {
                System.out.println("Revise successfully!");
            }
        }
        else if (index.equals("c")) {
            System.out.print("Please enter the id which you want to revise: ");
            int uid = revInput.nextInt();
            String skip = revInput.nextLine();
            System.out.print("Please enter the correct item: ");
            double uCost = revInput.nextDouble();
            skip = revInput.nextLine();
            boolean flag = Operate.updateCost(uid, uCost);
            if (flag) {
                System.out.println("Revise successfully!");
            }
        }
        else if (index.equals("d")) {
            System.out.print("Please enter the id which you want to revise: ");
            int uid = revInput.nextInt();
            String skip = revInput.nextLine();
            System.out.print("Please enter the correct item: ");
            String uNote = revInput.nextLine();
            boolean flag = Operate.updateNote(uid, uNote);
            if (flag) {
                System.out.println("Revise successfully!");
            }
        }
    }

    /**
     * 删除条目
     */
    public static void Delete() {
        System.out.print("Please enter the id you want to delete: ");
        Scanner keyboard = new Scanner(System.in);
        int uid = keyboard.nextInt();
        String skip = keyboard.nextLine();
        boolean flag = Operate.deleteInfo(uid);
        if (flag) {
            System.out.println("Delete NO." + uid + " successfully");
        }
    }

    /**
     * 展示本月支出与剩余
     * 会有一个简单的进度条
     */
    public static void Statistic() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the year: ");
        String year = input.nextLine();
        System.out.print("Please enter the month: ");
        String month = input.nextLine();
        Operate.Balance(year, month);
    }

    /**
     * 账本的菜单界面
     */
    public static void Menu() {
        System.out.println("------------Welcome------------");
        System.out.println("----- A. Add item ");
        System.out.println("----- B. Print all the item");
        System.out.println("----- C. Revise the item");
        System.out.println("----- D. Delete the item");
        System.out.println("----- E. Month remaining");
        System.out.println("----- F. Monthly summary");
        System.out.println("----- G. Export data");
        System.out.println("----- Z. Exit");
        System.out.println("------------------------------");
        System.out.println();
        System.out.print("Please enter the number to operate: ");
        Scanner Input = new Scanner(System.in);
        String chosen = Input.nextLine();

        switch (chosen) {
            case "A" -> {
                CreateData();
                break;
            }
            case "B" -> {
                Print();
                break;
            }
            case "C" -> {
                System.out.println("a .revise type");
                System.out.println("b .revise date");
                System.out.println("c .revise cost");
                System.out.println("d .revise notes");
                System.out.print("Please choose one you want to revise: ");

                String c = Input.nextLine();

                Revise(c);
                break;
            }
            case "D" -> {
                Delete();
                break;
            }
            case "E" -> {
                Statistic();
                break;
            }
            case "F" -> {
                System.out.print("Please enter the year: ");
                String year = Input.nextLine();
                System.out.print("Please enter the month: ");
                String month = Input.nextLine();
                VisualChart(year, month);
                break;
            }
            case "G" -> {
                toExcel();
                break;
            }
            case "Z" -> {
                System.exit(0);
            }
            default -> System.out.println("Please enter again!");
        }
    }

}
