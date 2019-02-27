import javax.swing.*;
import java.awt.*;

public class CustomJCheckBox extends JCheckBox {
    CustomJCheckBox(String text, int x, int y){
        super(text);
        this.setBackground(null);
        DynamicLabel placeholder = new DynamicLabel("This is a placeholder.", x, y, Color.BLACK);
        this.setFont(placeholder.getFont());
    }
}
