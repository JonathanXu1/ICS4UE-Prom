/**
 * HeaderPanel.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 14, 2019
 * Template for the header of each panel
 **/
import java.awt.Color;
import java.awt.FlowLayout;

public class HeaderPanel extends CustomPanel {
    public HeaderPanel(String content, int x, int y, int colorScheme){
        super(x, y);

        Color bg = Color.decode("#8780B8");
        Color text = Color.BLACK;

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        if(colorScheme == 1) { //Purple bg, white text
            bg = Color.decode("#8780B8");
            text = Color.WHITE;
        } else if(colorScheme == 2){ //Grey bg, black text
            bg = Color.decode("#E5E5E5");
            text = Color.BLACK;
        }
        this.setBackground(bg);
        DynamicLabel title = new DynamicLabel(content, x/4, y/2, text);
        this.add(title);
    }
}
