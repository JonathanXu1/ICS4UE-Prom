import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends CustomPanel {
    public HeaderPanel(int x, int y){
        super(x, y);
        this.setBackground(Color.red);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required
        setDoubleBuffered(true);

        repaint();
    }
}
