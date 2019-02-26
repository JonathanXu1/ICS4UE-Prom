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
    private boolean enabled;
    private int x,y;
    private CustomPanel[] frames = new CustomPanel[1];
    public void enableButton(){

    }

    public TableLayout(int x, int y) {
        super(x, y, "Table Display", "Show diagram of tables");
        this.x = x;
        this.y = y;
        addFrame1();
        showFrame(0);
    }
    public void addFrame1(){
        frames[0] = new CustomPanel();
        frames[0].setLayout(new BoxLayout(frames[0], BoxLayout.PAGE_AXIS));
/*
        if(enabled){
            CustomButton showFloorPlan = new CustomButton("Show Floor Plan", 2, x / 10, y / 40);
            showFloorPlan.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //FloorPlan floorDisplay = new FloorPlan();
                   // floorDisplay.generateFloorPlan(tables);
                   // floorDisplay.displayFloorPlan();
                }
            });
            showFloorPlan.setPreferredSize(new Dimension(x/4, y/8));
            //row1.add(showFloorPlan);
        }*/

    }
    private void showFrame(int x) {
        for (int i = 0; i < frames.length; i++) {
            frames[i].setVisible(false);
        }
        frames[x].setVisible(true);
        JButton display = new JButton("Display Floor Plan!");
        this.add(display);

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
