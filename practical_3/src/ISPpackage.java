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
public class ISPpackage {
    public static void main (String[] args){
        Scanner input= new Scanner(System.in);
        String choice; double bill; int NoHours; int x;
        bill=0;x=0;
        System.out.println("Please enter the number of hours you used your internet access:");
        NoHours=input.nextInt();
        input.nextLine();
        System.out.println("Here are the internet package choices offered: ");
        System.out.println("1. Package A");
        System.out.println("2. Package B");
        System.out.println("3. Package C");
        System.out.println("please enter A,B or C according to the package you purchased:");
        choice=input.nextLine();
        
       
        while (x==0){
            if ((!choice.equals("A")) && (!choice.equals("B")) && (!choice.equals("C"))) {
            System.out.println("invalid input. Please enter A,B or C according to the package you purchased:");
            choice=input.nextLine();
           
            }
            else
                x=1;
            
        }      
    switch (choice){
        case "A":
            if (NoHours>10){
            bill=9.95+(NoHours-10)*2;break;}
            else
                bill=9.95;break;
            
        case "B": 
            if (NoHours>20){
            bill=13.95+(NoHours-20);break;}
            
            else
                bill=13.95;break;
                
        case "C":
            bill=19.95;break;
        
    } 
    System.out.println("your monthly bill amounts to:"+bill);
   
}
    
}
