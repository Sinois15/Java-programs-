/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.awt.*;

/**
 *
 * @author User
 */
public class Player extends Ship{
    
    public Player(int x, int y, int speed, Color color){
        super(x,y,speed,color);
    }
    
    
    public boolean collideBorder(Ship s){
        boolean collide = false;
        if (s.getX() <= 0 || s.getX() >= 570 || s.getY() <= 0 || s.getY() >= 570){
            collide = true;
        }
        return collide;
    }
    
     public boolean collideVader(Vader v){
        boolean collide = false;
        int sz = 30;
        int px = super.getX();
        int py = super.getY();
        if (v.getX() >= (px-sz) && v.getX() <= (px+sz) && v.getY() >= (py-sz) && v.getY() <= (py+sz)){
            collide = true;
        }
        return collide;
    }
}
