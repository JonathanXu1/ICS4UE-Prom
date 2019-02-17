import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardLayout extends CustomPanel {
    public DashboardLayout(int x, int y){
        super(x, y, "Dashboard", "");

        DynamicLabel welcome = new DynamicLabel("Welcome to the Seating Arranger!", x, y/10, Color.BLACK);
        JPanel row1 = new JPanel();
            JButton newProject = new JButton("New Project");
            newProject.setPreferredSize(new Dimension(x/4, y/8));
            JButton loadProject = new JButton("Load Project");
            loadProject.setPreferredSize(new Dimension(x/4, y/8));
        row1.add(newProject);
        row1.add(loadProject);
        row1.setBackground(null);

        JButton exit = new JButton("Exit");
        exit.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        this.add(welcome);
        this.add(row1);
        this.add(exit);
    }

    public void test(){
        System.out.println(this.getPreferredSize());
    }
}
