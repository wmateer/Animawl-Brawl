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

public class INIT_GUI{

	private MusicFrame masterFrame;
	private JPanel current_Screen;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					new INIT_GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * The constructor.  This starts the game and opens a new MusicFrame as well as loading the Title_Screen.
	 */
	public INIT_GUI() {
		masterFrame = new MusicFrame();
		masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masterFrame.setBounds(200, 150, 900, 600);
		current_Screen = new Title_Screen(masterFrame);
		current_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
		current_Screen.setLayout(new BorderLayout(0, 0));
		masterFrame.setContentPane(current_Screen);
		masterFrame.StartMusic(1);
		masterFrame.setVisible(true);
		masterFrame.setResizable(false);
	}
}
