/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

/**
 *
 * @author User
 */
import java.awt.*;
import java.util.Random;
public class Vader extends Ship {
    
    private Random rng = new Random();
    public Vader(int x, int y, int speed, Color color){
        super(x, y, speed, color);
    }
    
    public void vCollideBorderHandler(Ship s){
        if (s.getX() + s.getDx() <= 0 || s.getX() + s.getDx() >= 570 
                || s.getY() + s.getDy() <= 0 || s.getY() + s.getDy() >= 540){
            s.setDx(-s.getDx());
            s.setDy(-s.getDy());
        }
        s.setX(s.getX() + s.getDx());
        s.setY(s.getY() + s.getDy());
        
    }
    
    public void moveVader(){
        int dir = rng.nextInt(4);
        if (dir == 0){
            super.moveUp();
        }
        else if (dir == 1){
            super.moveDown();
        }
        else if (dir == 2){
            super.moveRight();
        }
        else if (dir == 3){
            super.moveLeft();
        }
        else if (dir == 4){
            
        }
    }
    
    public void hunt(Ship s){
        int vx = super.getX();
        int vy = super.getY();
        int sx = s.getX();
        int sy = s.getY();
        int dir = rng.nextInt(8);
        
        if (dir == 0){
            super.moveUp();
        }
        else if (dir == 1){
            super.moveDown();
        }
        else if (dir == 2){
            super.moveRight();
        }
        else if (dir == 3){
            super.moveLeft();
        }
        else if (dir == 4 || dir == 5){
            if (vx < sx){
                super.moveRight();
            }
            if (vx > sx){
                super.moveLeft();
            }
        }
        else if (dir == 6 || dir == 7){
            if (vy < sy){
                super.moveDown();
            }
            if (vy > sy){
                super.moveUp();
            }
        }
        
        
    }
    
    public boolean vCollideBorder(Ship s){
        return (s.getX() + s.getDx() -10 <= 0 || s.getX() + s.getDx() -10 >= 570 
                || s.getY() + s.getDy() - 10<= 0 || s.getY() +s.getDy() - 10 >= 570);
    }
    
    public void vStop(Ship s){
        s.setDx(0);
        s.setDy(0);
    }
}
