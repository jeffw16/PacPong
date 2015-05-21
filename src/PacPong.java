/**
* PacPong
* Runner
*/
import java.util.Scanner;

import javax.swing.JFrame;
class PacPong {
private int score1=0;
private int score2=0;
public static void main ( String[] args ) {
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
	
Sound s = new Sound();
boolean ballright, ballup;
l.setUndecorated(true);
l.setAlwaysOnTop(true);
l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
int pLength = canvas.getPLength();
int girth = canvas.getGirth();
l.setVisible(true);
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
score1++;
}
} else {
X -= speed;
if ( X <= 0) {
ballright = true;
s.scoreChange();
score2++;
}
}
// The ball moves from up to down
if ( ballup ) {
// go up
Y += speed; // move not found
if (Y >= (height - (height/95))) { // height not found
	s.wallHit();
	ballup= false;
}
} else {
// go down
Y -= speed;
if ( Y <= 0 ) {
s.wallHit();
ballup = true;
}
}
canvas.moveBall(X, Y);
// Move player 1
int smp1 = l.shouldMovePlayer1(canvas.getp1Y(),canvas.getHeight(), canvas.getPLength());
// Move player 2
int smp2 = l.shouldMovePlayer2(canvas.getp2Y(),canvas.getHeight(), canvas.getPLength());
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
if (score1 == 9 || score2 == 9 ) {
game=false;
canvas.over();
}
int p1X, p1Y, p2X, p2Y;
p1X=canvas.getp1X();
p2X=canvas.getp2X();
p1Y=canvas.getp1Y();
p2Y=canvas.getp2Y();
// The ball stroke with the player 1
if (X > p1X-(girth/2)&& X < p1X+(girth/2) && Y >= p1Y && Y <= ( p1Y+pLength ) ) {
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
if(X > p2X-(girth/2)&& X < p2X+(girth/2) && Y >= p2Y && Y <= (p2Y+pLength)) {	
s.paddleHit();
ballright=false;
if(smp2==1){
ballup=false;
}
if(smp2==-1){
ballup=true;
}
}
canvas.setScore1(score1);
canvas.setScore2(score2);
count++;
if(count%4==0){
canvas.setSpeed(speed++);
}
try {
	Thread.sleep(15);
		while(!l.shouldRun()){
			Thread.sleep(60);
		}
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
}
