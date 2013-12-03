package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import GameEngine.User;

public class MultiplayerMenu_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	private MusicFrame parentFrame;
	
	public MultiplayerMenu_Screen(MusicFrame masterFrame, User currentUser) {
		setBackground(new Color(128, 0, 0));
		setLayout(null);
		
		parentFrame = masterFrame;
		final User tmpUser = currentUser;
		
		JLabel multiplayerTitle_label = new JLabel("MULTIPLAYER MENU");
		multiplayerTitle_label.setForeground(new Color(255, 255, 255));
		multiplayerTitle_label.setHorizontalAlignment(SwingConstants.CENTER);
		multiplayerTitle_label.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 23));
		multiplayerTitle_label.setBounds(84, 6, 282, 57);
		add(multiplayerTitle_label);
		
		JButton findDuel_Button = new JButton("FIND DUEL");
		findDuel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GO TO THE DISPLAY AVAILABLE DUELS OR SHOW "TYPE IN IP DESTINATION"???
				//*****DOES NOTHING
			}
		});
		findDuel_Button.setBounds(166, 106, 117, 29);
		add(findDuel_Button);
		
		JButton createDuel_Button = new JButton("CREATE DUEL");
		createDuel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//START A MULTIPLAYER SESSION THAT WAITS UNTIL A PLAYER JOINS
				//FOR TESTING IT WILL JUST START A LOCAL GAME!!!
				//parentFrame.removeAll();
				
				//TURN OFF TITLE MUSIC//
				//parentFrame.StopMusic(); need to reform first JFRAME!!!
				
				parentFrame.setVisible(false);
				JPanel tmp_Screen = new CharacterSelect_Screen(parentFrame,tmpUser);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		createDuel_Button.setBounds(166, 173, 117, 29);
		add(createDuel_Button);
		
		JButton logout_Button = new JButton("LOGOUT");
		logout_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GOES TO THE LOGIN SCREEN AND ERASES CURRENT USER INPUTS??
				//parentFrame.removeAll();
				//parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		logout_Button.setBounds(56, 236, 117, 29);
		add(logout_Button);
		
		JButton goToMainMenu_Button = new JButton("GO TO MAIN MENU");
		goToMainMenu_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//parentFrame.removeAll();
				//parentFrame.setVisible(false);
				JPanel tmp_Screen = new MainMenu_Screen(parentFrame, tmpUser);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		goToMainMenu_Button.setBounds(229, 236, 164, 29);
		add(goToMainMenu_Button);

	}

}
