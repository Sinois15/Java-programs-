/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

public class question_1 {
    //declaring static global variables
    static int value1,value2;
    //defining method
    public static void generate(int value1,int value2){
    //declaring local variables
    double result1,result2,result3,result4,result5;
    //calculations
    result1=value1+value2;
    result2=value2-value1;
    result3=value1*value2;
    result4=value2/value1;
    result5=value1%value2;
    //output results
    System.out.println("result1= "+result1);
    System.out.println("result2= "+result2);
    System.out.println("result3= "+result3);
    System.out.println("result4= "+result4);
    System.out.println("result5= "+result5);

    }
    public static void main(String[] args){
        //assigning value to variables
        value1=100;value2=250;
        //calling method "generate"
        generate(value1,value2);
    }
}
