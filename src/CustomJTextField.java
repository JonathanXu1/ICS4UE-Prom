import javax.swing.*;
import java.awt.*;

public class CustomJTextField extends JTextField {
    public CustomJTextField(int columns, int x, int y){
        super(columns);
        DynamicLabel placeholder = new DynamicLabel("Placeholder text.", x, y, Color.BLACK);
        this.setFont(placeholder.getFont());
        //this.setForeground(Color.decode("#846D9B"));
        this.setBackground(Color.decode("#E4E4E4"));
    }
}
