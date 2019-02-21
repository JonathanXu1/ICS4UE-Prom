import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Table extends JPanel {
    private JTable table;
    public Table( /*ArrayList<Student> students */) {
        setLayout(new FlowLayout());
        String[] columnNames = {"Student Number",
                "First",
                "Last",
                "Likes",
                "Dietary Restrictions"};
        /* Wait for FileIO to complete
        Object[][] data = new Object[students.size()][5];
        for (int i = 0; i < students.size(); i++){
            String[] token =  students.get(i).getName().split(" ");
            data[i][0] = students.get(i).getStudentNumber();
            data[i][1] = token[0];
            data[i][2] = token[1];
            data[i][3] = students.get(i).getFriendStudentNumbers();
            data[i][4] = students.get(i).getDietaryRestrictions();
        }*/
        // Temporary fake data to be removed
        Object[][] data = {
                {"1","David","Bao","6","none"},
                {"2","Jonathan","Xu","9","none"},
                {"3","Sung","Ondese","6","Nuts"},
                {"4","Donald","Trump","9","Mexicans"},
                {"5","George","Bush","69","Arabs"},
                {"06","Bill","Clinton","69","Being faithful"},
                {"07","Bernie","Sanders","69","Capitalism"}
        };

        table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);

        DefaultTableModel unEditable = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells unEditable
                return false;
            }
        };

        table.setModel(unEditable);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
}
