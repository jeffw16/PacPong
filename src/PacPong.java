/**
* PacPong
* Runner
*/
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.applet.*;
import javax.swing.JFrame;
class PacPong {
private int score1=0;
private int score2=0;
private int score3=0;
private int motile=50;
private boolean wwak=false;
public void init () {
/**Scanner chooseScreenSize = new Scanner ( System.in );
System.out.println ( "Screen size? 1 = 800x600, 2 = 1600x900, 3 = fullscreen: " );
int screenSizeSelection;
try {
screenSizeSelection = chooseScreenSize.nextInt();
} catch ( Exception e ) {
System.out.println ( "Invalid input; we will default your selection to 800x600." );
screenSizeSelection = 1;
}*/
int screenSizeX, screenSizeY;
/**if ( screenSizeSelection == 1 ) {
screenSizeX = 800;
screenSizeY = 600;
} else if ( screenSizeSelection == 2 ) {
screenSizeX = 1600;
screenSizeY = 900;
} else { // if ( screenSizeSelection == 3 ) {
*/screenSizeX = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();
screenSizeY = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
//} else {
// add failsafe later here
//}
PacPong ppgame = new PacPong (screenSizeX, screenSizeY );
}
public PacPong( int screenSizeX, int screenSizeY ) {
try {
run(screenSizeX, screenSizeY);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
public void run(int screenSizeX, int screenSizeY) throws InterruptedException {
	Canvas canvas = new Canvas ( screenSizeX, screenSizeY );
	Run l= new Run(canvas);
	
boolean sballright, sballup;  
Canvas start = new Canvas (screenSizeX, screenSizeY); 
Run starter = new Run(start);
starter.setUndecorated(true);
starter.setAlwaysOnTop(true);
starter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
starter.setVisible(true);
if (Math.random()>.5) {
sballright=true;
sballup=true;
} else {
sballright=false;
sballup=false;
}
int sspeed = start.getSpeed();
int sX = start.ballX();
int sY = start.ballY();
int sheight = start.getHeight();
int swidth = start.getWidth();
int smove = start.getMove();
boolean pause=true;
while(pause){
// The ball move from left to right
if ( sballright ) {
sX += sspeed; // move not found
if (sX >= (swidth)){ // width not found
sballright= false;
}
} else {
sX -= sspeed;
if ( sX <= 0) {
sballright = true;
}
}
// The ball moves from up to down
if ( sballup ) {
// go up
sY += sspeed; // move not found
if (sY >= (sheight)) { // height not found
sballup= false;
}
} else {
// go down
sY -= sspeed;
if ( sY <= 0 ) {
sballup = true;
}
}
start.moveBall(sX, sY);
Thread.sleep(15);
pause=!starter.shouldStart();
}
starter.setVisible(false);
playgame(l, canvas);
}
								public void playgame(Run l, Canvas canvas) {
									
									
Run.setHelp(false);
Sound s = new Sound();
boolean ballright, ballup;
l.setUndecorated(true);
l.setAlwaysOnTop(true);
l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
int pLength = canvas.getPLength();
int girth = canvas.getGirth();
l.setVisible(true);
//Transparent 16 x 16 pixel cursor image.
BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

//Create a new blank cursor.
Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
 cursorImg, new Point(0, 0), "blank cursor");

//Set the blank cursor to the JFrame.
l.getContentPane().setCursor(blankCursor);
boolean game = true;
int X, Y;
score1=0;
score2=0;
if (Math.random()>.5) {
ballright=true;
ballup=true;
} else {
ballright=false;
ballup=false;
}
int count=0;
int speed1 = canvas.getSpeed();
									while ( game ) {
																				
int speed = canvas.getSpeed();
X = canvas.ballX();
Y = canvas.ballY();
int height = canvas.getHeight();
int width = canvas.getWidth();
int move = canvas.getMove();
// The ball move from left to right
if ( ballright ) {
X += speed; // move not found
if (X >= width ) { // width not found
ballright= false;
s.scoreChange();
if(Math.random()>0.5){
	speed1+=(int)(Math.random()*1);
	}
	else{
	speed1-=(int)(Math.random()*1);	
	}
score1++;
}
} else {
X -= speed;
if ( X <= 0) {
ballright = true;
s.scoreChange();
if(Math.random()>0.5){
	speed1+=(int)(Math.random()*1);
	}
	else{
	speed1-=(int)(Math.random()*1);	
	}
score2++;
}
}
// The ball moves from up to down
if ( ballup ) {
// go up
Y += speed1; // move not found
if (Y >= (height - (height/95))) { // height not found
	s.wallHit();
	if(Math.random()>0.5){
		speed1+=(int)(Math.random()*1);
		}
		else{
		speed1-=(int)(Math.random()*1);	
		}
	ballup= false;
}
} else {
// go down
Y -= speed1;
if ( Y <= 0 ) {
s.wallHit();
if(Math.random()>0.5){
	speed1+=(int)(Math.random()*1);
	}
	else{
	speed1-=(int)(Math.random()*1);	
	}
ballup = true;
}
}
l.setp3X(canvas.getp3X());
l.setp3Y(canvas.getp3Y());
canvas.moveBall(X, Y);




// Move player 1
int smp1 = l.shouldMovePlayer1(canvas.getp1Y(),canvas.getHeight(), canvas.getPLength());
// Move player 2
int smp2 = l.shouldMovePlayer2(canvas.getp2Y(),canvas.getHeight(), canvas.getPLength());

int smp3v = l.shouldMovePlayer3V(canvas.getp3X(), canvas.getp3Y(), canvas.getWidth(), canvas.getHeight(),canvas.getPLength());
int smp3h = l.shouldMovePlayer3H(canvas.getp3X(), canvas.getp3Y(), canvas.getWidth(), canvas.getHeight(),canvas.getPLength());

if ( smp1 == 1) {
canvas.movePlayer1UP();
} else if ( smp1 == 0 ) {
// do nothing
} else if ( smp1 == -1 ) {
canvas.movePlayer1D();
}
if ( smp2 == 1) {
canvas.movePlayer2UP();
} else if ( smp2 == 0 ) {
// do nothing
} else if ( smp2 == -1 ) {
canvas.movePlayer2D();
}
int p3X,p3Y;
p3Y=canvas.getp3Y();
p3X=canvas.getp3X();
boolean musicmachen=true;
switch(smp3v){
case 1 :
	p3Y-=(speed*2)/3;
	if(count%15==0 && l.pm())
		s.wak();
	break;
case -1:
	p3Y+=(speed*2)/3;
	if(count%15==0 && l.pm())
		s.wak();
	break;
}
switch(smp3h){
case 1:
	p3X+=(speed*2)/3;
	if(count%15==0 && l.pm())
		s.wak();
	break;
case -1:
    p3X-=(speed*2)/3;
    if(count%15==0 && l.pm())
		s.wak();
	break;
}
canvas.movePlayer3(p3X, p3Y);

if (score1 == 7 || score2 == 7 || score3 == 9) {
game=false;
canvas.over();
}




int p1X, p1Y, p2X, p2Y;
p1X=canvas.getp1X();
p2X=canvas.getp2X();
p1Y=canvas.getp1Y();
p2Y=canvas.getp2Y();
p3Y=canvas.getp3Y();
p3X=canvas.getp3X();
// The ball stroke with the player 1
if (X > p1X-(girth/2)&& X < p1X+(girth/2) && Y >= p1Y && Y <= ( p1Y+pLength ) ) {
	if(Math.random()>0.5){
		speed1+=(int)(Math.random()*1);
		}
		else{
		speed1-=(int)(Math.random()*1);	
		}
s.paddleHit();
ballright=true;
if(smp1==1){
ballup = false;
}
if(smp1==-1){
ballup=true;
}
}
// The ball stroke with the player 2
if(X > p2X-(girth) && X < p2X+(girth) && Y >= p2Y && Y <= (p2Y+pLength)) {
	if(Math.random()>0.5){
		speed1+=(int)(Math.random()*1);
		}
		else{
		speed1-=(int)(Math.random()*1);	
		}		
s.paddleHit();
ballright=false;
if(smp2==1){
ballup=false;
}
if(smp2==-1){
ballup=true;
}
}
if(canvas.p3mov()){
if(X>=p3X && X<= p3X + (pLength/3)*2 && Y >= p3Y && Y<= p3Y + (pLength/3)*2) {
score3++;
canvas.p3Mot(false);
motile=0;
}
}
canvas.setScore1(score1);
canvas.setScore2(score2);
canvas.setScore3(score3);
boolean p3bemov;
if(!l.getp3r() && !l.getp3l() && !l.getp3u() && !l.getp3d()){
p3bemov = false;	
}
else{
	p3bemov=true;
}
canvas.setPac(l.getp3r(), l.getp3l(), l.getp3u(), l.getp3d());
if(motile<50){
	motile++;
}
if(motile == 50 && !canvas.p3mov()){
	canvas.p3Mot(true);
}
count++;
canvas.setSpeed(speed++);
if(count%5==0 && p3bemov){
	canvas.bite();
}
if (l.shouldClose()) {
	System.exit(0);
}
try {
	Thread.sleep(20);
		while(!l.shouldRun()){
			Thread.sleep(60);
		}
} catch (InterruptedException e) {
	e.printStackTrace();
}
}
	while(true) {
		if (l.shouldClose()) {
			System.exit(0);
			break;
		}
		try {
			Thread.sleep(30);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
