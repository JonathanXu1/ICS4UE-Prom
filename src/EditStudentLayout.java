import javax.swing.*;
import java.awt.*;

public class EditStudentLayout extends JPanel {

    public EditStudentLayout(){
        // Deciding between row layout vs gridbag layout

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JPanel editorContent = new CustomPanel(this.getWidth()/20*19, this.getHeight()/12*11);
        editorContent.setLayout(new BoxLayout(editorContent, BoxLayout.PAGE_AXIS));
        JPanel row1 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10);
        JLabel nameLabel = new JLabel("Full Name");
        JLabel numberLabel = new JLabel("Student Number");
        row1.add(nameLabel);
        row1.add(numberLabel);
        JPanel row2 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10);
        JPanel row3 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10);
        JLabel dietLabel = new JLabel("Dietary Restrictions");
        JLabel likesLabel = new JLabel("Likes");
        JButton deleteBtn = new JButton("Delete");
        JButton addBtn = new JButton("Add");
        row3.add(dietLabel);
        row3.add(likesLabel);
        row3.add(deleteBtn);
        row3.add(addBtn);
        JPanel row4 = new CustomPanel(editorContent.getWidth(), editorContent.getHeight()/10*6);
        JPanel dietPanel = new CustomPanel(row4.getWidth()/2, row4.getHeight());
        JPanel likesPanel = new CustomPanel(row4.getWidth()/2, row4.getHeight());
        row4.add(dietPanel);
        row4.add(likesPanel);
        editorContent.add(row1);
        editorContent.add(row2);
        editorContent.add(row3);
        editorContent.add(row4);
        JPanel bottomNav = new JPanel();
        JLabel title = new JLabel("Student Manager");
        this.add(title);
        this.add(editorContent);
        this.add(bottomNav);

    }
    // Edit existing student
    public void editExisting (Student student){

    }
}
