/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//importing decimalformat from java.text
//DecimalFormat is used to create a format for decimal numbers
import java.text.DecimalFormat;
public class question_2 {
    //method squareRoot
    public static void squareRoot(){
        //declaring variables and array
        int x;
        int num[]=new int[20];
        //creating format fourDp
        DecimalFormat fourDp=new DecimalFormat("###.0000");
        //loop for output
        for (x=0;x<=20;x+=2){
            System.out.println("√"+x+"="+fourDp.format(Math.sqrt(x)));
        }
    }
    public static void main(String[] args){
        //calling method squareRoot
        squareRoot();
    }
}
