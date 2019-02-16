import javax.swing.*;

public class SeatingGenLayout extends JPanel {
    public SeatingGenLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("Seating Generator");
        JButton generate = new JButton("Generate Seating!");
        this.add(title);
        this.add(generate);
    }
}
