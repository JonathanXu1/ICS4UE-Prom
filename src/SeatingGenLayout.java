import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatingGenLayout extends CustomPanel {
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[2];
    private FileIOManager io;

    private int tableSize;
    private ArrayList<Table> tables;
    private StudentChart chart;
    private ArrayList<Student> students;
    private SeatingAlg seating = new SeatingAlg();


    public void loadStudents(){
        this.students = io.loadStudents();
        String[] size = new String[2];
        size = io.getProject();
        this.tableSize = Integer.parseInt(size[1]);
    }

    public SeatingGenLayout(int x, int y, FileIOManager io) {
        super(x, y, "Seating Generator", "Creates seating arrangement");
        this.x = x;
        this.y = y;
        this.io = io;

        addFrame1();
        addFrame2();

        showFrame(0);
    }

    private void addFrame1() {
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));

            JButton generate = new JButton("Generate Seating!");
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                tables = seating.generateTables(students, tableSize);
                showFrame(1);
            }
        });
    row1.add(generate);
    frames[0].add(row1);
    this.add(frames[0], BorderLayout.CENTER);
    }

    private void addFrame2(){
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
        JPanel initPane = new JPanel();
        initPane.setBackground(Color.WHITE);
        initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));


        this.add(frames[1], BorderLayout.CENTER);
    }

    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }

        frames[x].setVisible(true);
    }
}
