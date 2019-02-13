import javax.swing.*;
import java.awt.*;

public class ContentPanel extends CustomPanel {
    public ContentPanel(int x, int y){
        super(x, y);
        this.setBackground(Color.gray);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required
        setDoubleBuffered(true);

        repaint();
    }
}
