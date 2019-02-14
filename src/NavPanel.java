import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NavPanel extends CustomPanel{
    private int selection = 0;

    public NavPanel(int x, int y){
        super(x, y);

        this.setLayout(new GridLayout(10,1));
        this.setBackground(Color.decode("#C4C4C4"));

        JRadioButton dashboard = new JRadioButton("Dasbhaord");
        dashboard.setSelected(true);
        JRadioButton students = new JRadioButton("Student Manager");
        JRadioButton seatingGen = new JRadioButton("Seating Generator");
        JRadioButton tableView = new JRadioButton("Table Display");

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(dashboard);
        group.add(students);
        group.add(seatingGen);
        group.add(tableView);


        this.add(dashboard);
        this.add(students);
        this.add(seatingGen);
        this.add(tableView);

        this.add(Box.createVerticalGlue());
    }
}
