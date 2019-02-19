import javax.swing.*;
public class NewProjectLayout extends CustomPanel{
  public NewProjectLayout(int x, int y) {
      super(x, y, "Dashboard", "Create a new project.");
      JTextField projectName = new JTextField();
      JTextField tableSize = new JTextField();
  }
}