package app;

import java.util.Scanner;
public class CountPoor{

    public static void main(String[] args){
        int poorCount=0,x,size=0,k=0;
        double income=0.0, housingCost=0.0, foodCost=0.0;
        String input;
        boolean valid;
        Scanner sc = new Scanner(System.in);
        do{
            
                System.out.print("Enter the number of families: ");
                input = sc.nextLine();
                k = Integer.parseInt(input);
                valid = true;
                if (k==0){
                    System.out.println("Number of families cannot be zero.");
                    valid=false;
                }
                else if (k<0){
                    System.out.println("Number of families cannot be negative.");
                    valid = false;
                }
            
    }while (!valid);
    Family[] family = new Family[k];
    double[] housingCostArray = new double[k];
    double[] foodCostArray = new double[k];
    for (x=0;x<k;x++){
        do{
            System.out.print("Enter the income of the family: $");
            input = sc.nextLine();
            income = Double.parseDouble(input);
            if (income < 0.0){
                System.out.println("Income cannot be negative");
                
            }   
        }while ( income<0);
        do{
            System.out.print("Enter the size of the family: ");
            input=sc.nextLine();
            size=Integer.parseInt(input);
                       
            if (size==0){
                System.out.println("The size of the family cannot be zero.");
                
            }
            else if (size<0){
                System.out.println("The size of the family cannot be negative.");
                
            }
        }while (income==0 || income<0);

        
        Family temp = new Family(income, size);
        family[x]=temp;
    
        
        do{
            
            System.out.print("Enter the average housing cost of the family: $");
            input=sc.nextLine();
            housingCostArray[x]=Double.parseDouble(input);
            
            if (housingCostArray[x]==0){
                System.out.println("Average housing cost cannot be zero.");
               
            }
            else if (housingCostArray[x]<0){
                System.out.println("Average housing cost cannot negative.");
                
            }

          
        }while (income==0 || income<0);
        do{
            
                System.out.print("Enter the aversge food cost of the family: $");
                input=sc.nextLine();
                foodCostArray[x]=Double.parseDouble(input);
                valid = true;
                if (foodCostArray[x]==0){
                    System.out.println("Average food cost cannot be zero.");
                    
                }
                else if (foodCostArray[x]<0){
                    System.out.println("Average food cost cannot be negative.");
                  
                }
            
        }while(income<=0);
        
    }
    System.out.println("list of poor family:");
    for(x=0;x<k;x++){
        if(family[x].isPoor(housingCostArray[x], foodCostArray[x])){
        System.out.println("family"+"["+(x+1)+"]: ");
        System.out.println(family[x]);
        
        }
        


    }
}

}
