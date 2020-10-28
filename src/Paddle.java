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
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {
    
    int id; //player1 will be assigned to id = 1 later and player2 to id = 2
    int ySpeed; //the speed of the paddle up and down
    int xSpeed;
    int speed = 10;
    
    /**
     * Constructor
     */
    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }
    
    /**
     * keyPressed determines which paddle has to move in which direction
     * @param e 
     */
    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                } 
                break;
        }
    }
    
    /**
     * keyReleased determines which paddle has to move in which direction
     * @param e 
     */
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                } 
                break;
        }
    }
    
    /**
     * setYDirection stores a value in the ySpeed field (paddle moves only in y direction)
     * @param yDir
     */
    public void setYDirection(int yDir) {
        ySpeed = yDir;
    }
    
    public void setXDirection(int xDir) {
        xSpeed = xDir;
    }
    
    /**
     * move method lets paddle move
     */
    public void move() {
        y = y + ySpeed;
    }
    
    /**
     * draw method draws the two paddles
     * @param g 
     */
    public void draw(Graphics g) {
        if(id == 1) //player1
            g.setColor(Color.cyan);
        else //player2
            g.setColor(Color.magenta);
        g.fillRect(x, y, width, height);
    }
}
