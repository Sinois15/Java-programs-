/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//importing object Scanner from java.util
import java.util.Scanner;
public class aboveAverageArray {
    public static void main (String[] args){
        //instantiating object Scanner
        Scanner input=new Scanner(System.in);
        //declaring variables and array
        double[] num = new double[8];
        int x,over=0;
        double avg,sum=0;
        //prompting for input
        System.out.println("Please input 8 positive numbers");
        //loop for input
        for (x=0;x<=7;x++){
            System.out.print("Please enter number["+(x+1)+"]: ");
            num[x]=input.nextDouble();
            input.nextLine();
            //checking whether input is positive
            while(num[x]<0){
                System.out.print("invalid input. Please enter a positive number: ");
                num[x]=input.nextDouble();
                input.nextLine();
            }
            //calculating sum
            sum=sum+num[x];
    }
        //calculating average
    avg=sum/8;
    //using loop to count the number of positive numbers greater than the average
    for (x=0;x<=7;x++){
        if (num[x]>avg){
            over++;
        }
    }
    //output
    System.out.println("the average of the 8 numbers is: "+avg);
    System.out.println(over+" are greater than the average.");
}
}
