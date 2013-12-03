package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import GameEngine.User;

public class MainMenu_Screen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private MusicFrame parentFrame;
	
	public MainMenu_Screen(MusicFrame masterFrame,User currentUser) {
		setBackground(new Color(218, 165, 32));
		setLayout(null);
		
		final User tmpUser = currentUser;
		
		parentFrame = masterFrame;
		
		JLabel playAnimawl_title = new JLabel("PLAY ANIMAWL BRAWL!!!");
		playAnimawl_title.setHorizontalAlignment(SwingConstants.CENTER);
		playAnimawl_title.setFont(new Font("KufiStandardGK", Font.PLAIN, 23));
		playAnimawl_title.setBounds(49, 6, 351, 79);
		add(playAnimawl_title);
		
		JButton singlePlayer_Button = new JButton("SINGLE PLAYER (TBA)");
		singlePlayer_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//DOES NOT WORK RIGHT NOW, BUT MIGHT BE FOR SINGLE PLAYER IMPLEMENTATION
				//DOES NOTHINGGGGGGG ************
			}
		});
		singlePlayer_Button.setBounds(138, 97, 174, 38);
		add(singlePlayer_Button);
		
		JButton multiplayer_Button = new JButton("MULTIPLAYER");
		multiplayer_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GOES TO THE MULTIPLAYER MENU SCREEN
				//parentFrame.removeAll();
				//parentFrame.setVisible(false);
				JPanel tmp_Screen = new MultiplayerMenu_Screen(parentFrame,tmpUser);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		multiplayer_Button.setBounds(138, 154, 174, 38);
		add(multiplayer_Button);
		
		JButton logout_Button = new JButton("LOGOUT");
		logout_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//LOGS USER OUT, TAKES BACK TO LOGIN SCREEN, DELETES CURRENT USER DATA...
				//parentFrame.removeAll();
				//parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		logout_Button.setBounds(76, 249, 117, 29);
		add(logout_Button);
		
		JButton options_Button = new JButton("OPTIONS???");
		options_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GOES TO OPTIONS PAGE??? MAYBE SOUND OR VISUAL OR WINDOW SIZE ADJUSTMENT, OR ACCT REMOVAL???
				//DOES NOTHIHNG *******
			}
		});
		options_Button.setBounds(275, 249, 117, 29);
		add(options_Button);

	}

}
