import javax.swing.*;
import java.awt.*;

/**
 * A short description of the program.
 * Algorithm(step by step pseudocode)
 *
 * @author Altamirano, Anastasia
 * @assignment CSCI 2912 Assignment X
 * @date Date
 */
public class tutorial extends JFrame {
    private JPanel tutorialPanel;
    private JLabel titleLabel;
    private JButton backButton;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    public tutorial(String title) {
        super(title);
        this.setTitle("GeoPong!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(tutorialPanel);
        this.pack();
        this.setVisible(true);

        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);

        backButton.addActionListener(e -> {
            menu frame = new menu("GeoPong!");
            dispose();
        });
    }
}
