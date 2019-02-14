import java.awt.FlowLayout;
import java.awt.Color;

public class HeaderPanel extends CustomPanel {
    public HeaderPanel(int x, int y){
        super(x, y);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(Color.decode("#8780B8"));
        DynamicLabel title = new DynamicLabel("Prom Design", x/4, y/2, 2);
        this.add(title);
    }
}
