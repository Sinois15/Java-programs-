/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical_test2;

/**
 *
 * @author User
 */
public class Practical_test2 {

    public class Family{
    
    private double income;
    private int size;
    public Family(double income, int size){
        this.income=income;
        this.size=size;

    }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
