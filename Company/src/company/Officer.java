/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

/**
 *
 * @author User
 */
public class Officer extends Employee {
 private double petrol;
 public Officer(String n, double s, double p) {
 super(n,s);
 petrol = p;
 }

 public void displayDetail() {

 super.displayDetail();
 System.out.println("PETROL : " + petrol);
 }
}