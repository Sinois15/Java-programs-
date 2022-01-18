/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.Scanner;
import java.text.DecimalFormat;
public class OverloadMethodVolume {
    //declaring global variable
    static double volume;
    static String unit;
    //creating a format to output values to 1dp
     static DecimalFormat Onedp=new DecimalFormat("#.0");
    //instantiating object scanner as "input"
     static Scanner input=new Scanner(System.in);
    //method for rectanguler box volume
    public static void volume(double l,double w ,double h){
        volume=l*w*h;
        System.out.println("the volume of rectangular box is: "+volume+unit);
    }
    //method for cube volume
      public static void volume(double l){
        volume=Math.pow(l,3);
        System.out.println("the volume of cube is: "+volume+unit);
    }
      //method for cylinder volume
      public static void volume(double h,double r){
        volume=Math.PI*Math.pow(r,2)*h;
        System.out.println("the volume of cylinder is: "+Onedp.format(volume)+unit);
    }
      //main method
    public static void main(String[] args){
        //prompting and inputting unit of measure
        System.out.println("Please enter the unit of the measurements:");
        unit=input.nextLine();
        //calling each method 1 by 1 using test values from question
        volume(5,8,9);
        volume(5);
        volume(12,6);
        System.out.println("process completed.");
           
        
    }
}
