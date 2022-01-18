/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house;

/**
 *
 * @author User
 */
public class Main {
    public static void main(String[] args){
        House a =new House("Duplex",'a',3,1000.00,false);
        House b = new House ("Apartment", 'b', 3, 150000.00, false);
        House c =new House("Studio",3,1000.00);
        House[] house = new House[3];
        house[0] = a;
        house[1] = b;
        house[2] = c;
        house[1].setType("Semi-Detached");
        System.out.println(house[0]);
        System.out.println(house[1]);
        System.out.println(house[2]);
    }
}
