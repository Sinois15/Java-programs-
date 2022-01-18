package mycompany;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Employee {
    private String name;
    private double salary ;
    private int age;
    public Employee(String name, double salary, int age){
        this.name=name;
        this.salary=salary;
        this.age=age;
    }
 
 

    public double getSalary() {
    return salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
 

    public void deductEPF() {
    salary = salary * 0.9;
    }
    @Override
    public String toString(){
        return "Name: "+name+"\nSalary: Rm"+salary+"\nAge: "+age;
    }
}