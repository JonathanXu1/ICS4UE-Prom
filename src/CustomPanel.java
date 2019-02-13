import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    CustomPanel(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
    }
}
