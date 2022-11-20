package com.ProjectPracitce.java.ReviseFrame;

import com.ProjectPracitce.java.*;
import com.ProjectPracitce.java.Menu;
import org.apache.poi.sl.draw.geom.GuideIf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class Revise_Type extends JFrame implements ItemListener {
    JLabel jlb1, jlb2, jlb;
    JButton jb, jb1, jb2;
    JComboBox<String> jcb1, jcb2;

    JTextField jtf;
    JTextArea jta;

    JPanel jp, jp1, jp2, jp3;
    Map<Integer, Vector<String>> map = new HashMap<Integer, Vector<String>>();

    public static void main(String[] args) {
        new Revise_Type().init_Revise_Type();
    }

    public Revise_Type() {
        jp = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb = new JLabel("Please enter the id you want to revise");
        jtf = new JTextField(10);
        jlb1 = new JLabel("The previous data");
        jlb2 = new JLabel("New type");

        Vector<String> Pre = new Vector<String>();
        Pre.add("Income");
        Pre.add("Spending");
        jcb1 = new JComboBox<String>(Pre);
        jcb1.addItemListener(this);
        jta = new JTextArea(1, 20);

        jb = new JButton("Confirm");
        jb1 = new JButton("Search");
        jb2 = new JButton("Cancel");

        Vector<String> Income = new Vector<String>();
        Income.add("Salary");
        Income.add("Pocket Money");
        Income.add("Bonus");
        Income.add("Others");
        map.put(0, Income);

        Vector<String> Spending = new Vector<String>();
        Spending.add("Eating");
        Spending.add("Necessity");
        Spending.add("Donate");
        Spending.add("Study");
        Spending.add("Health");
        Spending.add("Sport");
        Spending.add("Vacation");
        Spending.add("Fun");
        Spending.add("Digital");
        Spending.add("Shop");
        Spending.add("Dress");
        map.put(1, Spending);

        jcb2 = new JComboBox<String>(new DefaultComboBoxModel<>(map.get(0)));
        jcb2.addItemListener(this);

        jp.add(jlb);
        jp.add(jtf);
        jp.add(jb1);
        jp1.add(jlb1);
        jp1.add(jta);
        jp2.add(jlb2);
        jp2.add(jcb1);
        jp2.add(jcb2);
        jp3.add(jb);
        jp3.add(jb2);

        this.add(jp);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(4, 1));
        this.setSize(300, 300);
        this.setTitle("Revise Type");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Revise.png");
        this.setIconImage(icon.getImage());

    }

    public void itemStateChanged(ItemEvent q) {
        if (q.getStateChange() == ItemEvent.SELECTED) {
            if (q.getSource() == jcb1) {
                int index = jcb1.getSelectedIndex();
                jcb2.setModel(new DefaultComboBoxModel<>(map.get(index)));
            }
            else if (q.getSource() == jcb2) {
                JOptionPane.showMessageDialog(this,
                        "You choose " + jcb1.getSelectedItem() + " and " + jcb2.getSelectedItem());
            }
        }
    }

    public void init_Revise_Type() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText() != null || !jtf.getText().equals("")) {
                    int uid = Integer.parseInt(jtf.getText());
                    List<DateReady> aList = Operate.selectInfo();
                    boolean search_flag = false;
                    for (DateReady i: aList) {
                        if (i.returnID() == uid) {
                            String[] tmp = i.returnType().split("");
                            jta.setText(DateReady.cmp(tmp[0], tmp[1]));
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

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] pre = {"A", "a"};
                String[] sub1 = {"A", "B", "C", "D"};
                String[] sub2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
                String type = "" + pre[jcb1.getSelectedIndex()];
                int uid = Integer.parseInt(jtf.getText());
                if (jcb1.getSelectedIndex() == 0) {
                    type += sub1[jcb2.getSelectedIndex()];
                }
                else {
                    type += sub2[jcb2.getSelectedIndex()];
                }
                if (Operate.updateType(uid, type)) {
                    new Successful("Success");
                }
                else {
                    new Warning("Failed to revise type!");
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Revise().init_Revise();
                Revise_Type.super.dispose();
            }
        });
    }

}
