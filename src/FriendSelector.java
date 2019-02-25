import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FriendSelector extends CustomPanel {
    private int x, y;
    private StudentManagerLayout studentManager;
    private CustomPanel selector;
    private JButton deleteLikesBtn, addBtn;
    private ArrayList<Student> students;

    public FriendSelector(int x, int y, StudentManagerLayout studentManager){
        super(x, y);
        this.x = x;
        this.y = y;
        this.studentManager = studentManager;

        this.setBackground(Color.decode("#E4E4E4"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        CustomPanel row1 = new CustomPanel();
        DynamicLabel likesLabel = new DynamicLabel("Likes", x, y/30, Color.BLACK);
        deleteLikesBtn = new JButton("Delete");
        deleteLikesBtn.setEnabled(false);
        deleteLikesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFriends();
            }
        });

        addBtn = new JButton("Add");

        row1.add(likesLabel);
        row1.add(deleteLikesBtn);
        row1.add(addBtn);

        selector = new CustomPanel();
        selector.setLayout(new GridLayout(0, 2));

        this.add(row1);
        this.add(selector);
    }

    public void loadOptions(ArrayList<Student> students){
        this.students = students;
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> others = new ArrayList<String>();
                for (int i = 0; i < students.size(); i++){
                    others.add(students.get(i).getName());
                }
                String[] otherList = others.toArray(new String[0]);
                String s = (String)JOptionPane.showInputDialog(
                        selector,
                        "Add any friends you would like to sit with.",
                        "Selector Dialog",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        otherList,
                        null);
                //Add listing if it doesn't exist already
                if ((s != null) && (s.length() > 0)) {
                    addFriends(s);
                }
            }
        });
    }

    public void addFriends(String person){
        if(!checkExist(person)){
            JCheckBox checkbox = new JCheckBox(person);
            checkbox.addActionListener(selectListener);
            checkbox.setSelected(true);
            selector.add(checkbox);
            selector.validate();
        }
    }

    public void removeFriends(){
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                if(box.isSelected()){
                    selector.remove(box);
                    selector.validate();
                }
            }
        }
        deleteLikesBtn.setEnabled(false);
    }

    public ArrayList<String> getFriends(){
        ArrayList<String> friends = new ArrayList<String>();
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                for(int i = 0; i < students.size(); i++){
                    if(students.get(i).getName().equals(box.getText())){
                        friends.add(students.get(i).getStudentNumber());
                    }
                }
            }
        }
        return friends;
    }

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

    private ActionListener selectListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AbstractButton abstractButton = (AbstractButton) e.getSource();
            boolean selected = abstractButton.getModel().isSelected();
            deleteLikesBtn.setEnabled(selected);
        }
    };

    public void clear(){
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                selector.remove(box);
            }
        }
    }
}
