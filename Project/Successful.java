package com.ProjectPracitce.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Successful extends JFrame {
    private String text;

    public Successful(String text) {
        Frame Success = new JFrame();
        JPanel jp1, jp2;
        JLabel jt;
        JButton jb;

        jt = new JLabel(text);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb = new JButton("I know");

        jp1.add(jt);
        jp2.add(jb);
        Success.add(jp1);
        Success.add(jp2);
        Success.setLayout(new GridLayout(2, 1));

        Success.setBounds(100, 100, 300, 120);
        Success.setLocationRelativeTo(null);
        Success.setVisible(true);
        Success.setResizable(false);
        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Success.png");
        this.setIconImage(icon.getImage());

        Success.setTitle("Success");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Success.dispose();
            }
        });
    }


}
