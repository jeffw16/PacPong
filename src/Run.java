import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.*;

import javax.swing.JFrame;
public class Run extends JFrame{
private int X,Y,ballX,ballY;	
private boolean player1Up, player1Down, player2Up, player2Down, player3Up, player3Right, gameTime, playTime;
private static boolean help = true, close;

public Run(Canvas c) {
	super();
	initialize(c);
	gameTime=false;
	playTime=true;
	this.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				// Move p1
				case KeyEvent.VK_W :
				player1Up = true;
				break;
				case KeyEvent.VK_S :
				player1Down = true;
				break;
				case KeyEvent.VK_F :
				gameTime = !gameTime;
				break;
				case KeyEvent.VK_P :
				playTime = !playTime;
				break;
				// Move p2
				case KeyEvent.VK_UP:
				player2Up=true;
				break;
				case KeyEvent.VK_DOWN:
				player2Down=true;
				break;
				case KeyEvent.VK_H:
				help = !help;
				break;
				case KeyEvent.VK_ESCAPE:
				close = true;		
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
	MListen myListener = new MListen();
	this.addMouseMotionListener(new MouseAdapter(){
		public void gMouseY(MouseEvent e) {
			int Y=e.getY();
			
			if(Y>ballY){
			player3Up=true;	
			}
			if(Y<ballY){
			player3Up=false;	
			}
		}
		public void gMouseX(MouseEvent e) {
			
			if(X>ballY){
			player3Right=true;	
			}
			if(X<ballY){
			player3Right=false;	
			}
		}
	});
		
	}
	public void setBallY(int y){
		ballY=y;
	}
	public void setBallX(int x){
		ballX=x;
	}
	public boolean shouldStart() {
		return gameTime;
	}
	public static boolean shouldClose() {
		return close;
	}
	public boolean shouldRun() {
		return playTime;
	}
	public static boolean shouldHelp() {
		return help;
	}
	public static void setHelp(boolean b) {
		help = b;
	}
	public int shouldMovePlayer1 (int p1Y, int height, int pLength) {
		if (player1Up == true && p1Y >= 0) {
			return 1;
	}
		if (player1Down == true && p1Y <= (height)) {
		return -1;
	}
		else{
		return 0;
	}
	} // end shouldMovePlayer1
	// Move player 2
	public int shouldMovePlayer2(int p2Y, int height, int pLength) {
		if (player2Up == true && p2Y >= 0) {
				return 1;
	}
	if (player2Down == true && p2Y <= (height)) {
		return -1;
	}
	else{
		return 0;
	}
	}
	public int shouldMovePlayer3V(int p3X,int p3Y, int width, int height) {
	// return 1 means keep going, return 0 means need to bounce off wall
	if ( player3Up && p3Y >= 0 ) {
		return 1;
	} else if ( !player3Up && p3Y <= height ) {
		return 1;
	} else {
		return 0;
	}
	}
	public int shouldMovePlayer3H(int p3X,int p3Y, int width, int height){
		if ( player3Right && p3Y <= width ) {
				return 1;
	} else if ( !player3Right && p3Y >= width ) {
				return -1;
	} else {
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
