import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyListener implements KeyListener{

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        //System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));

        if (KeyEvent.getKeyText(e.getKeyCode()).equals("W")) {  //If 'W' is pressed
            character.moveUp();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("A")) {  //If 'A' is pressed
            character.moveLeft();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("S")) {  //If 'S' is pressed
            character.moveDown();
        } else if (KeyEvent.getKeyText(e.getKeyCode()).equals("D")) {  //If 'D' is pressed
            character.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {  //If ESC is pressed
            System.out.println("Quitting!"); //close frame & quit
            window.dispose();

        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
