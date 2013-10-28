package gui_WindowBuilder_TEST.GUI;


import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Register_Screen extends JPanel {
	private JPasswordField passwordField_ONE;
	private JPasswordField passwordField_TWO;
	private JTextField userName_field;
	private JFrame parentFrame;
	
	/**
	 * Create the panel.
	 */
	public Register_Screen(JFrame masterFrame) {
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
		
		JButton confirmNewUser_button = new JButton("CONFIRM NEW USER");
		confirmNewUser_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CONFIRMS NEW USER CRENDTIALS, CHECK OLD GUI IMPLEMENT
				//NEEEEDDDD TOOOOO DOOOOO
				///
				//
				//parentFrame.removeAll();
				//parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
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

}
