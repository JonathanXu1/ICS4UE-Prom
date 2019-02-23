import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    DynamicLabel title, subtitle;

    CustomPanel(int x, int y, String titleText, String subtitleText){
        this.setBackground(Color.decode("#E5E5E5"));

        CustomPanel header = new CustomPanel(x, y/10);
        header.setLayout(new BoxLayout(header, BoxLayout.PAGE_AXIS));
        title = new DynamicLabel(titleText, x, y/20, Color.BLACK);
        subtitle = new DynamicLabel(subtitleText, x, y/40, Color.BLACK);
        header.add(title);
        header.add(new JSeparator());
        header.add(subtitle);
        this.add(header, BorderLayout.NORTH);
    }
    CustomPanel(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(null);
    }
    CustomPanel(){
        this.setBackground(null);
    }

    public void changeHeader(String titleText, String subtitleText){
        title.setText(titleText);
        subtitle.setText(subtitleText);
    }

}
