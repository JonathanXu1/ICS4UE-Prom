import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class StudentChart extends Chart {
    private static JTable table;
    private static DefaultTableModel model;

    StudentChart(int x, int y){
        super(x,y);

        String[] columnNames = {"Student Number",
                "First",
                "Last",
                "Likes",
                "Dietary Restrictions"};

        Object[][] emptyRow = {};

        model = new DefaultTableModel(emptyRow, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells unEditable
                return false;
            }
        };;

        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        table.setFillsViewportHeight(true);
        this.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(x, y));
        this.add(scrollPane);
    }


    public void loadStudents(ArrayList<Student> students) {


        Object[][] data = new Object[students.size()][5];
        for (int i = 0; i < students.size(); i++) {
            String[] token = students.get(i).getName().split(" ");
            data[i][0] = students.get(i).getStudentNumber();
            data[i][1] = token[0];
            data[i][2] = token[1];
            data[i][3] = students.get(i).getFriendStudentNumbers();
            data[i][4] = students.get(i).getDietaryRestrictions();
            if(!existsInTable(data[i])){
                model.addRow(data[i]);
            }
        }
    }

    public boolean existsInTable(Object[] entry) {

        // Get row and column count
        int rowCount = table.getRowCount();
        int colCount = table.getColumnCount();

        // Get Current Table Entry
        String curEntry = "";
        for (Object o : entry) {
            String e = o.toString();
            curEntry = curEntry + " " + e;
        }

        // Check against all entries
        for (int i = 0; i < rowCount; i++) {
            String rowEntry = "";
            for (int j = 0; j < colCount; j++)
                rowEntry = rowEntry + " " + table.getValueAt(i, j).toString();
            if (rowEntry.equalsIgnoreCase(curEntry)) {
                return true;
            }
        }
        return false;
    }
}
