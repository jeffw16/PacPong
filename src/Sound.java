/**
 * PacPong
 * Sound
*/


import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.net.URL;


public class Sound{
	AudioClip paddlePing, wallPing, scorePing;

	public Sound(){

			System.out.println("Sound object created");
			URL paddleH = Sound.class.getResource("high ping.wav");
			paddlePing = Applet.newAudioClip(paddleH);
			URL wallH = Sound.class.getResource("low ping.wav");
			wallPing = Applet.newAudioClip(wallH);
			URL scoreC = Sound.class.getResource("loser_beep.wav");
			scorePing = Applet.newAudioClip(scoreC);
	
		}
	
	void paddleHit(){		
		
		paddlePing.play();
		
	}
	
	void wallHit(){		
		
		wallPing.play();
		
	}
	
	void scoreChange(){			
		
		scorePing.play();
		
	}
	}
