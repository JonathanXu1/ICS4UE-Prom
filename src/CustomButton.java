/**
 * CustomButton.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 13, 2019
 * Template to create buttons
 **/
// GUI & Graphics Import
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;

public class CustomButton extends JButton {
    // Class variables
    private Color bg = Color.RED;
    private Color textColor = Color.RED;

    // Constructor
    public CustomButton(String text, int colorScheme, int x, int y){

        if(colorScheme == 1){ //Styled like the dashboard buttons
            bg = Color.decode("#BDA7D4");
            textColor = Color.WHITE;
        } else if (colorScheme == 2){ //Styled like the exit button
            bg = Color.decode("#8780B8");
            textColor = Color.WHITE;
        }
        this.setBackground(bg);

        this.setLayout(new GridBagLayout());

        DynamicLabel label = new DynamicLabel(text, x, y, textColor);
        this.add(label);
    }// End of constructor

    /**
     * setEnabled
     * Enables the button when called
     * @param state, A boolean that controls if button is enabled
     * @return void, the method output a value
     */
    public void setEnabled(boolean state){
        super.setEnabled(state);
        if(state){
            this.setBackground(bg);
        } else {
            this.setBackground(Color.decode("#969696"));
        }
    }

}
