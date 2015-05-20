import java.awt.event.KeyEvent;

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
player2Up = false;
break;
case KeyEvent.VK_DOWN:
player2Down = false;
break;
} // end switch
} // end keyReleased
// Move player 1
public int shouldMovePlayer1 (int p1Y, int height) {
if (player1Up == true && p1Y >= 0) {
return 1;
}
if (player1Down == true && p1Y <= (height-25)) {
return -1;
}
else{
return 0;
}
} // end shouldMovePlayer1
// Move player 2
public int shouldMovePlayer2(int p2Y, int height) {
if (player2Up == true && p2Y >= 0) {
return 1;
}
if (player2Down == true && p2Y <= (height-25)) {
return -1;
}
else{
return 0;
}
}
}
