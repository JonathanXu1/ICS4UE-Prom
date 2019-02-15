import javax.swing.*;
import java.awt.*;

public class EditStudentLayout extends CustomPanel {

    public EditStudentLayout(int x, int y){
        // Deciding between row layout vs gridbag layout
        super(x, y);
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
        System.out.println(x);
        System.out.println(y);
        JPanel mainContent = new JPanel();
            JPanel row1 = new JPanel();
                JLabel nameLabel = new JLabel("Name");
                JLabel numberLabel = new JLabel("Name");
            row1.add(nameLabel);
            row1.add(numberLabel);
            JPanel row2 = new JPanel();
            JPanel row3 = new JPanel();
                JLabel dietLabel = new JLabel("Name");
                JLabel likesLabel = new JLabel("Name");
                JButton deleteBtn = new JButton("Delete");
                JButton addBtn = new JButton("Add");
            row3.add(dietLabel);
            row3.add(likesLabel);
            row3.add(deleteBtn);
            row3.add(addBtn);
            JPanel row4 = new JPanel();
                JPanel dietPanel = new JPanel();
                JPanel likesPanel = new JPanel();
        mainContent.add(row1);
        mainContent.add(row2);
        mainContent.add(row3);
        mainContent.add(row4);

        JPanel bottomNav = new JPanel();
    }

    public void addChildren(){
        System.out.println("two");
        System.out.println(this.getWidth());
        System.out.println(this.getHeight());
    }

    // Edit existing student
    public void editExisting (Student student){

    }
}
