/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompanythree;

/**
 *
 * @author User
 */
public class Clerk extends EmployeeThree{
    private double cola;
    public Clerk(String n, double s, int y, double c){
        super(n,s,y);
        cola = c;
    }
    
    public double getCola() {
        return cola;
    }

    public void setCola(double cola) {
        this.cola = cola;
    }
    public void displayDetail(){
        super.displayDetail();
        System.out.println("Cost of living allowance: Rm"+cola);
    }

    
}
