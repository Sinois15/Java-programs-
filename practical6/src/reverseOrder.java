/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//importing InputMismatchException from java.util
//this exception happens when an input doesn't match the data type of the variable it is stored in
import java.util.InputMismatchException;
//importing object Scanner
import java.util.Scanner;
public class reverseOrder {
    public static void ComplicatedWay(){
         Scanner input=new Scanner(System.in);
        int x;
        boolean error=false;
        int[] z= new int[10]; 
        double[] num=new double[10];
        System.out.println("Please enter 10 integers");
        for (x=0;x<=9;x++){
            System.out.print("Please enter an integer: ");
            num[x]=input.nextDouble();
            input.nextLine();
            double y=Math.round(Math.floor(num[x]));
            double p=y+1;
            double n=y-1;
            while((y<num[x] && num[x]<p) || (n<num[x] && num[x]<y) ){
                System.out.print("invalid input. Please enter only integers (i.e whole numbers): ");
                num[x]=input.nextDouble();
                input.nextLine();
                y=Math.round(Math.floor(num[x]));
                p=y+1;
                n=y-1;
            }
             z[x]=(int)Math.round(num[x]);
        }
            
            System.out.print("The integers sorted in reverse order of input: ");
            for(x=9;x>=0;x--){
                System.out.print(z[x]+" ");
            }
            
    }
    public static void UsingNumberFormatException(){
        //instantiating object Scanner
        Scanner input=new Scanner(System.in);
        //declaring variables and array
        String y;
        int x=0;
        int[] num = new int[10];
        //prompting user for input
        System.out.println("Please enter 10 integers.");
        //loop for 9 inputs
        while(x<=9){
            System.out.print("Please enter an integer: ");
            y=input.nextLine();
            //validition of input in case user enters something other than an integer
            try{
                num[x]=Integer.parseInt(y);
                x++;
            }catch(NumberFormatException e){
                //prompting for re-input in case of previous invalid input
                System.out.println("invalid input. Please only enter whole numbers.");
            }
        }    
            System.out.print("The integers sorted in reverse order of input: ");
            for(x=9;x>=0;x--){
                System.out.print(num[x]+" ");
            }
    }
    public static void main(String[] args) {
        //instantiating object Scanner
        Scanner input=new Scanner(System.in);
        //declaring variables and array
        boolean error=false;
        int x=0;
        int[] num = new int[10];
        //prompting user for input
        System.out.println("Please enter 10 integers.");
        //looping for input
        do{
            //validition of input in case user enters something other than an integer
                try{
                    System.out.print("Please enter an integer: ");
                    num[x]=input.nextInt();
                    input.nextLine();
                    error=false;
                    x++;

                }
                catch(InputMismatchException e){
                    //prompting for re-input in case of previous invalid input
                    System.out.println("invalid input. Please enter only integers i.e whole numbers.");
                    input.nextLine();
                    error=true;
                }
            }while(error || x<=9);
        //outputting the integers in reverse order of input
        System.out.print("The integers sorted in reverse order of input: ");
            for(x=9;x>=0;x--){
                System.out.print(num[x]+" ");
            }
            }
    }




