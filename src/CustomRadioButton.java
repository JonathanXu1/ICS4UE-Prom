import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomRadioButton extends JRadioButton{
    private boolean state = false;

    CustomRadioButton(String text){
        super(text);

        this.setBackground(Color.decode("#C4C4C4"));

        if(this.isSelected()){
            this.setBackground(Color.decode("#8F8F8F"));
        }

        this.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent  e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    changeColor(Color.decode("#8F8F8F"));
                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    changeColor(Color.decode("#C4C4C4"));
                }
            }
        } );

    }

    private void changeColor(Color color){
        this.setBackground(color);
    }
}
