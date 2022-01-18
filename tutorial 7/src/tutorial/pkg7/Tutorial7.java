/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.pkg7;

/**
 *
 * @author User
 */
//importing everything form java.util
import java.util.*;
//importing object arraylist
import java.util.ArrayList;
//importing object Scanner
import java.util.Scanner;
public class Tutorial7 {

   
    public static void main(String[] args) {
        //instantiating object Scanner
        Scanner input=new Scanner(System.in);
        //creating arraylists
        ArrayList<String> name=new ArrayList<String>();
        ArrayList<Double> salary=new ArrayList<Double>();
        //declaring variables
        boolean found=false,error=false;
        int x=0;
        double s=0,total=0; 
        String n,exit=" ";
        //start of enterinng data into the arraylist
        System.out.println("+================+");
        System.out.println("|   DATA ENTRY   |");
        System.out.println("+================+");
        //loop to input data
        while(!exit.equals("n")){
            System.out.print("Please enter an employee name: ");
            //input
            n=input.nextLine();
            //adding data into the arraylist
            name.add(n);
            //loop for validating salary in cse user inputs something other than digits
        do{
            try{
            System.out.print("Please enter the employee's salary: $");
            s=input.nextDouble();
            input.nextLine();
            salary.add(s);
           error=false;
        }catch(InputMismatchException e){
            System.out.println("invalid input.");
            input.nextLine();
            error=true;
          }
          }while(error);
        //calculating total
            total+=s;
            //promting user if he/she wants to continue
            System.out.println("to continue entering data, enter any character, else enter 'n'");
            System.out.print("input: ");
            exit=input.nextLine();
        }
        //displaying data stored in both arraylists
        System.out.println("");
        System.out.println("+================+");
        System.out.println("|  DATA DISPLAY  |");
        System.out.println("+================+");
        System.out.println("List of employees: ");
        for(x=0;x<=name.size()-1;x++) {
            int y;
            int z = name.get(x).length();
            String space;
            System.out.print(name.get(x));
                    for(y=1;y<=(15-z);y++){
                        System.out.print(" ");
                    }
                    System.out.print("$"+salary.get(x));
                    System.out.println("");
        }
        System.out.println("the total salary is: $"+total);
        System.out.println("");
        System.out.println("+=============+");
        System.out.println("| DATA SEARCH |");
        System.out.println("+=============+");
        System.out.println("");
        //prompting user to enter the name of the employee whose salary he/she wants to know
        System.out.print("Please enter the employee name whose salary you want to know: ");
        int c=0;
        //loop for searching the wanted salary by comparing inputted employee name
        for (x=0;x<=name.size()-1;x++){
            n=input.nextLine();
            if (n.equals(name.get(x))){
                System.out.println("the salary of the employee is: $"+salary.get(x));
                System.exit(0);
            }
            else 
                c++;
        }
        //outputting error message in case employee name is not found within the arraylist name
        if(c==name.size()){
            System.out.println("Sorry. Employee name not found.");
        }
        
    }
    
}
