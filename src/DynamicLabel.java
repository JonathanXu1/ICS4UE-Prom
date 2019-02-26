/**
 * DynamicLabel.java
 * Version 1.0;
 * @author Bao, Xu
 * Febuary 14, 2019
 * Layout for text to show
 **/
// Graphics and GUI Imports
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class DynamicLabel extends JLabel {
    // Class variables
    private static Font labelFont = new Font("Roboto Light", Font.PLAIN, 12);

    // Constructor
    public DynamicLabel(String content, int width, int height, Color color){
        super(content);

        int stringWidth = this.getFontMetrics(labelFont).stringWidth(content);
        int componentWidth = width;

        // Find out how much the font can grow in width.
        double widthRatio = (double)componentWidth / (double)stringWidth;

        int newFontSize = (int)(labelFont.getSize() * widthRatio);
        int componentHeight = height;

        // Pick a new font size so it will not be larger than the height of label.
        int fontSizeToUse = Math.min(newFontSize, componentHeight);

        // Set the label's font size to the newly determined size.
        this.setFont(new Font(labelFont.getName(), Font.PLAIN, fontSizeToUse));

        this.setForeground(color);

    }// End of constructor
}
