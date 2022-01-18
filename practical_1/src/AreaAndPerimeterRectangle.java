/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AreaAndPerimeterRectangle {
    public static void main (String[] args){
        //declaring variables
        double w; double h; double perimeter; double area;
        //assigning values to variables
        w=5.3;
        h=8.6;
        //calculating perimeter
        perimeter=2*(w+h);
        //calculating area
        area=w*h;
        //output perimeter and area respectively
        System.out.println("the perimeter of the rectangle is "+perimeter);
        System.out.println("the area of the rectangle is "+area);
    }
    
}
