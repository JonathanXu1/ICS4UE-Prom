/**
 * CustomRadioButton.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 13, 2019
 * Extension of a normal java radio button
 **/

// Graphics Imports
import java.awt.Color;

// Button Imports
import javax.swing.JRadioButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomRadioButton extends JRadioButton {
    // Class variables
    private boolean state = false;
    // Constructor
    CustomRadioButton(String text){
        super(text);

        // Sets different colours
        this.setBackground(Color.decode("#C4C4C4"));
        if(this.isSelected()){
            this.setBackground(Color.decode("#8F8F8F"));
        }

        // Changes colour based on selection
        this.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    changeColor(Color.decode("#8F8F8F"));
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    changeColor(Color.decode("#C4C4C4"));
                }
            }
        } );

    }// End of constructor
/**-----------------------METHODS------------------------**/
    /**
     * changeColor
     * This method accepts a color and sets it to the background
     * @param color, one of java built-in colors
     * @return void, sets the color to the background does not return anything
     */
    private void changeColor(Color color){
        this.setBackground(color);
    }
}
