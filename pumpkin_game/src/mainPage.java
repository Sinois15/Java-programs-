/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
public class mainPage extends JFrame{
    public void initUI(){
    add (new board());
    pack();
    setTitle("Main page");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    
}
    public mainPage(){
        initUI();
    }
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
        mainPage ex = new mainPage();
        ex.setVisible(true);
    });
    }
}
