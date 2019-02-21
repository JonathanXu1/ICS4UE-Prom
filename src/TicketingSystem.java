/**
 Shape Game
 A basic shape game
 Jonathan Xu
 February 6, 2019
 **/

import javax.swing.*;

//Keyboard imports
import java.awt.*;

//Graphics &GUI imports
import javax.swing.JFrame;

//Util
import java.io.IOException;

public class TicketingSystem extends JFrame {
    //Class variables
    private static JFrame window;
    private HeaderPanel headerPanel;
    private ContentPanel  contentPanel;

    private final int MAX_WIDTH = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final int MAX_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    private FileIOManager io = new FileIOManager(this);

    //Main
    public static void main(String[] args) throws IOException, FontFormatException {
        window = new TicketingSystem();
    }

    //Constructor - this runs first
    TicketingSystem() throws IOException, FontFormatException{
        super("Prom Ticketing System");

        // Set the frame to full screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);
        //frame.setResizable(false);

        //Set up fonts
        //TODO: Load files from assets folder instead of from the production folder
        Font robotoThin = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("Roboto-Thin.ttf"));
        Font robotoLight = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("Roboto-Light.ttf").openStream());
        Font robotoRegular = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("Roboto-Regular.ttf").openStream());

        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(robotoThin);
        genv.registerFont(robotoLight);
        genv.registerFont(robotoRegular);


        //Set up the inner panels (where we put our graphics)``
        headerPanel = new HeaderPanel("Prom Design", MAX_WIDTH, MAX_HEIGHT/10, 1);
        this.add(headerPanel, BorderLayout.NORTH);
        contentPanel = new ContentPanel(MAX_WIDTH, MAX_HEIGHT/10*9, io);
        this.add(contentPanel, BorderLayout.CENTER);

        this.pack();
        contentPanel.addChildren();

         //Add listeners
        CustomKeyListener keyListener = new CustomKeyListener();
        this.addKeyListener(keyListener);

        this.requestFocusInWindow(); //make sure the frame has focus

        this.setVisible(true);


    }


}
