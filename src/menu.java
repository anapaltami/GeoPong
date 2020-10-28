import javax.swing.*;
import java.awt.*;

/**
 * This is the main menu that will allow the user to click play and start GeoPong! in a new scene. User will also be
 * able to select a help button that will show a new scene with tutorial information.
 *
 * @author Altamirano, Anastasia
 * @assignment CSCI 2912 Game Assignment
 * @date 10/27/2020
 */

public class menu extends JFrame {

    private JPanel menuPanel;
    private JLabel titleLabel;
    private JButton playButton;
    private JButton tutorialButton;

    public menu(String title) {
        super(title);
        this.setTitle("GeoPong!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(menuPanel);
        this.pack();
        this.setVisible(true);

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

        playButton.addActionListener(e -> {
            GameFrame gameFrame = new GameFrame();
            dispose();
        });

        tutorialButton.addActionListener(e -> {
            tutorial frame = new tutorial("GeoPong!");
            dispose();
        });
    }
}
