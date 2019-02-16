import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardLayout extends JPanel {
    public DashboardLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("Dashboard");
        JLabel welcome = new JLabel("Welcome to the Seating Arranger!");
        JPanel row1 = new JPanel();
            JButton newProject = new JButton("New Project");
            JButton loadProject = new JButton("Load Project");
        row1.add(newProject);
        row1.add(loadProject);

        JButton exit = new JButton("Exit");
        exit.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        this.add(title);
        this.add(welcome);
        this.add(row1);
        this.add(exit);
    }
}
