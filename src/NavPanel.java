import javax.swing.*;
import java.awt.*;

public class NavPanel extends CustomPanel {
    public NavPanel(int x, int y){
        super(x, y);
        this.setBackground(Color.blue);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required
        setDoubleBuffered(true);

        repaint();
    }
}
