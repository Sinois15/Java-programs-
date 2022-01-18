/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewars;

import java.awt.Color;
import java.awt.Graphics;

public class Cedric extends Person{
   
   
   
   public Cedric(int sx, int sy, int s) {
      super(sx,sy,s);
   } 
   
   public void drawCedric(Graphics g) {
      g.setColor(Color.YELLOW);
       
        int x = super.getX();
        int y = super.getY();
        int dir = super.getDir();
        if(dir == 1){
            int xpts[] = {x,x,x+5,x+3,x+3,x+5,x,x,x+25,x+30,x+30,x+25};
            int ypts[] = {y+30,y+25,y+25,y+20,y+10,y+5,y+5,y,y,y+5,y+25,y+30};
            g.fillPolygon(xpts, ypts, 12);
        }   
        if(dir == 2){
            int xpts[] = {x,x+5,x+5,x+10,x+20,x+25,x+25,x+30,x+30,x+25,x+5,x};
            int ypts[] = {y,y,y+5,y+3,y+3,y+5,y,y,y+25,y+30,y+30,y+25};
            g.fillPolygon(xpts, ypts, 12);
        }
        if(dir == 3){
            int xpts[] = {x+30,x+30,x+25,x+27,x+27,x+25,x+30,x+30,x+5,x,x,x+5};
            int ypts[] = {y,y+5,y+5,y+10,y+20,y+25,y+25,y+30,y+30,y+25,y+5,y};
            g.fillPolygon(xpts, ypts, 12);
        }
        if(dir == 4){
            int xpts[] = {x+30,x+25,x+25,x+20,x+10,x+5,x+5,x,x,x+5,x+25,x+30};
            int ypts[] = {y+30,y+30,y+25,y+27,y+27,y+25,y+30,y+30,y+5,y,y,y+5};
            g.fillPolygon(xpts, ypts, 12);
        }
        g.setColor(Color.BLACK);
        g.fillRect(x+12, y+12, 5,5);
    
   }
   
    public boolean collideBorder() {
      boolean collide = false;
      int x = super.getX();
      int y = super.getY();
      if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
         collide = true;
      }
      return collide;
    }
    
    public boolean collideZombie(Zombie z) {
        boolean collide = false;
        int sz = 30;
        int cx = super.getX();
        int cy = super.getY();
        if (z.getX() >= (cx-sz) && z.getX() <= (cx+sz) && z.getY() >= (cy-sz) && z.getY() <= (cy+sz)){
            collide = true;
        }
        return collide;
    }
    
}
   
   

        

     
   
