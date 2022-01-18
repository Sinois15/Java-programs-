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
public class SavingAccount extends Account{
   
    private double yearlyRate;
    public SavingAccount(String acNo, double balance){
        super(acNo,balance);
        yearlyRate = -1;
   
    }
    public SavingAccount(String acNo, double balance, double yearlyRate){
        super(acNo,balance);
        this.yearlyRate=yearlyRate;
   
    }
   
    public void rollYear(){
        double bal = super.getBalance();
        if (yearlyRate>0){
            bal = bal + (bal*yearlyRate);
            super.setBalance(bal);
        }
        
    }
    
    
    
    public void displayDetails(){
        System.out.println("====SAVING====");
        //System.out.println("");
        super.displayDetails();
        if (yearlyRate > 0){
            System.out.println("Yearly Rate: "+yearlyRate);
        }else
            System.out.println("Yearly Rate: Awaiting Decision");
    }
    

    
}
