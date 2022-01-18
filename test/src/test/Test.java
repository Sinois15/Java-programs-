/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author User
 */
//import java.lang.Character;
import java.util.Random;
import java.util.Scanner;
public class Test {

    public void randomLottery(){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        String num="",lottery;
        boolean valid = true, match = false;
        int randNum, input, count=0, award=0;
        randNum = rand.nextInt(100);
        lottery = Integer.toString(randNum);
        //for testing
        /*lottery = "11";
        randNum = 11;*/
        do{
            System.out.print("Please enter a number smaller than 100: ");
            input = Integer.parseInt(sc.nextLine());
            if (input<0){
                if (input>=100){
                    System.out.println("The number should not be longer than 2 digits!");
                    valid=false;
            }
                System.out.println("Your input should be positive!");
                valid = false;
            }
        
        }while(!valid);
        if (input == randNum){
            match=true;
            award = 10000;
        }
        if (input<10){
            for (int x=0;x<2;x++){
                    if(num.charAt(0)==lottery.charAt(x)){
                        count++;
                    }
            }
            if (count>0){
                award=3000;
                match = true;
            }
        }
        if (match){
            System.out.println("Your number matches!! you won $"+award);
        }else 
            System.out.println("Your number does not match. you lost :(");
  
    }    
    public static void main(String[] arg){
        Test t = new Test();
        t.randomLottery();
        
        
    }
}
