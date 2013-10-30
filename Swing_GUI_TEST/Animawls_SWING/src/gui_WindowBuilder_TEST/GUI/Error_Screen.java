package gui_WindowBuilder_TEST.GUI;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Error_Screen extends JPanel {
	private JFrame parentFrame;

	/**
	 * Create the panel.
	 * @param name 
	 */
	public Error_Screen(JFrame masterFrame) {
		parentFrame = masterFrame;
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblLoginpasswordIncorrect = new JLabel("                        Login/Password Incorrect");
		add(lblLoginpasswordIncorrect, BorderLayout.NORTH);
		
		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		add(btnGoBack, BorderLayout.CENTER);

	}

}
