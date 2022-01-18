/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytransport;

/**
 *
 * @author User
 */
public class Vehicle {
    private String type;
    private int speed;
    public Vehicle(String t, int s) {
        type = t;
        speed = s;
    }
    public String getType() {
        return type;
    }
    public int getSpeed() {
        return speed;
    }
}

