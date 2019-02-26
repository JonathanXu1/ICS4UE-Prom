/**
 * Chart.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 20, 2019
 * Template to create charts
 **/

// Graphics imports
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

// Table imports
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Chart extends JPanel {

    // Class variables
    private static JTable table;
    private static DefaultTableModel model;

    // Constructor
    public Chart(int x, int y) {
        setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(null);
    }//End of constructor
}
