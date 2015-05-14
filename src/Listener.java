/**
 * PacPong
 * Listener
*/

class Listener {

private boolean player1Up, player1Down, player2Up, player2Down;

  public Listener() {
    
  }
public void keyPressed(KeyEvent e) {
   switch(e.getKeyCode()) {
     // Move ship 1
     case KeyEvent.VK_W :
       player1Up = true;
       break;
     case KeyEvent.VK_S :
       player1Down = true;
       break;
     
     // Move ship 2
     case KeyEvent.VK_UP:
       player2Up=true;
       break;
     case KeyEvent.VK_DOWN:
       player2Down=true;
       break;
   } // end switch
 } // end keyPressed

 // Here we receive from the game container class the key released
 public void keyReleased(KeyEvent e) {
  switch(e.getKeyCode()) {
   // Move player 1
   case KeyEvent.VK_W :
     player1Up = false;
     break;
   case KeyEvent.VK_S :
     player1Down = false;
     break;

   // Move player 2
   case KeyEvent.VK_UP:
     player2Upr = false;
     break;
   case KeyEvent.VK_DOWN:
     player2Down = false;
     break;
   } // end switch
 } // end keyReleased

 // Move player 1
 public void shouldMovePlayer1 () {
   if (player1Up == true && p1Y >= 0) {
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

}
