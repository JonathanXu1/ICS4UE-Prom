import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatingGenLayout extends CustomPanel {
    private int x,y;
    private FileIOManager io;
    private ArrayList<Student> students;
    private JPanel[] frames = new JPanel[2];
    private int tableSize;

    public void loadStudents(){
        this.students = io.loadStudents();
        String[] size = new String[2];
        size = io.getProject();
        this.tableSize = Integer.parseInt(size[1]);
    }

    public SeatingGenLayout(int x, int y, FileIOManager io) {
        super(x, y, "Seating Generator", "Group up students into tables.");
        this.io = io;
        addFrame1();
        addFrame2();

        //showFrame(0);
    }
    private void addFrame1() {
        frames[0] = new JPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        JPanel row1 = new JPanel();
            JButton generate = new JButton("Generate Seating!");
        // seating = new SeatingAlg();
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                //seating.generateTables(students, tableSize );
                showFrame(1);
            }
        });
    row1.add(generate);
    frames[0].add(row1);
    this.add(frames[0], BorderLayout.CENTER);
    }
    private void addFrame2(){
        frames[1] = new JPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
        DynamicLabel header = new DynamicLabel("Done Generating", x, y/15, Color.BLACK);
        
    }
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }

        frames[x].setVisible(true);
    }
}
