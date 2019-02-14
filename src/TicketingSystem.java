/**
 Shape Game
 A basic shape game
 Jonathan Xu
 February 6, 2019
 **/

import javax.swing.JFrame;
import javax.swing.JPanel;

//Keyboard imports
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;

//Util
import java.util.ArrayList;
import java.util.Random;

public class TicketingSystem extends JFrame {
    //Class variables
    private static JFrame window;
    private JPanel headerPanel;
    private JPanel navPanel;
    private JPanel contentPanel;
    private Random rand = new Random();
    private final int MAX_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int MAX_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    //Main
    public static void main(String[] args) {
        window = new TicketingSystem();
    }

    //Constructor - this runs first
    TicketingSystem() {
        super("Prom Ticketing System");

        // Set the frame to full screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        //frame.setResizable(false);

        //Set up the inner panels (where we put our graphics)``
        headerPanel = new HeaderPanel(MAX_WIDTH, MAX_HEIGHT/10);
        this.add(headerPanel, BorderLayout.NORTH);
        navPanel = new NavPanel(MAX_WIDTH/6, MAX_HEIGHT/10*9);
        this.add(navPanel, BorderLayout.WEST);
        contentPanel = new ContentPanel();
        this.add(contentPanel, BorderLayout.CENTER);

        //Add listeners
        CustomKeyListener keyListener = new CustomKeyListener();
        this.addKeyListener(keyListener);

        this.requestFocusInWindow(); //make sure the frame has focus

        this.setVisible(true);

        //Navigate between panels


    } //End of Constructor

}
