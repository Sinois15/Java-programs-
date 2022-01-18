/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop;

/**
 *
 * @author User
 */
public class Computer {
 private String model;
 private int qty = 0;

 public Computer(String m) {
 model = m;
 qty++;
 }

 public int getQty() {
 return qty;
 }

 public void showDetail() {
 System.out.println("MODEL :" + model);
 }
}
