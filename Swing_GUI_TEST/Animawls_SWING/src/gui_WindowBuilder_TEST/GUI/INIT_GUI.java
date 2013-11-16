package gui_WindowBuilder_TEST.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class INIT_GUI{ //extends JFrame {

	protected JFrame masterFrame;
	private JPanel current_Screen;

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
		
		masterFrame.setVisible(true);
		masterFrame.setResizable(false);
	}

}
