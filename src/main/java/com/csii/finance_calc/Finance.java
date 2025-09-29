/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csii.finance_calc;

import java.util.ArrayList;

/**
 *
 * @author alvin
 */
public class Finance {
    
    private double amount;
    private String category;
    private String year;
    private String month;
    private ArrayList<Expense> expenses;
     
    public Finance(String year, String month, String category, double amount, ArrayList<Expense> expenses) {
        this.amount = amount;
        this.category = category;
        this.year = year;
        this.month = month;
        this.expenses = new ArrayList<>(expenses);
    }
    public Finance(String year, String month, String category, double amount) {
        this(year, month, category, amount, new ArrayList<>());
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    public void addExpense(String description, double amount) {
        expenses.add(new Expense(description, amount));
    }
    
    public ArrayList<Expense> getExpenses() {
        return new ArrayList<>(expenses);  
    }
            

    
}
