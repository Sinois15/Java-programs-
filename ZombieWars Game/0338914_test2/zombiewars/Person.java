/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewars;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author User
 */
public class Person {
   private int x;
   private int dx = 0;
   private int y;
   private int dy = 0;
   private int speed;
   private int dir = 2;
    public Person(int sx, int sy, int s) {
      x = sx;
      y = sy;
      speed = s;
    }
    public int getX() {
      return x;
    }
   
    public int getY() {
      return y;
    }
    public void reverseDirection() {
      dx = -dx;
      dy = -dy;
   }    
   
   public void updatePosition() {
      x = x + dx;
      y = y + dy;
   }

   public void moveLeft() {
      dir = 1;
      dx = -speed;
      dy = 0;
   }

   public void moveRight() {
      dir = 3; 
      dx = speed;
      dy = 0;
   }

   public void moveUp() {
       dir = 2;
      dx = 0;
      dy = -speed;
   }

   public void moveDown() {
       dir = 4;
      dx = 0;
      dy = speed;
   }
   
   public int getDir(){
       return dir;
   }

   
   
  
}
