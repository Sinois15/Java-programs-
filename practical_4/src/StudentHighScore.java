/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.Scanner;
public class StudentHighScore {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String sname,top;double max,score;int snum,x;
        max=0;top=" ";
        System.out.print("Please enter the number of students: ");
        snum=input.nextInt();
        input.nextLine();
        for (x=1;x<=snum;x++){
            System.out.print("Please enter the name of student["+x+"]: ");
            sname=input.nextLine();
            
            System.out.print("please enter the score of student["+x+"]: ");
            score=input.nextDouble();
            input.nextLine();
            if (score>max){
               top=sname; 
            }
        }
        System.out.println("the name of the student with the highest score is: "+top);
        
    }
    
}
