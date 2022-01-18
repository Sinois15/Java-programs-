package app;

import java.util.Scanner;
public class CountPoor{

    public static void main(String[] args){
        int x,size=0,k=0;
        double income=0.0;
        String input;
        boolean valid=true;
        Scanner sc = new Scanner(System.in);
        do{
            try{
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
            }catch(NumberFormatException e){
                System.out.println("The number of families should be a positive integer.");
            }
            
    }while (!valid);
    Family[] family = new Family[k];
    double[] housingCostArray = new double[k];
    double[] foodCostArray = new double[k];
    for (x=0;x<k;x++){
        do{
            try{
            System.out.print("Enter the income of the family["+(x+1)+"]:  $");
            input = sc.nextLine();
            valid = true;
            income = Double.parseDouble(input);
            if (income < 0.0){
                System.out.println("Income cannot be negative");
                valid = false;
                
            }  
        }catch(NumberFormatException e){
            System.out.println("The income of the family should be a positive float number.");
            valid = false;
        } 
        }while ( !valid);
       // valid=false;
        do{
            try{
                System.out.print("Enter the size of the family["+(x+1)+"]: ");
                input=sc.nextLine();
                size=Integer.parseInt(input);
                valid = true;
                if (size==0){
                    System.out.println("The size of the family cannot be zero.");
                    valid = false;
                }
                else if (size<0){
                    System.out.println("The size of the family cannot be negative.");
                    valid = false;
                }
            }catch (NumberFormatException e){
                    System.out.println("The size of the family should be a positive integer.");
                    valid = false;
                }
        }while (!valid);

        
        Family temp = new Family(income, size);
        family[x]=temp;
    
        
        do{
            
            System.out.print("Enter the average housing cost of the family["+(x+1)+"]:  $");
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
            
                System.out.print("Enter the aversge food cost of the family["+(x+1)+"]:  $");
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
    sc.close();
    System.out.println();
    System.out.println("list of poor family:");
    for(x=0;x<k;x++){
        if(family[x].isPoor(housingCostArray[x], foodCostArray[x])){
        System.out.println("family"+"["+(x+1)+"]: ");
        System.out.println(family[x]);
        System.out.println("Status: Poor.");
        System.out.println();
        }
        


    }
}

}
