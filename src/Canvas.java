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
 
 
  private int ballX, ballY, p1X, p1Y, p2X, p2Y;
    private int move;
    private int ballspeed;
    int score1 = 0, score2 = 0;
    boolean player1FlagArr,player1FlagAba, player2FlagArr, player2FlagAba;

  public Canvas(int x, int y) {
    height = x;
    width = y;
    move = height/45;
    ballspeed = width/60;
    
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
  public void moveBall (int nx, int ny) {
    ballX = nx;
    ballY = ny;
    repaint();
  } // end moveBall
   public void movePlayer1UP(){
p1Y+=move;
repaint();
}
// Position on Y for the player 2
public void movePlayer2UP(int x, int y){
p2Y+=move;
repaint();
}
}
