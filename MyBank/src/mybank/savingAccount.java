/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mybank;

/**
 *
 * @author User
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class savingAccount {
    Scanner sc = new Scanner(System.in);
    DecimalFormat twoDp=new DecimalFormat("###.00");
    private String accountNo;
    private double balance;
    private double yearlyRate;

    
    public savingAccount(String accountNo, double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }
     public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getYearlyRate() {
        return yearlyRate;
    }

    public void setYearlyRate(double yearlyRate) {
        this.yearlyRate = yearlyRate;
    }
    //servicefee
    public void serviceFee(){
        balance=balance-10;
        System.out.println("Rm10 has been deducted as service fee.");
        
        //System.out.print("New balance: Rm"+twoDp.format(balance));
        
    }
    //withdraw with parameters
    public void withdraw(double amount){
        
        System.out.println("-WITHDRAWAL-");
        System.out.println("====================");
        if (balance<amount){
            System.out.println("Insufficient funds.");
        }
        else{
            balance = balance - amount;
            System.out.println("Rm"+amount+" has been withdrawn");
            System.out.println("New balance: Rm"+twoDp.format(balance));
        }
        System.out.println("====================");
        System.out.println("");
    }
    //deposit with parameter
    public void deposit(double amount){
        
        System.out.println("-DEPOSIT-");
        System.out.println("====================");
        balance = balance + amount;
        System.out.println("Rm"+amount+" has been deposited");
        System.out.println("New balance: Rm"+twoDp.format(balance));
        System.out.println("====================");
        System.out.println("");
    }
    //withdraw
    public void withdraw(){
        boolean valid=true;
        String input;
        double amount=0;
        System.out.println("-WITHDRAWAL-");
        System.out.println("====================");
        do{
            try{
                valid=true;
                System.out.print("How much money do you wish to withdraw ?: Rm");
                input=sc.nextLine();
                amount = Double.parseDouble(input);
                if (amount>1000.00){
                    System.out.println("You cannot withdraw more than rm1000!");
                    valid=false;
                }
                if (amount<=0){
                    System.out.println("You cannot withdraw rm0 or less!");
                    valid=false;
                }
            
            }catch(NumberFormatException e){
                valid=false;
                System.out.println("That is an invalid amount. Please re-enter the amount desired");
            }
        }while(!valid);
        balance = balance - amount;
        System.out.println("Rm"+amount+" has been withdrawn");
        System.out.println("New balance: Rm"+twoDp.format(balance));
        System.out.println("");
    }
    //deposit
    public void deposit(){
        boolean valid=true;
        String input;
        double amount=0;
        System.out.println("-DEPOSIT-");
        System.out.println("====================");
        do{
            try{
                valid=true;
                System.out.print("How much money do you wish to deposit ?: Rm");
                input=sc.nextLine();
                amount = Double.parseDouble(input);
                if (amount<=0){
                    System.out.println("You cannot deposit rm0 or less!");
                    valid=false;
                }
            }catch(NumberFormatException e){
                valid=false;
                System.out.println("That is an invalid amount. Please re-enter the amount desired");
            }
     
    
        }while(!valid);
        balance = balance + amount;
        System.out.println("Rm"+amount+" has been deposited");
        System.out.println("New balance: Rm"+twoDp.format(balance));
        System.out.println("");
        
    }
    //account details
    @Override
    public String toString(){
        return "Account no: "+accountNo+"\nBalance: Rm"+twoDp.format(balance);
    
    }
}
    
    

   

    

   


