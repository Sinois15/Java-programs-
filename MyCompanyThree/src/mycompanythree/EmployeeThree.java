/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mycompanythree;

/**
 *
 * @author User
 */import java.time.Year;
    public class EmployeeThree {


        private String name;
        private double salary;
        private int yearBorn;
        private boolean status;
        EmployeeThree (String n, double s, int y) {
            name = n;
            salary = s;
            yearBorn = y;
            status = true;
        }

        public double getSalary() {
            return salary;
        }
        public void setSalary(double s) {
            if (s < 25000)
            salary = s;
        }
        public String getName() {
            return name;
        }
        public String getStatus() {
            return status? "active":"resigned";
        }
        public void resigned() {
            status = false;
        }
        public int getAge(){
            int age;
            age = Year.now().getValue()-yearBorn;
            return age;
        }
        public void displayDetail() {
            System.out.println("==========================");
            System.out.println("NAME : " + name);
            System.out.println("SALARY : " + salary);
            System.out.println("Age: "+ getAge()); //assuming the year is 2014
            System.out.println("STATUS : " + getStatus());
            
        }
} 

