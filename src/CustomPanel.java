/**
 * CustomPanel.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 20, 2019
 * Template to create general panels
 **/

// Graphics & GUI Imports
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class CustomPanel extends JPanel {
    // Class variables
    DynamicLabel title, subtitle;

    // Constructor for main panel
    CustomPanel(int x, int y, String titleText, String subtitleText){

        // Initialize the header and its contents
        CustomPanel header = new CustomPanel(x, y/10);
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        title = new DynamicLabel(titleText, x, y/20, Color.BLACK);
        subtitle = new DynamicLabel(subtitleText, x, y/40, Color.BLACK);

        // Add components to header
        header.add(title);
        header.add(new JSeparator());
        header.add(subtitle);

        // Add to class
        this.setBackground(Color.decode("#E5E5E5"));
        this.add(header, BorderLayout.NORTH);
    } // End of constructor

    // Constructor for sub panel
    CustomPanel(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(null);
    }

    // Constructor for empty panel
    CustomPanel(){
        this.setBackground(null);
    }

    /**-------------------------------METHODS--------------------------------**/

    /**
     * changeHeader
     * This method turns the title and subtitle to new string
     * @param titleText, string for the new title
     * @param subtitleText, string for its subtitle
     * @return Boolean, true if the operation was a success, false otherwise.
     */
    public void changeHeader(String titleText, String subtitleText){
        title.setText(titleText);
        subtitle.setText(subtitleText);
    }

}
