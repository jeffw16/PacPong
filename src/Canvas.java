/**
 * PacPong
 * Canvas
*/
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Canvas extends JPanel implements Runnable {

 private int height = 0;
 private int width = 0;
 
  private static final long serialVersionUID = 1L;   // Positions on X and Y for the ball, player 1 and player 2
  private int ballX = 10, ballY = 100, p1X=10, p1Y=100, p2X=230, p2Y=100;
  Thread ppthread;
    int right = 5; // to the right
    int left = -5; //to the left
    int up = 5; // upward
    int down = -5; // down
     // Scores
     int score1 = 0, score2 = 0;
    boolean player1FlagArr,player1FlagAba, player2FlagArr, player2FlagAba;
    boolean game, gameOver;
  
  public Canvas(int x, int y) {
    height = x;
    width = y;
    game = true;
    ppthread = new Thread(this);
    ppthread.start();
  }

  // Draw ball and ships
  public void paintComponent(Graphics g) {
    setOpaque(true);
    super.paintComponent(g);
    
    // Draw ball
    g.setColor(Color.WHITE);
    g.fillRect(ballX, ballY, ballX-10, ballY-10);
    
    // Draw paddles
    g.fillRect(p1X, p1Y, 10, 25);
    g.fillRect(p2X, p2Y, 10, 25);

    //Draw scores and calculate for X locations
    g.drawString(score1, width/4, 100);
    g.drawString(score2, (width/4)*3, 100);

    if ( gameOver ) {
      g.drawString("Game Over", 100, 125);
    }
  } // end paintComponent

  // Positions on X and Y for the ball
  public static void moveBall (int nx, int ny) {
    ballX = nx;
    ballY = ny;
    repaint();
  } // end moveBall
/*
  public void run() {
    // TODO Auto-generated method stub
    boolean ballright=false;
    boolean ballup=false;
    
    while ( true ) {

     }
   }
   */
}
