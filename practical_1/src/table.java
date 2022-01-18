/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class table {
      public static void main(String[] args){
          //declaring variables
          double a; double b;double c;double d;; double x;String space;
          //initialising variables
          space=("   ");
          a=1;
          b=0;
          c=0;
          d=0;
          x=1;
          
          //creating table
        System.out.println("a    a^2    a^3    a^4");
        while (x<5){
            b=Math.pow(a,2);
            c=Math.pow(a,3);
            d=Math.pow(a,4);
            
        
        
            System.out.println(a+space+b+space+c+space+d);
            //incrementing values
            a++;
            x++;
                    
    }
}
