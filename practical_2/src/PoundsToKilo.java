/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//import object scanner from java util
import java.util.Scanner;
public class PoundsToKilo {
    public static void main(String[] arg){
//creating instance of object scanner named 'input'
       Scanner input=new Scanner(System.in);
       //declaring variables
       double lb; double kg;
       //prompting user for input
       System.out.println("enter a value in pounds:");
       //input
       lb=input.nextDouble();
       //converting to kilogram
       kg=lb*0.454;
       //output value in kilograms
       System.out.println(lb+"pounds is "+kg+" kilograms");
    
}
}
