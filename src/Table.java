import javax.swing.*;
import java.awt.*;

public class Table extends JPanel {
    private JTable table;
    public Table() {
        setLayout(new FlowLayout());
        String[] columnNames = {"Student Number",
                "First",
                "Last",
                "Likes",
                "Dietary Restrictions"};
        Object[][] data = {
                {"1","David", "Bao", "6969", "Peanuts"},
                {"2","Jonathan", "Xu", "1234", "Water"},
                {"3","William", "Fung", "4321", "Seafood"}
        };
        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
