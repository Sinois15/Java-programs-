/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 * 
 */
//import object scanner from java util
import java.util.Scanner;
public class SumOfDigitsInANumber {
    public static void main(String[] arg){
        //creating instance of object scanner named 'input'
        Scanner input= new Scanner(System.in);
        //declaring variables
        int num;int sum;int x;
        //initialising variables
        num=0;sum=0;x=0;
        //prompting user
        System.out.println("enter a number between 1 and 1000: ");
        //input
            num=input.nextInt();
            //condition in case of invalid input
            while (num<1 || num>999){
                System.out.println("invalid number, re-enter a number between 0 and 1000: ");
                num=input.nextInt();}
                //using loop to calculating sum
             while (x==0){
                    if (num>0){  
                    sum=sum+(num%10);
                    num= num/10;}
                    else
                    //condition to exit loop
                    x=1;
                }
                //output sum
                System.out.println("the sum of the digits in the number is: "+ sum);
                
                
            
            
            
            
         }
       
    }
                
            
            
           
            
    

         
            
            
            
            
                        
            
            
        
        
        
    
    

