/*
Create an object called School which has name, yearEstablished, totalNoOfStudents, totalNoOfStaff.
Create an ArrayList of Student object in School object and enter the following students:
Anshul 20 43124
Sanjay 69 43125
Lim 6 43126
Create an object called Subjects which has name, finalMark. 
Create an ArrayList of Subjects object in Student object.
Prompt the user to enter the marks of the students.
Create a method to find the average score of the class and output it.
*/

public class main {
    public static void main(String[] args){
        School school=new School("Raju's",2019,0,0);
        Student raju = new Student("Raju",19,43123);
       // System.out.println(raju.toString());
        school.addStudent(new Student("Anshul",20,43124));
        school.addStudent(new Student("Sanjay",69,43125));
        school.addStudent(new Student("Lim",6,43126));
        System.out.println(school.toString());
        System.out.println(school.getStudents().get(1));
        
    } 
    
}
