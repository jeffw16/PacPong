/**
* PacPong
* Canvas
*/
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class Canvas extends JPanel {
private int height = 0;
private int width = 0;
private boolean game=true;
private boolean bite=false;
private boolean pacr, pacl, pacu, pacd; 
private int ballX, ballY, p1X, p1Y, p2X, p2Y, p3X, p3Y, girth, pLength;
private int move;
private int ballspeed;
private int score1,score2,score3;
private boolean p3Motile;
File oneScore = new File("src/0.png");
Image p1score = null;
File twoScore = new File("src/0.png");
Image p2score = null;
File threeScore = new File("src/0.png");
Image p3score = null;
File threeFace2 = new File("src/pacclose.png");
Image p3Face2 = null;
File threeFace11 = new File("src/pac_right.png");
Image p3Face11= null;
File threeFace12 = new File("src/pac_downright.png");
Image p3Face12 = null;
File threeFace13 = new File("src/pac_down.png");
Image p3Face13 = null;
File threeFace14 = new File("src/pac_downleft.png");
Image p3Face14 = null;
File threeFace15 = new File("src/pac_left.png");
Image p3Face15 = null;
File threeFace16 = new File("src/pac_upleft.png");
Image p3Face16 = null;
File threeFace17 = new File("src/pac_up.png");
Image p3Face17 = null;
File threeFace18 = new File("src/pac_upright.png");
Image p3Face18 = null;
public Canvas(int x, int y) {
try {
	p3Face11 = ImageIO.read(threeFace11);
} catch (IOException e) {
	System.err.println("Could not find image");
}
try {
	p3Face12 = ImageIO.read(threeFace12);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
try {
	p3Face13 = ImageIO.read(threeFace13);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
try {
	p3Face14 = ImageIO.read(threeFace14);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
try {
	p3Face15 = ImageIO.read(threeFace15);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
try {
	p3Face16 = ImageIO.read(threeFace16);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
try {
	p3Face17 = ImageIO.read(threeFace17);
} catch (IOException e) {
	System.err.println("Could not find image");
}
try {
	p3Face18 = ImageIO.read(threeFace18);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
try {
	p3Face2 = ImageIO.read(threeFace2);
} catch (IOException e) {
	System.err.println("Could not find image");
}	
height = y;
width = x;
move = height/40;
ballspeed = width/150;
ballX = width/2;
ballY = height/2;
p1Y = height/2;
p2Y = height/2;
p1X = width/40;
p2X = (width /40)*38;
p3X = width/2;
p3Y = height/3;
pLength=height/12;
girth=width/120;
game=true;
score1=0;
score2=0;
score3=0;
p3Motile=true;
}
public void setPac(boolean r, boolean l, boolean u, boolean d){
	pacr=r;
	pacd=d;
	pacu=u;
	pacl=l;
}
public void setScore3(int s3){
	score3=s3;
}
public void bite(){
	bite=!bite;
}
public int getPLength(){
return pLength;
}
public int getGirth(){
return girth;
}
public int getSpeed(){
return ballspeed;
}
public void setSpeed(int s){
ballspeed=s;
}
public void run(){
repaint();
}
public void setScore1(int s){
score1=s;
}
public void setScore2(int s){
score2=s;
}
public int getMove(){
return move;
}
public int getWidth(){
return width;
}
public int getHeight(){
return height;
}
public int ballX(){
return ballX;
}
public void over(){
game=false;
repaint();
}
public int ballY(){
return ballY;
}
// Draw ball and ships
public void paintComponent(Graphics g) {
		setOpaque(true);
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.WHITE);
		int boun = height/30;
		int leng = boun/2;
			
		for(int i=0; i<31; i++){
				g.fillRect(width/2, boun*i, width/500, leng);
				}
		g.fillRect(ballX, ballY, width/165, height/95 );
		// Draw paddles
		g.fillRect(p1X, p1Y, girth, pLength);
		g.fillRect(p2X, p2Y, girth, pLength);
		int ei=(pLength/3)*2+(((pLength/3)*2)/100)*14;
		int o=(pLength/3)*2;
		if(bite){
			g.drawImage(p3Face2, p3X, p3Y, (pLength/3)*2, pLength/2, null);
		}
		else{
			if(pacr && !pacd && !pacu && !pacl)
				g.drawImage(p3Face11, p3X, p3Y, o,ei, null);
			if(pacr && pacd && !pacu && !pacl)
				g.drawImage(p3Face12, p3X, p3Y, o, (pLength/3)*2, null);
			if(!pacr && pacd && !pacu && !pacl)
				g.drawImage(p3Face13, p3X, p3Y, ei, o, null);
			if(!pacr && pacd && !pacu && pacl)
				g.drawImage(p3Face14, p3X, p3Y, o, o, null);
			if(!pacr && !pacd && !pacu && pacl)
				g.drawImage(p3Face15, p3X, p3Y, o, ei, null);
			if(!pacr && !pacd && pacu && pacl)
				g.drawImage(p3Face16, p3X, p3Y, o, o, null);
			if(!pacr && !pacd && pacu && !pacl)
				g.drawImage(p3Face17, p3X, p3Y, ei, o, null);
			if(pacr && !pacd && pacu && !pacl)
				g.drawImage(p3Face18, p3X, p3Y, o, o, null);
				
		}
		g.setColor(Color.WHITE);
		g.drawRect(width/3,height/3, width/3, height/3);
		//Draw scores and calculate for X locations

	oneScore = new File("src/" + score1 + ".png");
    try{
    	p1score = ImageIO.read(oneScore);
    	}catch(IOException e){
    		System.err.println("Could not find image");
    	}
    		
	twoScore = new File("src/" + score2 + ".png");
    try{
    	p2score = ImageIO.read(twoScore);
    	}catch(IOException q){
    		System.err.println("Could not find image");
    	}
    
    threeScore = new File("src/" + score3 + ".png");
    try{
    	p3score = ImageIO.read(threeScore);
    	}catch(IOException q){
    		System.err.println("Could not find image");
    	}
g.drawImage(p1score, width/4, height/10, null);
g.drawImage(p2score, (width/4)*3, height/10, null);
g.drawImage(p3score, width/2, height/10, null);

	//displays help
	if(Run.shouldHelp()==true) {
		g.drawString("HELP:", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-200);
		g.drawString("Left Paddle - 'W' and 'S'", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-175);
		g.drawString("Right Paddle - UP and DOWN arrows", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-150);
		g.drawString("Pause game - 'P'", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-125);
		g.drawString("Exit game - ESC key", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-100);
		g.drawString("To access this menu at any time, press 'H'", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-50);
		g.drawString("To begin, press the 'F' key", 0, java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-25);
	}

	if ( !game ) {
			File endGame = new File("src/game_over.png");
			Image end = null;
				try {
					end = ImageIO.read(endGame);
				} catch (IOException e) {
					e.printStackTrace();
					}
					g.drawImage(end, width/3, (height/2),width/3,height/10,null);
					}
    	}    

public boolean getGame(){
	return game;
}
// end paintComponent
// Positions on X and Y for the ball
public void moveBall (int nx, int ny) {
ballX = nx;
ballY = ny;
repaint();
} // end moveBall
public void movePlayer1UP(){
if(p1Y>0){
p1Y-=move;
}
repaint();
}
// Position on Y for the player 2
public void movePlayer2UP(){
if(p2Y>0){
p2Y-=move;
}
repaint();
}
public void movePlayer1D(){
if(p1Y<(height-pLength)){
p1Y+=move;
}
repaint();
}
public void movePlayer2D(){
if(p2Y<(height-pLength)){
p2Y+=move;
}
repaint();
}
public void movePlayer3(int x, int y) {
	if(p3Motile){
		p3Y = y;
		p3X = x;
	}
	repaint();
}
public void p3Mot(boolean m){
	p3Motile=m;
}
public boolean p3mov(){
	return p3Motile;
}

public int getp1X () {
return p1X;
}
public int getp1Y () {
return p1Y;
}
public int getp2X () {
return p2X;
}
public int getp2Y () {
return p2Y;
}
public int getp3X() {
	return p3X;
}
public int getp3Y() {
	return p3Y;
}
}
