/**
 * PacPong
 * Runner
*/
import java.util.*;
import java.io.*;

class PacPong {
  private int p1Y = 0;
  public static void main ( String[] args ) {
    Scanner chooseScreenSize = new Scanner ( System.in );
    System.out.println ( "Screen size? 1 = 800x600, 2 = 1600x900, 3 = fullscreen: " );
    try {
      int screenSizeSelection = chooseScreenSize.nextInt();
    } catch ( Exception e ) {
      System.out.println ( "Invalid input; we will default your selection to 800x600." );
      int screenSizeSelection = 1;
    }
    if ( screenSizeSelection == 1 ) {
      int screenSizeX = 800;
      int screenSizeY = 600;
    } else if ( screenSizeSelection == 2 ) {
      int screenSizeX = 1600;
      int screenSizeY = 900;
    } else if ( screenSizeSelection == 3 ) {
      int screenSizeX = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
      int screenSizeY = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
    } else {
      // add failsafe later here
    }
    Listener l = new Listener();
    PacPong ppgame = new PacPong ( l, screenSizeX, screenSizeY );
  }
  public PacPong( Listener l, int screenSizeX, int screenSizeY ) {
    boolean gameRunning = true;
    Canvas canvas = new Canvas ( screenSizeX, screenSizeY );
    canvas.paintcomponent;
    int X, Y;
    X = canvas.ballX();
    Y = canvas.ballY();
    while ( gameRunning ) {
      boolean ballright, ballup;
      if (Math.random()>.5) {
        ballright=true;
      } else {
        ballright=false;
      }
      // The ball move from left to right
      if ( ballright ) {
        X += move;
        if (X >= (width - 8)) {
          ballright= false;
        }
      } else {
        X += move;
        if ( X <= 0) {
          ballright = true;
        }
      }
      // The ball moves from up to down
      if ( ballup ) {
        // go up
        Y += move;
        if (Y >= (length - 8)) {
          ballup= false;
        }
      } else {
        // go down
        Y += down;
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
      
      // The score of the player 1 increase
      if (X >= (width - 8)) {
        score1++;
      }
      // The score of the player 2 increase
      if ( X == 0 ) {
        score2++;
      }
      // Game over. Here you can change 10 to any value
      // When the score reach to the value, the game will end
      if (score1 == 10 || score2 == 10 ) {
        game = false;
        gameOver = true;
      }
      // The ball stroke with the player 1
      if ( X == p1X+10 && Y >= p1Y && Y <= ( p1Y+25 ) ) {
        ballright=true;
      }
      // The ball stroke with the player 2
      if( X ==(p2X-5) && Y>=p2Y && Y<=(p2Y+25)) {
        ballright=false;
      }
     }
    }
}


