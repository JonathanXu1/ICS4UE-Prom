import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton {

    public CustomButton(String text, int colorScheme, int x, int y){
        Color bg = Color.RED;
        Color textColor = Color.RED;
        if(colorScheme == 1){ //Styled like the dashboard buttons
            bg = Color.decode("#BDA7D4");
            textColor = Color.WHITE;
        } else if (colorScheme == 2){
            bg = Color.decode("#8780B8");
            textColor = Color.WHITE;
        }
        this.setBackground(bg);

        //this.setBorder(null);
        //this.setPreferredSize(new Dimension(x, y));
        this.setLayout(new GridBagLayout());

        DynamicLabel label = new DynamicLabel(text, x, y, textColor);
        this.add(label);
    }

}
