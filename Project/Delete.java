package com.ProjectPracitce.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Delete extends JFrame {
    JPanel jp1, jp2, jp3;
    JLabel jl;
    JButton jb1, jb2, jb3;
    JTextArea jta;
    JTextField jtf;

    String toShow = "";

    JFrame question;
    JPanel jpUp, jpDown;
    JLabel ask;
    JButton confirm, cancel;

    int uid = 0;




    public static void main(String[] args) {
        new Delete().init_Delete();
    }

    public Delete() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jb1 = new JButton("Search");
        jb2 = new JButton("Delete");
        jb3 = new JButton("Cancel");
        jtf = new JTextField(10);
        jta = new JTextArea(5, 20);
        jta.setEditable(false);

        jl = new JLabel("Please enter the id you want to delete");

        jp1.add(jl);
        jp1.add(jtf);
        jp1.add(jb1);

        jp2.add(jta);
        jp3.add(jb2);
        jp3.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(3, 1));
        this.setSize(300, 400);
        this.setTitle("Delete Data");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Delete.png");
        this.setIconImage(icon.getImage());

    }

    public void init_Delete() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText() != null || !jtf.getText().equals("")) {
                    uid = Integer.parseInt(jtf.getText());
                    List<DateReady> dataList = Operate.selectInfo();
                    boolean search_flag = false;
                    for (DateReady i: dataList) {
                        if (i.returnID() == uid) {
                            String[] sorted = i.returnType().split("");
                            toShow += "uid: " + i.returnID() + "\n";
                            toShow += "Type: " + DateReady.cmp(sorted[0], sorted[1]) + "\n";
                            toShow += "Date: " + i.returnDate() + "\n";
                            toShow += "Cost: " + i.returnCost() + "\n";
                            toShow += "Note: " + i.returnNotes() + "\n";
                            jta.setText("");
                            jta.setText(toShow);
                            search_flag = true;
                        }
                    }
                    if (!search_flag) {
                        new Warning("Sorry! We cannot find the data with id" + uid);
                    }
                }
                else {
                    new Warning("The blank was empty!");
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                againAsk();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().init_Menu();
                Delete.super.dispose();
            }
        });

    }

    public void againAsk() {
        question = new JFrame();
        ask = new JLabel("Do you want to delete the id?");
        confirm = new JButton("Yes");
        cancel = new JButton("No");
        jpUp = new JPanel();
        jpDown = new JPanel();
        jpUp.add(ask);
        jpDown.add(confirm);
        jpDown.add(cancel);
        question.add(jpUp);
        question.add(jpDown);
        question.setLayout(new GridLayout(2, 1));
        question.setBounds(100, 100, 320, 120);
        question.setTitle("Are you sure");
        question.setVisible(true);
        question.setResizable(false);
        Dimension SmallscreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension SmallframeSize = question.getSize();
        question.setLocation((SmallscreenSize.width - SmallframeSize.width) / 2, (SmallscreenSize.height - SmallframeSize.height) / 2);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operate.deleteInfo(uid)) {
                    question.dispose();
                    new Successful("Success!");
                }
                else {
                    new Warning("Fail to delete!");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete().init_Delete();
                question.dispose();
            }
        });
    }


}
