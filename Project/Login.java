package com.ProjectPracitce.java;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.List;


public class Login extends JFrame {

    JPanel jp1, jp2, jp3;
    JLabel jlb1, jlb2;
    JButton jb1, jb2, jb3;
    JTextField jtf1;
    JPasswordField jpf1;




    public static void main(String[] args) {
        Login d1 = new Login();
        d1.init();
    }

    public Login() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("Username");
        jlb1.setSize(100, 25);
        jlb2 = new JLabel("Password");
        jlb2.setSize(100, 25);

        jb1 = new JButton("Login");

        jb2 = new JButton("Sign");
        jb3 = new JButton("Quit");

        jtf1 = new JTextField(15);
        jpf1 = new JPasswordField(15);
        this.setLayout(new GridLayout(3, 1));

        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jpf1);

        jp3.add(jb1);
        jp3.add(jb2);
        jp3.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setSize(300, 150);
        this.setTitle("Welcome");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public void init() {
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sign().init_Sign();
                Login.super.dispose();
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uName = jtf1.getText();
                char[] passArray = jpf1.getPassword();
                String uPass = "";
                for (char i: passArray) {
                    uPass += i;
                }
                System.out.println(uName + "\t" + uPass);
                if (LoginFrame.toLogin(uName, uPass)) {
                    new Menu().init_Menu();
                    Login.super.dispose();
                }
                else {
                    Failed();
                }
            }
        });
    }

    public void Failed() {
        Frame Failed = new JFrame();
        JPanel jp1, jp2;
        JLabel jt;
        JButton jb;

        jt = new JLabel("Failed to Login!\nPlease try again!");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb = new JButton("I know");

        jp1.add(jt);
        jp2.add(jb);
        Failed.add(jp1);
        Failed.add(jp2);
        Failed.setLayout(new GridLayout(2, 1));

        Failed.setBounds(100, 100, 300, 120);
        Failed.setLocationRelativeTo(null);
        Failed.setVisible(true);
        Failed.setResizable(false);
        Failed.setTitle("Failed");

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Failed.dispose();
            }
        });

    }
}