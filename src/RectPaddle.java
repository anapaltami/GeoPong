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

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class RectPaddle extends Rectangle {

    int id; //player1 will be asigned to id = 1 later and player2 to id = 2
    int ySpeed; //the speed of the paddle up and down
    int speed = 10;

    /**
     * Constructor
     */
    RectPaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    /**
     * keyPressed determines which paddle has to move in which direction
     * @param e
     */
    public void keyPressedRect(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirectionRect(-speed);
                    moveRect();
                }

                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirectionRect(speed);
                    moveRect();
                }
                if(e.getKeyCode() == KeyEvent.VK_A) {

                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirectionRect(-speed);
                    moveRect();
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirectionRect(speed);
                    moveRect();
                }
                break;
        }
    }

    /**
     * keyReleased determines which paddle has to move in which direction
     * @param e
     */
    public void keyReleasedRect(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirectionRect(0);
                    moveRect();
                }

                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirectionRect(0);
                    moveRect();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirectionRect(0);
                    moveRect();
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirectionRect(0);
                    moveRect();
                }
                break;
        }
    }

    /**
     * setYDirection stores a value in the ySpeed field (paddle moves only in y direction)
     * @param yDir
     */
    public void setYDirectionRect(int yDir) {
        ySpeed = yDir;
    }

    /**
     * move method lets paddle move
     */
    public void moveRect() {
        y = y + ySpeed;
    }

    /**
     * draw method draws the two paddles
     * @param g
     */
    public void drawRect(Graphics g) {
        if(id == 1) //player1
            g.setColor(Color.cyan);
        else //player2
            g.setColor(Color.magenta);
        g.fillRect(x, y, width, height);
    }

}


