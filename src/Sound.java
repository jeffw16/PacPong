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
	AudioClip paddlePing;
	AudioClip death;

	public Sound(){

			System.out.println("Sound object created");		
	
		}
	
	void paddleHit(){
		
		URL paddleH = Sound.class.getResource("high ping.wav");
		paddlePing = Applet.newAudioClip(paddleH);
		paddlePing.play();
		
	}
	
	void wallHit(){
		
		URL wallH = Sound.class.getResource("low ping.wav");
		paddlePing = Applet.newAudioClip(wallH);
		paddlePing.play();
		
	}
	
	void scoreChange(){		
		
		URL scoreC = Sound.class.getResource("loser_beep.wav");
		paddlePing = Applet.newAudioClip(scoreC);
		paddlePing.play();
		
	}
	
	/**void playDeath()
	{
		try{click.stop();}catch(Exception e){System.out.println("Thou shall not stop Rally X music");}
		URL urlDeath = music.class.getResource("explosion.wav");
		death = Applet.newAudioClip(urlDeath);
		death.loop();
		System.out.println("DEATH TO ALL MISCREANTS");
	}**/
		
	}



	
