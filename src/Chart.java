import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Chart extends JPanel {
    private static JTable table;
    private static DefaultTableModel model;

    public Chart(int x, int y) {
        setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(null);
    }
}
