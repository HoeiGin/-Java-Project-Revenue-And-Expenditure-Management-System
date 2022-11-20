package com.ProjectPracitce.java;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Sign extends JFrame{
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5, jlb6;
    JTextField jtf1, jtf2, jtf3, jtf4;
    JPasswordField jpf1, jpf2;
    JButton jb1, jb2, jb3;
    JCheckBox jcb;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8;

    int maxID;

    public static void main(String[] args) {
        Sign e = new Sign();
        e.init_Sign();
    }

    public Sign() {
        jlb1 = new JLabel("UserID");
        jlb2 = new JLabel("FindID");
        jlb3 = new JLabel("Username");
        jlb4 = new JLabel("Password");
        jlb5 = new JLabel("Confirm Password");
        jlb6 = new JLabel("Telephone");

        jtf1 = new JTextField(5);

        User tmp = LoginFrame.findMax();
        maxID = tmp.returnId() + 1;
        String toShow = "" + maxID;
        jtf1.setText(toShow);

        jtf2 = new JTextField(10);
        jtf3 = new JTextField(15);
        jtf4 = new JTextField(11);
        jpf1 = new JPasswordField(15);
        jpf2 = new JPasswordField(15);

        jcb = new JCheckBox("Accept our agreement");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();

        jb1 = new JButton("Confirm");
        jb2 = new JButton("Quit");
        jb3 = new JButton("Go back");

        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jlb4);
        jp4.add(jpf1);

        jp5.add(jlb5);
        jp5.add(jpf2);

        jp6.add(jlb6);
        jp6.add(jtf4);

        jp7.add(jcb);

        jp8.add(jb1);
        jp8.add(jb2);
        jp8.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        this.add(jp8);

        this.setLayout(new GridLayout(8, 1));
        this.setSize(400, 300);
        this.setTitle("Sign");
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public void init_Sign() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int uid = maxID;
                String findID = jtf2.getText();
                String user = jtf3.getText();
                String pass = "";
                char[] t1 = jpf1.getPassword();
                for (char i: t1) {
                    pass += i;
                }
                String cPass = "";
                char[] t2 = jpf2.getPassword();
                for (char i: t2) {
                    cPass += i;
                }
                String tel = jtf4.getText();

                User temp = new User();
                temp.setId(maxID);

                if (jcb.isSelected()) {
                    if (findID != null || !findID.equals("")) {
                        temp.setFindId(findID);
                        if (user != null || !user.equals("")) {
                            temp.setUsername(user);
                            if (pass.equals(cPass))  {
                                temp.setPassword(pass);
                                if (tel != null || !tel.equals("")) {
                                    temp.setTelephone(tel);
                                    LoginFrame.addToSQL(temp);
                                    System.out.println("Successful to add in administrator list!");
                                    new Successful("Successful to add in administrator list!");

                                }
                                else {
                                    new Warning("Please enter the telephone\nIt is very important to find your account!");
                                }
                            }
                            else {
                                new Warning("Your password and the confirm password was not equalled!");
                            }
                        }
                        else {
                            new Warning("Please enter the username!\nIt is very important!");
                        }
                    }
                    else {
                        new Warning("Please enter the findId \nIt will help to find the account!");
                    }
                }
                else {
                    new Warning("Please accept out agreement!");
                }



            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sign.super.dispose();
                new Login().init();
            }
        });
    }

}
