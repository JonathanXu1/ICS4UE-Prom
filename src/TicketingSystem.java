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
    JPanel gamePanel;

    //Main
    public static void main(String[] args) {
        window = new TicketingSystem();
    }

    //Constructor - this runs first
    TicketingSystem() {
        super("Prom Ticketing System");

    } //End of Constructor

}
