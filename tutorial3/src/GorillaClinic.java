/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *;
 * @author User
 */
//
//importing object scanner from java utility
import java.util.Scanner;
public class GorillaClinic {
    public static void main(String[] args){
        //creating instance of object scanner called input
        Scanner input=new Scanner(System.in);
        //decalration of variable
        String Cname; int Scode; int NoHours; String Sname; double Scharge;int x;
        //initialising x
        x=0;
        //prompting user for input and inputting values
        System.out.println("enter customer's name: ");
        Cname=input.nextLine();
        System.out.println("enter the number of service hours: ");
        NoHours=input.nextInt();
        //giving the user the valid input options for the service code
        System.out.println("service code options:");
        System.out.println("a. 111");
        System.out.println("b. 222");
        System.out.println("c. 333");
        System.out.println("Please choose one of the above options and enter the service code: ");
        Scode=input.nextInt();
        //loop for validation of service code
        while(x==0){
            if ((Scode!=111) && (Scode!=222) &&(Scode!=333)){
            
                System.out.println("Invalid service code. Please enter one the service code options listed above: ");
                Scode=input.nextInt();
        }
                else
                   x=1;
                        
        }
        //checking the service code inputted to output the appropriate content
        if (Scode==111){
            //assigning value to Sname according to service code inputted
            Sname="Deworm";
            //calculatin service charge
            Scharge= 100.00*NoHours;
        }
        else
            if (Scode==222){
                Sname="Vaccine";
                Scharge= 150.00*NoHours;
            }
            else{
                Sname="Skin Disesase";
                Scharge=70.00*NoHours;}
        //output
        System.out.println("Name: "+Cname);
        System.out.println("code: "+Scode);
        System.out.println("Hour: "+NoHours);
        System.out.println("");
        System.out.println("Service name: "+Sname);
        System.out.println("Fee: RM"+Scharge);
                
  
        }
        
    }
