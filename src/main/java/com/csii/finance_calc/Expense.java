/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csii.finance_calc;

/**
 *
 * @author alvin
 */
public class Expense {
    private final String description;
    private final double amount;

    public Expense(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription(){
        return description; 
    }
    
    public double getAmount(){ 
        return amount; 
    }
    
}
