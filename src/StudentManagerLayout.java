import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class StudentManagerLayout extends CustomPanel{
    private int x, y;
    private JPanel[] frames = new JPanel[2];
    private FileIOManager io;

    private Table table;
    private ArrayList<Student> students;

    public StudentManagerLayout(int x, int y, FileIOManager io){
        super(x, y, "Student Manager", "Add and modify students here.");
        this.x = x;
        this.y = y;
       // this.setLayout(new OverlayLayout(this));
        this.io = io;

        addFrame1();
        addFrame2();

        showFrame(0);
    }

    public void loadStudents(){
        this.students = io.loadStudents();
        table.loadStudents(students);
    }

    // Default Student Display
    private void addFrame1(){
        frames[0] = new JPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
            DynamicLabel header = new DynamicLabel("Current Students", x, y/30, Color.BLACK);

            JButton saveBtn = new JButton("Save");
            saveBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    io.saveStudents(students);
                }
            });
            JButton manageBtn = new JButton("Manage");
            JButton newStudentBtn = new JButton("New Student");
            newStudentBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showFrame(1);
                }
            });
        row1.add(header);
        row1.add(saveBtn);
        row1.add(manageBtn);
        row1.add(newStudentBtn);

        table = new Table(x/10*9,y/5*4);

        frames[0].add(row1);
        frames[0].add(table);

        this.add(frames[0], BorderLayout.CENTER);
    }

    // New student display
    private void addFrame2(){
        frames[1] = new JPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
        JPanel initPane = new JPanel();
        initPane.setBackground(Color.WHITE);
        initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));
            CustomPanel row1 = new CustomPanel();
            CustomPanel namePanel = new CustomPanel();
            namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.PAGE_AXIS));
                DynamicLabel nameLabel = new DynamicLabel("Full Name", x, y/20, Color.BLACK);
                JTextField nameField = new JTextField(15);
                nameField.setPreferredSize(new Dimension(x, y/20));
            namePanel.add(nameLabel);
            namePanel.add(nameField);

            CustomPanel numberPanel = new CustomPanel();
            numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.PAGE_AXIS));
                DynamicLabel numLabel = new DynamicLabel("Student Number", x, y/20, Color.BLACK);
                JTextField numField = new JTextField(15);
                numField.setPreferredSize(new Dimension(x,y/20));
            namePanel.add(numLabel);
            namePanel.add(numField);

            row1.add(namePanel);
            row1.add(numberPanel);


            CustomPanel row2 = new CustomPanel();
            CustomPanel dietPanel = new CustomPanel();
            dietPanel.setLayout(new BoxLayout(dietPanel, BoxLayout.PAGE_AXIS));
                DynamicLabel dietLabel = new DynamicLabel("Dietary Restrictions", x, y/20, Color.BLACK);
                JPanel dietSelector = new JPanel();
                //TODO: Fix hardcode
                dietSelector.setPreferredSize(new Dimension(x/8, y/4));
                dietSelector.setBackground(Color.GRAY);
            dietPanel.add(dietLabel);
            dietPanel.add(dietSelector);

            CustomPanel likesPanel = new CustomPanel();
            likesPanel.setLayout(new BoxLayout(likesPanel, BoxLayout.PAGE_AXIS));
                JPanel row3 = new JPanel();
                    DynamicLabel likesLabel = new DynamicLabel("Likes", x, y/20, Color.BLACK);
                    JButton deleteBtn = new JButton("Delete");
                    JButton addBtn = new JButton("Add");
                row3.add(likesLabel);
                row3.add(deleteBtn);
                row3.add(addBtn);
                JPanel likesSelector = new JPanel();
                //TODO: Fix hardcode
                likesSelector.setPreferredSize(new Dimension(x/8, y/4));
                likesSelector.setBackground(Color.GRAY);
            likesPanel.add(row3);
            likesPanel.add(likesSelector);

            row2.add(dietPanel);
            row2.add(likesPanel);

        initPane.add(row1);
        initPane.add(row2);


        CustomPanel row4 = new CustomPanel();
        //Goes Back
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                showFrame(0);
            }
        });
        //Creates a student
        JButton saveBtn = new JButton("Next");
        saveBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = nameField.getText();
                String studentNumber = numField.getText();
                ArrayList<String> dietaryRestrictions = new ArrayList<String>();
                dietaryRestrictions.add("N/A");
                ArrayList<String> friends = new ArrayList<String>();
                friends. add("335548079");

                if(!name.isEmpty() && !studentNumber.isEmpty()){
                    Student newStudent = new Student(name, studentNumber, dietaryRestrictions, friends);
                    students.add(newStudent);
                    table.loadStudents(students);
                    showFrame(0);
                }
            }
        });
        row4.add(cancelBtn);
        row4.add(saveBtn);
        frames[1].add(initPane);
        frames[1].add(row4);

        this.add(frames[1], BorderLayout.CENTER);
    }

    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }

        frames[x].setVisible(true);
    }
}
