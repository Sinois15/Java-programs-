 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.text.DecimalFormat;
import java.util.Scanner;
public class LoanAndInterest {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        DecimalFormat twoDP = new DecimalFormat("######.00 ");
        DecimalFormat threeDP = new DecimalFormat("######.000 ");
        int loan,nyears,x;
        String s;
        double iRate = 5.000;
        double p1,p2,n,r;
        double mPay[]=new double[60];
        double tPay[]=new double[50];
        x=0;s="             ";
        System.out.print("Please enter your loan amount: ");
        loan=input.nextInt();
        input.nextLine();
        System.out.print("Please enter your loan period in years: ");
        nyears=input.nextInt();
        input.nextLine();
        while (iRate<8.000){
            iRate=iRate+0.125;
            n=nyears*12;
            r=(iRate/100)/12;
            p1=loan*r;
            p2=Math.pow(1+r,n);
            mPay[x]=p1/(1-1/p2);
            tPay[x]=mPay[x]+(nyears*12);
            System.out.println("Interest Rate       Monthly Payment       Total Payment ");
            System.out.println(threeDP.format(iRate)+"%"+s+twoDP.format(mPay[x])+s+twoDP.format(tPay[x]));
            
        }
    }
    
}
