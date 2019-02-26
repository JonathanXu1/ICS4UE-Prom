/**
 * TableChart.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 20, 2019
 * Layout for tables of students to show
 **/

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableChart extends Chart {
    private static JTable table;
    private static DefaultTableModel model;
    private int x, y;

    TableChart(int x, int y){
        super(x,y);
        this.x = x;
        this.y = y;
        String[] columnNames = {};
        Object[][] emptyRow = {};

        model = new DefaultTableModel(emptyRow, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells unEditable
                return false;
            }
        };

        table = new JTable(model);
        //TODO: make smaller
        table.setPreferredScrollableViewportSize(new Dimension(x, y));
        table.setFillsViewportHeight(true);
        DynamicLabel placeholder = new DynamicLabel("placeholder", x/10, y/20, Color.BLACK);
        table.setFont(placeholder.getFont());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(y/20);
        table.setShowGrid(false);
        table.getTableHeader().setBackground(Color.decode("#BDA7D4"));
        table.getTableHeader().setFont(placeholder.getFont());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(x, y));
        this.add(scrollPane);
    }

    public void loadTable(ArrayList<Table> tables, int tableSize) {
        model.setColumnCount(0);
        model.setRowCount(0);
        for (int i = 0; i < tables.size(); i++){
            model.addColumn("Table " + (i + 1));
        }
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(x/5);
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

