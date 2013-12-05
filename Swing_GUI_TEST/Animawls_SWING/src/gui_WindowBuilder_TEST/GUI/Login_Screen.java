package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;

import Animation.mover;
import GameEngine.User;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;


public class Login_Screen extends JPanel {
	private JPasswordField passwordField;
	private JTextField userName_field;
	private MusicFrame parentFrame;
	private String user;
	private String inpassword;
	
	/** 
	 * The constructor, which uses the passed MusicFrame to load the panel data. 
	 * 
	 * @param masterFrame The passed in MusicFrame that loads the panel.
	 */
	
	public Login_Screen(MusicFrame masterFrame) {
		parentFrame = masterFrame;
		parentFrame.setSize(450, 320);
		setBackground(new Color(135, 206, 235));
		setLayout(null);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(233, 167, 134, 28);
		passwordField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				user = new String(userName_field.getText());
				inpassword = new String(passwordField.getPassword());
				Hashtable data = null;
				data = LoadTable(data);
				CheckLogin(user, inpassword, data);
			}
			
		});
		add(passwordField);
		
		userName_field = new JTextField();
		userName_field.setBounds(233, 127, 134, 28);
		add(userName_field);
		userName_field.setColumns(10);
		
		JLabel user_Label = new JLabel("USERNAME");
		user_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		user_Label.setBounds(69, 133, 134, 16);
		add(user_Label);
		
		JLabel password_Label = new JLabel("PASSWORD");
		password_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		password_Label.setBounds(69, 173, 134, 16);
		add(password_Label);
		
/////////////////////Login button actions
		
		JButton login_Button = new JButton("LOGIN");		
		login_Button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			user = new String(userName_field.getText());
			inpassword = new String(passwordField.getPassword());
			Hashtable data = new Hashtable<String,User>();
			data = LoadTable(data);
			CheckLogin(user, inpassword, data);
				
			}
		});
		login_Button.setBounds(69, 246, 117, 29);
		add(login_Button);
		
/////////////// New User button actions		
		JButton newUser_button = new JButton("NEW USER");
		newUser_button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	
				JPanel tmp_Screen = new Register_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		newUser_button.setBounds(250, 246, 117, 29);
		add(newUser_button);
		// 
		JLabel title_Label = new JLabel("ANIMAWL BRAWL LOGIN");
		title_Label.setFont(new Font("Mona Lisa Solid ITC TT", Font.PLAIN, 30));
		title_Label.setBounds(66, 23, 318, 75);
		add(title_Label);
		
		add( new mover("IMAGES/CHAR_PICTS/rabbit_left.png", 150, 200, 0, 20, 1, 1, 80) );
	}
		
	
	/** 
	 * Login Checking function that tells the user if the Username and password combination was valid.
	 * Uses JOptionPane to let the user know what happened.  If successful, will go to the MainMenu_Screen
	 * 
	 * @param user Input username that the user submitted.
	 * @param inpassword Input password that the user submitted.
	 * @param data A Hashtable that stores the data that is extracted from the saved .ser file.
	 */
	public void CheckLogin(String user, String inpassword, Hashtable<String,User> data){
		if (user.isEmpty() || inpassword.isEmpty()){
			JOptionPane.showMessageDialog(null, "One or more boxes are empty","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(data.containsKey(user)){
			
			Object player = data.get(user);
			String password = ((User) player).getPassword();
			
			if (data.containsKey(user) && password.equals(inpassword)){
				JOptionPane.showMessageDialog(null, "Login successfull","Success", JOptionPane.INFORMATION_MESSAGE);
				JPanel tmp_Screen = new MainMenu_Screen(parentFrame,data.get(user) );
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}else{
				JOptionPane.showMessageDialog(null, "incorrect password","Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}else{
			JOptionPane.showMessageDialog(null, "Username does not exist","Error", JOptionPane.ERROR_MESSAGE);
		}
			
		

	}
	

	/** 
	 * A function that loads from the .ser file so that the login can check user/password data. 
	 * 
	 * @param data A generic Hashtable that loads the .ser file data.
	 */
	private static Hashtable LoadTable(Hashtable data){
		try{
			FileInputStream fileIn = new FileInputStream("Savefiles/Saved_users_passwords.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			data = (Hashtable)in.readObject();
			in.close();
			fileIn.close();
	
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			//makefile();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return data;
	}

	/* 
	 * Login Checking function that tells the user if the Username and password combination was valid.
	 */
	private static void makefile(){
		try{
			File tmp = new File("Savefiles/Saved_users_passwords.ser");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}


