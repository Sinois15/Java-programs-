/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompanythree;

public class Officer extends EmployeeThree {
    private double petrol;
    
    public Officer(String n, double s, double p,int y) {
       super(n,s,y);
       petrol = p;
       
    }

    
    public double getPetrol() {
       return petrol;
    }
    public void displayDetail() {
       super.displayDetail();
       System.out.println("PETROL : " + petrol);
    }
}