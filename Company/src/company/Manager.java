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
public class Manager extends Employee {
 private String car;
 public Manager(String n, double s, String c) {
 super(n,s);
 car = c;
 }

 public Manager(Employee e, String c) {
 super(e.getName(), e.getSalary());
 car = c;
 }
 public void displayDetail() {
 super.displayDetail();
 System.out.println("CAR : " + car);
 }
}

