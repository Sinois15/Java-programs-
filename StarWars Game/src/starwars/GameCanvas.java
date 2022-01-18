/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starwars;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameCanvas extends JPanel implements ActionListener, KeyListener {
    private Player player;
    private Vader vader1;
    private Vader vader2;
    private Timer aTimer;
    private int score;
    
    private int status = 0;// 0 = waiting for start
                           // 1 = running 
                           // 2 = game over    
    
    
    public GameCanvas() {
        aTimer = new Timer(50, this);
        player = new Player(300, 500, 10,Color.YELLOW );
        vader1 = new Vader(200,100,5,Color.RED);
        vader2 = new Vader(400,100,10,Color.RED);
        addKeyListener(this);
    }
    
    public void startTimer() {
        if (status == 0){
            aTimer.start();
            status = 1;
        }
    }
    
    public void pause(){
        status = 3;
    }
    
    public void resume(){
        status = 1;
    }
    public void reset(){
        player = new Player(300, 500, 10,Color.YELLOW );
        vader1 = new Vader(200,100,5,Color.RED);
        vader2 = new Vader(400,100,10,Color.RED);
        score = 0;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    
    public void paint(Graphics g) {
        
        if (player.collideBorder(player)){
            status = 2;
        }
        if (status == 1){
            score++;
            
            if (player.collideVader(vader1) ){
                status = 2;
            }
            if (player.collideVader(vader2)){
                status = 2;
            }
            vader1.hunt(player);
            vader2.moveVader();
            player.updatePos();
            vader1.updatePos();
            vader2.updatePos();
            vader1.vCollideBorderHandler(vader1);
            vader2.vCollideBorderHandler(vader2);    
        }
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.BLUE);
        g.fillRect(0, 600, 600, 30);
        player.drawShip(g);
        vader1.drawShip(g);
        vader2.drawShip(g);
        if (status == 0){
            g.setColor(Color.WHITE);
            g.drawString("Press Start to begin", 260, 250);
        }
        if (status == 2){
            g.setColor(Color.WHITE);
            g.drawString("G A M E O V E R", 265, 250);
        }
        
        g.setColor(Color.WHITE);
        g.drawString("S C O R E: "+score, 10, 620);
        
        
    }
    
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aTimer) {
            repaint(0, 0, 600, 630);
            requestFocus();
        }
    }
    
    public void moveLeft() {
        player.moveLeft();
    }

    public void moveRight() {
        player.moveRight();
    }
    
    public void moveUp(){
        player.moveUp();
    }
    public void moveDown(){
        player.moveDown();
    }
    
    

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            moveLeft();
        }
        else if (keyCode == 39) {
            moveRight();
        }
        else if (keyCode == 38){
            moveUp();
        }
        else if (keyCode == 40){
            moveDown();
        }
        else if (keyCode == 32){
            if (status == 1){
                pause();
            }
            if (status == 3){
                resume();
            }
        }
        
        else if (keyCode == 13){
            startTimer();
        }        
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
}