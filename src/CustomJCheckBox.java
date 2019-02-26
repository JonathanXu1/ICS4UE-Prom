import javax.swing.*;
import java.awt.*;

public class CustomJCheckBox extends JCheckBox {
    CustomJCheckBox(String text){
        super(text);
        this.setBackground(null);
        DynamicLabel placeholder = new DynamicLabel("This is a placeholder.", this.getWidth(), this.getHeight(), Color.BLACK);
        this.setFont(placeholder.getFont());
    }
}
