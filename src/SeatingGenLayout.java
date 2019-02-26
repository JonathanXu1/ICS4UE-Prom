/**
 * SeatingGenLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 17, 2019
 * Places students into tables
 **/

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
        String[] size = io.getProject();
        this.tableSize = Integer.parseInt(size[1]);
    }
    // Constructor
    public SeatingGenLayout(int x, int y, FileIOManager io, TableLayout tableLayout) {
        super(x, y, "Seating Generator", "Creates seating arrangement");
        this.x = x;
        this.y = y;
        this.io = io;
        this.tableLayout = tableLayout;

        addFrame1();
        addFrame2();
        showFrame(0);
    }

    // Displays when nothing is generated yet
    private void addFrame1() {
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.LINE_AXIS));
        // Runs seating algorithm
        chart = new TableChart(x/10*9,y/5*4);

        CustomButton generate = new CustomButton("Generate Seating!", 2, x/6, y);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables = seating.generateTables(students, tableSize);
                io.saveGroups(tables);
                chart.loadTable(tables, tableSize);
                showFrame(1);
            }
        });

        CustomButton loadSeating = new CustomButton("Display Seating", 2, x/6, y);
        loadSeating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tables = io.loadTablesFromFile();
                chart.loadTable(tables, tableSize);
                showFrame(1);
            }
        });

        // Adds these options to the frame

        row1.add(generate);
        row1.add(loadSeating);
        frames[0].add(row1);

        this.add(frames[0], BorderLayout.CENTER);
    }

    // Shows students placed into tables
    private void addFrame2() {
        frames[1] = new CustomPanel();
        frames[1].setLayout(new BoxLayout(frames[1], BoxLayout.PAGE_AXIS));
        JPanel initPane = new JPanel();
        initPane.setBackground(Color.WHITE);
        initPane.setLayout(new BoxLayout(initPane, BoxLayout.PAGE_AXIS));

        frames[1].add(chart);
        CustomPanel row1 = new CustomPanel();
        CustomButton saveSeating = new CustomButton("Save Seating", 2, x / 10, y / 40);
        saveSeating.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                io.saveGroups(tables);
            }
        });
        saveSeating.setPreferredSize(new Dimension(x/4, y/8));

        CustomButton showFloorPlan = new CustomButton("Show Floor Plan", 2, x / 10, y / 40);
        showFloorPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FloorPlan floorDisplay = new FloorPlan();
                floorDisplay.generateFloorPlan(tables);
                floorDisplay.displayFloorPlan();
            }
        });
        showFloorPlan.setPreferredSize(new Dimension(x/4, y/8));
        row1.add(saveSeating);
        row1.add(showFloorPlan);
        frames[1].add(row1);
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