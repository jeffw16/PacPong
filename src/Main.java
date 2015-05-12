/**
 * PacPong
 * Listener
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

private JPanel jContentPane = null;

private Canvas panel = null; // This is the panel of the game class

private Canvas getPanel() {
if (panel == null) {
panel = new Canvas(); // The panel is created
}
return panel;
}

public Main() {
super();
initialize();
// Listeners for the keyboard
this.addKeyListener(new KeyAdapter()) {
public void keyPressed(KeyEvent e) {
formKeyPressed(e);
}
// Method for the key released
public void keyReleased(KeyEvent e) {
formKeyReleased(e);
}
});

}

// Here i'm stating the method that will send the key pressed to the game class
private void formKeyPressed(KeyEvent e)
{
panel.keyPressed(e);
}

// Here i'm stating the method that will send the key released to the game class
private void formKeyReleased(KeyEvent e)
{
panel.keyReleased(e);
}

/**
* This method initializes this
*
* @return void
*/
private void initialize() {
this.setResizable(false);
this.setBounds(new Rectangle(, , , ));
this.setTitle("Pong");
}

/**
* This method initializes jContentPane
*
* @return javax.swing.JPanel
*/
private JPanel getJContentPane() {
if (jContentPane == null) {
jContentPane = new JPanel();
jContentPane.setLayout(new BorderLayout());
jContentPane.add(getPanel(), BorderLayout.CENTER);
}
return jContentPane;
}

public static void main(String[] args) {
// TODO Auto-generated method stub
SwingUtilities.invokeLater(new Runnable() {
public void run() {
Main thisClass = new Main();
thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
thisClass.setVisible(true);
}
});
}
}
