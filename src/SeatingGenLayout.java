import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SeatingGenLayout extends CustomPanel {
    private FileIOManager io;
    private ArrayList<Student> students;

    private void loadStudents(){
        this.students = io.loadStudents();
       // SeatingAlg seating = new SeatingAlg();
        // Seating.generateTables();
    }

    public SeatingGenLayout(int x, int y, FileIOManager io){
        super(x , y, "Seating Generator", "Group up students into tables.");
        this.io = io;
        JButton generate = new JButton("Generate Seating!");
        this.add(generate);
        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
