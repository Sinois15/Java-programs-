
package labtest1;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Labtest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //creating a format to set values to two dp
        DecimalFormat twoDp=new DecimalFormat("###.00");
        //declaration of variables
        double mPrice,total,tax,cash,change;
        String cont="1";
        while (!cont.equals("0")){
            
            //inputting and validating meal price
            do{
            System.out.print("Please enter the price of the meal: RM");
            mPrice=sc.nextDouble();
            sc.nextLine();
            if (mPrice<0){
                System.out.println("Meal price is negative.");
                if (mPrice==0){
                    System.out.println("Meal price cannot be zero.");
                }
            }
            }while(mPrice<=0);
            
            //calculating tax
            tax=0.06*mPrice;
            //calculating discounted price if meal price is more than 200
            if ((1.06*mPrice)>200){
                total=0.95*(tax+mPrice);
            }else total=(mPrice+tax);
            //inputting and validating amount tendered
            do{
            System.out.print("Please enter the amount tendered: RM");
            cash=sc.nextDouble();
            sc.nextLine();
            if(cash<total){
                System.out.println("Insufficient amount tendered ");
                if(cash<0){
                 System.out.println("Amount tendered is negative. ");
            }
            }
            }while(cash<total || cash<0);
            //calculating change
            change=cash-total;
            //output
            System.out.println("");
            System.out.println("****Pizza House****");
            System.out.println();
            System.out.println("Price Of Meal: RM"+mPrice);
            System.out.println("Sales Tax: RM"+twoDp.format(tax));
            System.out.println("--------------------------------");
            System.out.println("Total Amount: RM"+twoDp.format((mPrice+tax)));
            if(mPrice>200){
                System.out.println("Discounted Amount: RM"+twoDp.format(total));
            }
            System.out.println();
            System.out.println("Amount Tendered: RM"+cash);
            System.out.println("--------------------------------");
            System.out.println("Change Cash: RM"+twoDp.format(change));
            System.out.println("To continue, press any key.");
            System.out.println("To quit, enter 0");
            System.out.println("Continue?: ");
            cont=sc.nextLine();
        }
        System.out.println("****Thank You****");
    }
    
}
