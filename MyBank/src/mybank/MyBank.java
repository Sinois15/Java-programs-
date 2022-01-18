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
import java.util.ArrayList;
import java.util.Scanner;
public class MyBank {

    
    public void run(){
    //creating arraylist of type savingAccount named accounts
        ArrayList<savingAccount> accounts = new ArrayList<savingAccount>();
        Scanner sc = new Scanner(System.in);
        //adding accounts to the arraylist
        accounts.add(new savingAccount("121515", 6000.00));
        accounts.add(new savingAccount("038989", 1500.00));
        System.out.println("-WELCOME-");
        System.out.println("");
        //deducting service fee in each account
        for(int x=0;x<accounts.size();x++){
            accounts.get(x).serviceFee();
            System.out.println(accounts.get(x));
            System.out.println("");
            
        }
        System.out.println("====================");
        //depositing money in account 121515
        accounts.get(0).deposit(500.00);
        accounts.get(1).withdraw(9999.00);
        //account details
        System.out.println("-ACCOUNT DETAILS-");
        System.out.println("====================");
        for(int x=0;x<accounts.size();x++){
            System.out.println(accounts.get(x));
            System.out.println("");
    }
    }
    public static void main(String[] args) {
        MyBank mb = new MyBank();
        mb.run();
        
            
        }
        
    }
    

