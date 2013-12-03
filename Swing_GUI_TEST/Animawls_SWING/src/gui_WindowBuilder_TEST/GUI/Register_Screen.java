package gui_WindowBuilder_TEST.GUI;


import javax.swing.*;

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
	private MusicFrame parentFrame;
	private String newusername;
	private String newpassword1;
	private String newpassword2;
	
	
	/** 
	 * The constructor, which takes in the passed MusicFrame to load the panel data. 
	 * 
	 * @param masterFrame The passed MusicFrame that is used to initialize the panel.
	 */
	public Register_Screen(MusicFrame masterFrame) {
	
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


		
		
//confirm button actions ----------------------
		JButton confirmNewUser_button = new JButton("CONFIRM NEW USER");
		confirmNewUser_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newusername = new String(userName_field.getText());
				newpassword1 = new String(passwordField_ONE.getPassword());
				newpassword2 = new String(passwordField_TWO.getPassword());
				//LoadTable
				Hashtable<String, User> data = new Hashtable<String,User>();
				data = LoadTable(data);
				register(newusername, newpassword1, newpassword2, data);
				
			}
		});
		confirmNewUser_button.setBounds(47, 244, 157, 29);
		add(confirmNewUser_button);
		
// BacktoLogin button -------------------		
		JButton backToLogin_button = new JButton("BACK TO LOGIN");
		backToLogin_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//CANCELS LOGIN, GOES BACK TO MAIN MENU
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		backToLogin_button.setBounds(251, 244, 150, 29);
		add(backToLogin_button);
	
		

	}

	/** 
	 * The registration function which takes in the entered user data and checks whether they are useable.
	 * Will let the user know if the requested username/password combination already exists. 
	 * 
	 * @param newusername The username requested by the current user.  Must be unique in the .ser file.
	 * @param newpassword1 The password requested by the user, must match the second password.
	 * @param newpassword2 The password requested by the user, must match the first password.
	 * @param data The hashtable that was created to store the saved data from the .ser file.
	 */
	public void register(String newusername, String newpassword1, String newpassword2, Hashtable<String, User> data)
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
		
		if (checkExisting(newusername, data)){
			JOptionPane.showMessageDialog(null, "User already exist","Error", JOptionPane.ERROR_MESSAGE);
		}else{
		
			JOptionPane.showMessageDialog(null, "Registration complete","Successfull", JOptionPane.INFORMATION_MESSAGE);
			SaveNewUser(newusername, newpassword1, data);
			JPanel tmp_Screen = new Login_Screen(parentFrame);
			parentFrame.setContentPane(tmp_Screen);
			parentFrame.setVisible(true);
			parentFrame.setResizable(false);

		}
			
	}
	
//Saves new Users ---------------------//PRIVATE METHOD//
	private void SaveNewUser(String newusername, String newpassword, Hashtable<String, User> data)
	{
	
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
	
// Loads the .ser file into the hash table//PRIVATE METHOD
	private static Hashtable<String, User> LoadTable(Hashtable<String, User> data){
		
		try{
			FileInputStream fileIn = new FileInputStream("Savefiles/Saved_users_passwords.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			data = (Hashtable<String, User>)in.readObject();
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
		return data;
		
	}
	
//Function to make the .ser file.  //PRIVATE METHOD
	private static void makefile(){
		try{
			FileOutputStream fileOut = new FileOutputStream("Savefiles/Saved_users_passwords.ser");
			fileOut.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//check for existing users //PRIVATE
	private static boolean checkExisting(String newusername, Hashtable<String, User> data)
	{	
		if ((data.containsKey(newusername))){
			return true;
		}else{
			return false;
		}	
	}
}
