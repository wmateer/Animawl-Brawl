package AnimawlBrawl.GUI;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.event.*;

import java.io.*;
import javax.imageio.ImageIO;

/**
 Main Class that produces a functional login screen
 */

public class AnimawlBrawlGUI {
		
	private JFrame mainFrame;
	private JLabel title;
	private JLabel loginText;
	private JLabel passwordText;
	private JTextField loginTextField;
	private JPasswordField passwordTextField; //needs to be password field
	private JPanel mainPanel;
	private HashMap <String,String> storedUserData;

	private JLabel loginReg;
	private JLabel regPassTextFirst;
	private JLabel regPassTextSecond;
	private JTextField regLogTextField;
	private JPasswordField regPassFirstTextField;
	private JPasswordField regPassSecondTextField;
	private JPanel regPanel;
	
	public AnimawlBrawlGUI() {
		initGUI();
	}

	private void initGUI() {
				
		//retrieve stored user data to storedUserData
		
		//storedUserData = new HashMap<String,String>();
		//storedUserData.put("will","cs");
		
		CheckSavedUserData();
		
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
		passwordTextField = new JPasswordField(20);
		
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
	
	private void CheckSavedUserData() {
		//checks the saved Serialzed obj file.
		try {
			FileInputStream fileStream = new FileInputStream("build/Saved_User_and_Passwords.ser");
			ObjectInputStream inputStream = new ObjectInputStream(fileStream);
			Object UserDefaults = inputStream.readObject();
			HashMap<String,String> TmpDefault = (HashMap<String,String>) UserDefaults;
			storedUserData.putAll(TmpDefault);
			inputStream.close();
		}
		catch (Exception ex) {
			DefaultUserViaSerializable();
			System.out.println("Saved_User_and_Passwords.ser does not exist.  This means there are no previous users registered.");
			
			/*try{
				FileOutputStream fileStream = new FileOutputStream("build/Saved_User_and_Passwords.ser");
				ObjectOutputStream outStream = new ObjectOutputStream(fileStream);
				HashMap<String,String> TmpMap = new HashMap<String,String>();
				TmpMap.put("will","cs");
				outStream.writeObject(TmpMap);
				outStream.close();
			}
			catch (Exception sex) {
				ex.printStackTrace();
			}*/
		}
	}
	
	private void DefaultUserViaSerializable() { 
		try{
			FileOutputStream fileStream = new FileOutputStream("build/Saved_User_and_Passwords.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileStream);
			storedUserData = new HashMap<String,String>();
			storedUserData.put("will","cs");
			
			outStream.writeObject(storedUserData);
			outStream.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	private void SaveNewUserViaSerializable() { 
		try{
			FileOutputStream fileStream = new FileOutputStream("build/Saved_User_and_Passwords.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileStream);
			outStream.writeObject(storedUserData);
			outStream.close();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	class loginListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
			//loginTextField.setText("BUTTON WORKS");
			String inputPassword = new String(passwordTextField.getPassword());
			
			String check = storedUserData.get(loginTextField.getText());
			if (check.equals(inputPassword)) {
				mainFrame.setVisible(false);
				//registerFrame.dispose();
				//DISPLAY SUCCESS PICTURE
				mainFrame.getContentPane().removeAll();
				try {
					File file = new File("src/AnimawlBrawl/GUI/success.jpg");
					BufferedImage image = ImageIO.read(file);
					JLabel label = new JLabel(new ImageIcon(image));
					mainFrame.getContentPane().add(label);
					mainFrame.pack();
					mainFrame.setLocation(200,200);
					mainFrame.setVisible(true);
				}
				catch (Exception ex) {
					System.out.println("Success.jpg does not exist.");
				}
			}
			else if (!(check.equals(null)) && !(check.equals(inputPassword))) {
				JOptionPane.showMessageDialog(null, "PASSWORD IS INCORRECT", "PASSWORD IS INCORRECT", JOptionPane.ERROR_MESSAGE);
			}
			else if (!storedUserData.containsKey(loginTextField.getText())) {
				JOptionPane.showMessageDialog(null, "USERNAME DOES NOT EXIST", "USERNAME DOES NOT EXIST", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	class registerListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
				//JFrame registerFrame = new JFrame();
				mainFrame.setVisible(false);
				mainFrame.getContentPane().removeAll();
				
				//registerFrame = new JFrame("Login Screen For Animawl Brawl");
				//registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
				loginReg = new JLabel("USER NAME",JLabel.CENTER);
				loginReg.setForeground(Color.black);
				loginReg.setBackground(Color.white);
				loginReg.setOpaque(true);
				loginReg.setFont(new Font("SansSerif", Font.BOLD, 20));
						
				regPassTextFirst = new JLabel("PASSWORD",JLabel.CENTER);
				regPassTextFirst.setForeground(Color.black);
				regPassTextFirst.setBackground(Color.white);
				regPassTextFirst.setOpaque(true);
				regPassTextFirst.setFont(new Font("SansSerif", Font.BOLD, 20));
				
				regPassTextSecond = new JLabel("RETYPE PASSWORD",JLabel.CENTER);
				regPassTextSecond.setForeground(Color.black);
				regPassTextSecond.setBackground(Color.white);
				regPassTextSecond.setOpaque(true);
				regPassTextSecond.setFont(new Font("SansSerif", Font.BOLD, 20));
						
				regLogTextField = new JTextField(20);
				regPassFirstTextField = new JPasswordField(20);
				regPassSecondTextField = new JPasswordField(20);
						
				JButton newUserButton = new JButton("REGISTER");
				newUserButton.addActionListener(new newUserListener());
						
				JButton backButton = new JButton("BACK");
				backButton.addActionListener(new backListener());
						
				regPanel = new JPanel(new GridLayout(0,2));
						
				regPanel.add(loginReg);
				regPanel.add(regLogTextField);
				regPanel.add(regPassTextFirst);
				regPanel.add(regPassFirstTextField);
				regPanel.add(regPassTextSecond);
				regPanel.add(regPassSecondTextField);
				regPanel.add(newUserButton);
				regPanel.add(backButton);
				regPanel.setPreferredSize(new Dimension(400,300));
						
				mainFrame.add(regPanel);
				mainFrame.pack();
				
				mainFrame.setVisible(true);
				//registerFrame.setVisible(true);
			}
		}
		
		class newUserListener implements ActionListener {
			public void actionPerformed(ActionEvent event){
			
				String regUserName = regLogTextField.getText();
				String regPasswordFirst = new String(regPassFirstTextField.getPassword());
				String regPasswordSecond = new String(regPassSecondTextField.getPassword());
				
				if (regPasswordFirst.equals(regPasswordSecond)) {
					//check if regUserName is in datafile
					
					
					String check = storedUserData.get(regUserName);
					if (check == null) {
						storedUserData.put(regUserName,regPasswordFirst);
						SaveNewUserViaSerializable();
						CheckSavedUserData();
						//registerFrame.setVisible(false);
						mainFrame.setVisible(false);
						//registerFrame.dispose();
						mainFrame.getContentPane().removeAll();
						initGUI();
						JOptionPane.showMessageDialog(null, "REGISTRATION SUCCESSFUL, PLEASE LOGIN", "REGISTRATION SUCCESSFUL, PLEASE LOGIN", JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						JOptionPane.showMessageDialog(null, "USERNAME ALREADY IN USE", "USERNAME ALREADY IN USE", JOptionPane.ERROR_MESSAGE);
					}

					//if it is then pop up box telling that username is already taken
					//if it is not already taken then pop up box telling that UserName registered successfully
					//--and return to main log in screen
				}
				else {
					JOptionPane.showMessageDialog(null, "PASSWORDS DO NOT MATCH", "PASSWORDS DO NOT MATCH", JOptionPane.ERROR_MESSAGE);
					//regPassFirstTextField = new JPasswordField(20);
					//regPassSecondTextField = new JPasswordField(20);
					//display pop in text box that shows different
				}

				
				//store userlist in an arraylist and use find on it
				//if ( checkDatabaseBoth(loginText.getText(),passwordText.getText()) ) {
				//	login as user; }
				//else {
				// login is incorrect;}
				//frame.setVisible(false);
				//frame.dispose();
				//>> load up main menu of animawl brawl <<
			}
		}
		
		class backListener implements ActionListener {
			public void actionPerformed(ActionEvent event){
				
				//registerFrame.setVisible(false);
				mainFrame.setVisible(false);
				mainFrame.getContentPane().removeAll();
				initGUI();
			}
		}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() ]{
            
			@Override
			public void run() {
                new AnimawlBrawlGUI();
            }
        });
    }
	
	
}









/*
class registerListener implements ActionListener {
	public void actionPerformed(ActionEvent event){
		
		final Runnable Linker = new Runnable() {
			public void run() {
				
			}
		};
		
		Thread LinkThread = new Thread() {
			public void run() {
				try {
					synchronized (this) {
						SwingUtilities.invokeAndWait(Linker);
						
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					JFrame registerFrame = new JFrame();
					
					registerFrame = new JFrame("Login Screen For Animawl Brawl");
					registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					loginReg = new JLabel("USER NAME",JLabel.CENTER);
					loginReg.setForeground(Color.black);
					loginReg.setBackground(Color.white);
					loginReg.setOpaque(true);
					loginReg.setFont(new Font("SansSerif", Font.BOLD, 20));
					
					regPassTextFirst = new JLabel("PASSWORD",JLabel.CENTER);
					regPassTextFirst.setForeground(Color.black);
					regPassTextFirst.setBackground(Color.white);
					regPassTextFirst.setOpaque(true);
					regPassTextFirst.setFont(new Font("SansSerif", Font.BOLD, 20));
					
					regPassTextSecond = new JLabel("RETYPE PASSWORD",JLabel.CENTER);
					regPassTextSecond.setForeground(Color.black);
					regPassTextSecond.setBackground(Color.white);
					regPassTextSecond.setOpaque(true);
					regPassTextSecond.setFont(new Font("SansSerif", Font.BOLD, 20));
					
					regLogTextField = new JTextField(20);
					regPassFirstTextField = new JPasswordField(20);
					regPassSecondTextField = new JPasswordField(20);
					
					JButton newUserButton = new JButton("REGISTER");
					newUserButton.addActionListener(new newUserListener());
					
					JButton backButton = new JButton("BACK");
					backButton.addActionListener(new backListener());
					
					regPanel = new JPanel(new GridLayout(0,2));
					
					regPanel.add(loginReg);
					regPanel.add(regLogTextField);
					regPanel.add(regPassTextFirst);
					regPanel.add(regPassFirstTextField);
					regPanel.add(regPassTextSecond);
					regPanel.add(regPassSecondTextField);
					regPanel.add(newUserButton);
					regPanel.add(backButton);
					regPanel.setPreferredSize(new Dimension(400,300));
					
					registerFrame.add(mainPanel);
					registerFrame.pack();
					
					mainFrame.setVisible(false);
					registerFrame.setVisible(true);
				}
			}
		};
		LinkThread.start();
		
	}*/
	
