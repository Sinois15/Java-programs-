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
public class Company {


 public void init() {
 Officer staff1 = new Officer("Joyah", 3000, 300);
 Manager staff2 = new Manager("Minah", 8000,"Honda Accord");
 staff1.displayDetail();
 staff2.displayDetail();
 }
 public static void main(String args[]) {
 Company mct = new Company();
 mct.init();
 }
} 
