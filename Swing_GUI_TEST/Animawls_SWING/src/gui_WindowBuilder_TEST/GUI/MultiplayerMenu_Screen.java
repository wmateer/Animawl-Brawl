package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import GameEngine.User;
import GameNetworking.Game_Screen_Client;

public class MultiplayerMenu_Screen extends JPanel {
	private MusicFrame parentFrame;
	
	/**
	 * The Constructor, which takes the passed MusicFrame and User to make the Multiplayer_Screen.
	 * On this Screen the user can choose whether to host, join, or back out.
	 * 
	 * @param masterFrame The passed MusicFrame that is used to show all the panel data.
	 * @param currentUser The passed User which is also passed again once the user makes a decision.
	 */
	public MultiplayerMenu_Screen(MusicFrame masterFrame, User currentUser) {
		setBackground(new Color(128, 0, 0));
		setLayout(null);
		
		parentFrame = masterFrame;
		final User tmpUser = currentUser;
		
		JLabel multiplayerTitle_label = new JLabel("MULTIPLAYER MENU");
		multiplayerTitle_label.setForeground(new Color(255, 255, 255));
		multiplayerTitle_label.setHorizontalAlignment(SwingConstants.CENTER);
		multiplayerTitle_label.setFont(new Font("Trajan Pro", Font.BOLD, 25));
		multiplayerTitle_label.setBounds(70, 6, 310, 57);
		add(multiplayerTitle_label);
		
		JButton findDuel_Button = new JButton("LOCAL DUEL");
		findDuel_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				parentFrame.setVisible(false);
				JPanel tmp_Screen = new CharacterSelect_Screen(parentFrame,tmpUser,0);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		findDuel_Button.setBounds(140, 64, 170, 40);
		add(findDuel_Button);
		
		//STARTS A SERVER FOR HOSTING ANOTHER CLIENT
		JButton createMultiplayerMatch_Button = new JButton("CREATE MULTIPLAYER MATCH");
		createMultiplayerMatch_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//START A MULTIPLAYER SESSION THAT WAITS UNTIL A PLAYER JOINS
				//CREATE A NEW SERVER SESSION//
				
				parentFrame.setVisible(false);
				JPanel tmp_Screen = new CharacterSelect_Screen(parentFrame,tmpUser,2);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		createMultiplayerMatch_Button.setBounds(140, 172, 170, 40);
		add(createMultiplayerMatch_Button);
		
		//JOINS A MATCH AS A CLIENT TO THE SERVER//HARDCODED SOCKETS
				JButton JoinExistingGame_Button = new JButton("JOIN EXISTING GAME");
				JoinExistingGame_Button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						parentFrame.setVisible(false);
						JPanel tmp_Screen = new CharacterSelect_Screen(parentFrame,tmpUser,1);
						parentFrame.setContentPane(tmp_Screen);
						parentFrame.setVisible(true);
						parentFrame.setResizable(false);
					}
				});
				JoinExistingGame_Button.setBounds(140, 121, 170, 40);
				add(JoinExistingGame_Button);
		
		//GOES ALL THE WAY BACK TO THE LOGIN SCREEN
		JButton logout_Button = new JButton("LOGOUT");
		logout_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//GOES TO THE LOGIN SCREEN AND ERASES CURRENT USER INPUTS??
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		logout_Button.setBounds(56, 236, 117, 29);
		add(logout_Button);
		
		//GOES BACK TO THE MAIN MENU
		JButton goToMainMenu_Button = new JButton("GO TO MAIN MENU");
		goToMainMenu_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
