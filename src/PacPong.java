/**
 * PacPong
 * Runner
*/
class PacPong {
  private int p1Y = 
  public static void main ( String[] args ) {
    Listener l = new Listener();
    PacPong ppgame = new PacPong ( listen );
  }
  public PacPong( Listener listen ) {
    boolean gameRunning = true;
    Canvas canvas = new Canvas ( listen );
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


