package com.ProjectPracitce.java;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.util.*;

/**
 * @author GinHeoi
 * @version 1.0
 */
public class Main {
    /**
     * 登录界面
     * @param index 选择操作（1.登录 2.注册 3.退出）
     */
    public static void Welcome(int index) {
        if (index == 1) {
            System.out.println("------Revenue And Expenditure Management System------");
            System.out.println("---- 1. Sign up");
            System.out.println("---- 2. Sign in");
            System.out.println("---- 3. Exit");
            System.out.println("-----------------------------------------------------");

        }
        else if (index == 2) {
            System.out.println("Attention!");
            System.out.println("id refers to your ordinal number in the database and is usually filled in automatically. " +
                    "findid is a field that must be filled in during the process of finding the account password, please keep this field in mind. " +
                    "The number of words in the username and password must be within 15, " +
                    "and the phone is optional.");
            System.out.println("-----------------------------------------------");
        }
    }

    /**
     * 主程序
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        while (true) {
            Welcome(1);
            System.out.print("Please choose one to next: " );
            int cho = input.nextInt();
            String skip = input.nextLine();
            if (cho == 1) {
                System.out.print("Username: ");
                String UsN = input.nextLine();
                System.out.print("Password: ");
                String PsW = input.nextLine();
                boolean flag = LoginFrame.Login(UsN, PsW);
                if (flag) {
                    while (true) {
                        Welcome.Menu();
                    }
                }
                else {
                    System.exit(0);
                }
            }
            else if (cho == 2) {
                Welcome(2);
                LoginFrame.SignIn();
            }
            else if (cho == 3) {
                System.exit(0);
            }
        }
    }
}