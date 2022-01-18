/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
//import Pumpkin_game.board;
import java.awt.EventQueue;
import javax.swing.JFrame;
public class application extends JFrame{
    public application(){
        initUI();
    }
    public void initUI(){
          add(new board());
          setSize(350,300);
          setTitle("Pumpkin game");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          
}
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            application ex = new application();
            ex.setVisible(true);
    });
}
}
