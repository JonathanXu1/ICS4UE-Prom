/**
 * CustomJCheckBox.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 25, 2019
 * Template to create checking boxes
 **/

// GUI & Graphics Imports
import javax.swing.JCheckBox;
import java.awt.Color;

public class CustomJCheckBox extends JCheckBox {
    // Constructor
    CustomJCheckBox(String text, int x, int y){
        super(text);
        this.setBackground(null);
        DynamicLabel placeholder = new DynamicLabel("This is a placeholder.", x, y, Color.BLACK);
        this.setFont(placeholder.getFont());
    }//End of constrictor
}
