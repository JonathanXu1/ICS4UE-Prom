import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DietSelector extends CustomPanel {
    private int x, y;
    JTextField otherField;
    DietSelector(int x, int y){
        super (x, y);
        this.x = x;
        this.y = y;

        this.setBackground(Color.decode("#E4E4E4"));
        this.setLayout(new GridLayout(0, 2));

        this.addOption("Vegatarian");
        this.addOption("Halal");
        this.addOption("Vegan");
        this.addOption("Kosher");
        this.addOption("Peanut Allergy");
        this.addOption("Soy Allergy");
        this.addOption("Fish Allergy");
        this.addOption("Shellfish Allergy");
        this.addOption("Dairy Allergy");
        this.addOption("Nut Allergy");
        this.addOption("Wheat Allergy");

        otherField = new JTextField(15);
        this.add(otherField);
    }

    public ArrayList<String> getDiet(){
        ArrayList<String> output = new ArrayList<String>();
        Component[] components = this.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                if (box.isSelected()) {
                    String text = box.getText();
                    output.add(text);
                }
            }
        }
        if(!otherField.getText().isEmpty()){
            output.add(otherField.getText());
        }
        return output;
    }

    private void addOption(String name){
        JCheckBox checkbox = new JCheckBox(name);
        this.add(checkbox);
    }

    public void clear(){
        Component[] components = this.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                box.setSelected(false);
            }
        }
        otherField.setText("");
    }
}
