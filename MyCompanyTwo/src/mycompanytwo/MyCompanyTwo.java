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
public class MyCompanyTwo {

    public void init() {
        EmployeeTwo staff1 = new EmployeeTwo("Joyah", 1000, 55);
        EmployeeTwo staff2 = new EmployeeTwo("Mat", 2000, 40);
        staff1.setSalary(3000);
        staff2.setName("Minah");
        staff2.setSalary(50000);
        staff2.setAge(30);
               
        staff1.displayDetail();
        staff2.displayDetail();
        System.out.println(staff1.getName() +"'s salary is Rm"+staff1.getSalary());
        System.out.println(staff2.getName()+"'s age is "+staff2.getAge());
    }


 public static void main(String args[]) {
    MyCompanyTwo mct = new MyCompanyTwo();
    mct.init();
 }
    
}
