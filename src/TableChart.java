import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TableChart extends Chart {
    private static JTable table;
    private static DefaultTableModel model;

    TableChart(int x, int y){
        super(x,y);
        String[] columnNames = {};
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

    public void loadTable(ArrayList<Table> tables, int tableSize) {
        for (int i = 0; i < tables.size(); i++){
            model.addColumn("Table " + (i + 1));
        }

        int col = tables.size();
        int row = tableSize;

        Object[][] data = new Object[row][col];

        for (int j = 0; j < col; j++) {
            for (int k = 0; k < tables.get(j).getStudents().size(); k++){
                Student currentStudent = tables.get(j).getStudents().get(k);
                data[k][j] = currentStudent.getName();
            }
        }
        for (int l = 0; l < row; l++){
            model.addRow(data[l]);
        }
    }

}

