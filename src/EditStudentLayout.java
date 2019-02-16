import javax.swing.*;
import java.awt.*;

public class EditStudentLayout extends CustomPanel {

    public EditStudentLayout(int x, int y){
        // Deciding between row layout vs gridbag layout
        super(x, y, "Student Manager", "Add/modify the prom attendance here.");
            JPanel editorContent = new CustomPanel(x/20*19, y/12*11);
            editorContent.setLayout(new BoxLayout(editorContent, BoxLayout.PAGE_AXIS));
                JPanel row1 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10);
                    JLabel nameLabel = new JLabel("Full Name");
                    JLabel numberLabel = new JLabel("Student Number");
                row1.add(nameLabel);
                row1.add(numberLabel);
                row1.setBackground(null);
                JPanel row2 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10);
                    JTextField nameField = new JTextField(15);
                    JTextField numberField = new JTextField(15);
                row2.add(nameField);
                row2.add(numberField);
                row2.setBackground(null);
                JPanel row3 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10);
                    JLabel dietLabel = new JLabel("Dietary Restrictions");
                    JLabel likesLabel = new JLabel("Likes");
                    JButton deleteBtn = new JButton("Delete");
                    JButton addBtn = new JButton("Add");
                row3.add(dietLabel);
                row3.add(likesLabel);
                row3.add(deleteBtn);
                row3.add(addBtn);
                row3.setBackground(null);
                    JPanel row4 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10*6);
                    JPanel dietPanel = new CustomPanel(row4.getWidth()/2, row4.getHeight());
                    JPanel likesPanel = new CustomPanel(row4.getWidth()/2, row4.getHeight());
                row4.add(dietPanel);
                row4.add(likesPanel);
                row4.setBackground(null);
            editorContent.add(row1);
            editorContent.add(row2);
            editorContent.add(row3);
            editorContent.add(row4);
            editorContent.setBackground(null);
            JPanel bottomNav = new JPanel();
                JButton back = new JButton("Back");
                JButton save = new JButton("Save");
            bottomNav.add(back);
            bottomNav.add(save);
            bottomNav.setBackground(null);
            JLabel title = new JLabel("Student Manager");
        this.add(editorContent);
        this.add(bottomNav);

    }
    // Edit existing student
    public void editExisting (Student student){

    }
}
