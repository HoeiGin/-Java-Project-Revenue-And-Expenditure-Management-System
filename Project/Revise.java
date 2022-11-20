package com.ProjectPracitce.java;

import com.ProjectPracitce.java.ReviseFrame.Revise_Cost;
import com.ProjectPracitce.java.ReviseFrame.Revise_Datetime;
import com.ProjectPracitce.java.ReviseFrame.Revise_Notes;
import com.ProjectPracitce.java.ReviseFrame.Revise_Type;

import javax.net.ssl.SSLContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Revise extends JFrame {
    JButton jb1, jb2, jb3, jb4, jb5;
    JPanel jp, jp1, jp2, jp3;
    static JTextField jtf;
    JLabel jlb;


    public static void main(String[] args) {
        new Revise().init_Revise();
    }


    public Revise() {
        jlb = new JLabel("Please enter the id you want to revise");
        jtf = new JTextField(10);

        jb1 = new JButton("Type");
        jb2 = new JButton("datetime");
        jb3 = new JButton("Cost");
        jb4 = new JButton("Notes");
        jb5 = new JButton("Cancel");

        jp = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        //jp.add(jlb);
        //jp.add(jtf);
        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp3.add(jb5);

        //this.add(jp);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(3, 1));
        this.setTitle("Revise");
        this.setSize(300, 150);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Revise.png");
        this.setIconImage(icon.getImage());
    }

    public void init_Revise() {
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jtf.getText());
                new Menu().init_Menu();
                Revise.super.dispose();
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise_Type().init_Revise_Type();
                Revise.super.dispose();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise_Datetime().init_Revise_Datetime();
                Revise.super.dispose();
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise_Cost().init_Revise_Cost();
                Revise.super.dispose();
            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise_Notes().init_Revise_Notes();
                Revise.super.dispose();
            }
        });
    }
}
