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
public class PositiveNegativeZero {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int x;
        System.out.println("enter a number: ");
        x=input.nextInt();
        if (x>0){
            System.out.println("the number entered is positive");
        }
        else 
            if (x<0){
                System.out.println("the number entered is negative");}
                else
                System.out.println("the number enters is equal to zero");
                
                
            }
    }
    

