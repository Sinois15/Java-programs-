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
public class MyFatherBank {

    public void init(){
        SavingAccount s1 = new SavingAccount("010001", 2000.0, 0.06);
        SavingAccount s2 = new SavingAccount("010002", 5000.0, 0.03);
        SavingAccount s3 = new SavingAccount("010003", 1000.0);
        CurrentAccount c1 = new CurrentAccount("020001", 4000.0, 5000.0);
        CurrentAccount c2 = new CurrentAccount("020002", 10000.0, 8000.0 );
        PowerSaving p1 = new PowerSaving("030001", 2200.0, 0.05,3000.0 );
        PowerSaving p2 = new PowerSaving("030002", 1900.0, 0.04,2000.0);
        
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
        c1.displayDetails();
        c2.displayDetails();
        s1.deposit(200);
        c1.deposit(100);
        s1.displayDetails();
        c1.displayDetails();
        s1.withdraw(4000);
        c1.withdraw(200);
        s1.displayDetails();
        c1.displayDetails();
        s2.withdraw(12000);
        c1.withdraw(0);
        c2.withdraw(0);
        s1.rollYear();
        s2.rollYear();
        s3.rollYear();
        s1.displayDetails();
        s2.displayDetails();
        s3.displayDetails();
        p1.displayDetails();
        p2.displayDetails();

    }
    public static void main(String[] args) {
        MyFatherBank mfb = new MyFatherBank();
        mfb.init();
    
}
}
