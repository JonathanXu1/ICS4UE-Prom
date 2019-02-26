/**
 * TableLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 18, 2019
 * Layout to run the floor plan
 **/

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableLayout extends CustomPanel {
    private boolean tablesAvailable = false;
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[1];
    private FileIOManager io;

    public void enableButton(){
        tablesAvailable = true;
    }

    public TableLayout(int x, int y, FileIOManager io) {
        super(x, y, "Table Display", "Show diagram of tables");
        this.x = x;
        this.y = y;
        this.io = io;
        addFrame1();
        showFrame(0);
    }

    public void loadTables (){

    }

    public void addFrame1(){
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));

        CustomButton showFloorPlan = new CustomButton("Display Floor Plan", 2, x / 6, y);
        showFloorPlan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FloorPlan floorDisplay = new FloorPlan();
               // floorDisplay.generateFloorPlan(tables);
               // floorDisplay.displayFloorPlan();
            }
        });
        showFloorPlan.setPreferredSize(new Dimension(x/4, y/8));
        //row1.add(showFloorPlan)
        frames[0].add(showFloorPlan);
        this.add(frames[0]);
    }
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }
        frames[x].setVisible(true);
    }
}
