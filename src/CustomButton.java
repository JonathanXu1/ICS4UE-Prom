import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;

public class CustomButton extends JButton {
    private Color bg = Color.RED;
    private Color textColor = Color.RED;

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
    }

    public void setEnabled(boolean state){
        super.setEnabled(state);
        if(state){
            this.setBackground(bg);
        } else {
            this.setBackground(Color.decode("#969696"));
        }
    }

}
