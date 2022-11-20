package com.ProjectPracitce.java;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Remain extends JFrame {
    private static final int MIN = 0;
    private static final int MAX = 100;



    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp;
    JButton jb1, jb2;
    JProgressBar jpb;
    JTextField jtf1, jtf2, jtfC1, jtfC2, jtfC3;
    JLabel jl1, jl2, jl3, jl4, jl;

    int split = 0;

    public static void main(String[] args) {
        new Remain().init_Remain();
    }

    public Remain() {



        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp = new JPanel();

        jpb = new JProgressBar();
        jpb.setMinimum(MIN);
        jpb.setMaximum(MAX);
        jpb.setStringPainted(true);
        // jpb.setIndeterminate(true);

        jb1 = new JButton("Confirm");
        jb2 = new JButton("Cancel");

        jtf1 = new JTextField(5);
        jtf2 = new JTextField(5);

        jtfC1 = new JTextField(10);
        jtfC2 = new JTextField(10);
        jtfC1.setEditable(false);
        jtfC2.setEditable(false);
        jtfC3 = new JTextField(10);
        jtfC3.setEditable(false);

        jl1 = new JLabel("Year to show");
        jl2 = new JLabel("Month to show");
        jl3 = new JLabel("Income");
        jl4 = new JLabel("Spending");
        jl = new JLabel("Remain");

        jp1.add(jl1);
        jp1.add(jtf1);
        jp2.add(jl2);
        jp2.add(jtf2);
        jp3.add(jb1);
        jp4.add(jpb);
        jp5.add(jl3);
        jp5.add(jtfC1);
        jp6.add(jl4);
        jp6.add(jtfC2);
        jp.add(jl);
        jp.add(jtfC3);
        jp7.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp);
        this.add(jp7);

        this.setLayout(new GridLayout(8, 1));
        this.setTitle("Remain");
        this.setSize(400, 320);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Remain.png");
        this.setIconImage(icon.getImage());
    }

    public void init_Remain() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String year = jtf1.getText();
                String month = jtf2.getText();
                double In = Operate.Process(1, true, year, month);
                double Out = Operate.Process(0, true, year, month);
                String toShowInRemain = "" + (In - Out);
                jtfC3.setText(toShowInRemain);
                String toShowInSpending = "" + Out;
                String toShowInIncome = "" + In;
                jtfC1.setText(toShowInIncome);
                jtfC2.setText(toShowInSpending);

                split = (int)((Out / In) * 100);
                jpb.setValue(split);

            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().init_Menu();
                Remain.super.dispose();
            }
        });
    }
}
