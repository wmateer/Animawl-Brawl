package Sound;
/*
import java.applet.*;
import java.io.*;
import java.net.*;
*/

import java.net.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

//largely untested, probably wont work for very long files.

public class Sound_Playback {

	private String currSoundPath;
	private Clip runningSound;
	private File inputFile;
	
	public Sound_Playback(String soundPath){
		currSoundPath = soundPath;
		inputFile = new File(currSoundPath);
	}
	
	public void play(){
		/*URL url = null;
		try
		{
		    URI uri = inputClip.toURI();
		    url = uri.toURL();
		    runningSound = Applet.newAudioClip(url);
		    runningSound.play();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}*/
		
		try{

	        runningSound = AudioSystem.getClip();
	        // getAudioInputStream() also accepts a File or InputStream
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(inputFile);
	        //AudioFormat littleEndianFormat = inputStream.getFormat();
	        //AudioInputStream converted = AudioSystem.getAudioInputStream(littleEndianFormat,inputStream);
	        ////NEED PCM 16 bit most likely
	        runningSound.open(inputStream);
	        runningSound.start();
	        /*SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                // A GUI element to prevent the Clip's daemon Thread
	                // from terminating at the end of the main()
	                JOptionPane.showMessageDialog(null, "Close to exit!");
	            }
	        }); *///TEST WITHOUT FIRST
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stop(){
		runningSound.stop();
	}
	public void close(){
		runningSound.close();
	}
}