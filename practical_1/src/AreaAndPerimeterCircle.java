/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AreaAndPerimeterCircle {
    public static void main (String[] args){
        //declaring variable
        double π; double r; double perimeter; double area;
        //entering values of variables
        π=3.14159;
        r=6.5;
        //calculating perimeter and area respectively
        perimeter=2*π*r;
        area=π*r*r;
        //output perimeter and area respectively
        System.out.println("the perimeter of the circle is "+perimeter);
        System.out.println("the area of the circle is "+area);
    }
    
}
