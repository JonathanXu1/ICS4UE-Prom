import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class DynamicLabel extends JLabel {
    private static Font labelFont = new Font("Roboto Light", Font.PLAIN, 12);

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

    }
}
