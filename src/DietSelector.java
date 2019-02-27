/**
 * DietSelector.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 20, 2019
 * Display to enter diet of new student
 **/

//Graphics & GUI Imports
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

//Utils
import java.awt.*;
import java.util.ArrayList;

public class DietSelector extends CustomPanel {
    // Class variables
    private CustomJTextField otherField;
    private CustomPanel selector;
    private int x, y;

    // Constructor
    public DietSelector(int x, int y){
        super (x, y);
        this.x = x;
        this.y = y;

        // Set the background
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Add the labels
        DynamicLabel dietLabel = new DynamicLabel("Dietary Restrictions", x, y/15, Color.BLACK);
        selector = new CustomPanel();
        selector.setLayout(new GridLayout(6, 2));
        selector.setBackground(Color.decode("#E4E4E4"));
        selector.setPreferredSize(new Dimension(x, y/10*9));

        // Various common dietary needs
        addOption("Vegetarian");
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

        // Field to accept needs not already mentioned
        otherField = new CustomJTextField(15, x/3, y);
        otherField.setBackground(Color.WHITE);
        selector.add(otherField);

        this.add(dietLabel);
        this.add(selector);
    }

/**----------------------------------METHODS----------------------------**/

/**
* getDiet
* Controls which frame to display
* @return void, only a display method
*/
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

/**
* addOption
* Controls which frame to display
* @param name,
* @return void, only a display method
*/
private void addOption(String name){
    CustomJCheckBox checkbox = new CustomJCheckBox(name, x/2, y/6);
    selector.add(checkbox);
}
/**
 * clear
 * Empties fields after use
 * @return void, updates components
 */
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

    /**
     * setDiet
     * Sets the diet of the new student
     * @param diet, an ArrayList of the student's dietary restrictions
     * @return void, set the variable through itself
     */
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
