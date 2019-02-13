import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    CustomPanel(){

    }
    CustomPanel(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
    }
}
