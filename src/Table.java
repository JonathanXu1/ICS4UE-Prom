import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Table extends JPanel {
    private JTable table;
    private ArrayList<Student> students;

    public Table(ArrayList<Student> students) {
        setLayout(new FlowLayout());

        this.students = students;
        String[] columnNames = {"Student Number",
                "First",
                "Last",
                "Likes",
                "Dietary Restrictions"};

        Object[][] data = new Object[students.size()][5];
        for (int i = 0; i < students.size(); i++) {
            String[] token = students.get(i).getName().split(" ");
            data[i][0] = students.get(i).getStudentNumber();
            data[i][1] = token[0];
            data[i][2] = token[1];
            data[i][3] = students.get(i).getFriendStudentNumbers();
            data[i][4] = students.get(i).getDietaryRestrictions();

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
}
