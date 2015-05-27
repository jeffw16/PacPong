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

	public Sound(){

			System.out.println("Sound object created"); //User is told that Sound will work
			URL paddleH = Sound.class.getResource("high ping.wav");  //import sounds
			paddlePing = Applet.newAudioClip(paddleH);               //assign them   
			URL wallH = Sound.class.getResource("low ping.wav");
			wallPing = Applet.newAudioClip(wallH);
			URL scoreC = Sound.class.getResource("loser beep.wav");
			scorePing = Applet.newAudioClip(scoreC);
			URL wak = Sound.class.getResource("wakka_wakka.wav");
			wakka = Applet.newAudioClip(wak);
			URL wak1 = Sound.class.getResource("wakka_wakka2.wav"); 
			wakka1 = Applet.newAudioClip(wak1);
		}
	void wak(){
		
		wakka.play(); //PacMan's sound
		
	}
		
	
	void paddleHit(){
		
		
		paddlePing.play(); //sound for paddlebounce
		
	}
	
	void wallHit(){
		
		
		wallPing.play(); //sound for hits wall
		
	}
	
	void scoreChange(){		
		
		
		scorePing.play(); // paddle scores
		
	}
	}
