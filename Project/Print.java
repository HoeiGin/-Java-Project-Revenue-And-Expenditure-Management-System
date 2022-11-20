package com.ProjectPracitce.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

public class Print extends JFrame {
    JTextArea jta;
    JPanel jp1, jp2;
    JButton jb;

    public static void main(String[] args) {
        new Print();
    }

    private static String dataShow(List<DateReady> aList) {
        String toShow = "";
        for (DateReady factor: aList) {
            String[] tmp = factor.returnType().split("");
            String temp = "" + factor.returnID() + "\t"
                             + DateReady.cmp(tmp[0], tmp[1]) + "\t"
                             + factor.returnDate() + "\t"
                             + factor.returnCost() + "\t"
                             + factor.returnNotes() + "\n";
            toShow += temp;
        }
        return toShow;
    }

    public Print() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb = new JButton("Cancel");
        jta = new JTextArea(40, 60);
        jta.setEditable(false);

        JScrollPane jsp = new JScrollPane(jta);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jp1.add(jsp);
        jp2.add(jb);

        this.add(jp1);
        this.add(jp2);
        this.setLayout(new FlowLayout());
        this.setTitle("Print data");
        this.setSize(750, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<DateReady> toPrint = Operate.selectInfo();
        String header = "id \t type \t \t datetime \t cost \t notes\n" + "----------------------------------------------------------";
        header += "--------------------------------------------------------------------------\n";
        String toShow = header + dataShow(toPrint);
        jta.setText(toShow);

        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Print.png");
        this.setIconImage(icon.getImage());

    }

    public void init_Print() {
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().init_Menu();
                Print.super.dispose();
            }
        });
    }
}
