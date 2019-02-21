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
        super(x, y, "Student Manager", "Add and modify students");
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
            DynamicLabel header = new DynamicLabel("Current Students", x, y/10, Color.BLACK);

            JPanel row1 = new JPanel();
            table = new Table();
            table.setSize(600,200);;
            JScrollPane scrollPane = new JScrollPane(table);
            frames[0].add(scrollPane);

                JButton newStudent = new JButton("New Student");
                newStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        showFrame(1);
                    }
                });
                newStudent.setPreferredSize(new Dimension(x / 4, y / 8));
            /* Not sure how we want to implement drop down bar
            JButton manageStudents = new JButton("Manage");
            manageStudents.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {

                }
            });
            */
                JButton save = new JButton("Save");
                save.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                row1.add(newStudent);
                row1.setBackground(null);

                newStudent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Code for student information
                    }
                });

                JButton exit = new JButton("Exit");
                exit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                frames[0].add(header);
                frames[0].add(row1);
                frames[0].add(exit);

                this.add(frames[0], BorderLayout.CENTER);
            }

        // New student display
        private void addFrame2(){
            frames[1] = new JPanel();
            frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
            DynamicLabel header = new DynamicLabel("New Student", x, y/15, Color.BLACK);
            JPanel initPane = new JPanel();
            initPane.setBackground(Color.WHITE);
            initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));
                DynamicLabel nameLabel = new DynamicLabel("Full Name", x, y/20, Color.BLACK);
                JTextField nameField = new JTextField(15);
                nameField.setPreferredSize(new Dimension(x, y/20));
                DynamicLabel numLabel = new DynamicLabel("Student Number", x, y/20, Color.BLACK);
                JTextField numField = new JTextField(15);
                numField.setPreferredSize(new Dimension(x,y/20));
            initPane.add(nameLabel);
            initPane.add(nameField);
            initPane.add(numLabel);
            initPane.add(numField);
            JPanel row1 = new JPanel();
            JButton cancelBtn = new JButton("Cancel");
            cancelBtn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    showFrame(0);
                }
            });
            JButton saveBtn = new JButton("Save");
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
                        showFrame(2);
                    }
                    showFrame(0);
                }
            });
            row1.add(cancelBtn);
            row1.add(saveBtn);
            frames[1].add(header);
            frames[1].add(initPane);
            frames[1].add(row1);

            this.add(frames[1], BorderLayout.CENTER);
        }

        private void showFrame(int x) {
            for (int i = 0; i < frames.length; i++) {
                frames[i].setVisible(false);
            }

            frames[x].setVisible(true);
        }
}
