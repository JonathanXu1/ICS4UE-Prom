import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardLayout extends CustomPanel {
    private int x, y;
    private JPanel[] frames = new JPanel[3];

    public DashboardLayout(int x, int y){
        super(x, y, "Dashboard", "");
        this.x = x;
        this.y = y;
        this.setLayout(new OverlayLayout(this));

        addFrame1();
        addFrame2();
        addFrame3();

        showFrame(0);
    }

    //Default welcome screen
    private void addFrame1(){
        frames[0] = new JPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));
        DynamicLabel header = new DynamicLabel("Welcome to the Seating Arranger!", x, y/10, Color.BLACK);
        JPanel row1 = new JPanel();
        JButton newProject = new JButton("New Project");
        newProject.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showFrame(1);
            }
        });
        newProject.setPreferredSize(new Dimension(x/4, y/8));
        JButton loadProject = new JButton("Load Project");
        loadProject.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showFrame(2);
            }
        });
        loadProject.setPreferredSize(new Dimension(x/4, y/8));
        row1.add(newProject);
        row1.add(loadProject);
        row1.setBackground(null);
        
        newProject.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e)
            {
              // Code for new project details
            }
          });
        
        loadProject.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e)
            {
              
            }
          });                             
                                     
        JButton exit = new JButton("Exit");
        exit.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        frames[0].add(header);
        frames[0].add(row1);
        frames[0].add(exit);

        this.add(frames[0], BorderLayout.CENTER);
    }

    // New project screen
    private void addFrame2(){
        frames[1] = new JPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));

            DynamicLabel header = new DynamicLabel("New Project", x, y/10, Color.BLACK);
            JPanel initPane = new JPanel();
            initPane.setBackground(Color.WHITE);
            initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));
                DynamicLabel nameLabel = new DynamicLabel("Project Name", x, y/8, Color.BLACK);
                JTextField nameField = new JTextField(15);
                DynamicLabel tableLabel = new DynamicLabel("Table Size", x, y/8, Color.BLACK);
                JTextField tableField = new JTextField(15);
            initPane.add(nameLabel);
            initPane.add(nameField);
            initPane.add(tableLabel);
            initPane.add(tableField);
            JPanel row1 = new JPanel();
                JButton cancelBtn = new JButton("Cancel");
                JButton saveBtn = new JButton("Save");
            row1.add(cancelBtn);
            row1.add(saveBtn);
        frames[1].add(header);
        frames[1].add(initPane);
        frames[1].add(row1);

        this.add(frames[1], BorderLayout.CENTER);
    }

    // Loaded project screen
    private void addFrame3(){
        frames[2] = new JPanel();
        frames[2].setLayout(new BoxLayout(frames[2], BoxLayout.PAGE_AXIS));

        JLabel header = new JLabel("Current Project: Cust");
        frames[2].add(header);

        this.add(frames[2], BorderLayout.CENTER);
    }

    private void showFrame(int x){
        for(int i = 0; i < frames.length; i++){
            frames[i].setVisible(false);
        }

        frames[x].setVisible(true);
    }
}
