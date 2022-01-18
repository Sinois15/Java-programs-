/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewars;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Zombie extends Person{
   
   private int x;
   private int dx = 0;
   private int y;
   private int dy = 0;
   private int speed;
   private Random rdm = new Random();
   
   public Zombie(int sx, int sy, int s) {
      super(sx, sy, s);
   }  
   
   public void drawZombie(Graphics g) {
     g.setColor(Color.RED);
        int x = super.getX();
        int y = super.getY();
        int dir = super.getDir();
        if(dir == 1){
            int xpts[] = {x,x,x+5,x+3,x+3,x+5,x,x,x+25,x+30,x+30,x+25};
            int ypts[] = {y+30,y+25,y+25,y+20,y+10,y+5,y+5,y,y,y+5,y+25,y+30};
            g.fillPolygon(xpts, ypts, 12);
        }   
        if(dir == 2){
            
        int xpts[] = {x, x+10, x+15, x+20, x+30, x+30, x+20, x+10, x+0};
        int ypts[] = {y , y+15, y, y+15, y, y+25, y+30, y+30, y+25};
            g.fillPolygon(xpts, ypts, 9);
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

   public void handleBorderCollision() {  
       int x = super.getX();
       int y = super.getY();
      if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) 
        super.reverseDirection();
        updatePosition();
   }
   
   public void hunting(Person c) {
      int dir = rdm.nextInt(8);
      int cx = c.getX();
      int cy = c.getY();
      int zx = super.getX();
      int zy = super.getY();
       switch (dir) {
           case 0:
               moveLeft();
               break;
           case 1:
               super.moveUp();
               break;
           case 2:
               super.moveRight();
               break;
           case 3:
               super.moveDown();
               break;
           case 4:
           case 5:
               if (zx < cx){
                   super.moveRight();
               }  if (zx > cx){
                   super.moveLeft();
               }  break;
           case 6:
           case 7:
               if (zy < cy){
                   super.moveDown();
               }  if (zy > cy){
                   super.moveUp();
               }  break;
           default:
               break;
       }
   }    
}