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

 public class Manager extends EmployeeThree {
    private String car;
   
    public Manager(String n, double s, String c,int y) {
        super(n,s,y);
        car = c;
        
    }
    public String getCar() {
        return car;
    }
    public void displayDetail() {
        super.displayDetail();
        System.out.println("CAR : " + car);
    }

   }



