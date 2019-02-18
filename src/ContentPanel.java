import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JTabbedPane {
    private DashboardLayout dashboard;
    private EditStudentLayout editStudent;
    private SeatingGenLayout seatGen;
    private TableLayout tableLayout;

    public ContentPanel(int x, int y){
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.decode("#C4C4C4"));
        this.setTabPlacement(LEFT);
    }

    public void addChildren(){
        dashboard = new DashboardLayout(this.getWidth(), this.getHeight());
        editStudent = new EditStudentLayout(this.getWidth(), this.getHeight());
        seatGen = new SeatingGenLayout(this.getWidth(), this.getHeight());
        tableLayout = new TableLayout(this.getWidth(), this.getHeight());

        this.addTab("Dashboard", dashboard);
        this.addTab("Student Manager", editStudent);
        this.addTab("Seating Generator", seatGen);
        this.addTab("Table Display", tableLayout);

    }
}
