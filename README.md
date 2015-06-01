# PacPong
A variation of Pong with the third player being Pac-Man, trying to eat the ball. Written in Java and uses Swing.

## Controls
F to start
Esc to quit
H to toggle help options
W/S - left paddle up/down
Up/down - right paddle up/down
Mouse - Pac-Man left/right/up/down

## Known issues
* The game is known to freeze at times.
* On Macs, the dock does not disappear during gameplay.

## Authors and their contributions
* Jarod Norwood - primary game programmer
* Nicholas Roth - graphics and audio designer
* Jeffrey Wang - project planner

### Jarod Norwood's contributions
Jarod was the primary author of the game, writing most of the jFrame methods and the main game loop. He designed most of the game structure. This includes all key and mouse listeners, cursor invisibility, paddle and ball physics (the ball's bounce off the paddle), movement of in-game sprites such as Pac-Man and the paddles, the start screen animation, counting of the score after Pac-Man "eats" the ball, incrementing of score if the ball bounces on the left or right edge of the canvas/jPanel, Pac-Man opening and closing his mouth, including the correct direction in which Pac-Man moves. Jarod was primarily responsible for designing the game rules, creating the Pac-Man "box" and code to ensure Pac-Man stayed within to counter his overpoweredness or "OPness". (He does not support free-range Pac-Men <joke>and has donated to the Super"PAC" Against Free-Range Pac-Men </joke>.)

### Nicholas Roth's contributions
Twitter: @nicholascroth
Nicholas was responsible for our sounds and our game sprites, including the Pac-Men, "waka-waka" sound, and the scores. He also helped design the proportions of the game. He worked with Jarod to design the interactions of the sprites and the events that happen in the game. He was primarily responsible and tasked with the graphical and audio resources of the project. He designed and implemented all images and sound. He created the Sound class that allowed him to add sound effects audio to the game. He contributed major optimization to the program, consolidating the resources of the code. He helped Jarod with other elements of the jPanel and canvas. He assisted Jarod with the paint component method of the Canvas class.

### Jeffrey Wang's contributions
Twitter: @jeffwang16
Email address: j@mywikis.com
Jeffrey was responsible for coordinating the overall project, gathering consensus for ideas and approving ideas proposed by other group members. In addition, he was responsible for writing some mutator and accessor methods within the files, as well as helping Jarod with his requests. Jeffrey was able to assist with debugging of many problems within the game, including jar file compatibility. In addition to forwarding helpful resources, he implemented the jFrame full screen option, allowing the game to run full screen. He stressed object-oriented principles within the code, forcing certain elements to be grouped in their own classes, contributing to readability, and later, debugging. He is responsible for website creation and marketing, creating the easy-to-use "bit.ly/pacpong" link.
