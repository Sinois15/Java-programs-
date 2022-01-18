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
public class Ship {
    private int x;
    private int y;
    private int dx = 0;
    private int dy = 0 ;
    private Color color;
    private int speed;
    private int dir = 2;
    
    public Ship(int x, int y, int speed, Color color){
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.color= color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void updatePos(){
        x = x + dx;
        y = y + dy;
    }
    
    public void drawShip(Graphics g){
        g.setColor(color);
        //g.fillRect(x, y, 30, 30);//for rectangular ship
        int x1 = x;
        int y1 = y;
        int x2 = x+15;
        int y2 = y;
        int x3 = x+30;
        int y3 = y;
        int x4 = x;
        int y4 = y+20;
        int x5 = x+15;
        int y5 = y+20;
        int x6 = x+30;
        int y6 = y+20;
        int x7 = x;
        int y7 = y+30;
        int x8 = x+15;
        int y8 = y+30;
        int x9 = x+30;
        int y9 = y+30;
        int npts = 4;
        int ptX[]={x+15, x+30, x+15, x+0};
        int ptY[] = {y+0, y+30, y+20, y+30};
        
        if(dir == 1){
            int xpts[] = {x5+5, x9, x4, x3};
            int ypts[] = {y5, y9, y4, y3};
            g.fillPolygon(xpts, ypts, npts);
        }
        if(dir == 2){
            int xpts[] = {x5, x7, x2, x9};
            int ypts[] = {y5, y7, y2, y9};
            g.fillPolygon(xpts, ypts, npts);
        }
        if(dir == 3){
            int xpts[] = {x5-5, x7, x6, x1};
            int ypts[] = {y5, y7, y6, y1};
            g.fillPolygon(xpts, ypts, npts);
        }
        if(dir == 4){
            int xpts[] = {x5, x1, x8, x3};
            int ypts[] = {y5-5, y1, y8, y3};
            g.fillPolygon(xpts, ypts, npts);
        }
        
    }
    
    
    public void moveLeft() {
        dx = -speed;
        dy = 0;
        dir = 1;
    }

    public void moveRight() {
        dx = speed;
        dy = 0;
        dir = 3;
    }
    
    public void moveUp(){
        dx = 0;
        dy = -speed;
        dir = 2;
    }
    public void moveDown(){
        dx = 0;
        dy = speed;
        dir = 4;
    }
    
    
}
