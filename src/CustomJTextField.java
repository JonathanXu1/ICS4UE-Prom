/**
 * CustomJTextField.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 25, 2019
 * Template to create buttons
 **/
// GUI and Graphics imports
import javax.swing.JTextField;
import java.awt.Color;

public class CustomJTextField extends JTextField {
    //Constructor
    public CustomJTextField(int columns, int x, int y){
        super(columns);
        DynamicLabel placeholder = new DynamicLabel("Placeholder text.", x, y, Color.BLACK);
        this.setFont(placeholder.getFont());
        //this.setForeground(Color.decode("#846D9B"));
        this.setBackground(Color.decode("#E4E4E4"));
    }// End of constructor
}
