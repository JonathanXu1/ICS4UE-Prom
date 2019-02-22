import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableLayout extends CustomPanel {

    public TableLayout(int x, int y) {
        super(x, y, "Table Display", "Show diagram of tables");
        JButton display = new JButton("Display Floor Plan!");
        this.add(display);

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
