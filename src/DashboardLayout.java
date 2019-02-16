import javax.swing.*;

public class DashboardLayout extends JPanel {
    public DashboardLayout(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        JLabel title = new JLabel("Dashboard");
        this.add(title);
    }
}
