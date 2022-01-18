/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime;

/**
 *
 * @author User
 */
public class Prime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num=2, x, prime=0, quotient,remainder;
        boolean stop = false;
        do{
            for (x=1;x<=num;x++){
                quotient = num/x;
                remainder = num%x;
                if ((remainder==0) && (quotient==1)){
                        System.out.print(num + " ");
                        prime++;
                }
                num++;
                if((prime%10)==0){
                    System.out.println("");
                }
                if (prime==50){
                    stop = true;
                }
                }   
            
        }while(!stop);
    }
}
