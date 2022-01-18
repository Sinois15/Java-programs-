/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class image extends JFrame {
    public image(){
        initUI();
    }
            private void initUI(){
                ImageIcon ii = loadImage();
                JLabel label = new JLabel(ii);
                createLayout(label);
                setTitle("Image");
                setLocationRelativeTo(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
            private ImageIcon loadImage(){
                ImageIcon ii = new ImageIcon();
                return ii;
            }
                    
            
}
