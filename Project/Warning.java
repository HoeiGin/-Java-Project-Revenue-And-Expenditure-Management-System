package com.ProjectPracitce.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning extends JFrame {

    private String text;

    public Warning(String text) {
        Frame Failed = new JFrame();
        JPanel jp1, jp2;
        JLabel jt;
        JButton jb;

        jt = new JLabel(text);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb = new JButton("I know");

        jp1.add(jt);
        jp2.add(jb);
        Failed.add(jp1);
        Failed.add(jp2);
        Failed.setLayout(new GridLayout(2, 1));

        Failed.setBounds(100, 100, 320, 120);
        Failed.setLocationRelativeTo(null);
        Failed.setVisible(true);
        Failed.setResizable(false);

        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Failed.png");
        this.setIconImage(icon.getImage());

        Failed.setTitle("Failed");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Failed.dispose();
            }
        });

    }
}
