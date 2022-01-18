/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycompanytwo;

/**
 *
 * @author User
 */
public class EmployeeTwo {
    private String name;
    private double salary;
    private int age;
    EmployeeTwo (String n, double s, int a) {
    name = n;
    salary = s;
    age = a;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
    public void setName(String n) {
    name = n;
    }
    public void displayDetail() {
    System.out.println("Staff name is " + name);
    System.out.println("Salary is RM " + salary);
    }

}
