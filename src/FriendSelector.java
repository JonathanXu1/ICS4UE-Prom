/**
 * FriendSelector.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 19, 2019
 * Adds friends when creating new students
 **/

// Button imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Graphics & GUI imports
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
// Utils
import java.util.ArrayList;

//TODO: Add feature so that new students are entered by student number, and name is selected by match instead of dropdown.

public class FriendSelector extends CustomPanel {
    // Class variables
    private int x, y;
    private CustomPanel selector;
    private CustomButton deleteLikesBtn, addBtn;
    private ArrayList<Student> students;
    private boolean initialized = false;

    // Constructor
    public FriendSelector(int x, int y){
        super(x, y);
        this.x = x;
        this.y = y;

        // Background color and layout
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Button and components
        CustomPanel row1 = new CustomPanel();
        DynamicLabel likesLabel = new DynamicLabel("Likes", x, y/15, Color.BLACK);
        deleteLikesBtn = new CustomButton("Delete", 2, x, y/20);
        deleteLikesBtn.setEnabled(false);
        deleteLikesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFriends();
            }
        });
        addBtn = new CustomButton("Add", 2, x, y/20);

        row1.add(likesLabel);
        row1.add(deleteLikesBtn);
        row1.add(addBtn);

        selector = new CustomPanel();
        selector.setLayout(new GridLayout(0, 2));
        selector.setBackground(Color.decode("#E4E4E4"));
        selector.setPreferredSize(new Dimension(x, y/10*9));

        this.add(row1);
        this.add(selector);
    }// End of constructor
/**------------------------------METHODS-------------------------**/

    /**
    * loadOptions
    * Provides drop down options for student
    * @param students, an ArrayList of students that will be altered
    * @return void, changes information of students internally
    */
    public void loadOptions(ArrayList<Student> students){
        this.students = students;
        // Adds click listeners only if this component hasn't been intialized before
        if (!initialized){
            addBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ArrayList<String> studentNames = new ArrayList<String>();
                    studentNames.add("<Empty>");
                    for (Student student : students){
                        studentNames.add(student.getName());
                    }

                    String[] otherList = studentNames.toArray(new String[0]);
                    String s = (String)JOptionPane.showInputDialog(
                            selector,
                            "Add any friends you would like to sit with.",
                            "Selector Dialog",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            otherList,
                            null);

                    //Add listing if it doesn't exist already
                    if (s == "<Empty>") {
                        while (s.length() != 9 || !s.matches("[0-9]+")) {
                            s = (String) JOptionPane.showInputDialog("Enter the student number of your friend");
                            if (s.length() != 9 || !s.matches("[0-9]+")) {
                                JOptionPane.showMessageDialog(null, "Not a valid student number.");
                            }
                        }
                    }

                    if ((s != null) && (s.length() > 0)) {
                        addFriends(s);
                    }
                }
            });
            initialized = true;
        }
    }
    /**
     * setLikes
     * Sets which people student wants to sit with
     * @param otherNumbers, the student numbers of the people they like
     * @return void, calls other method, nothing to return
     */
    public void setLikes(ArrayList<String> otherNumbers){
        for (String otherNumber : otherNumbers){
            boolean matched = false;
            for (Student student : students){
                if(student.getStudentNumber().equals(otherNumber)){
                    addFriends(student.getName());
                    matched = true;
                }
            }
            if(!matched){
                addFriends(otherNumber);
            }
        }
    }
    /**
     * addFriends
     * Creates a checkbox below of friends
     * @param personName, the name of the student's friends
     * @return void, only a display method
     */
    public void addFriends(String personName){
        if(!checkExist(personName)){
            CustomJCheckBox checkbox = new CustomJCheckBox(personName, x/2, y/6);
            checkbox.addActionListener(selectListener);
            selector.add(checkbox);
            selector.validate();
        }
    }
    /**
     * removeFriends
     * Takes selected person off friends list
     * @return void, takes person off, does not need to return anything
     */
    public void removeFriends(){
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                if(box.isSelected()){
                    selector.remove(box);
                }
            }
        }
        deleteLikesBtn.setEnabled(false);
        selector.validate();
        selector.repaint();
    }

    /**
     * getFriends
     * Sends out the friends of a student
     * @return void, returns the names of their friends
     */
    public ArrayList<String> getFriends(){
        ArrayList<String> friends = new ArrayList<String>();
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                // If student number
                if(box.getText().matches("[0-9]+")){
                    friends.add(box.getText());
                } else {
                    for(Student student : students){
                        if(student.getName().equals(box.getText())){
                            friends.add(student.getStudentNumber());
                        }
                    }
                }
            }
        }
        return friends;
    }

    /**
     * checkExist
     * Checks to see if a student has already been added as a preference
     * @return boolean, true if such student is found, false if they are not there
     */
    private boolean checkExist(String person){
        boolean exists = false;
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                if(box.getText().equals(person)){
                    exists = true;
                }
            }
        }
        return exists;
    }

    /**
     * selectListener
     * Controls the delete button and enables it when needed
     */
    private ActionListener selectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractButton abstractButton = (AbstractButton) e.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            deleteLikesBtn.setEnabled(selected);
        }
    };

    /**
     * clear
     * Empties the selections on the check box
     * @return void, changes component, nothing to return
     */
    public void clear(){
        selector.removeAll();
    }

}
