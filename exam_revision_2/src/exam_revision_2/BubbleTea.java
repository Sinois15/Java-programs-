/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam_revision_2;

/**
 *
 * @author User
 */
public class BubbleTea {
    private String teaName;
    private double teaPrice;
    private int teaQuantity;
    
    public BubbleTea(String teaName, int teaQuantity){
        this.teaName=teaName;
        this.teaQuantity=teaQuantity;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public double getTeaPrice() {
        return teaPrice;
    }

    public void setTeaPrice(double teaPrice) {
        this.teaPrice = teaPrice;
    }

    public int getTeaQuantity() {
        return teaQuantity;
    }

    public void setTeaQuantity(int teaQuantity) {
        this.teaQuantity = teaQuantity;
    }
    public double calcTotal(){
        double total;
        total = teaPrice * teaQuantity;
        return total;
    }
    @Override
    public String toString(){
        return "Tea name: "+teaName+"\nTea price: $"+teaPrice+"\nTea Quantity: "+teaQuantity+"Total price: $"+calcTotal();
    }
    
}
