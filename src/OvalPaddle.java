
import java.awt.*;
import java.awt.event.*;

public class OvalPaddle extends Rectangle {
    int id; //player1 will be asigned to id = 1 later and player2 to id = 2
    int ySpeed; //the speed of the paddle up and down
    int speed = 5;

    /**
     * Constructor
     * @param x: x coordinate of paddle
     * @param y: y coordinate of paddle
     * @param OVAL_WIDTH: width of paddle (Rectangle version)
     * @param OVAL_HEIGHT: height of paddle (Rectangle version)
     */

    OvalPaddle(int x, int y, int OVAL_WIDTH, int OVAL_HEIGHT, int id) {
        super(x, y, OVAL_WIDTH, OVAL_HEIGHT);
        this.id = id;
    }


    /**
     * keyPressed determines which paddle has to move in which direction
     * @param e
     */
    public void keyPressedOval(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirectionOval(-speed);
                    moveOval();
                }

                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirectionOval(speed);
                    moveOval();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirectionOval(-speed);
                    moveOval();
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirectionOval(speed);
                    moveOval();
                }
                break;
        }
    }

    /**
     * keyReleased determines which paddle has to move in which direction
     * @param e
     */
    public void keyReleasedOval(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirectionOval(0);
                    moveOval();
                }

                if(e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirectionOval(0);
                    moveOval();
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirectionOval(0);
                    moveOval();
                }

                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirectionOval(0);
                    moveOval();
                }
                break;
        }
    }

    /**
     * setYDirection stores a value in the ySpeed field (paddle moves only in y direction)
     * @param yDir
     */
    public void setYDirectionOval(int yDir) {
        ySpeed = yDir;
    }

    /**
     * move method lets paddle move
     */
    public void moveOval() {
        y = y + ySpeed;
    }

    /**
     * draw method draws the two paddles
     * @param g
     */
    public void drawOval(Graphics g) {
        if(id == 1) //player1
            g.setColor(Color.cyan);
        else //player2
            g.setColor(Color.magenta);
        g.fillOval(x, y, width, height);
    }

}
