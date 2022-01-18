/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practical.pkg9;

import java.util.Scanner;
public class course {
    Scanner sc = new Scanner(System.in);
     
     String courseTitle;
    double feesPerStudent;
    int noOfStudents;
    String[] studentNames=new String[1000];
    int courseCount;
    public course(String courseTitle, double feesPerStudent, int noOfStudents, String[] studentNames,int courseCount){
        this.courseTitle=courseTitle;
        this.feesPerStudent=feesPerStudent;
        this.noOfStudents=noOfStudents;
        this.studentNames=studentNames;
        this.courseCount=courseCount;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public double getFeesPerStudent() {
        return feesPerStudent;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public String[] getStudentNames() {
        return studentNames;
    }

    public int getCourseCount() {
        return courseCount;
    }
    

    public void setCourseTitle(String courseTitle) {
        do{
          if (courseTitle.length()>20 ){
              System.out.println("Setting of course title failed");
              System.out.println("Course title should not be more than 20 characters long.");
              System.out.print("Enter a suitable course title: ");
              courseTitle=sc.nextLine();
          }else{
          this.courseTitle = courseTitle;
          System.out.println("Course title successfully set.");
          }
        }
    }
    public void addStudent(String studentName){
        String cont;
        do{
            System.out.print("Enter the nme of the student to be added: ");
            studentName=sc.nextLine();
        for (int x=0;x<studentNames.length;x++){
            if(studentNames[x]==null){
                studentNames[x]=studentName;
                System.out.println("Student successfully added");
                noOfStudents++;
            }else
                System.out.println("Course is full. No more student can be added.");
            }
        System.out.print("Do you want to add more students?");
        System.out.print("If yes, press any key.");
        System.out.print("If no,enter N.");
        cont=sc.nextLine().toLowerCase();
        
        }while(!cont.equals("n"));
    }

  
}
