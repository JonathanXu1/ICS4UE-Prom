import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required
        setDoubleBuffered(true);

        repaint();
    }
}
