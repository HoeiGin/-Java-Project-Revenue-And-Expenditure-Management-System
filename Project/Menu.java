package com.ProjectPracitce.java;
import com.ProjectPracitce.java.HelpGuide.Version;
import com.ProjectPracitce.java.HelpGuide.guide;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Menu extends JFrame {

    JMenuBar jmb;
    JMenu m1, m2, m3, m4;
    JMenuItem m1_it1, m1_it2;
    JMenuItem m4_it1, m4_it2, m4_it3, m4_it4;

    JButton add, print, revise, delete, remain, summary, export, exit;

    JPanel jp1, jp2;

    JTextArea jt;



    public static void main(String[] args) {
        new Menu().init_Menu();
    }

    public Menu() {

        jp1 = new JPanel();
        jp2 = new JPanel();

        jmb = new JMenuBar();

        m1 = new JMenu("New");
        m1.setMnemonic('N');

        // m2 = new JMenu("Print");
        // m2.setMnemonic('P');

        m3 = new JMenu("Export");
        m3.setMnemonic('E');

        m4 = new JMenu("Help");
        m4.setMnemonic('H');

        m1_it1 = new JMenuItem("Record");
        m1_it1.setMnemonic('R');
        m1_it1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_DOWN_MASK));

        m1_it2 = new JMenuItem("Delete");
        m1_it2.setMnemonic('D');
        m1_it2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.ALT_DOWN_MASK));

        m4_it1 = new JMenuItem("User manual");
        m4_it1.setMnemonic('U');
        m4_it1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.ALT_DOWN_MASK));

        m4_it2 = new JMenuItem("Quit");
        m4_it2.setMnemonic('Q');
        m4_it2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.ALT_DOWN_MASK));

        m4_it3 = new JMenuItem("About us");
        m4_it3.setMnemonic('A');
        m4_it3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_DOWN_MASK));

        m4_it4 = new JMenuItem("Version");
        m4_it4.setMnemonic('V');
        m4_it4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));


        m1.add(m1_it1);
        m1.add(m1_it2);

        m4.add(m4_it1);
        m4.add(m4_it3);
        m4.add(m4_it4);
        m4.addSeparator();
        m4.add(m4_it2);


        jmb.add(m1);
        // jmb.add(m2);
        // jmb.add(m3);
        jmb.add(m4);

        add = new JButton("Add");
        add.setToolTipText("Add item");
        print = new JButton("Print");
        print.setToolTipText("Print all the item");
        revise = new JButton("Revise");
        revise.setToolTipText("Revise the item");
        delete = new JButton("Delete");
        delete.setToolTipText("Delete the item");
        remain = new JButton("Remain");
        remain.setToolTipText("Month remaining");
        summary = new JButton("Summary");
        summary.setToolTipText("Monthly summary");
        export = new JButton("Export");
        export.setToolTipText("Export data");
        exit = new JButton("Exit");
        exit.setToolTipText("Exit the REMS");

        jp1.add(add);
        jp1.add(print);
        jp1.add(revise);
        jp1.add(delete);
        jp1.add(remain);
        jp1.add(summary);
        jp1.add(export);
        jp1.add(exit);


        jt = new JTextArea("Welcome to REMS");
        jt.setEditable(false);

        this.add(jp1);
        this.add(jt, BorderLayout.SOUTH);

        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Menu.png");
        this.setIconImage(icon.getImage());


        this.add(jmb, BorderLayout.NORTH);
        this.setTitle("Revenue And Expenditure Management System");
        this.setSize(700, 125);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init_Menu() {
        m4_it2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        m4_it1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new guide().init_guide();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addData().init_addData();
                Menu.super.dispose();
            }
        });

        m1_it1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addData().init_addData();
                Menu.super.dispose();
            }
        });

        m1_it2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete().init_Delete();
                Menu.super.dispose();
            }
        });

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Print().init_Print();
                Menu.super.dispose();
            }
        });

        revise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise().init_Revise();
                Menu.super.dispose();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete().init_Delete();
                Menu.super.dispose();
            }
        });

        remain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Remain().init_Remain();
                Menu.super.dispose();
            }
        });

        summary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Summary().init_Summary();
                Menu.super.dispose();
            }
        });

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operate.Export();
                new Successful("Success. Please check your desktop!");
            }
        });

        m4_it3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI("https://github.com/HoeiGin/-Java-Project-Revenue-And-Expenditure-Management-System"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

        m4_it4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Version();
            }
        });
    }

}
