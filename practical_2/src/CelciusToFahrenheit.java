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
public class CelciusToFahrenheit {
    

    public static void main(String[] arg){
        //creating instance of object scanner named 'input'
       Scanner input=new Scanner(System.in);
       //declaring variables
       double tempC; double tempF;
       //prompting user
       System.out.println("enter a value in celcius:");
       //input
       tempC=input.nextDouble();
       //converting to fahrenheit
       tempF=9.0/5 * tempC +32;
       //output temp in fahrenheit 
       System.out.println(tempC+"celcius is "+tempF+" fahrenheit");
    
}
}
