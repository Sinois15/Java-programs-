/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class tableFloat {
    public static void main (String [] args){
        //declaring variables
        double a; double b;String s;double multiple;
        //initialising variables
        a=1;
        b=a+1;
        s="  ";
        //table header
        System.out.println("a"+s+"b"+s+"pow(a,b)");
        //loop
        while (a<6){
            //using power function to calculate values of "pow(a,b)" column
            multiple=Math.pow(a,b);
            //converting float to integer
            int c=(int)a;
            int d=(int)b;
            int m= (int)multiple;
            //outputting values of table
            System.out.println(c+s+d+s+m);
            a=a+1;
            b=a+1;
            
            
        }
        
    }
    
}
