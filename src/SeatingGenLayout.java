/**
 * SeatingGenLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 17, 2019
 * Places students into tables
 **/

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatingGenLayout extends CustomPanel {
    // Class variables
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[2];
    private FileIOManager io;
    private TableLayout tableLayout;

    private int tableSize;
    private ArrayList<Table> tables;
    private TableChart chart;
    private ArrayList<Student> students;
    private SeatingAlg seating = new SeatingAlg();

    // Passes students into the generator
    public void loadStudents(){
        this.students = io.loadStudents();
        tables = io.loadTablesFromFile();
        String[] size = io.getProject();
        this.tableSize = Integer.parseInt(size[1]);

        System.out.println(tables.size());

        if(tables.size() > 0){
            chart.loadTable(tables, tableSize);
            tableLayout.updateTables(tables);
            showFrame(1);
        } else {
            showFrame(0);
        }
    }
    // Constructor
    public SeatingGenLayout(int x, int y, FileIOManager io, TableLayout tableLayout) {
        super(x, y, "Seating Generator", "Creates seating arrangement");
        this.x = x;
        this.y = y;
        this.io = io;
        this.tableLayout = tableLayout;
        this.chart = new TableChart(x/10*9,y/4*3);


        addFrame1();
        addFrame2();
    }

    // Displays when nothing is generated yet
    private void addFrame1() {
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
        // Runs seating algorithm

        CustomButton generate = new CustomButton("Generate Seating!", 2, x/6, y);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables = seating.generateTables(students, tableSize);
                io.saveGroups(tables);
                chart.loadTable(tables, tableSize);
                tableLayout.updateTables(tables);
                showFrame(1);
            }
        });

        // Adds these options to the frame

        row1.add(generate);
        frames[0].add(row1);

        this.add(frames[0], BorderLayout.CENTER);
    }

    // Shows students placed into tables
    private void addFrame2() {
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
        frames[1].add(chart);

        CustomButton regenerateSeatingButton = new CustomButton("Regenerate Seating!", 2,x/6, y/20);
        regenerateSeatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables = seating.generateTables(students, tableSize);
                io.saveGroups(tables);
                chart.loadTable(tables, tableSize);
            }
        });
        frames[1].add(regenerateSeatingButton);

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