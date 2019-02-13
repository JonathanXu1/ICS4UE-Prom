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
    static JFrame window;
    JPanel headerPanel;
    JPanel navPanel;
    JPanel contentPanel;
    private Random rand = new Random();
    final int MAX_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final int MAX_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    //Main
    public static void main(String[] args) {
        window = new TicketingSystem();
    }

    //Constructor - this runs first
    TicketingSystem() {
        super("Prom Ticketing System");

        // Set the frame to full screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        // this.setUndecorated(true);  //Set to true to remove title bar
        //frame.setResizable(false);

        //Set up the inner panels (where we put our graphics)``
        headerPanel = new HeaderPanel(MAX_WIDTH, 500);
        this.add(headerPanel, BorderLayout.NORTH);
        navPanel = new NavPanel(MAX_WIDTH/4, MAX_HEIGHT-500);
        this.add(navPanel, BorderLayout.WEST);
        contentPanel = new ContentPanel(MAX_WIDTH/4*3, MAX_HEIGHT-500);
        this.add(contentPanel, BorderLayout.CENTER);

        //Add listeners
        CustomKeyListener keyListener = new CustomKeyListener();
        this.addKeyListener(keyListener);

        this.requestFocusInWindow(); //make sure the frame has focus

        this.setVisible(true);

    } //End of Constructor

}
