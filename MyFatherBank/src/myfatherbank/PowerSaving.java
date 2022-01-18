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
public class PowerSaving extends SavingAccount {
    private double EOTL;
    public PowerSaving(String acNo, double balance,double yRate, double EOTL){
        super(acNo, balance,yRate);
        this.EOTL = EOTL;
    }
    public void displayDetails(){
        System.out.println("====POWERSAVING====");
        //System.out.println("");
        super.displayDetails();
        System.out.println("EOTL: Rm"+EOTL);
    }
    
}
