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
public class CurrentAccount extends Account{
    private double overdraft;
    public CurrentAccount(String acNo, double balance, double overdraft){
        super(acNo,balance);
        this.overdraft= overdraft;
        
    }
    public void withdraw(double amount){
        double bal = super.getBalance();
        System.out.println("====WITHDRAWAL====");
        if (amount> (bal+overdraft)){
            System.out.println("Insufficient funds");
        }else
            if (amount > bal){
                bal = bal + overdraft-amount;
                setBalance( bal );
                System.out.println("Rm"+amount+" has been withdrawn");
            }else 
                bal = bal - amount;
                setBalance(bal);
                System.out.println("Rm"+amount+" has been withdrawn");
    }
    
    public void displayDetails(){
        System.out.println("====CURRENT====");
        //System.out.println("");
        super.displayDetails();
        System.out.println("Overdraft: " + overdraft);
    }
}
