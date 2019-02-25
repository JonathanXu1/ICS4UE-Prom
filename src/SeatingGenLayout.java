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
        if (io.loadTablesfromFile().isEmpty()) {
            CustomButton generate = new CustomButton("Generate", 2, x, y/20);
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tables = seating.generateTables(students, tableSize);
                    chart.loadTable(tables, tableSize);
                    frames[1].add(chart);
                    showFrame(1);
                }
            });
            frames[0].add(generate);
        }else{
            tables = io.loadTablesfromFile();
            chart.loadTable(tables, tableSize);
            frames[0].add(chart);
            showFrame(0);
        }

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

    frames[0].add(row1);
    this.add(frames[0], BorderLayout.CENTER);
    }


    private void addFrame2() {
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));

        CustomPanel row2 = new CustomPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.LINE_AXIS));

        CustomButton reGenerate = new CustomButton("Re-Generate", 2, x, y/20);
        reGenerate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables = seating.generateTables(students, tableSize);
            }
        });
        frames[1].add(reGenerate);
        frames[1].add(row2);
        this.add(frames[1], BorderLayout.CENTER);
    }

    // Controls which frame is displayed
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }
        frames[x].setVisible(true);
    }
    public ArrayList<Table> getTables(){
        return tables;
    }
}
