package gui_WindowBuilder_TEST.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Sound.BigClip;

public class INIT_GUI{ //extends JFrame {

	protected JFrame masterFrame;
	private JPanel current_Screen;
	private BigClip TitleThemeSound;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					//INIT_GUI frame = new INIT_GUI();
					//frame.setVisible(true);
					//frame.setResizable(false);
					new INIT_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public INIT_GUI() {
		//INIT_GUI frame = new INIT_GUI();
		masterFrame = new JFrame();
		
		masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		//masterFrame.setBounds(400, 250, 450, 320);
		masterFrame.setBounds(200, 150, 900, 600);
		current_Screen = new Title_Screen(masterFrame);
		current_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
		current_Screen.setLayout(new BorderLayout(0, 0));
		masterFrame.setContentPane(current_Screen);
		
		//START TITLE MUSIC//
		//TitleThemeSound = new Sound_Playback("SOUNDS/TITLE_MUSIC/LongThemeTemp_TitleSong.wav");
		//TitleThemeSound.play();
		/*try{
			File inputFile = new File("SOUNDS/TITLE_MUSIC/LongThemeTemp_TitleSong.wav");
	        Clip runningSound = AudioSystem.getClip();
	        // getAudioInputStream() also accepts a File or InputStream
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(inputFile);
	        
	       TitleThemeSound = new BigClip(runningSound);
	       TitleThemeSound.open(inputStream);
	       TitleThemeSound.start();
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
		/*}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
		
		masterFrame.setVisible(true);
		masterFrame.setResizable(false);
	}
	
	public void StopMusic(){
		TitleThemeSound.stop();
		TitleThemeSound.close();
	}

}
