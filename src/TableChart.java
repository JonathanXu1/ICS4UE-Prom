import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class TableChart extends Chart {
    private static JTable table;
    private static DefaultTableModel model;
    private static int tableSize;

    TableChart(int x, int y, int tableSize){
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
/*
    public void loadTable(ArrayList<Table> tables) {
        String[] columnNames = new String[tables.size()];
        Object[][] data = new Object[tableSize][tables.size()];
        for (int i = 0; i < tables.size(); i++){
            columnNames[i] = ("Table " + i);
        }
        for (int j = 0; j < tables.size(); j++) {
            for (int k = 0; k < tables.get(j).getStudents().size(); k++){
                Student currentStudent = tables.get(j).getStudents().get(k);
                data[k][j] = currentStudent.getStudentNumber();
            }
        }
    }*/

}

