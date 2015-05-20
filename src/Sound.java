/**
 * PacPong
 * Sound
*/

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class AudioPlayer {
	
	 AudioClip sound;
	
		 void playSound(){
			
			URL url = AudioPlayer.class.getResource("/Sound/src/Windows Logon Sound.wav");
		  	sound = Applet.newAudioClip(url);
		  	sound.play();
			
		}

}
