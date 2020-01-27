/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author Jules Gammad 500874689
 */
public class Account {
    //instance variables
    private String name;
    private int number;
    private double initialBalance;
   
    
    //constructor
    public Account (String name, int number, double initialBalance) {
        //assigning instance variable values from @param
        this.name = name;
        this.number = number;
        this.initialBalance = initialBalance;
        toString();
    }

    //method to get the name of the account
    String getName() {  
        return name;
    }
    //method to get of the balane of an account 
    double getBalance() {
        return initialBalance;
    }
    //method to get the account number
    int getNumber() {
        return number;
    }
    
    //method to deposit an amount to account
    boolean deposit(double amount) {
        //dont deposit if the amount is less than or equal to zero and return false;
        if (amount <= 0.0) 
            return false;
        else { //else deposit the amount and return true
            initialBalance += amount;
            return true;
        }
            
    }
    //method to withdraw from account
    boolean withdraw(double amount) {
        //if the amount is less than or equal to zero or if it's more than the account balance
        //don't withdraw and return false
        if (amount <= 0.0 || amount > initialBalance)
            return false;
        else { //else subtract from the ammount and return true
            initialBalance -= amount;
            return true;
        }
    }
    
    //method to return the string equivalent of the values in the constructor method
    @Override
    public String toString() {
        return ("(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")");
        
    }
    
    
}

