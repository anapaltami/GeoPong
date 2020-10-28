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

public class Ball extends Rectangle {
    
    Random random;
    int xSpeed; //speed of ball in horizontal direction
    int ySpeed; //speed of ball in vertical direction
    int initialSpeed = 2; //till ball hits paddle
    
    /**
     * Constructor
     * @param x: x coordinate of ball
     * @param y: y coordinate of ball
     * @param width: width of ball (Rectangle version)
     * @param height: height of ball (Rectangle version)
     */
    Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random(); //to let ball move randomly
        int randomXDir = random.nextInt(2); //chooses 0 or 1 for movements in opposite direction
        
        if(randomXDir == 0) //for random movement left/right
            randomXDir--;
        setXDirection(randomXDir*initialSpeed);
        
        int randomYDir = random.nextInt(2); //for random movement up/down
        if(randomYDir == 0)
            randomYDir--;
        setYDirection(randomYDir*initialSpeed);
    }

    /**
     * setXDirection stores a value in the xSpeed field
     * @param randomXDir 
     */
    public void setXDirection(int randomXDir) { 
        xSpeed = randomXDir;
    }
    
    /**
     * setYDirection stores a value in the ySpeed field
     * @param randomYDir 
     */
    public void setYDirection(int randomYDir) { 
        ySpeed = randomYDir;
    }
    
    /**
     * move method makes ball movement more smooth
     */
    public void move() { 
        x += xSpeed;
        y += ySpeed;
    }
    
    /**
     * draw method draws the ball in white and changes the shape to oval
     * @param g 
     */
    public void draw(Graphics g) { 
        g.setColor(Color.white);
        g.fillOval(x, y, width, height);
    }
}
