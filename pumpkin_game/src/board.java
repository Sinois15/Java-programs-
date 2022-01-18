/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
    public final class board extends JPanel{
        public Image main_page;
    
    public board() {
        initboard();
       
}
    private void loadImage(){
        ImageIcon ii = new ImageIcon("Downloads/pumpkin_reaper.png");
    }
    public void initboard(){
        loadImage();
        int w = main_page.getWidth(this);
        int h = main_page.getHeight(this);
        setPreferredSize(new Dimension(w,h));
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(main_page,0,0,null);
    }
    
    
    }