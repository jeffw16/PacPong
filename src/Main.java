/**
 * PacPong
 * Main
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
  private JPanel jContentPane = null;
  private Canvas panel = null; // This is the panel of the game class

  private Canvas getPanel() {
    if ( panel == null ) {
      panel = new Canvas(); // The panel is created
    }
    return panel;
  } // end getPanel
  
  public Main (int x, int y) {
    super();
    initialize(x, y);
  } // end constructor
  
  // Listeners for the keyboard
  this.addKeyListener(new KeyAdapter()) {
    public void keyPressed(KeyEvent e) {
      formKeyPressed(e);
      } // end keyPressed
    
      /**
       * Sends key released
      */
     public void keyReleased(KeyEvent e) {
      formKeyReleased(e);
    }
  });

  /**
    * Will send the key _pressed_ to the game class
  */
  private void formKeyPressed(KeyEvent e) {
    panel.keyPressed(e);
  }

  /**
   * Will send the key _released_ to the game class
   */
  private void formKeyReleased(KeyEvent e) {
    panel.keyReleased(e);
  }

  /**
  * This method initializes the game
  *
  * @return void
  */
  private void initialize(gameWidth, gameHeight) {//vars need to be initialized somewhere else
  
    this.setResizable(false);
    this.setSize(gameWidth, gameHeight);
    this.setTitle("PacPong");
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
      } // end run
   }); // end invokeLater
  } // end main method
} // end Main class
