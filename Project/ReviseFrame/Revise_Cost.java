package com.ProjectPracitce.java.ReviseFrame;

import com.ProjectPracitce.java.*;
import com.ProjectPracitce.java.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Revise_Cost extends JFrame {
    JPanel jp1, jp2, jp3, jp4;
    JButton jb1, jb2, jb3;
    JTextField jtf1, jtf2;
    JTextArea jta;
    JLabel jl1, jl2, jl3;

    public static void main(String[] args) {
        new Revise_Cost().init_Revise_Cost();
    }

    public Revise_Cost() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jb1 = new JButton("Search");
        jb2 = new JButton("Confirm");
        jb3 = new JButton("Cancel");

        jtf1 = new JTextField(10);
        jtf2 = new JTextField(11);

        jta = new JTextArea(1, 20);
        jta.setEditable(false);

        jl1 = new JLabel("Please enter the id you want to revise");
        jl2 = new JLabel("The previous Cost");
        jl3 = new JLabel("New Cost");

        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jb1);

        jp2.add(jl2);
        jp2.add(jta);

        jp3.add(jl3);
        jp3.add(jtf2);

        jp4.add(jb2);
        jp4.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.setLayout(new GridLayout(4, 1));
        this.setSize(300, 300);
        this.setTitle("Revise Cost");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Revise.png");
        this.setIconImage(icon.getImage());
    }

    public void init_Revise_Cost() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf1.getText() != null || !jtf1.getText().equals("")) {
                    int uid = Integer.parseInt(jtf1.getText());
                    List<DateReady> dataList = Operate.selectInfo();
                    boolean search_flag = false;
                    for (DateReady i: dataList) {
                        if (i.returnID() == uid) {
                            String uCost = "" + i.returnCost();
                            jta.setText(uCost);
                            search_flag = true;
                        }
                    }
                    if (!search_flag) {
                        new Warning("Sorry, we cannot found the data with id" + uid);
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
                int uid = Integer.parseInt(jtf1.getText());
                double RvCost = Double.parseDouble(jtf2.getText());
                if (Operate.updateCost(uid, RvCost)) {
                    new Successful("Success");
                }
                else {
                    new Warning("Failed to revise cost!");
                }
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise().init_Revise();
                Revise_Cost.super.dispose();
            }
        });
    }

}
