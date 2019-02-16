import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    DynamicLabel title, subtitle;

    CustomPanel(int x, int y, String titleText, String subtitleText){
        //this.setBackground(Color.RED);
        this.setBackground(Color.decode("#E5E5E5"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        title = new DynamicLabel(titleText, x, y/20, Color.BLACK);
        subtitle = new DynamicLabel(subtitleText, x, y/30, Color.BLACK);
        this.add(title);
        this.add(new JSeparator());
        this.add(subtitle);
    }
    CustomPanel(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
    }

    public void changeHeader(String titleText, String subtitleText){
        title.setText(titleText);
        subtitle.setText(subtitleText);
    }

}
