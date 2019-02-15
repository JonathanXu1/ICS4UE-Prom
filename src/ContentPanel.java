import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private JPanel dashboard = new JPanel();
    private EditStudentLayout studentMgr;
    private JPanel seatGen = new JPanel();
    private JPanel table = new JPanel();

    public ContentPanel(){
        super();
        this.setBackground(Color.decode("#E5E5E5"));
    }

    public void addChildren(){

        dashboard.setPreferredSize(new Dimension(this.getWidth()/20*19, this.getHeight()));
        studentMgr = new EditStudentLayout(this.getWidth()/20*19, this.getHeight());
        seatGen.setPreferredSize(new Dimension(this.getWidth()/20*19, this.getHeight()));
        table.setPreferredSize(new Dimension(this.getWidth()/20*19, this.getHeight()));

        HeaderPanel dashTitle = new HeaderPanel("Dashboard", this.getWidth()/20*19, this.getHeight()/12, 2);
        dashboard.add(dashTitle, BorderLayout.NORTH);
        HeaderPanel studentTitle = new HeaderPanel("Student Manager", this.getWidth()/20*19, this.getHeight()/12, 2);
        studentMgr.add(studentTitle, BorderLayout.NORTH);
        HeaderPanel seatGenTitle = new HeaderPanel("Seating Generator", this.getWidth()/20*19, this.getHeight()/12, 2);
        seatGen.add(seatGenTitle, BorderLayout.NORTH);
        HeaderPanel tableTitle = new HeaderPanel("Table Display", this.getWidth()/20*19, this.getHeight()/12, 2);
        table.add(tableTitle, BorderLayout.NORTH);

        this.add(dashboard);
        this.add(studentMgr);
        this.add(seatGen);
        this.add(table);

        this.revalidate();
        studentMgr.addChildren();

        dashboard.setVisible(true);
        studentMgr.setVisible(false);
        seatGen.setVisible(false);
        table.setVisible(false);
    }

    public void changePanel(int currentPanel){
        dashboard.setVisible(false);
        studentMgr.setVisible(false);
        seatGen.setVisible(false);
        table.setVisible(false);
        if(currentPanel == 0){
            dashboard.setVisible(true);
        } else if(currentPanel == 1){
            studentMgr.setVisible(true);
        } else if(currentPanel == 2){
            seatGen.setVisible(true);
        } else if(currentPanel == 3){
            table.setVisible(true);
        }
    }
}
