/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 //import object Scanner from java.util
 */import java.util.Scanner;
public class reverse {
    //creating method reverse taking in integer parameter
    public static void reverse(int number){
        //declaring variables
        int x,size;
        //converting num to string data type
        String num=Integer.toString(number);
        //assigning the length value of string num to variable size
        size=num.length();
        //outputting the entered number in reverse
        System.out.print("the inputted integer in reverse is: ");
        for(x=size-1;x>=0;x--){
           System.out.print(num.charAt(x));
        }         
    }
    //main praogram
    public static void main(String[] args){
        //declaring variables
        int number;
        //instantiating object Scanner
        Scanner input=new Scanner(System.in);
        //prompting for input
        System.out.print("Please enter an integer: ");
        //input
        number=input.nextInt();
        input.nextLine();
        //calling method reverse using parameter "number"
        reverse(number);
    }
}
