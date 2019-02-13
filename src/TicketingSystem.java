/**
 Shape Game
 A basic shape game
 Jonathan Xu
 February 6, 2019
 **/

import javax.swing.JFrame;
import javax.swing.JPanel;

//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;

//Util
import java.util.ArrayList;
import java.util.Random;

public class TicketingSystem extends JFrame {
    static JFrame window;
    JPanel headerPanel;
    JPanel navPanel;
    JPanel contentPanel;

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

        //Set up the inner panels (where we put our graphics)
        headerPanel = new HeaderPanel();
        this.add(headerPanel);
        navPanel = new HeaderPanel();
        this.add(navPanel);
        contentPanel = new contentPanel();
        this.add(headerPanel);

        
    } //End of Constructor

}
