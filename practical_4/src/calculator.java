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
public class calculator {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int num,sum,pos,neg,x ;
        double avg;
        String exit;
        sum=0;pos=0;neg=0;x=0;exit="1";
        System.out.println("This program takes in a number of integers of your choice");
        while(!exit.equals("0")){
            System.out.print("Please enter an integer: ");
            num=input.nextInt();
            input.nextLine();
            x++;
            if (num!=0){
                if (num>0){
                    pos++;}
                    else
                    neg++;
                }
            sum=sum+num;
            System.out.print("To continue, press any key, otherwise enter 0: ");
            exit=input.nextLine();
            //input.nextLine();
            }
        avg=sum/x;
        System.out.println("the number of positives is "+pos);
        System.out.println("the number of negatives is "+neg);
        System.out.println("the total is "+sum);
        System.out.println("the average is "+avg);
        }
                
    }

