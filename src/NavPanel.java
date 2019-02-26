/**
 * NavLayout.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 15, 2019
 * Panel to navigate between features
 **/

import javax.swing.Box;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavPanel extends CustomPanel{
    // Class variables
    private ContentPanel mainPanel;
    private ButtonGroup group;
    // Constructor
    public NavPanel(int x, int y, ContentPanel mainPanel){
        super(x, y);
        this.setLayout(new GridLayout(10,1));
        this.setBackground(Color.decode("#C4C4C4"));
        this.mainPanel = mainPanel;

        // Buttons to access different frames
        CustomRadioButton dashboard, students, seatingGen, tableView;
        dashboard = new CustomRadioButton("Dashboard");
        dashboard.setSelected(true);
        students = new CustomRadioButton("Student Manager");
        seatingGen = new CustomRadioButton("Seating Generator");
        tableView = new CustomRadioButton("Table Display");

        //Group the radio buttons.
        group = new ButtonGroup();
        group.add(dashboard);
        group.add(students);
        group.add(seatingGen);
        group.add(tableView);

        ActionListener groupListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                CustomRadioButton btn = (CustomRadioButton) e.getSource();
                /*
                if(btn.getText().equals("Dashboard")){
                    mainPanel.changePanel(0);
                } else if(btn.getText().equals("Student Manager")){
                    mainPanel.changePanel(1);
                } else if(btn.getText().equals("Seating Generator")){
                    mainPanel.changePanel(2);
                } else if(btn.getText().equals("Table Display")){
                    mainPanel.changePanel(3);
                }*/
            }
        };

        dashboard.addActionListener(groupListener);
        students.addActionListener(groupListener);
        seatingGen.addActionListener(groupListener);
        tableView.addActionListener(groupListener);

        this.add(dashboard);
        this.add(students);
        this.add(seatingGen);
        this.add(tableView);

        this.add(Box.createVerticalGlue());
    }

}
