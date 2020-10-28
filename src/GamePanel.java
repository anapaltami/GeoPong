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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class GamePanel extends JPanel implements Runnable {
    
    //screen size variables
    static final int GAME_WIDTH = 900; //constant variable
    static final int GAME_HEIGHT = 500; //constant variable
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    
    static final int BALL_DIAMETER = 15; //ball diameter
    
    //paddle dimensions
    static final int PADDLE_WIDTH = 20;  
    static final int PADDLE_HEIGHT = 80;
    
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    RectPaddle rectPaddle1;
    RectPaddle rectPaddle2;
    Ball ball;
    Score score;

    /**
     * Constructor
     */
    GamePanel() {
        newPaddles(); 
        newBall(); 
        score = new Score(GAME_WIDTH, GAME_HEIGHT); 
        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(SCREEN_SIZE);
        
        //create and starts threads
        gameThread = new Thread(this); 
        gameThread.start();
    }
    
    /**
     * newBall method puts the ball creates a new ball on the screen
     */
    public void newBall() {
        random = new Random(); //to let Ball move randomly
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER) , BALL_DIAMETER, BALL_DIAMETER);   //ball starts randomly (middle, random) for (x,y)
    }
    
    /**
     * newPaddles method creates new paddles on the screen
     */
    public void newPaddles() {
        rectPaddle1 = new RectPaddle(0, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 1); //x and y coordinate, width and height, and id
        rectPaddle2 = new RectPaddle(GAME_WIDTH-PADDLE_WIDTH, (GAME_HEIGHT/2)-(PADDLE_HEIGHT/2), PADDLE_WIDTH, PADDLE_HEIGHT, 2); //x and y coordinate, width and height, and id
    }
    
    /**
     * paint method to paint on the screen
     * @param g 
     */
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();    
        draw(graphics); //to draw the components
        g.drawImage(image, 0, 0, this); //x and y coordinates are 0 (top left corner)
    }
    
    /**
     * draw method draws the two paddles, the ball and the score
     * @param g 
     */
    public void draw(Graphics g) {
        rectPaddle1.drawRect(g);
        rectPaddle2.drawRect(g);
        ball.draw(g);
        score.draw(g);
    }
    
    /**
     * move method lets object move 
     */
    public void move() {
        rectPaddle1.moveRect();
        rectPaddle2.moveRect();
        ball.move();
    }
    
    /**
     * chackCollision method lets ball and paddle stay in the screen and ball bounces back from paddle
     * and gives player points
     */
    public void checkCollision() {
        //bounce ball off top & bottom window edges
        if(ball.y <= 0) {
            ball.setYDirection(-ball.ySpeed);
        }
        
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.ySpeed);
        }
        
        //bounces ball off paddles
        if(ball.intersects(rectPaddle1)){
            ball.xSpeed = Math.abs(ball.xSpeed);
            ball.xSpeed++; //to increment the speed of the ball after hitting the paddle
            if(ball.ySpeed>0)
                ball.ySpeed++; //to increment the speed of the ball after hitting the paddle
             else   
                ball.ySpeed--;
            ball.setXDirection(ball.xSpeed);
            ball.setYDirection(ball.ySpeed);
        }
        
        if(ball.intersects(rectPaddle2)){
            ball.xSpeed = Math.abs(ball.xSpeed);
            ball.xSpeed++; //to increment the speed of the ball after hitting the paddle
            if(ball.ySpeed>0)
                ball.ySpeed++; //to increment the speed of the ball after hitting the paddle
             else   
                ball.ySpeed--;
            ball.setXDirection(-ball.xSpeed);
            ball.setYDirection(ball.ySpeed);
        }
        
        //stops paddle at window edges
        if(rectPaddle1.y <= 0)
            rectPaddle1.y=0;
        if(rectPaddle1.y>= (GAME_HEIGHT-PADDLE_HEIGHT))
            rectPaddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        
        if(rectPaddle2.y <= 0)
            rectPaddle2.y=0;
        if(rectPaddle2.y>= (GAME_HEIGHT-PADDLE_HEIGHT))
            rectPaddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        
        //gives a player a point and creates new paddles and ball
        if(ball.x <= 0) { //player 2 scored
            score.player2++;
            sound("GoalSound.wav");
            newPaddles();
            newBall();
        }
        
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) { //player 1 scored
            score.player1++;
            sound("GoalSound.wav");
            newPaddles();
            newBall();
        }
    }
    /**
     * run method lets the game loop
     */
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }   
        }   
    }
    
    /**
     * ActionListener class - inner class
     *      reacts when the key is pressed or released
     */
    public class ActionListener extends KeyAdapter { 
        public void keyPressed(KeyEvent e) {
            rectPaddle1.keyPressedRect(e);
            rectPaddle2.keyPressedRect(e);
        }
        
        public void keyReleased(KeyEvent e) {
            rectPaddle1.keyReleasedRect(e);
            rectPaddle2.keyReleasedRect(e);
        }
    }

    public void sound (String soundName) {

        try{
            File file = new File(soundName);
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (Exception e){
            System.out.println("check "+soundName+"\n");
            e.printStackTrace();
        }
    }


}
