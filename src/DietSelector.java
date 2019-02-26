import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DietSelector extends CustomPanel {
    private int x, y;
    private JTextField otherField;
    private CustomPanel selector;

    DietSelector(int x, int y){
        super (x, y);
        this.x = x;
        this.y = y;

        this.setBackground(Color.decode("#E4E4E4"));
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        DynamicLabel dietLabel = new DynamicLabel("Dietary Restrictions", x, y/30, Color.BLACK);
        selector = new CustomPanel();
        selector.setLayout(new GridLayout(0, 2));

        addOption("Vegatarian");
        addOption("Halal");
        addOption("Vegan");
        addOption("Kosher");
        addOption("Peanut Allergy");
        addOption("Soy Allergy");
        addOption("Fish Allergy");
        addOption("Shellfish Allergy");
        addOption("Dairy Allergy");
        addOption("Nut Allergy");
        addOption("Wheat Allergy");

        otherField = new JTextField(15);
        selector.add(otherField);

        this.add(dietLabel);
        this.add(selector);
    }

    public ArrayList<String> getDiet(){
        ArrayList<String> output = new ArrayList<String>();
        Component[] components = selector.getComponents();
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
        selector.add(checkbox);
    }

    public void clear(){
        Component[] components = selector.getComponents();
        for (Component comp : components) {
            if (comp instanceof JCheckBox) {
                JCheckBox box = (JCheckBox) comp;
                box.setSelected(false);
            }
        }
        otherField.setText("");
    }

    public void setDiet(ArrayList<String> diet){
        Component[] components = selector.getComponents();
        for(int i = 0; i < diet.size(); i++){
            for (Component comp : components) {
                if (comp instanceof JCheckBox) {
                    JCheckBox box = (JCheckBox) comp;
                    if(box.getText().equals(diet.get(i))){
                        box.setSelected(true);
                    } else {
                        otherField.setText(diet.get(i));
                    }
                }
            }
        }
    }
}
