/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical_11;

/**
 *
 * @author User
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Practical_11 {
    static Scanner sc = new Scanner(System.in);
    public static void imagingCupDrive(){
        Random random = new Random();
        ImagingCup[] imagingCup = new ImagingCup[5];
        ImagingCup temp = new ImagingCup();
        int x;
        for (x=0;x<=4;x++){
            temp.setGroupName("Group "+(x+1));
            temp.setProjectTitle("Project "+(x+1));
            temp.setNoOfMembers(random.nextInt(11));
            imagingCup[x]=temp;
            System.out.println(imagingCup[x]);
            System.out.println("Amount Collected: RM"+temp.calcCollectionPerGroup());
            System.out.println();
        }
    }
    public static void bakeryDriver(){
        Bakery cake1 = new Bakery();
        Bakery cake2 = new Bakery("Strawberry","1.5",1,20.0);
        System.out.println(cake1);
        System.out.println(cake2);
        System.out.println("The price of a 1kg Chocolate Moist cake is: RM "+cake1.getPrice());
        
    }
    public static void orderCake(){
        ArrayList<Bakery> cakes = new ArrayList<Bakery>();
        int noCakeType=0;
        String temp;
        boolean valid=true;
        do{
            try{
                System.out.print("Please enter the number of types of cakes you would like to order: ");
                temp=sc.nextLine();
                noCakeType=Integer.parseInt(temp);
                valid=true;
                if (noCakeType<=0){
                    System.out.println("The number of types of cakes should be positive.");
                    valid=false;
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please only input integers.");
                valid=false;
            }
        }while (!valid);
        
        Bakery bakery = new Bakery();
        bakery.displayFlavours();
        bakery.priceList();
       for(int x=0;x<=noCakeType;x++){
           System.out.println("Bakery Item "+ (x+1));
           System.out.println("---------------");
           do{
               try{
                   System.out.print("Please enter your choice of cake (1 - 5): ");
                   temp=sc.nextLine();
                   int choice=Integer.parseInt(temp);
                   valid=true;
                   if (choice<1 || choice>5){
                       System.out.println("Please enter only a digit from 1 to 5 for your choice of flavour.");
                       valid=false;
                   }
               }catch(NumberFormatException e){
                   System.out.println("Please enter only a digit from 1 to 5 for your choice of flavour.");
                   valid=false;
               }
           }while (!valid);
           
           do{
               try{
                   System.out.print("Please enter the Weight Of Cake (1 - 1kg, 2 - 2kg and 3 - 3kg): ");
                   String cakeWeight=sc.nextLine();
                   int testCakeWeight=Integer.parseInt(cakeWeight);
                   valid=true;
                   if (testCakeWeight<1 || testCakeWeight>3){
                       System.out.println("Sorry but only cakes of 1,2 and 3kg are available.");
                       valid=false;
                   }
                   
               }catch (NumberFormatException e){
                    System.out.println("Sorry but only cakes of 1,2 and 3kg are available.");
                    valid=false; 
               }
           }while(!valid);
           do{
               try{
                   System.out.print("Please enter quantity ordered: ");
                   temp=sc.nextLine();
                   int quant= Integer.parseInt(temp);
                   valid=true;
                   if (quant<0){
                       System.out.println("Quantity ordered should be positive.");
                       valid=false;
                   }
                           
                   }catch(NumberFormatException e){
                       System.out.println("Quantity ordered should be a positive integer.");
                       valid=false;
                   }
               }while(!valid);
           }
       
           
           
           
            
       }
    
  
    

 
    public static void main(String[] args) {
        orderCake();
        
        
    }
    
}
