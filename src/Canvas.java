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

    //Draw scores
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
    this.width = this.getWidth();
    this.length = this.getHeight();
    repaint();
  } // end moveBall

  // Here we receive from the game container class the key pressed
  public void keyPressed(KeyEvent e) {
    switch(e.getKeyCode()) {
      // Move ship 1
      case KeyEvent.VK_W :
        player1FlagArr = true;
        break;
      case KeyEvent.VK_S :
        player1FlagAba = true;
        break;
      
      // Move ship 2
      case KeyEvent.VK_UP:
        player2FlagArr=true;
        break;
      case KeyEvent.VK_DOWN:
        player2FlagAba=true;
        break;
    } // end switch
  } // end keyPressed

  // Here we receive from the game container class the key released
  public void keyReleased(KeyEvent e) {
   switch(e.getKeyCode()) {
    // Move player 1
    case KeyEvent.VK_W :
      player1FlagArr = false;
      break;
    case KeyEvent.VK_S :
      player1FlagAba = false;
      break;

    // Move player 2
    case KeyEvent.VK_UP:
      player2FlagArr = false;
      break;
    case KeyEvent.VK_DOWN:
      player2FlagAba = false;
      break;
    } // end switch
  } // end keyReleased

  // Move player 1
  public void shouldMovePlayer1 () {
    if (player1FlagArr == true && p1Y >= 0) {
      p1Y += down;
    }
    if (player1FlagAba == true && p1Y <= (this.getHeight()-25)) {
      p1Y += up;
    }
    movePlayer1(p1X, p1Y);
    
  } // end shouldMovePlayer1

  // Move player 2
  public void shouldMovePlayer2() {
    if (player2FlagArr == true && p2Y >= 0) {
      p2Y += down;
    }
    if (player2FlagAba == true && p2Y <= (this.getHeight()-25)) {
      p2Y += up;
    }
    movePlayer2(p2X, p2Y);
  }

  // Position on Y for the player 1
  public void movePlayer1(int x, int y){
    this.p1X = x;
    this.p1Y = y;
    repaint();
  }
  // Position on Y for the player 2
  public void movePlayer2(int x, int y){
    this.p2X = x;
    this.p2Y = y;
    repaint();
  }

  public void run() {
    // TODO Auto-generated method stub
    boolean ballright=false;
    boolean ballup=false;
    
    while ( true ) {
      if ( game ) {
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
          moveBall(ballX, ballY);
          
         // Delay
          try {
            Thread.sleep( 20 );
          } catch(InterruptedException ex) {
          
          }
          // Move player 1
          shouldMovePlayer1();
          // Move player 2
          shouldMovePlayer2();
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
