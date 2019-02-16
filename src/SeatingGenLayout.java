import javax.swing.*;

public class SeatingGenLayout extends CustomPanel {
    public SeatingGenLayout(int x, int y){
        super(x , y, "Seating Generator", "Group up students into tables.");

        JButton generate = new JButton("Generate Seating!");
        this.add(generate);
    }
}
