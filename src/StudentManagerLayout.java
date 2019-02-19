import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagerLayout extends CustomPanel{
    private int x, y;
    private JPanel[] frames = new JPanel[4];

    public StudentManagerLayout(int x, int y){
        super(x, y, "Student Manager", "Add and modify students");
        this.x = x;
        this.y = y;
        this.setLayout(new OverlayLayout(this));

        addFrame1();
        addFrame2();

        showFrame(0);
        }

        // Default Student Display
        private void addFrame1(){
            frames[0] = new JPanel();
            frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));
            DynamicLabel header = new DynamicLabel("Current Students", x, y/10, Color.BLACK);
            JPanel row1 = new JPanel();
            JButton newStudent = new JButton("New Student");
            newStudent.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    showFrame(1);
                }
            });
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
            save.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {

                }
            });
            row1.add(newStudent);
            row1.setBackground(null);

            newStudent.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // Code for student information
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
        // New student display
        private void addFrame2(){
            frames[1] = new JPanel();
            frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));

            JLabel header = new JLabel("New Student");
            frames[1].add(header);

            this.add(frames[1], BorderLayout.CENTER);
        }

        private void showFrame(int x){
            for(int i = 0; i < frames.length; i++){
                frames[i].setVisible(false);
            }

            frames[x].setVisible(true);
        }
}
