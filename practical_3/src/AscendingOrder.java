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
public class AscendingOrder {
 public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        double max; double min;double mid;int x;
       double numbers[]=new double[3];
        max=0;
        min=9999999;
        mid=1;
        System.out.println("please enter 3 numbers");
         for (x=0;x<3;x++){
                     System.out.println("enter a number: ");
                     numbers[x]=input.nextDouble();}
         for  (x=0;x<3;x++){
             if (numbers[x]>max)
                 max=numbers[x];
             if (numbers[x]<min)
                 min=numbers[x];
                 
         }
         for  (x=0;x<3;x++){
             if (numbers[x]!=min && numbers[x]!=max)
                 mid=numbers[x];  }
         System.out.println("the inputs in sorted order are:");
            System.out.println(min);
            System.out.println(mid);
            System.out.println(max);

    
}
}
