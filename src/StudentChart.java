/**
 * StudentChart.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 19, 2019
 * Puts students into chart display
 **/

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

//TODO: Selecting students (edit/delete) messes up when tables are sorted

public class StudentChart extends Chart {
    private static JTable table;
    private static DefaultTableModel model;

    private StudentManagerLayout studentManager;

    public StudentChart(int x, int y, StudentManagerLayout manager){
        super(x,y);
        this.studentManager = manager;

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
        };

        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(x, y));
        table.setFillsViewportHeight(true);
        DynamicLabel placeholder = new DynamicLabel("placeholder", x/10, y/40, Color.BLACK);
        table.setFont(placeholder.getFont());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(y/30);
        table.setShowGrid(false);
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setBackground(Color.decode("#BDA7D4"));
        table.getTableHeader().setFont(placeholder.getFont());

        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                studentManager.changeSelected(true);
            }
        });

        table.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(x, y));
        this.add(scrollPane);
    }

    public void loadStudents(ArrayList<Student> students) {
        Object[][] data = new Object[students.size()][5];
        model.setRowCount(0);
        for (int row = 0; row < students.size(); row++) {
            String[] token = students.get(row).getName().split(" ");
            data[row][0] = students.get(row).getStudentNumber();
            data[row][1] = token[0];
            data[row][2] = token[1];
            // TODO: Determine whether to show numbers or names
            data[row][3] = students.get(row).getFriendStudentNumbers();
            data[row][4] = students.get(row).getDietaryRestrictions();
            if(!existsInTable(data[row])){
                model.addRow(data[row]);
            }
        }
    }

    public void updateStudent(Student updatedStudent){
        int row = table.getSelectedRow();
        String[] token = updatedStudent.getName().split(" ");

        model.setValueAt(token[0], row, 1);
        model.setValueAt(token[1], row, 2);
        model.setValueAt(updatedStudent.getFriendStudentNumbers(), row, 3);
        //System.out.println(updatedStudent.getFriendStudentNumbers());
        model.setValueAt(updatedStudent.getDietaryRestrictions(), row, 4);
    }

    public void deleteStudent(){
        model.removeRow(table.getSelectedRow());
        studentManager.changeSelected(false);
    }

    public Student getStudent(ArrayList<Student> reference){
        int row = table.getSelectedRow();
        Student selectedStudent = null;
        for(Student target : reference){
            System.out.println(target.getStudentNumber());
            System.out.println(model.getValueAt(row, 0));
            System.out.println();
            if(target.getStudentNumber().equals(model.getValueAt(row, 0))){
                selectedStudent = target;
                System.out.println("goteem");
            }
        }
        return selectedStudent;
    }

    private boolean existsInTable(Object[] entry) {

        // Get row and column count
        int rowCount = table.getRowCount();
        int colCount = table.getColumnCount();
        //TODO: Compare only student numbers instead of everything

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
