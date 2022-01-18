/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiccal.pkg7;

/**
 *
 * @author User
 */
import java.text.DecimalFormat;
import java.util.*;
public class Practiccal7 {
        static Scanner input=new Scanner(System.in);
        static ArrayList<String> item=new ArrayList<>(Arrays.asList("milo","water","coke","tea","coffee"));
        static ArrayList<Double> price=new ArrayList<>(Arrays.asList(3.00, 1.00, 5.00, 2.00, 3.50));
        static ArrayList<Integer>quantity=new ArrayList<>(Arrays.asList(200, 500, 350, 100, 700));
        static int x;
        static DecimalFormat twoDp=new DecimalFormat("####.00");
        public void generate(){
            System.out.print("String [] item = { ");
            System.out.print(item.get(0));
            for (x=1;x<item.size();x++){
                System.out.print(", "+item.get(x));
            }
            System.out.println("};");
            System.out.print("double [] price = { ");
            System.out.print(price.get(0));
            for (x=1;x<item.size();x++){
                System.out.print(", "+price.get(x));
            }
            System.out.println("};");
            System.out.print("int [] quantity = { ");
            System.out.print(quantity.get(0));
            for (x=1;x<item.size();x++){
                System.out.print(", "+quantity.get(x));
            }
            System.out.println("};");
            
        }
        public void partA(){
            
            for(x=0;x<item.size();x++)
                if(item.get(x).equals("coke")){
            item.set(x,"pepsi");
            price.set(x,6.00);
                }
        }
        public void display(){
            double sum=0,total=0;
            String s="         ";
            
            System.out.println("Sales of the day:");
            System.out.println("   item       quantity    price    total");
            for(x=0;x<item.size();x++){
                int y=(item.get(x).length()+4);
                int z;
                total=price.get(x)*quantity.get(x);
                sum+=total;
                System.out.print((x+1)+") ");
                System.out.print(item.get(x));
                for(z=1;z<=15-y;z++){
                    System.out.print(" ");
                }
                System.out.print(quantity.get(x)+"         "+twoDp.format(price.get(x))+"     "+twoDp.format(total) );
                System.out.println("");
            }
            System.out.print("TOTAL INCOME: RM"+twoDp.format(sum));
            System.out.println(" ");
        }
        public void replace(){
            String name;
            int y=0,quant;
            double value;
             System.out.print("Please enter the name of the item you wish to replace: ");
                        name=input.nextLine();
                        for(x=0;x<item.size();x++){
                            if(name.equals(item.get(x))){
                                System.out.print("Please the name of the new item: ");
                                name=input.nextLine();
                                System.out.print("Please the price of the new item: ");
                                value=input.nextDouble();
                                System.out.print("Please the quantity of the new item: ");
                                quant=input.nextInt();
                                item.set(x, name);
                                price.set(x,value);
                                quantity.set(x, quant);
                            }else y++;
                            }
                        if (y==item.size()){
                            System.out.println("item not found");
                        }
                        
        }
        public void edit(){
            int edit=0,z=0,y=0,quant;
            double value;
            boolean error=false,notfound=true;
            String name;
            System.out.print("Please enter the name of the item you want to edit: ");
            name=input.nextLine();
            for (x=0;x<item.size();x++){
                if (name.equals(item.get(x))){
                    
                do{
                    try{
                    System.out.println("[1].item name  [2].quantity  [3].price");
                    System.out.print("Please 1,2 or 3 to edit the name,quantity or price of the item respectively: ");
                    edit=input.nextInt();
                    input.nextLine();
                    if(edit!=1 && edit!=2 && edit!=3){
                        System.out.println("invalid input.");
                    }else z=1;
                    error=false; 
            }catch(InputMismatchException e){
                        System.out.println("Invalid input");
                        error=true;
                        input.nextLine();
                        }
                }while(z==0 && error);
            
            switch (edit){
                case(1):
                    System.out.print("Please enter the new name of the item: ");
                    name=input.nextLine();
                    item.set(y, name);
                    break;
                case(2):
                    System.out.print("Please enter the new quantity of the item: ");
                    quant=input.nextInt();
                    input.nextLine();
                    quantity.set(y, quant);
                    break;
                case(3):
                    System.out.print("Please enter the new price of the item: ");
                    value=input.nextDouble();
                    input.nextLine();
                    price.set(y, value);
                    break;
            }
                }else y++;
        }
            if (y==item.size()){
                System.out.println("item not found");
             }
        }
        public void clearScreen(){
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        }
        public void app(){
            int choice=-1;
            while(choice!=0){
                System.out.println("");
            System.out.println("[1].print report  [2].replace item  [3].edit item  [0].exit");
            System.out.print("Please enter the number for the action you wish to perform: ");
            choice=input.nextInt();
            input.nextLine();
            System.out.println("");
            while(choice!=1 && choice!=2 && choice!=3 && choice!=0){
               try{
                System.out.print("invalid input. Please either enter 1,2,3 or 0 according to the action you wish to perform.");
                System.out.print("Please re-enter your choice: ");
                choice=input.nextInt();
                input.nextLine();
            }catch(InputMismatchException e){
                System.out.print("invalid input. Please either enter 1,2,3 or 0 according to the action you wish to perform.");
                System.out.print("Please re-enter your choice: ");
                    }
            }
            switch (choice){
                case (1):
                    clearScreen();
                    display();
                    break;
                case(2):
                    clearScreen();
                    replace();
                    break;
                case(3):
                    clearScreen();
                    edit();
                    break;
                        
            } 
            }
        }
        
    public static void main(String[] args) {
        Practiccal7 p7 = new Practiccal7();
        //generate();
        //partA();
        //display();
        p7.app();
        
        
        

    }
    
}
