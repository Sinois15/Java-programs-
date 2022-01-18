/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial.pkg8;

/**
 *
 * @author User
 */
public class Tutorial8 {
    //declaring global variables
    static int x;
    //defining method which takes in an array as parameter and returns the index of the smallest integer in the array
    public static int smallestIndex(int[] num){
        
        int least=9999;
         
        int index=0;
        for (x=0;x<num.length;x++){
           //determining smallest integer
           if (num[x]<least){
               least=num[x];
               //storing index of smallest integer in a temp
               index=x;
           } 
           
      
    }//returning index of smallest integer
        return index;
    }
    public static void main(String[] args) {
        //declaring and filling the array
        int[] num=new int[]{1,2,4,5,10,100,-22,-2,};
        //outputting index of smallest integer 
        System.out.println("the index of the smallest number in this array is: "+smallestIndex(num));
        
    }
    
}
