package AnimawlBrawl.GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 Main Class that produces a functional login screen
 */

public class AnimawlBrawlGUI {
		
	private JFrame mainFrame;
	private JLabel title;
	private JLabel loginText;
	private JLabel passwordText;
	private JTextField loginTextField;
	private JTextField passwordTextField;
	private JPanel mainPanel;
	
	public AnimawlBrawlGUI() {
		
	
		mainFrame = new JFrame("Login Screen For Animawl Brawl");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		title = new JLabel("Animawl Brawl",JLabel.CENTER);
		title.setForeground(Color.black);
		title.setBackground(Color.white);
		title.setOpaque(true);
		title.setFont(new Font("SansSerif", Font.BOLD, 40));
	
		loginText = new JLabel("LOGIN",JLabel.CENTER);
		loginText.setForeground(Color.black);
		loginText.setBackground(Color.white);
		loginText.setOpaque(true);
		loginText.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		passwordText = new JLabel("PASSWORD",JLabel.CENTER);
		passwordText.setForeground(Color.black);
		passwordText.setBackground(Color.white);
		passwordText.setOpaque(true);
		passwordText.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		loginTextField = new JTextField(20);
		passwordTextField = new JTextField(20);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new loginListener());
		//once button is pressed .getText() out of both and compare with database
		//if they are in database sign user in with stored data
		//if they are in database but password is incorrect, clear password field and tell user incorrect password use .setText()
		//else if user is not in database clear both fields and ask if they want to register as a new user
		
		JButton registerButton = new JButton("NEW USER");
		registerButton.addActionListener(new registerListener());
	
		mainPanel = new JPanel(new GridLayout(0,2));
		
		mainPanel.add(loginText);
		mainPanel.add(loginTextField);
        mainPanel.add(passwordText);
		mainPanel.add(passwordTextField);
		mainPanel.add(loginButton);
		mainPanel.add(registerButton);
		mainPanel.setPreferredSize(new Dimension(400,200));
		
		mainFrame.add(title);
		mainFrame.add(mainPanel);
		mainFrame.pack();
        mainFrame.setVisible(true);
	}
	
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
			loginTextField.setText("BUTTON WORKS");
			//if ( checkDatabaseBoth(loginText.getText(),passwordText.getText()) ) {
			//	login as user; }
			//else {
			// login is incorrect;}
			//frame.setVisible(false);
			//frame.dispose();
			//>> load up main menu of animawl brawl <<
		}
	}
	
	class registerListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
			passwordTextField.setText("BUTTON WORKS");
			//checkDatabaseUser(loginText.getText());
			//confirmPassword(PASSWORD);
			//storeNewUser(USER,PASSWORD);
		}
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            
			@Override
			public void run() {
                new AnimawlBrawlGUI();
            }
        });
    }
	
	
}
