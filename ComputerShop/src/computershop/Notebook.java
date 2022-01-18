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
public class Notebook extends Computer {
 private double weight;
 private double price;

 public Notebook(String m, double w) {
 super(m);
 weight = w;
 }

 public void showComputerType() {
 System.out.println("This is a notebook");
 }


 public void showDetail() {
 super.showDetail();
 System.out.println("WEIGHT :" + weight);
 System.out.println("PRICE :" + price);
 }
}

