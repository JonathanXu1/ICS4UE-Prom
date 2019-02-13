import java.awt.*;

public class ContentPanel extends CustomPanel {
    public ContentPanel(){
        this.setBackground(Color.decode("#E5E5E5"));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); //required
        setDoubleBuffered(true);

        repaint();
    }
}
