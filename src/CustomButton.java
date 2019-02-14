import javax.swing.*;
import java.awt.Dimension;

public class CustomButton extends JButton {

    public CustomButton(String text, int colorId, int textColor){
        super(text);

        /*
        DynamicLabel label = new DynamicLabel(text, this.getWidth(), this.getHeight(), textColor);
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
        this.add(label);
        */
    }
    public CustomButton(String text, int x, int y, int colorId){
        super(text);

        this.setPreferredSize(new Dimension(x, y));
    }
}
