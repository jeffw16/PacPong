import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;
import java.applet.*;
import javax.swing.JFrame;
public class Run extends JFrame {
private int X,Y,ballX,ballY, pLong;	
private boolean player1Up, player1Down, player2Up, player2Down, player3Up, player3Right, player3Left, player3Down, gameTime, playTime, shouldYap;
private static boolean help = true, close;

public Run(Canvas c) {
	super(); //draws JFrame
	initialize(c); //method that starts the content pane
	gameTime=false;
	playTime=true;
	shouldYap = true;
	this.addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) { //paddle movement and various controls
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
				case KeyEvent.VK_J :
				shouldYap = !shouldYap;
				break;
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
		public void keyReleased(KeyEvent e) {  //for movement and various controls
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
	this.addMouseMotionListener(new MouseMotionAdapter(){ //Pacman movement
		public void mouseMoved(MouseEvent e) {
			Point platz = e.getPoint();
			int X = (int) platz.getX();
			int Y = (int) platz.getY();
			if(X>ballX+pLong){
				player3Right = true;
				player3Left = false;
			}
			else if (X<ballX-pLong){
				player3Right = false;
				player3Left = true;
			}
			else{
				player3Right = false;
				player3Left = false;
			}
			if(Y<ballY-pLong){
				player3Up = true;
				player3Down = false;
			}
			else if (Y>ballY+pLong){
				player3Up = false;
				player3Down = true;
			}
			else{
				player3Down = false;
				player3Up = false;
			}
			}
	});this.addMouseListener(new MouseAdapter(){ //Pacman stop moving
		public void mousePressed(MouseEvent e) {
			player3Right = false;
			player3Left = false;
			player3Up = false;
			player3Down=false;
		}
	});
		
	}
	public boolean getp3r(){                                                //These are accessor methods for other objs
		return player3Right;                                           
	}
	public boolean getp3l(){
		return player3Left;
	}
	public boolean pm(){
		return shouldYap; //make the infernal noise of PMan cease
	}
	public boolean getp3d(){
		return player3Down;
	}
	public boolean getp3u(){
		return player3Up;
	}
	public void setp3Y(int y){                                              //set values for movement
		ballY=y;
	}
	public void setp3X(int x){
		ballX=x;
	}
	public boolean shouldStart() {                                      // should are to access from listeners like pause etc.
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
	public int shouldMovePlayer1 (int p1Y, int height, int pLength) {    //should moves dictate how pieces should move
		pLong=(pLength/2);
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
		pLong=(pLength/2);
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
	public int shouldMovePlayer3V(int p3X,int p3Y, int width, int height,int pLength) {
	if ( player3Up && p3Y >= height/3 ) {
		return 1;
	} else if ( player3Down && p3Y <= (height*2)/3-pLength/2) {
		return -1;
	} else {
		return 0;
	}
	}
	public int shouldMovePlayer3H(int p3X,int p3Y, int width, int height, int pLength){
		if ( player3Right && p3X <= (width*2)/3 -pLength/2) {
				return 1;
	} 
		else if ( player3Left && p3X >= width/3 ) {
				return -1;
	} 
		else {
				return 0;
	}
	}
	
	public void initialize(Canvas can) {     //starts the JFrame
		Dimension size= new Dimension(can.getWidth(),can.getHeight());
		this.setSize(size);
		this.setContentPane(can);
		this.setResizable(true);
		this.setTitle("PacPong");
	}
	}
