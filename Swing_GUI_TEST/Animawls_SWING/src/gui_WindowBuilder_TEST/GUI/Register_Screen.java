package gui_WindowBuilder_TEST.GUI;


import javax.swing.*;

import GameEngine.Player;
import GameEngine.User;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class Register_Screen extends JPanel {
	private JPasswordField passwordField_ONE;
	private JPasswordField passwordField_TWO;
	private JTextField userName_field;
	private JFrame parentFrame;
	private String newusername;
	private String newpassword1;
	private String newpassword2;
	private static Hashtable data;
	
	
	/**
	 * Create the panel.
	 */
	public Register_Screen(JFrame masterFrame) {
		//LoadTable
		
		LoadTable();
		setBackground(new Color(106, 90, 205));
		setForeground(new Color(0, 0, 0));
		setLayout(null);
		
		parentFrame = masterFrame;
		
		JLabel newUserTitle_label = new JLabel("NEW USER REGISTRATION");
		newUserTitle_label.setHorizontalAlignment(SwingConstants.CENTER);
		newUserTitle_label.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		newUserTitle_label.setBounds(68, 31, 313, 44);
		add(newUserTitle_label);
		
		passwordField_ONE = new JPasswordField();
		passwordField_ONE.setBounds(247, 147, 134, 28);
		add(passwordField_ONE);
		
		passwordField_TWO = new JPasswordField();
		passwordField_TWO.setBounds(247, 187, 134, 28);
		add(passwordField_TWO);
		
		userName_field = new JTextField();
		userName_field.setBounds(247, 106, 134, 28);
		add(userName_field);
		userName_field.setColumns(10);
		
		JLabel userName_label = new JLabel("USERNAME");
		userName_label.setBounds(91, 112, 104, 16);
		add(userName_label);
		
		JLabel password_labelONE = new JLabel("PASSWORD");
		password_labelONE.setBounds(91, 153, 104, 16);
		add(password_labelONE);
		
		JLabel password_labelTWO = new JLabel("RETYPE PASSWORD");
		password_labelTWO.setBounds(91, 193, 126, 16);
		add(password_labelTWO);


		
		
///////////// confirm button actions
		JButton confirmNewUser_button = new JButton("CONFIRM NEW USER");
		confirmNewUser_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newusername = new String(userName_field.getText());
				newpassword1 = new String(passwordField_ONE.getPassword());
				newpassword2 = new String(passwordField_TWO.getPassword());
				//empty strings check
				
				register(newusername, newpassword1, newpassword2);
				
				//call register method
				/*JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
				*/
			}
		});
		confirmNewUser_button.setBounds(47, 244, 157, 29);
		add(confirmNewUser_button);
		
		JButton backToLogin_button = new JButton("BACK TO LOGIN");
		backToLogin_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CANCELS LOGIN, GOES BACK TO MAIN MENU
				//parentFrame.removeAll();
				//parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		backToLogin_button.setBounds(251, 244, 150, 29);
		add(backToLogin_button);
	
		

	}
	public void register(String newusername, String newpassword1, String newpassword2)
	{
		//empty strings check
		if ( newusername.isEmpty() || newpassword1.isEmpty() || newpassword2.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "One or more boxes are empty","Error", JOptionPane.ERROR_MESSAGE);
		}	
		//passwords do not match
		if (!newpassword1.equals(newpassword2))
		{
			JOptionPane.showMessageDialog(null, "Passwords do not match","Error", JOptionPane.ERROR_MESSAGE);
		}
		// check for existing username and give message
		
		if (checkExisting(newusername)){
			JOptionPane.showMessageDialog(null, "User already exist","Error", JOptionPane.ERROR_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "Registration complete","Successfull", JOptionPane.INFORMATION_MESSAGE);
			SaveNewUser(newusername, newpassword1);
			JPanel tmp_Screen = new Login_Screen(parentFrame);
			parentFrame.setContentPane(tmp_Screen);
			parentFrame.setVisible(true);
			parentFrame.setResizable(false);

		}
			
	}
	
	//Saves new Users
	private void SaveNewUser(String newusername, String newpassword)
	{
	Hashtable<String,User> data = new Hashtable<String,User>();
	
	LoadTable(); // puts the existing users in the hashtable.
	User user = new User(newusername,newpassword);

	
	data.put(newusername, user);
	
	try{
	FileOutputStream fileOut = new FileOutputStream("Savefiles/Saved_users_passwords.ser");
	ObjectOutputStream out = new ObjectOutputStream(fileOut);
	out.writeObject(data);
	out.close();
	fileOut.close();
	}catch(FileNotFoundException e){
		e.printStackTrace();
	}
	catch(IOException e){
	e.printStackTrace();
	}
	}
	
	//Loads the .ser file into the hash table
	private static void LoadTable(){
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
			makefile();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private static void makefile(){
		try{
			File tmp = new File("Savefiles/Saved_users_passwords.ser");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//check for existing users
	private static boolean checkExisting(String newusername)
	{
		if ((data.containsKey(newusername)))
		{
			return true;
		}else
		{
			return false;
		}		
	}
}
