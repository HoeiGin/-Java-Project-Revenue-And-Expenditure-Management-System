package com.ProjectPracitce.java;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serial;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class addData extends JFrame implements ItemListener {

    @Serial
    private static final long serialVersionUID = 1L;
    JLabel jlb1, jlb2, jlb3, jlb4, jlb5;
    JTextField jtf1, jtf2, jtf3, jtf4;

    JComboBox<String> jcb1, jcb2;
    JList<String> jl;
    JScrollPane jsp;
    JButton jb1, jb2;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6;

    Map<Integer, Vector<String>> map = new HashMap<Integer, Vector<String>>();

    int maxCostId;

    public static void main(String[] args) {
       new addData().init_addData();
    }

    public addData() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();

        jlb1 = new JLabel("id");
        jlb2 = new JLabel("type");
        jlb3 = new JLabel("datetime");
        jlb3.setToolTipText("yyyy-MM-dd");
        jlb4 = new JLabel("cost");
        jlb5 = new JLabel("notes");

        jb1 = new JButton("Confirm");
        jb2 = new JButton("Cancel");

        jtf1 = new JTextField(5);
        DateReady tmp = new DateReady();
        tmp = Operate.maxId();
        maxCostId = tmp.returnID() + 1;
        String toShow = "" + maxCostId;
        jtf1.setText(toShow);


        jtf2 = new JTextField(15);
        jtf3 = new JTextField(15);
        jtf4 = new JTextField(30);

        Vector<String> sorted = new Vector<String>();
        sorted.add("Income");
        sorted.add("Spending");
        jcb1 = new JComboBox<String>(sorted);
        jcb1.addItemListener(this);

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

        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jcb1);
        jp2.add(jcb2);

        jp3.add(jlb3);
        jp3.add(jtf2);

        jp4.add(jlb4);
        jp4.add(jtf3);

        jp5.add(jlb5);
        jp5.add(jtf4);

        jp6.add(jb1);
        jp6.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);

        this.setLayout(new GridLayout(6, 1));
        this.setSize(400, 300);
        this.setTitle("Add");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        ImageIcon icon = new ImageIcon("D:\\IntelliJ IDEA 2022.1.3\\Program\\TestProgram\\src\\main\\java\\com\\ProjectPracitce\\java\\icon\\Add.png");
        this.setIconImage(icon.getImage());
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (e.getSource() == jcb1) {
                int index = jcb1.getSelectedIndex();
                jcb2.setModel(new DefaultComboBoxModel<>(map.get(index)));
            }
            else if (e.getSource() == jcb2) {
                JOptionPane.showMessageDialog(this,
                        "You choose " + jcb1.getSelectedItem() + " and " + jcb2.getSelectedItem());
            }
        }
    }

    public void init_addData() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] pre = {"A", "a"};
                String[] sub1 = {"A", "B", "C", "D"};
                String[] sub2 = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
                DateReady tmp = new DateReady();
                tmp.setID(maxCostId);
                String type = "" + pre[jcb1.getSelectedIndex()];
                if (jcb1.getSelectedIndex() == 0) {
                    type += sub1[jcb2.getSelectedIndex()];
                }
                else {
                    type += sub2[jcb2.getSelectedIndex()];
                }
                System.out.println(jcb1.getSelectedIndex() + "\t" + jcb2.getSelectedIndex());
                System.out.println(type);
                tmp.setType(type);
                if (jtf2.getText() != null || !jtf2.getText().equals("")) {
                    tmp.setDate(jtf2.getText());
                }
                else {
                    new Warning("The datetime must be written!");
                }
                if (jtf3.getText() != null || !jtf3.getText().equals("")) {
                    double cost = Double.parseDouble(jtf3.getText());
                    tmp.setCost(cost);
                }
                else {
                    new Warning("The cost must be written!");
                }
                tmp.setNotes(jtf4.getText());
                if (Operate.saveOperate(tmp)) {
                    new Successful("Successful");
                }
                else {
                    new Warning("Failed to add Data!");
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Menu().init_Menu();
                addData.super.dispose();
            }
        });

    }

}
