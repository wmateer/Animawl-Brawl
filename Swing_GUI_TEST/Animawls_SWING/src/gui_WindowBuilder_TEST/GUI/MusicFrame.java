package gui_WindowBuilder_TEST.GUI;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import Sound.BigClip;

public class MusicFrame extends JFrame {
	
	public BigClip TitleThemeSound;
	
	public void MusicFrame(){
		TitleThemeSound = null;
	}
	
	public void StopMusic(){
		TitleThemeSound.stop();
		TitleThemeSound.close();
	}
	
	public void StartMusic(int LoopTimes){
		TitleThemeSound = null;
		try{
			File inputFile = new File("SOUNDS/TITLE_MUSIC/LongThemeTemp_TitleSong.wav");
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(inputFile);
			TitleThemeSound = new BigClip();
	        TitleThemeSound.open(inputStream);
	        TitleThemeSound.loop(LoopTimes);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void LoopCont(){
		TitleThemeSound = null;
		try{
			File inputFile = new File("SOUNDS/TITLE_MUSIC/LongThemeTemp_TitleSong.wav");
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(inputFile);
			TitleThemeSound = new BigClip();
	        TitleThemeSound.open(inputStream);
	        TitleThemeSound.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
