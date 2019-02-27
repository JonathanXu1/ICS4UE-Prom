/**
 * TableLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 18, 2019
 * Layout to run the floor plan
 **/
// GUI Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Util
import java.util.ArrayList;

//TODO: Implement horizontal scrolling

public class TableLayout extends CustomPanel {
    // Class variable
    private FileIOManager io;
    private boolean tablesAvailable;
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[1];
    private CustomButton generateFloorPlan, showFloorPlan;
    private ArrayList<Table> tables;
    private FloorPlan floorDisplay = null;

    // Constructor
    public TableLayout(int x, int y, FileIOManager io) {
        super(x, y, "Table Display", "A graphical representation of table seating.");
        this.x = x;
        this.y = y;
        this.io = io;
        addFrame1();
        showFrame(0);
    }//End of constructor

    /**-----------------------METHOD-------------------**/
    /**
     * updateTables
     * @param tables, ArrayList of tables to be updated to
     * @return void, changes the displayed info
     */
    public void updateTables(ArrayList<Table> tables){
        this.tables = tables;
        if(tables.size() > 0){
            tablesAvailable = true;
            generateFloorPlan.setEnabled(true);
        } else {
            tablesAvailable = false;
            generateFloorPlan.setEnabled(false);
            showFloorPlan.setEnabled(false);
        }
        if(io.getProject()[3].equals('0')){
            showFloorPlan.setEnabled(false);
        } else {
            showFloorPlan.setEnabled(true);
        }
    }
    /**
     * addFrame1
     * Default frame for the floor plan
     * @return void, used for display
     */
    public void addFrame1(){
        // Set up frame
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
        // Buttons for new floor plan
        generateFloorPlan = new CustomButton("Generate Floor Plan", 1, x/5, y);
        generateFloorPlan.setPreferredSize(new Dimension(x/4, y/8));
        generateFloorPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(floorDisplay == null){
                    floorDisplay = new FloorPlan();
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        floorDisplay.generateFloorPlan(tables);
                    }
                });
                io.setGenerated();
                showFloorPlan.setEnabled(true);
            }
        });
        showFloorPlan = new CustomButton("Display Floor Plan", 1, x /5, y);
        showFloorPlan.setPreferredSize(new Dimension(x/4, y/8));
        showFloorPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(floorDisplay == null){
                    floorDisplay = new FloorPlan();
                }
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        floorDisplay.displayFloorPlan();
                    }
                });
            }
        });
        if(!tablesAvailable){
            generateFloorPlan.setEnabled(false);
            showFloorPlan.setEnabled(false);
        }
        row1.add(generateFloorPlan);
        row1.add(Box.createHorizontalStrut(x/8));
        row1.add(showFloorPlan);

        frames[0].add(Box.createVerticalStrut(x/6));
        frames[0].add(row1);
        frames[0].add(Box.createVerticalGlue());
        this.add(frames[0]);
    }
    /**
     * showFrame
     * Displays the correct frame
     * @param x, an integer of the selected frame
     * @return void, displayed frame nothing to return
     */
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }
        frames[x].setVisible(true);
    }
}
