package com.ProjectPracitce.java.HelpGuide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Version extends JFrame {
    JLabel jl1, jl2, jl3, jl4, jl5, jl6;
    JPanel jp1, jp2, jp3, jp4, jp0, jp01;
    JButton jb;

    public static void main(String[] args) {
        new Version();
    }

    public Version() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();


        jl1 = new JLabel(new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Software.png"));
        jl2 = new JLabel(new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Menu.png"));
        jl3 = new JLabel("Revenue And Expenditure Management System");
        jl4 = new JLabel("Version  1.0.1");
        jl5 = new JLabel("author  HeoiGin");
        jl6 = new JLabel("GitHub  Please press button \"About us\"");

        jb = new JButton("I know");

        jp1.add(jl1);
        jp1.add(jl2);
        jp2.add(jl3);

        jp3.add(jl4);
        jp3.add(jl5);
        jp3.add(jl6);

        jp4.add(jb);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);


        this.setLayout(new GridLayout(4, 1));
        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Menu.png");
        this.setIconImage(icon.getImage());
        this.setTitle("Version");
        this.setSize(400, 420);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Version.super.dispose();
            }
        });

    }


}
