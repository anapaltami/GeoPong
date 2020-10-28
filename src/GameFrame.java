/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nici
 */
import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{
    
    GamePanel panel;
    
    /**
     * Constructor: creates the window
     */
    GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("GeoPong!");
        this.setResizable(false); //so user cannot resize the frame
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); //game frame class fit around game panel - we don't need to set the size of JFrame
        this.setVisible(true);
        this.setLocationRelativeTo(null); //window in middle
    }   
}
