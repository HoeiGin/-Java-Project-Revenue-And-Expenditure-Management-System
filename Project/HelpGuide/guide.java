package com.ProjectPracitce.java.HelpGuide;

import com.ProjectPracitce.java.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guide extends JFrame {
    JTextArea jta;
    String GUIDE = """
            User manual
                This is a Revenue and Expenditure Management System (REMS) designed primarily to help keep track of day-to-day expenses\s
            and earnings.
                "Add" function: Can be used for the recording of income or expenses.
                "Print" function: print out the recorded data.
                "Revise" function: you can modify an entry in the data (please note that this may require you to provide the ID of the data you need\s
            to modify, you can check the ID of the entry you need to delete in the "Print" function.)
                "Delete" function: You can delete entries in the data, which requires you to provide an ID to delete.
                "Remain" feature: You can see your expenses and earnings for a month, which requires you to provide the year and month.
                "Summary": This feature allows you to see how much you've spent during a month, which requires you to provide the year and\s
            month.
                "Export" function: You can output the saved data to your desktop in CSV file format.
                (This introduction is translated using translation software, if you don't understand, please experience it yourself)""";
    JPanel jp1, jp2;
    JButton jb;
    public guide() {
        jb = new JButton("I Know");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jta = new JTextArea(20, 70);
        jta.setEditable(false);
        jta.setText(GUIDE);

        JScrollPane jsp = new JScrollPane(jta);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jp1.add(jsp);
        jp2.add(jb);
        this.add(jp1);
        this.add(jp2);
        this.setLayout(new FlowLayout());
        this.setTitle("User manual");
        this.setSize(750, 440);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        new guide().init_guide();
    }

    public void init_guide() {
         jb.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 guide.super.dispose();
             }
         });
    }

}
