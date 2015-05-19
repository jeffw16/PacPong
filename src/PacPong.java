/**
 * PacPong
 * Runner
*/

import java.util.Scanner;

class PacPong {
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
    Listener l = new Listener();
    PacPong ppgame = new PacPong ( l, screenSizeX, screenSizeY );
  }
  public PacPong( Listener l, int screenSizeX, int screenSizeY ) {
    boolean game = true;
    boolean ballright, ballup;
    Canvas canvas = new Canvas ( screenSizeX, screenSizeY );
    int X, Y, score1, score2;
    score1=0;
    score2=0;
     if (Math.random()>.5) {
        ballright=true;
      } else {
        ballright=false;
      }
    while ( game ) {
      X = canvas.ballX();
      Y = canvas.ballY();
      int height = canvas.getHeight();
      int width = canvas.getWidth();
      int move = canvas.getMove();
      // The ball move from left to right
      if ( ballright ) {
        X += move; // move not found
        if (X >= (width - 8)) { // width not found
          ballright= false;
          score1++;
        }
      } else {
        X -= move; 
        if ( X <= 0) {
          ballright = true;
          score2++;
        }
      }
      // The ball moves from up to down
      if ( ballup ) {
        // go up
        Y += move; // move not found
        if (Y >= (height - 8)) { // height not found
          ballup= false;
        }
      } else {
        // go down
        Y -= move; 
        if ( Y <= 0 ) {
          ballup = true;
        }
      }
      canvas.moveBall(X, Y);
      // Move player 1
      int smp1 = l.shouldMovePlayer1();
      // Move player 2
      int smp2 = l.shouldMovePlayer2();
      
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
        canvas.paintcomponent(game);
      }
     int p1X, p1Y, p2X, p2Y;
     p1X=canvas.getp1X();
     p2X=canvas.getp2X();
     p1Y=canvas.getp1Y();
     p1Y=canvas.getp2Y();
      // The ball stroke with the player 1
      if ( X == p1X+10 && Y >= p1Y && Y <= ( p1Y+25 ) ) {
        ballright=true;
        if(smp1==1){
        ballup = true;
        }
        if(smp1==-1){
          ballup=false;
        }
        }
      // The ball stroke with the player 2
      if( X ==(p2X-5) && Y>=p2Y && Y<=(p2Y+25)) {
        ballright=false;
        if(smp2==1){
          ballup=true;
        }
        if(smp2==-1){
          ballup=false;
        }
      }
     }
    }
}


