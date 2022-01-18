/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompany;

/**
 *
 * @author User
 */
public class MyCompany {

 public static void main(String args[]) {

 Employee staff1 = new Employee("Mamat",2000,60);
 Employee staff2 = new Employee("Minah",500,30);
 
 staff2.deductEPF();

 System.out.println(staff1);
 System.out.println(staff2);
 
 }
}

