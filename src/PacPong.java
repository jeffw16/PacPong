/**
* PacPong
* Runner
*/
import java.util.Scanner;
class PacPong {
private int score1=0;
private int score2=0;
	
public static void main ( String[] args ) {
Scanner chooseScreenSize = new Scanner ( System.in );
System.out.println ( "Screen size? 1 = 800x600, 2 = 1600x900, 3 = fullscreen: " );
int screenSizeSelection;
try {
screenSizeSelection = chooseScreenSize.nextInt();
} catch ( Exception e ) {
System.out.println ( "Invalid input; we will default your selection to 800x600." );
screenSizeSelection = 1;
}
int screenSizeX, screenSizeY;
if ( screenSizeSelection == 1 ) {
screenSizeX = 800;
screenSizeY = 600;
} else if ( screenSizeSelection == 2 ) {
screenSizeX = 1600;
screenSizeY = 900;
} else { // if ( screenSizeSelection == 3 ) {
screenSizeX = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
screenSizeY = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
//} else {
// add failsafe later here
}
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
boolean game = true;
boolean ballright, ballup;
Canvas canvas = new Canvas ( screenSizeX, screenSizeY );
Run l= new Run(canvas);
int pLength = getPLength();
int girth = getGirth();
l.setVisible(true);
int X, Y;
score1=0;
score2=0;
if (Math.random()>.5) {
ballright=true;
ballup=true;
} else {
ballright=false;
ballup=false;
canvas.run();
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
if (X >= (width - 8)) { // width not found
ballright= false;
score1++;
}
} else {
X -= speed;
if ( X <= 0) {
ballright = true;
score2++;
}
}
// The ball moves from up to down
if ( ballup ) {
// go up
Y += speed; // move not found
if (Y >= (height - 8)) { // height not found
ballup= false;
}
} else {
// go down
Y -= speed;
if ( Y <= 0 ) {
ballup = true;
}
}
canvas.moveBall(X, Y);
// Move player 1
int smp1 = l.shouldMovePlayer1(canvas.getp1Y(),canvas.getHeight());
// Move player 2
int smp2 = l.shouldMovePlayer2(canvas.getp2Y(),canvas.getHeight());
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
if (score1 == 10 || score2 == 10 ) {
game=false;
canvas.over();
}
int p1X, p1Y, p2X, p2Y;
p1X=canvas.getp1X();
p2X=canvas.getp2X();
p1Y=canvas.getp1Y();
p2Y=canvas.getp2Y();
// The ball stroke with the player 1
if ( X == p1X+girth && Y >= p1Y && Y <= ( p1Y+pLength ) ) {
ballright=true;
if(smp1==1){
ballup = true;
}
if(smp1==-1){
ballup=false;
}
}
// The ball stroke with the player 2
if( X ==(p2X-(girth/2)) && Y >= p2Y && Y <= (p2Y+pLength)) {
ballright=false;
if(smp2==1){
ballup=true;
}
if(smp2==-1){
ballup=false;
}
}
canvas.setScore1(score1);
canvas.setScore2(score2);
count++;
if(count%150==0){
	canvas.setSpeed(speed++);
}
Thread.sleep(17);
}
}
}

