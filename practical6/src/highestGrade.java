/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//importing object scanner
import java.util.Scanner;
public class highestGrade {
    
    public static void main(String[] args){
        //instatntiating object scanner
     Scanner input=new Scanner(System.in);
     //declaring variables
     int nStu,x;
     int top=0;
     //prompting for input
     System.out.print("Please enter the number of students: ");
     nStu=input.nextInt();
     //declaring array score of size nStu
        int[] score=new int[nStu];
        //prompting for input of scores
        System.out.println("Please enter "+nStu+" scores");
        for (x=0;x<=nStu-1;x++){
            //input
            System.out.print("Please enter the score of student["+x+"]: ");
            score[x]=input.nextInt();
            input.nextLine();
            //checking whether score inputted is valid
            while(score[x]<0 || score[x]>100){
                System.out.print("Invalid input. Please enter a score between 0 and 100: ");
                score[x]=input.nextInt();
                input.nextLine();
            }
            //determining top score
            if (score[x]>top){
                top=score[x];
            }
        }
        //using if statement to output correct data according to the score of the student
        for (x=0;x<=nStu-1;x++){
            if (score[x]>=top-10){
                System.out.println("student["+x+"]-"+"score is "+score[x]+"and grade is A");
            }
                else
                if (score[x]>=top-20){
                System.out.println("student["+x+"]-"+"score is "+score[x]+"and grade is B");
                }
            else
                    if (score[x]>=top-30){
                System.out.println("student["+x+"]-"+"score is "+score[x]+"and grade is C");
                    }
            else
                        if (score[x]>=top-40){
                System.out.println("student["+x+"]-"+"score is "+score[x]+"and grade is D");
                        }
            else
                            System.out.println("student["+x+"]-"+"score is "+score[x]+"and grade is F");
                
    
    
        
        }
        
            
        }
    }
    

