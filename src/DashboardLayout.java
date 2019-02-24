import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardLayout extends CustomPanel {
    private int x, y;
    private CustomPanel[] frames = new CustomPanel[3];
    private FileIOManager io;
    private ContentPanel contentPanel;

    private DynamicLabel projectTitle, tableSizeLabel, studentHeaderStatus, numOfStudents;

    public DashboardLayout(int x, int y, FileIOManager fileManager, ContentPanel contentPanel){
        super(x, y, "Dashboard", "");
        this.x = x;
        this.y = y;
        this.io = fileManager;
        this.contentPanel = contentPanel;
        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        addFrame1();
        addFrame2();
        addFrame3();

        showFrame(0);
    }

    //Default welcome screen
    private void addFrame1(){
        frames[0] = new CustomPanel(x, y);
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
            DynamicLabel header = new DynamicLabel("Welcome to the Seating Arranger!", x/2, y, Color.BLACK);
        row1.add(header);

        CustomPanel row2 = new CustomPanel();
            CustomButton newProject = new CustomButton("New Project", 1, x/6, y);
            newProject.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    showFrame(1);
                }
            });
            newProject.setPreferredSize(new Dimension(x/4, y/8));
            CustomButton loadProject = new CustomButton("Load Project", 1, x/6, y);
            loadProject.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(io.loadProject()){
                        showFrame(2);
                    }
                }
            });

            loadProject.setPreferredSize(new Dimension(x/4, y/8));
        row2.add(newProject);
        row2.add(Box.createRigidArea(new Dimension(x/8,0)));
        row2.add(loadProject);

        CustomPanel row3 = new CustomPanel();
        row3.setLayout(new FlowLayout(FlowLayout.RIGHT));
            CustomButton exit = new CustomButton("Exit", 2,x/30, y);
        row3.add(exit);

        exit.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        frames[0].add(Box.createRigidArea(new Dimension(0,y/8)));
        frames[0].add(row1);
        frames[0].add(row2);
        frames[0].add(Box.createVerticalGlue());
        frames[0].add(row3);

        this.add(frames[0], BorderLayout.CENTER);
    }

    // New project screen
    private void addFrame2(){
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));

            DynamicLabel header = new DynamicLabel("New Project", x, y/15, Color.BLACK);
            JPanel initPane = new JPanel();
            initPane.setBackground(Color.WHITE);
            initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));
                DynamicLabel nameLabel = new DynamicLabel("Project Name", x, y/20, Color.BLACK);
                JTextField nameField = new JTextField(15);
                nameField.setPreferredSize(new Dimension(x/2, y/20));
                DynamicLabel tableLabel = new DynamicLabel("Table Size", x, y/20, Color.BLACK);
                JTextField tableField = new JTextField(15);
                tableField.setPreferredSize(new Dimension(x/2, y/20));
            initPane.add(nameLabel);
            initPane.add(nameField);
            initPane.add(tableLabel);
            initPane.add(tableField);
            // TODO: Find way to make button row @ bottom of page
            CustomPanel row1 = new CustomPanel(x/3, y/20);
            //row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
                CustomButton cancelBtn = new CustomButton("Cancel", 2,  x, y/40);
                cancelBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        showFrame(0);
                    }
                });
                CustomButton saveBtn = new CustomButton("Save", 2,  x, y/40);
                saveBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String newTitle = nameField.getText();
                        String newTableSize = tableField.getText();

                        if(!newTitle.isEmpty() && !newTableSize.isEmpty()){
                            try {
                                io.createProject(newTitle, newTableSize);
                                showFrame(2);
                            } catch (Exception j){

                            }

                        }
                    }
                });
            row1.add(cancelBtn);
            //row1.add(Box.createHorizontalGlue());
            row1.add(saveBtn);
        frames[1].add(header);
        frames[1].add(initPane);
        frames[1].add(Box.createVerticalGlue());
        frames[1].add(row1);

        this.add(frames[1], BorderLayout.CENTER);
    }

    // Loaded project screen
    private void addFrame3(){
        frames[2] = new CustomPanel(x, y);
        frames[2].setLayout(new BoxLayout(frames[2], BoxLayout.PAGE_AXIS));

        projectTitle = new DynamicLabel("Current Project: NULL", x, y/15, Color.BLACK);

        CustomPanel row1 = new CustomPanel();
            DynamicLabel studentHeader = new DynamicLabel("Student List:", x, y/20, Color.BLACK);
            studentHeaderStatus = new DynamicLabel("Empty", x, y/20, Color.RED);
        row1.add(studentHeader);
        row1.add(studentHeaderStatus);
        numOfStudents = new DynamicLabel("Students: NULL", x, y/30, Color.BLACK);

        CustomPanel row2 = new CustomPanel();
            DynamicLabel seatingHeader = new DynamicLabel("Seating Arrangement:", x, y/20, Color.BLACK);
            DynamicLabel seatingHeaderStatus = new DynamicLabel("Not Generated", x, y/20, Color.RED);
        row2.add(seatingHeader);
        row2.add(seatingHeaderStatus);
        DynamicLabel tables = new DynamicLabel("Tables: NULL", x, y/30, Color.BLACK);
        tableSizeLabel = new DynamicLabel("Tables Size: NULL", x, y/30, Color.BLACK);

        CustomPanel row3 = new CustomPanel();
        //row3.setLayout(new BoxLayout(row3, BoxLayout.LINE_AXIS));
            CustomButton loadAnother = new CustomButton("Load Another Project", 2,  x, y/40);
            loadAnother.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    if(io.loadProject()){
                        showFrame(2);
                    }
                }
            });
            CustomButton exit = new CustomButton("Exit", 2,  x, y/40);
            exit.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.exit(0);
                }
            });
        row3.add(loadAnother);
        //row3.add(Box.createHorizontalGlue());
        row3.add(exit);

        frames[2].add(projectTitle);
        frames[2].add(row1);
        frames[2].add(numOfStudents);
        frames[2].add(row2);
        frames[2].add(tables);
        frames[2].add(tableSizeLabel);
        frames[2].add(row3);

        this.add(frames[2], BorderLayout.CENTER);
    }

    private void showFrame(int x){
        for(int i = 0; i < frames.length; i++){
            frames[i].setVisible(false);
        }

        //Update frame 2 content, it's a custy solution tho
        if(x == 2){
            updateDashboard();
        }
        frames[x].setVisible(true);
    }

    public void updateDashboard(){
        projectTitle.setText("Current Project: " + io.getProject()[0]);
        tableSizeLabel.setText("Tables Size: " + io.getProject()[1]);
        if(io.getProject()[2].equals("0")){
            studentHeaderStatus.setText("Empty");
            studentHeaderStatus.setForeground(Color.RED);
        } else {
            studentHeaderStatus.setText("Available");
            studentHeaderStatus.setForeground(Color.GREEN);
        }
        numOfStudents.setText("Students: " + io.getProject()[2]);
        contentPanel.enableTabs();
    }
}
