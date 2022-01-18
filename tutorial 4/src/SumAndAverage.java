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
public class SumAndAverage{
    public static void main (String[] args){
        //instantiating object Scanner as "input"
        Scanner input=new Scanner(System.in);
        //declaring variables and array
        int num[]=new int[5];int x;int sum;int avg;int y;String choice;
        choice="Y";
        //loop
       while(choice.equals("Y") && !choice.equals("X")){
           //initialising variables
           y=0;sum=0;avg=0;
           //input
        System.out.println("input 5 integer numbers");
        for(x=0;x<5;x++){
            System.out.print("integer "+(x+1)+": ");
            num[x]=input.nextInt();
            input.nextLine();
            //calculating sum
            sum=sum+num[x];
        }
        //calculating average
        avg=sum/5;
        //output sum and average
        System.out.println("the sum of 5 numbers is : "+sum);
        System.out.println("the Average is : "+avg);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        //prompting whether to continue or not
        System.out.println("Do you want to continue? ");
        System.out.println("Press Y to continue ");
        System.out.println("Press X to exit ");
        System.out.print("Your choice [Y/X]: ");
        choice=input.nextLine();
        //validating choice
        if (!(choice.equals("Y"))){
            if ((!choice.equals("X"))){
            //looping for correct choice input in case of initial incorrect input
            while(!(choice.equals("Y")) && (!choice.equals("X"))){
            System.out.println("invalid input. Please enter either Y or X");
            System.out.print("Your choice [Y/X]: ");
            choice=input.nextLine();
            }
            }
        
    }
}
    }
    }

    
    
