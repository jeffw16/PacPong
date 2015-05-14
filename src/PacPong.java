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
    while ( gameRunning ) {
        // The ball move from left to right
        if ( ballright ) {
          ballX += right;
          if (ballX >= (width - 8))
            ballright= false;
          } else {
            ballX += left;
            if ( ballX <= 0) {
              ballright = true;
            }
          }
          // The ball moves from up to down
          if ( ballup ) {
            // go up
            ballY += up;
            if (ballY >= (length - 8)) {
              ballup= false;
            }
          } else {
            // go down
            ballY += down;
            if ( ballY <= 0 ) {
              ballup = true;
            }
          }
          canvas.moveBall(ballX, ballY);
          // Move player 1
          l.shouldMovePlayer1();
          // Move player 2
          l.shouldMovePlayer2();
          // The score of the player 1 increase
          if (ballX >= (width - 8)) {
            score1++;
          }
          // The score of the player 2 increase
          if ( ballX == 0 ) {
            score2++;
          }

          // Game over. Here you can change 10 to any value
          // When the score reach to the value, the game will end
          if (score1 == 10 || score2 == 10 ) {
            game = false;
            gameOver = true;
          }

          // The ball stroke with the player 1
          if ( ballX == p1X+10 && ballY >= p1Y && ballY <= ( p1Y+25 ) ) {
            ballright=true;
          }

          // The ball stroke with the player 2
          if(ballX==(p2X-5) && ballY>=p2Y && ballY<=(p2Y+25)) {
            ballright=false;
          }
       }
    }
  }
}


