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
public class Employee {

 private String name;
 private double salary;
 Employee (String n, double s) {
 name = n;
 salary = s;
 }

 public String getName() {
 return name;
 }

 public double getSalary() {
 return salary;
 }
 public void displayDetail() {
 System.out.println("==========================");
 System.out.println("NAME : " + name);
 System.out.println("SALARY : " + salary);
 }
} 
