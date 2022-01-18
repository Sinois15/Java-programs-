/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//importing object scanner
import java.util.Scanner;
public class sum {
    public static void main (String[] args){
        //creating instance of object scanner called input
        Scanner input= new Scanner(System.in);
        //declaring variables
        double num1; double num2; double sum;
        // inputting values
        System.out.println("enter a number:");
         num1= input.nextDouble();
         System.out.println("enter a another number:");
         num2= input.nextDouble();
         //sum
         sum=num1+num2;
         //output sum
         System.out.println("the sum of the two numbers is:" + sum); 
    }
}
