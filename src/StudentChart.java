/**
 * StudentChart.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 19, 2019
 * Puts students into chart display
 **/

// GUI & Graphics Imports
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
// Util
import java.util.ArrayList;

//TODO: Selecting students (edit/delete) messes up when tables are sorted

public class StudentChart extends Chart {
    // Class variables
    private static JTable table;
    private static DefaultTableModel model;

    private StudentManagerLayout studentManager;

    // Constructor
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
        };//End of constructor

        // Setup table model
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(x, y));
        table.setFillsViewportHeight(true);

        // Placeholder until chart is generated
        DynamicLabel placeholder = new DynamicLabel("placeholder", x/10, y/40, Color.BLACK);
        table.setFont(placeholder.getFont());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(y/30);
        table.setShowGrid(false);
        table.setAutoCreateRowSorter(true);
        table.getTableHeader().setBackground(Color.decode("#BDA7D4"));
        table.getTableHeader().setFont(placeholder.getFont());

        // Adjust chart's values
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting())
                    return;
                studentManager.changeSelected(true);
            }
        });

        // Adds to panel
        table.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(x, y));
        this.add(scrollPane);
    }
/**--------------------------------------METHODS---------------------------------**/
    /**
     * loadStudents
     * Takes the student into the class
     * @param  students, ArrayList of students to be processed
     * @return void, nothing to return
     */
    public void loadStudents(ArrayList<Student> students) {
        Object[][] data = new Object[students.size()][5];
        model.setRowCount(0);
        // Takes info from each student
        for (int row = 0; row < students.size(); row++) {
            String[] token = students.get(row).getName().split(" ");
            data[row][0] = students.get(row).getStudentNumber();
            data[row][1] = token[0];
            data[row][2] = token[1];
            data[row][3] = students.get(row).getFriendStudentNumbers();
            data[row][4] = students.get(row).getDietaryRestrictions();
            if(!existsInTable(data[row][0])){
                model.addRow(data[row]);
            }
        }
    }

    /**
     * updateStudent
     * Updates the table when students change
     * @param updatedStudent, new student with changed data
     * @return void nothing to return
     */
    public void updateStudent(Student updatedStudent){
        int row = table.getSelectedRow();
        String[] token = updatedStudent.getName().split(" ");
        // Updates table values
        model.setValueAt(token[0], row, 1);
        model.setValueAt(token[1], row, 2);
        model.setValueAt(updatedStudent.getFriendStudentNumbers(), row, 3);
        //System.out.println(updatedStudent.getFriendStudentNumbers());
        model.setValueAt(updatedStudent.getDietaryRestrictions(), row, 4);
    }

    /**
     * deleteStudent
     * Deletes a student from the table
     * @return void, nothing to return
     */
    public void deleteStudent(){
        model.removeRow(table.getSelectedRow());
        studentManager.changeSelected(false);
    }

    /**
     * getStudent
     * Returns a student from the ArrayList of students in table
     * @param reference, ArrayList of Students to search from
     * @return Student, student that is found
     */
    public Student getStudent(ArrayList<Student> reference){
        int row = table.getSelectedRow();
        Student selectedStudent = null;
        // Searches for student
        for(Student target : reference){
            //System.out.println(target.getStudentNumber());
            //System.out.println(model.getValueAt(row, 0));
            //System.out.println();
            if(target.getStudentNumber().equals(model.getValueAt(row, 0))){
                selectedStudent = target;
                //System.out.println("goteem");
            }
        }
        return selectedStudent;
    }

    /**
     * existsInTable
     * Sees if a student is in the chart
     * @param entry, the data being search for
     * @return Boolean, true if they are found, false if they are not there
     */
    public boolean existsInTable(Object entry) {

        // Get row and column count
        int rowCount = table.getRowCount();
        int colCount = table.getColumnCount();
        //TODO: Compare only student numbers instead of everything

        // Get Current Table Entry
        String curNum = (String)entry;

        // Check against all entries
        for (int i = 0; i < rowCount; i++) {
            String rowNum = (String)table.getValueAt(i, 0);
            if (rowNum.equalsIgnoreCase(curNum)) {
                return true;
            }
        }
        return false;
    }
}
