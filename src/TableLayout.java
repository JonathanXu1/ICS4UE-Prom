/**
 * TableLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 18, 2019
 * Layout to run the floor plan
 **/
// GUI Imports
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Util
import java.util.ArrayList;

public class TableLayout extends CustomPanel {
    // Class variable
    private boolean tablesAvailable;
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[1];
    private CustomButton showFloorPlan;
    private ArrayList<Table> tables;
    private FloorPlan floorDisplay;

    // Constructor
    public TableLayout(int x, int y) {
        super(x, y, "Table Display", "Show diagram of tables");
        this.x = x;
        this.y = y;
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
            showFloorPlan.setEnabled(true);
        } else {
            tablesAvailable = false;
            showFloorPlan.setEnabled(false);
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
        // Button for new floor plan
        showFloorPlan = new CustomButton("Display Floor Plan", 2, x / 6, y);
        showFloorPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                floorDisplay = new FloorPlan();
                floorDisplay.generateFloorPlan(tables);
                floorDisplay.displayFloorPlan();
            }
        });
        if(!tablesAvailable){
            showFloorPlan.setEnabled(false);
        }
        //row1.add(showFloorPlan)
        frames[0].add(showFloorPlan);
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
