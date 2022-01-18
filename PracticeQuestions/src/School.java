/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.util.List;
import java.util.ArrayList;
public class School {
    ArrayList<Student> students=new ArrayList<>();
    private String name;
    private int yearEstablished;
    private int totalNoStudents;
    private int totalNoStaff;
    public School(String name, int yearEstablished, int totalNoStudents, int totalNoStaff){
        this.name=name;
        this.yearEstablished=yearEstablished;
        this.totalNoStudents=totalNoStudents;
        this.totalNoStaff=totalNoStaff;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public int getTotalNoStudents() {
        return totalNoStudents;
    }

    public int getTotalNoStaff() {
        return totalNoStaff;
    }

   public void increaseTotalNoStudents(){
       totalNoStudents++;
   }
    
    
    public void  addStudent(Student student){
        students.stream().filter((currentStudent) -> (currentStudent == null && currentStudent.getId()!=student.getId())).map((_item) -> {
            students.add(student);
            return _item;
        }).forEachOrdered((_item) -> {
            increaseTotalNoStudents();
        });
        
    }
    @Override
    public String toString(){
        return "name: "+ name + "\nyear established: " + yearEstablished + "\ntotal no of students: " + totalNoStudents + "\ntotal no of staff: " + totalNoStaff;
    }
}
