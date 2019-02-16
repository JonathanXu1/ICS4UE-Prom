import javax.swing.*;

public class TableLayout extends JPanel {
    public TableLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("Table Display");
        JLabel subtitle = new JLabel("A graphical representation of table seating");
        this.add(title);
        this.add(subtitle);
    }
}
