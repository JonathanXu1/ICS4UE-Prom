/**
 * DashboardLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 15, 2019
 * Layout for dashboard to appear in
 **/
// Graphics & GUI Imports
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
// Button Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Util
import java.util.ArrayList;

//TODO: Align elements

public class DashboardLayout extends CustomPanel {
    // Class variables
    private int x, y;
    private CustomPanel[] frames = new CustomPanel[3];
    private FileIOManager io;
    private ContentPanel contentPanel;
    private DynamicLabel projectTitle, studentHeaderStatus, numOfStudents, seatingHeaderStatus, tablenum, tableSizeLabel;

    // Constructor
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
    }// End of constructor

    /**----------------------------METHODS-------------------------**/
    /**
     * addFrame1
     * Displays the default frame
     * @return void, method is only used for display
     */
    private void addFrame1(){
        // Create new panel
        frames[0] = new CustomPanel(x, y);
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));
        CustomPanel row1 = new CustomPanel();
        // Contents of panel
            DynamicLabel header = new DynamicLabel("Welcome to the Seating Arranger!", x/2, y, Color.BLACK);
        row1.add(header);

        // Buttons for generating new project and loading old ones
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

            // Add components to frame
        row2.add(newProject);
        row2.add(Box.createRigidArea(new Dimension(x/8,0)));
        row2.add(loadProject);

        // Button to close program
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

        // Connects all the buttons and labels to the frame
        frames[0].add(Box.createRigidArea(new Dimension(0,y/8)));
        frames[0].add(row1);
        frames[0].add(row2);
        frames[0].add(Box.createVerticalGlue());
        frames[0].add(row3);
        this.add(frames[0], BorderLayout.CENTER);
    }

    /**
     * addFrame2
     * Displays the new project screen
     * @return void, students are added in method not returned
     */
    private void addFrame2(){
        // Setup frame
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));

            DynamicLabel header = new DynamicLabel("New Project", x, y/15, Color.BLACK);
            JPanel initPane = new JPanel();
            initPane.setBackground(Color.WHITE);
            initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));
            initPane.setBorder(new EmptyBorder(x/40, x/40, x/40, x/40));

            // Takes in a project name and table size
                DynamicLabel nameLabel = new DynamicLabel("Project Name", x, y/20, Color.BLACK);
                CustomJTextField nameField = new CustomJTextField(15, x, y/40);
                nameField.setPreferredSize(new Dimension(x/2, y/20));
                DynamicLabel tableLabel = new DynamicLabel("Table Size", x, y/20, Color.BLACK);
                CustomJTextField tableField = new CustomJTextField(15, x, y/40);
                tableField.setPreferredSize(new Dimension(x/2, y/20));

            DynamicLabel errorLabel = new DynamicLabel("Placeholder text. I hope Mr.Mangat gives me a good mark.", x/2, y/20, Color.RED);
            errorLabel.setText("");
            // Add components to inner tabs
            initPane.add(nameLabel);
            initPane.add(nameField);
            initPane.add(tableLabel);
            initPane.add(tableField);
            initPane.add(errorLabel);

            // Buttons to save or cancel the project
            CustomPanel row2 = new CustomPanel(x/3, y/15);
            //row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
                CustomButton cancelBtn = new CustomButton("Cancel", 2,  x, y/30);
                cancelBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        nameField.setText("");
                        tableField.setText("");
                        showFrame(0);
                    }
                });
                CustomButton saveBtn = new CustomButton("Save", 2,  x, y/30);
                saveBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        String newTitle = nameField.getText();
                        String newTableSize = tableField.getText();
                        boolean isValid = true;
                        errorLabel.setText("");

                        if(newTitle.isEmpty()){
                            errorLabel.setText(errorLabel.getText() + " Please enter a title.");
                            isValid = false;
                        }
                        if(newTableSize.isEmpty()){
                            errorLabel.setText(errorLabel.getText() + " Please enter a table size.");
                            isValid = false;
                        } else if (!newTableSize.matches("[0-9]+")){
                            errorLabel.setText(errorLabel.getText() + " Improper input for table size.");
                            isValid = false;
                        }

                        if(isValid){
                            try {
                                io.createProject(newTitle, newTableSize);
                                errorLabel.setText("");
                                showFrame(2);
                            } catch (Exception j){
                            }

                        }
                    }
                });
            row2.add(cancelBtn);
            //row1.add(Box.createHorizontalGlue());
            row2.add(saveBtn);

        // Adds fields and label to frame
        frames[1].add(header);
        frames[1].add(initPane);
        frames[1].add(row2);

        this.add(frames[1], BorderLayout.CENTER);
    }

    /**
     * addFrame3
     * Displays screen for loaded projects
     * @return void, displays the frame, nothing to return
     */
    private void addFrame3(){
        // Setup new frame
        frames[2] = new CustomPanel();
        frames[2].setLayout(new BoxLayout(frames[2], BoxLayout.PAGE_AXIS));

        // Display project name, tables, and students
        projectTitle = new DynamicLabel("Current Project: NULL", x, y/15, Color.BLACK);
        CustomPanel row1 = new CustomPanel(x, y/12);
        row1.setLayout(new FlowLayout(FlowLayout.LEFT));
            DynamicLabel studentHeader = new DynamicLabel("Student List:", x, y/20, Color.BLACK);
            studentHeaderStatus = new DynamicLabel("Empty", x, y/20, Color.RED);
        row1.add(studentHeader);
        row1.add(studentHeaderStatus);
        numOfStudents = new DynamicLabel("Students: NULL", x, y/30, Color.BLACK);
        // Elements that need to be generate or are already generated
        CustomPanel row2 = new CustomPanel(x, y/12);
        row2.setLayout(new FlowLayout(FlowLayout.LEFT));
        DynamicLabel seatingHeader = new DynamicLabel("Seating Arrangement:", x, y/20, Color.BLACK);
            seatingHeaderStatus = new DynamicLabel("Not Generated", x, y/20, Color.RED);

        row2.add(seatingHeader);
        row2.add(seatingHeaderStatus);
        tablenum = new DynamicLabel("Number of Tables: NULL", x, y/30, Color.BLACK);
        tableSizeLabel = new DynamicLabel("Table Size: NULL", x, y/30, Color.BLACK);

        // Loads a different project
        CustomPanel bottomRow = new CustomPanel();
        bottomRow.setLayout(new BoxLayout(bottomRow, BoxLayout.LINE_AXIS));
        CustomPanel btnCont1 = new CustomPanel();
        CustomButton loadAnother = new CustomButton("Load Another Project", 2,  x, y/30);
        loadAnother.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(io.loadProject()){
                    showFrame(2);
                }
            }
        });
        btnCont1.add(loadAnother);

        // Exits program
        CustomPanel btnCont2 = new CustomPanel();
            CustomButton exit = new CustomButton("Exit", 2,  x, y/30);
            exit.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                    {
                        System.exit(0);
                    }
            });
        btnCont2.add(exit);
        bottomRow.add(btnCont1);
        bottomRow.add(Box.createHorizontalGlue());
        bottomRow.add(btnCont2);

        projectTitle.setAlignmentX( Component.LEFT_ALIGNMENT );
        row1.setAlignmentX( Component.LEFT_ALIGNMENT );
        numOfStudents.setAlignmentX( Component.LEFT_ALIGNMENT );
        row2.setAlignmentX( Component.LEFT_ALIGNMENT );
        tablenum.setAlignmentX( Component.LEFT_ALIGNMENT );
        tableSizeLabel.setAlignmentX( Component.LEFT_ALIGNMENT );

        // Adds buttons and information to the frame
        frames[2].add(projectTitle);
        frames[2].add(Box.createVerticalStrut(y/8));
        frames[2].add(row1);
        frames[2].add(numOfStudents);
        frames[2].add(Box.createVerticalStrut(y/15));
        frames[2].add(row2);
        frames[2].add(tablenum);
        frames[2].add(tableSizeLabel);
        frames[2].add(Box.createVerticalStrut(y/8));
        frames[2].add(bottomRow);
        this.add(frames[2], BorderLayout.CENTER);
    }

    /**
     * showFrame
     * Controls which frame to display
     * @param x, the number of the panel to be displayed
     * @return void, only a display method
     */
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

    /**
     * updateDashboard
     * Updates from the io
     * @return void, changes the information, nothing to return
     */
    public void updateDashboard(){
        projectTitle.setText("Current Project: " + io.getProject()[0]);

        if(io.getProject()[2].equals("0")){
            studentHeaderStatus.setText("Empty");
            studentHeaderStatus.setForeground(Color.decode("#D54F4F"));
        } else {
            studentHeaderStatus.setText("Available");
            studentHeaderStatus.setForeground(Color.decode("#4C8861"));
        }
        numOfStudents.setText("Students: " + io.getProject()[2]);
        contentPanel.enableTabs();

        if(io.loadTablesFromFile().size() > 0){
            seatingHeaderStatus.setText("Generated");
            seatingHeaderStatus.setForeground(Color.decode("#4C8861"));
        } else {
            seatingHeaderStatus.setText("Not Generated");
            seatingHeaderStatus.setForeground(Color.decode("#D54F4F"));
        }
        tablenum.setText("Number of Tables: " + io.loadTablesFromFile().size());
        tableSizeLabel.setText("Table Size: " + io.getProject()[1]);
    }

    /**
     * updateDashboard
     * Updates from the student manager
     * @param students, arraylist of students from manager
     * @return void, only a display method
     */
    public void updateDashboardStudents(ArrayList<Student> students){
        if(students.size() == 0){
            studentHeaderStatus.setText("Empty");
            studentHeaderStatus.setForeground(Color.decode("#D54F4F"));
        } else {
            studentHeaderStatus.setText("Available");
            studentHeaderStatus.setForeground(Color.decode("#4C8861"));
        }
        numOfStudents.setText("Students: " + students.size());
    }

    /**
     * updateDashboardTables
     * Updates if seating has been generated instead of re-generating each time
     * @param tables, ArrayList of Tables that were created
     * @return void, updates the display
     */
    public void updateDashboardTables(ArrayList<Table> tables){
        if(tables.size() > 0){
            seatingHeaderStatus.setText("Generated");
            seatingHeaderStatus.setForeground(Color.decode("#4C8861"));
        } else {
            seatingHeaderStatus.setText("Not Generated");
            seatingHeaderStatus.setForeground(Color.decode("#D54F4F"));
        }
        tablenum.setText("Number of Tables: " + tables.size());
    }
}
