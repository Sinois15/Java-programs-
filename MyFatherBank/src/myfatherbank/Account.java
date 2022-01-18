/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfatherbank;

/**
 *
 * @author User
 */
public class Account {
    private String name;
    private String acNo;
    private double balance;
    
    public Account(String acNo, double balance){
        this.acNo=acNo;
        this.balance=balance;
    }

    public void deposit(double amount){
        System.out.println("====DEPOSIT====");
        balance = balance + amount;
        System.out.println("Rm"+amount+" has been deposited");
    }
     public void withdraw(double amount){
        System.out.println("====WITHDRAWAL====");
        if (amount > getBalance()){
            System.out.println("Insufficient balance.");
        }else{
            setBalance(getBalance() - amount);
            System.out.println("Rm"+amount+" has been withdrawn.");
        }
            
    }

    public void setAcNo(String acNo) {
        this.acNo = acNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAcNo() {
        return acNo;
    }

    public double getBalance() {
        return balance;
    }
    public void setName(String name){
        this.name = name;
    }
    public void displayName(){
        System.out.println(name);
    }
    
    
    public void displayDetails(){
        System.out.println("Account No: "+acNo);
        System.out.println("Balance: Rm"+ balance);
    }    
    
}
