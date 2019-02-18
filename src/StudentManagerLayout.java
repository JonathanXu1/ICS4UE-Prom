import javax.swing.*;
public class StudentManagerLayout extends CustomPanel{
    public StudentManagerLayout(int x, int y){

        super(x , y, "Student Manager", "Add/modify the prom attendance here.");
        JButton save = new JButton("Save");
        JButton createStudent = new JButton("New Student");
        JButton manage = new JButton("Manage");

    }

}
