import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JTabbedPane {
    private DashboardLayout dashboard;
    private EditStudentLayout editStudent;
    private SeatingGenLayout seatGen;
    private TableLayout tableLayout;

    public ContentPanel(){
        super();
        this.setBackground(Color.decode("#E5E5E5"));
        this.setTabPlacement(LEFT);
    }

    public void addChildren(){
        dashboard = new DashboardLayout();
        editStudent = new EditStudentLayout();
        seatGen = new SeatingGenLayout();
        tableLayout = new TableLayout();

        this.addTab("Dashboard", dashboard);
        this.addTab("Student Manager", editStudent);
        this.addTab("Seating Generator", seatGen);
        this.addTab("Table Display", tableLayout);

        /*
        dashboard = new CustomPanel(this.getWidth()/20*19, this.getHeight());
            HeaderPanel dashTitle = new HeaderPanel("Dashboard", this.getWidth()/20*19, this.getHeight()/12, 2);
        dashboard.add(dashTitle, BorderLayout.NORTH);

        studentMgr = new CustomPanel(this.getWidth()/20*19, this.getHeight());
        HeaderPanel studentTitle = new HeaderPanel("Student Manager", this.getWidth()/20*19, this.getHeight()/12, 2);
        studentMgr.add(studentTitle, BorderLayout.NORTH);

        table = new CustomPanel(this.getWidth()/20*19, this.getHeight());
        HeaderPanel tableTitle = new HeaderPanel("Table Display", this.getWidth()/20*19, this.getHeight()/12, 2);
        table.add(tableTitle, BorderLayout.NORTH);

        this.add(dashboard, BorderLayout.CENTER);
        this.add(studentMgr, BorderLayout.CENTER);
        this.add(seatGen, BorderLayout.CENTER);
        this.add(table, BorderLayout.CENTER);*/

        //this.revalidate();


        /*
        dashboard.setVisible(true);
        studentMgr.setVisible(false);
        seatGen.setVisible(false);
        table.setVisible(false);*/
    }
}
