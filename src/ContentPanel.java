import javax.swing.*;
import java.awt.Color;

public class ContentPanel extends JPanel {
    private JPanel dashboard = new JPanel();
    private JPanel studentMgr = new JPanel();
    private JPanel seatGen = new JPanel();
    private JPanel table = new JPanel();

    public ContentPanel(){
        super();
        this.setBackground(Color.decode("#E5E5E5"));

        JLabel dashTitle = new JLabel("Dashboard");
        dashboard.add(dashTitle);

        JLabel studentTitle = new JLabel("Student Manager");
        studentMgr.add(studentTitle);

        JLabel seatGenTitle = new JLabel("Seating Generator");
        seatGen.add(seatGenTitle);

        JLabel tableTitle = new JLabel("Table Display");
        table.add(tableTitle);

        this.add(dashboard);
        this.add(studentMgr);
        this.add(seatGen);
        this.add(table);

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
