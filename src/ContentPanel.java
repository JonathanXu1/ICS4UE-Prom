/**
 * ContentPanel.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 13, 2019
 * Template to create panels with information on them
 **/

// Graphics & GUI imports
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Dimension;

public class ContentPanel extends JTabbedPane {
    // Class variables
    private DashboardLayout dashboard;
    private StudentManagerLayout editStudent;
    private SeatingGenLayout seatGen;
    private TableLayout tableLayout;
    private FileIOManager io;

    // Constructor
    public ContentPanel(int x, int y, FileIOManager fileManager){

        // JTabbedPane styling
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.decode("#C4C4C4"));
        this.setTabPlacement(LEFT);
        DynamicLabel placeholder = new DynamicLabel("Placeholder", x/12, y, Color.BLACK);
        this.setFont(placeholder.getFont());

        this.io = fileManager;
    }// End of constructor

    /**---------------------------METHODS----------------------------**/

    /**
     * addChildren
     * This method initializes the features
     * @return void, just needs to create
     */
    public void addChildren(){
        dashboard = new DashboardLayout(this.getWidth()/5*4, this.getHeight(), io, this);
        tableLayout = new TableLayout(this.getWidth()/5*4, this.getHeight(), io);
        seatGen = new SeatingGenLayout(this.getWidth()/5*4, this.getHeight(), io, tableLayout, dashboard);
        editStudent = new StudentManagerLayout(this.getWidth()/5*4, this.getHeight(), io, dashboard);

        this.addTab("Dashboard", dashboard);
        this.addTab("Student Manager", editStudent);
        this.addTab("Seating Generator", seatGen);
        this.addTab("Table Display", tableLayout);

        // Disable other tabs until project is set up/loaded
        this.setEnabledAt(1, false);
        this.setEnabledAt(2, false);
        this.setEnabledAt(3, false);
    }

    /**
     * enableTabs
     * This method provides access once a project is selected
     * @return void, method only enables already created tabs
     */
    // Enable other tabs when project is set up/loaded
    public void enableTabs(){
        this.setEnabledAt(1, true);
        this.setEnabledAt(2, true);
        this.setEnabledAt(3, true);
        editStudent.loadStudents();
        seatGen.loadStudents();
    }
}
