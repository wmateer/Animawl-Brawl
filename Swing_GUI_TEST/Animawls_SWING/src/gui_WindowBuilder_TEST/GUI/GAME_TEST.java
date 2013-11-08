package gui_WindowBuilder_TEST.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GAME_TEST{ 

	protected JFrame masterFrame;
	private JPanel current_Screen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GAME_TEST();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GAME_TEST() {
		masterFrame = new JFrame();
		masterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		masterFrame.setBounds(200, 150, 900, 600);
		current_Screen = new Game_Screen(masterFrame);
		current_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
		current_Screen.setLayout(new BorderLayout(0, 0));
		masterFrame.setContentPane(current_Screen);
		masterFrame.setVisible(true);
		masterFrame.setResizable(false);
	}

}