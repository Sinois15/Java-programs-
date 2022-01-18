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
public class investment {
    public static void main(String[] args){
        
        //creating instance of object scanner named 'input'
        Scanner input= new Scanner(System.in);
        //declaring variables
        double investment; double interestRate;int nyears;double finvestment;double MiRate;
        //prompting user for input and inputting values
        System.out.println("enter the investment amount: ");
        investment=input.nextDouble();
        System.out.println("enter the annual interest rate in percentage: ");
        interestRate=input.nextDouble();
        MiRate= interestRate/12;
        
                
        
        
        System.out.println("enter the number of years: ");
        nyears=input.nextInt();     
        

        //calculating value of future investment
        finvestment= investment*Math.pow((1+(MiRate/100)),(nyears*12));
        //output value of future investment
        System.out.println("the accumulated value is $"+finvestment);
        
    }
    
}
