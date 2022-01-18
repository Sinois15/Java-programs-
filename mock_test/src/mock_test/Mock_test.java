
package mock_test;

import java.util.Scanner;
public class Mock_test {
    public static void main(String[] args) {
        
      
        int nSubjects,totalhrs,x,y,credithrs,valid;
        String grade;
        double gpa,total,point; 
        totalhrs=0;total=0;point=0;valid=0;
        
        Scanner input=new Scanner(System.in);
        System.out.print("please enter the number of subjects: ");
        nSubjects=input.nextInt();
        input.nextLine();
         System.out.println("Here are the valid grades and their corresponding points allocated:");
                   System.out.println("-------------------");
                   System.out.println("| Grades | Points |");
                   System.out.println("-------------------");
                   System.out.println("| A      | 4.0    |");
                   System.out.println("| B      | 3.0    |");
                   System.out.println("| C      | 2.0    |");
                   System.out.println("| D      | 1.0    |");
                   System.out.println("| F      | 0.0    |");
                   System.out.println("-------------------");
        for (x=1;x<=nSubjects;x++){
            
            System.out.print("please enter your grade for subject number "+x+": ");
            grade=input.nextLine();
           
               //(!grade.equals("A") || !grade.equals("B") || !grade.equals("C") || !grade.equals("D") || !grade.equals("F")){
                  while (valid==0){
                   if(!grade.equals("A") && !grade.equals("B") && !grade.equals("C") && !grade.equals("D") && !grade.equals("F")){
                   System.out.println("Invalid grade inputted.");
                   System.out.println("Here are the valid grades:");
                   System.out.println("+------+");
                   System.out.println("|Grades|");
                   System.out.println("+------+");
                   System.out.println("| A    |");
                   System.out.println("| B    |");
                   System.out.println("| C    |");
                   System.out.println("| D    |");
                   System.out.println("| F    |");
                   System.out.println("+------+");
                   System.out.print("Please enter one of these grades: ");
                   grade=input.nextLine();
                   }
                   else valid=1;
               }
            switch (grade) {
                case "A":
                    point=4.0;
                    break;
                case "B":
                    point=3.0;
                    break;
                case "C":
                    point=2.0;
                    break;
                case "D":
                    point=1.0;
                    break;
                case "F":
                   point=0;    
            }
            System.out.print("please enter the credit hours for subject number "+x+": ");
            credithrs=input.nextInt();
            input.nextLine();
            while(credithrs<0 || credithrs>21){
                System.out.print("invalid number of credit hours entered. Please enter a number of credit hours between 0 and 21: ");
                credithrs=input.nextInt();
            }
            totalhrs=(totalhrs+credithrs);
            total=(total+(point*credithrs));
       }
        gpa=total/totalhrs;
        System.out.print("your GPA is : ");
        System.out.format("%.2f\n", gpa);
        }
   }
    
    

