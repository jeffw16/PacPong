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
	AudioClip paddlePing, wallPing, scorePing, wakka, wakka1;

	public Sound(){  //the constructor procures all thesounds through URLs then sends them into AudioClips

			System.out.println("Sound object created");
			URL paddleH = Sound.class.getResource("high ping.wav");
			paddlePing = Applet.newAudioClip(paddleH);
			URL wallH = Sound.class.getResource("low ping.wav");
			wallPing = Applet.newAudioClip(wallH);
			URL scoreC = Sound.class.getResource("loser beep.wav");
			scorePing = Applet.newAudioClip(scoreC);
			URL wak = Sound.class.getResource("wakka_wakka.wav");
			wakka = Applet.newAudioClip(wak);
			URL wak1 = Sound.class.getResource("wakka_wakka2.wav");
			wakka1 = Applet.newAudioClip(wak1);
		}
	void wak(){  //all below methods play sounds
		
		wakka.play();
		
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
