package com.ProjectPracitce.java;
import java.awt.Font;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class Visual {
    ChartPanel jFrame;

    /**
     * 绘制柱状图
     * @param year 年份
     * @param month 月份
     */
    public Visual(String year, String month) {
        DefaultCategoryDataset data = (DefaultCategoryDataset) getSQL(year, month);
        JFreeChart chart = ChartFactory.createBarChart3D(
                "Spending in " + month + ", " + year,
                "Month: " + month + "Year: " + year,
                "Spending(Yuan)",
                data,
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domain = plot.getDomainAxis();
        domain.setTickLabelFont(new Font("Product Sans", Font.BOLD, 12));
        domain.setLabelFont(new Font("Product Sans", Font.BOLD, 15));
        ValueAxis rangeAxis=plot.getRangeAxis();
        chart.getLegend().setItemFont(new Font("Product Sans", Font.BOLD, 12));
        chart.getTitle().setFont(new Font("Product Sans", Font.BOLD, 12));
        jFrame=new ChartPanel(chart);
    }

    /**
     * 统计函数
     * @param year 年份
     * @param month 月份
     * @return 返回归类好的数据
     */
    public static CategoryDataset getSQL(String year, String month) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        List<DateReady> uList = Operate.selectInfo();
        Map<String, Double> map = new HashMap<String, Double>();
        for (DateReady factor: uList) {
            String[] type = (factor.returnType()).split("");
            String uType = DateReady.cmp(type[0], type[1]);
            String[] time = DateReady.turnData(factor);
            if (time[0].equals(year)) {
                if (time[1].equals(month)) {
                    if (type[0].equals("a")) {
                        if (map.containsKey(uType)) {
                            double tmp = factor.returnCost() + map.get(uType);
                            map.put(uType, tmp);
                        }
                        else {
                            map.put(uType, factor.returnCost());
                        }
                    }
                }
            }
        }

        for (Map.Entry<String, Double> entry: map.entrySet()) {
            data.setValue(entry.getValue(), entry.getKey(), month);
        }

        return data;
    }

    public ChartPanel getPanel() {
        return jFrame;
    }
}
