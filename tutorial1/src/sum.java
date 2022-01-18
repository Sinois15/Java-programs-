/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//calling object scanner from util
import java.util.Scanner;
public class sum {
    public static void main(String[] args){
        //creating input, which is an instance of object scanner(pu ki kav input sa. )
        Scanner input=new Scanner(System.in);
        //input
        System.out.println("enter a number: ");
        double num1=input. nextDouble();
        System.out.println("enter another number: ");
        double num2=input. nextDouble();
        //addition of the 2 numbers
        double sum= num1 + num2;
        //output of sum
        System.out.print("the sum of the 2 numbers is " +sum);
        
        
        
    }
}
