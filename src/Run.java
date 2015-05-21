import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;


public class Run extends JFrame{
	private boolean player1Up, player1Down, player2Up, player2Down;
	public Run(Canvas c){
	super();
	initialize(c);
	 this.addKeyListener(new KeyAdapter() {
		 public void keyPressed(KeyEvent e) {
			 switch(e.getKeyCode()) {
			 // Move ship 1
			 case KeyEvent.VK_W :
			 player1Up = true;
			 break;
			 case KeyEvent.VK_S :
			 player1Down = true;
			 break;
			 // Move ship 2
			 case KeyEvent.VK_UP:
			 player2Up=true;
			 break;
			 case KeyEvent.VK_DOWN:
			 player2Down=true;
			 break;
			 } // end switch
			 } // end keyPressed
		 public void keyReleased(KeyEvent e) {
			 switch(e.getKeyCode()) {
			 // Move player 1
			 case KeyEvent.VK_W :
			 player1Up = false;
			 break;
			 case KeyEvent.VK_S :
			 player1Down = false;
			 break;
			 // Move player 2
			 case KeyEvent.VK_UP:
			 player2Up = false;
			 break;
			 case KeyEvent.VK_DOWN:
			 player2Down = false;
			 break;
			 } // end switch
			 } // end keyReleased
	 });
	}
	public int shouldMovePlayer1 (int p1Y, int height) {
		if (player1Up == true && p1Y >= 0) {
		return 1;
		}
		if (player1Down == true && p1Y <= (height-25)) {
		return -1;
		}
		else{
		return 0;
		}
		} // end shouldMovePlayer1
		// Move player 2
		public int shouldMovePlayer2(int p2Y, int height) {
		if (player2Up == true && p2Y >= 0) {
		return 1;
		}
		if (player2Down == true && p2Y <= (height-25)) {
		return -1;
		}
		else{
		return 0;
		}
		}
	public void initialize(Canvas can) {
		Dimension size= new Dimension(can.getWidth(),can.getHeight());
		this.setSize(size);
		this.setContentPane(can);
		this.setResizable(true);
		this.setTitle("PacPong");
		}

}
