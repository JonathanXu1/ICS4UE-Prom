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
    private TableChart chart;
   // private ArrayList<Table> tables;

    public void loadStudents(){
        this.students = io.loadStudents();
        String[] size = new String[2];
        size = io.getProject();
        this.tableSize = Integer.parseInt(size[1]);
    }

    public SeatingGenLayout(int x, int y, FileIOManager io) {
        super(x, y, "Seating Generator", "Creates seating arrangement");
        this.io = io;
        addFrame1();
        addFrame2();

        showFrame(0);
    }
    private void addFrame1() {
        frames[0] = new JPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        JPanel row1 = new JPanel();
            JButton generate = new JButton("Generate Seating!");
            //seating = new SeatingAlg();
            generate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                //tables = seating.generateTables(students, tableSize);

                    showFrame(1);
            }
        });
    row1.add(generate);
    frames[0].add(row1);
    this.add(frames[0], BorderLayout.CENTER);
    }

    private void addFrame2(){
        String tokens[] = io.getProject();
        tableSize = Integer.parseInt(tokens[1]);
        chart = new TableChart(x/10*9,y/5*4, tableSize);
        frames[1] = new JPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));

        this.add(frames[1], BorderLayout.CENTER);
    }
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }

        frames[x].setVisible(true);
    }
}
