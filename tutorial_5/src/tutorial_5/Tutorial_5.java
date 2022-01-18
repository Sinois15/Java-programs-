/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial_5;
//import object Scanner for java.util
import java.util.Scanner;
public class Tutorial_5 {

    public static void main(String[] args) {
       //instantiating object Scanner 
       Scanner input=new Scanner(System.in);
       //declaring variables and array
       String status[]=new String[4];
       String info;
       int x;
       //assigning a value to each array index
       status[0]="freshman";
       status[1]="sophomore";
       status[2]="junior";
       status[3]="senior";
       //displaying the necessary information to the user
       System.out.println("Here are the available options for your major(first character): ");
       System.out.println("+---------------------------+");
       System.out.println("|           Major           |");
       System.out.println("+---------------------------+");
       System.out.println("|M - mathematics            |");
       System.out.println("|C - computer science       |");
       System.out.println("|I - information technology |");
       System.out.println("+---------------------------+");
       System.out.println(" ");
       System.out.println("Here are the available options for your status: ");
       System.out.println("+--------------+");
       System.out.println("|    Status    |");
       System.out.println("+--------------+");
       System.out.println("|1 - freshman  |");
       System.out.println("|2 - sophomore |");
       System.out.println("|3 - junior    |");
       System.out.println("|4 - senior    |");
       System.out.println("+--------------+");
       //input of 2 character code
       System.out.print("Please enter your 2-character code representing your major and status: ");
       info=input.nextLine();
       //validating the code
       while(info.charAt(0)!='M' && info.charAt(0)!='C' && info.charAt(0)!='I' || info.length()>2){
          while (info.charAt(1)!='1' && info.charAt(1)!='2' && info.charAt(1)!='3' && info.charAt(1)!='4' ){
               //prompting for new input in case of previous invalid input
           System.out.print("invalid input. Please re-enter your 2-character code: ");
           info=input.nextLine(); 
               }
       }
            
        char test = info.charAt(0);
        char s=info.charAt(1);
       //switch statement to output information corresponding to the code entered
        switch (test) {
            case 'M':
                for(x=0;x<=3;x++){
                   char c = Integer.toString(x+1).charAt(0);
                    if(s==c){
                        System.out.println("Mathematics "+status[x]);
                    }   
                }    break;
            case 'C':
                for(x=0;x<=3;x++){
                    char c = Integer.toString(x+1).charAt(0);
                    if(s==c){
                        System.out.println("Computer science "+status[x]);
                    }
                }   break;
            case 'I':
                for(x=0;x<=3;x++){
                    char c = Integer.toString(x+1).charAt(0);
                    if(s==c){
                        System.out.println("Information technology "+status[x]);
                    }
                }   break;
        }
    }
}
}
    

