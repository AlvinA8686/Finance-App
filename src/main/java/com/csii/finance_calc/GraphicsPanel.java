/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csii.finance_calc;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 *
 * @author amin_940155
 */
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.awt.FontMetrics;

public class GraphicsPanel extends JPanel {
    private List<Finance> finances;
    private String targetYear;
    private String targetMonth;
    private final int PANEL_WIDTH = 500;  // Fixed width
    private final int PANEL_HEIGHT = 300; // Fixed height

    public GraphicsPanel() {
        this.finances = new ArrayList<>();
        this.targetYear = "";
        this.targetMonth = "";
        setPreferredSize(new java.awt.Dimension(PANEL_WIDTH, PANEL_HEIGHT)); //set the size
    }

    public void setResults(List<Finance> finances, String year, String month) {
        this.finances = finances;
        this.targetYear = year;
        this.targetMonth = month;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = PANEL_WIDTH; // Use the fixed width
        int height = PANEL_HEIGHT; // Use the fixed height

        if (finances == null || finances.isEmpty() || targetYear.isEmpty() || targetMonth.isEmpty()) {
            g.drawString("No data to display.", 20, 20);
            return;
        }

        // Filter data for the specified year and month
        List<Finance> filteredFinances = new ArrayList<>();
        for (Finance finance : finances) {
            if (finance.getYear().equals(targetYear) && finance.getMonth().equals(targetMonth)) {
                filteredFinances.add(finance);
            }
        }

        if (filteredFinances.isEmpty()) {
            g.drawString("No data for the specified year and month.", 20, 20);
            return;
        }

        // 1. Calculate the maximum amount for scaling
        double maxAmount = 0;
        for (Finance finance : filteredFinances) {
            maxAmount = Math.max(maxAmount, finance.getAmount());
        }

        // 2. Define drawing parameters, using the fixed width and height
        int originX = 50;
        int originY = height - 50;
        int graphWidth = width - 100;
        int graphHeight = height - 100;
        int barWidth = graphWidth / filteredFinances.size() / 2;
        int barSpacing = (graphWidth - (filteredFinances.size() * barWidth)) / (filteredFinances.size() + 1);
        if (barSpacing < 0) {
            barSpacing = 10;
            barWidth = (graphWidth - (filteredFinances.size() * barSpacing)) / (filteredFinances.size());
        }

        // 3. Draw the coordinate system
        g.setColor(Color.BLACK);
        g.drawLine(originX, originY, originX + graphWidth, originY); // X-axis
        g.drawLine(originX, originY, originX, originY - graphHeight); // Y-axis

        // 4. Draw the bars
        for (int i = 0; i < filteredFinances.size(); i++) {
            Finance finance = filteredFinances.get(i);
            int barX = originX + barSpacing + i * (barWidth + barSpacing);
            int barHeight = (int) (finance.getAmount() / maxAmount * graphHeight);
            g.setColor(Color.BLUE);
            g.fillRect(barX, originY - barHeight, barWidth, barHeight);

            // Draw the category label below the bar
            String category = finance.getCategory();
            Font categoryFont = new Font("Arial", Font.PLAIN, 12);
            g.setFont(categoryFont);
            FontMetrics fm = g.getFontMetrics(categoryFont);
            int categoryWidth = fm.stringWidth(category);
            int categoryX = barX + (barWidth - categoryWidth) / 2;
            int categoryY = originY + 20;
            g.setColor(Color.BLACK);
            g.drawString(category, categoryX, categoryY);

            // Draw the amount on top of the bar
            String amountString = String.format("%.2f", finance.getAmount());
            Font amountFont = new Font("Arial", Font.PLAIN, 10);
            g.setFont(amountFont);
            FontMetrics amountFm = g.getFontMetrics(amountFont);
            int amountWidth = amountFm.stringWidth(amountString);
            int amountX = barX + (barWidth - amountWidth) / 2;
            int amountY = originY - barHeight - 5;
            g.setColor(Color.BLACK);
            g.drawString(amountString, amountX, amountY);
        }
        // Draw the title
        String title = "Financial Bar Graph for " + targetMonth + "/" + targetYear;
        Font titleFont = new Font("Arial", Font.BOLD, 16);
        g.setFont(titleFont);
        FontMetrics titleFm = g.getFontMetrics(titleFont);
        int titleWidth = titleFm.stringWidth(title);
        int titleX = (width - titleWidth) / 2;
        int titleY = originY - graphHeight - 30;
        g.drawString(title, titleX, titleY);
    }
}

