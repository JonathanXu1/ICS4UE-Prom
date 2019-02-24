// Seats the students into tables
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatingGenLayout extends CustomPanel {
    // Class variables
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[2];
    private FileIOManager io;

    private int tableSize;
    private ArrayList<Table> tables;
    private TableChart chart;
    private ArrayList<Student> students;
    private SeatingAlg seating = new SeatingAlg();

    // Passes students into the generator
    public void loadStudents(){
        this.students = io.loadStudents();
        String[] size = new String[2];
        size = io.getProject();
        this.tableSize = Integer.parseInt(size[1]);
    }
    // Constructor
    public SeatingGenLayout(int x, int y, FileIOManager io) {
        super(x, y, "Seating Generator", "Creates seating arrangement");
        this.x = x;
        this.y = y;
        this.io = io;

        addFrame1();
        addFrame2();

        showFrame(0);
    }
    // Displays button to generate seating
    private void addFrame1() {
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
            // Runs seating algorithm
        chart = new TableChart(x/10*9,y/5*4);
            JButton generate = new JButton("Generate Seating!");
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                tables = seating.generateTables(students, tableSize);
                chart.loadTable(tables, tableSize);
                showFrame(1);
            }
        });
    // Adds these options to the frame
    row1.add(generate);
    frames[0].add(row1);
    this.add(frames[0], BorderLayout.CENTER);
    }
    // Shows students placed into tables
    private void addFrame2(){
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
        JPanel initPane = new JPanel();
        initPane.setBackground(Color.WHITE);
        initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));

        frames[1].add(chart);
        this.add(frames[1], BorderLayout.CENTER);

    }
    // Controls which frame is displayed
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }
        frames[x].setVisible(true);
    }
}
