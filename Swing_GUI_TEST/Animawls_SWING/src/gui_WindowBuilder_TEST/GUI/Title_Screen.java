package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;

import java.awt.BorderLayout;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.util.Random;

public class Title_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame parentFrame;
	
	public Title_Screen(JFrame masterFrame) {
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				Random tmpTest = new Random();
				setBackground(new Color(tmpTest.nextInt(256),tmpTest.nextInt(256),tmpTest.nextInt(256)));
			}
		});
		//super();
		//this.addMouseListener(new MouseAdapter() {
			//@Override
			//public void mouseClicked(MouseEvent arg0) {
				//WHAT HAPPENS IF CLICKED, USE BUTTON FOR TIME BEING UP TO US
			//}
		//});
		parentFrame = masterFrame;
		
		setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		JLabel Title_Label = new JLabel("ANIMAWL BRAWL!!!");
		Title_Label.setFont(new Font("Lithos Pro", Font.PLAIN, 25));
		Title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Label.setBounds(73, 24, 303, 59);
		add(Title_Label);
		
		JLabel ClickAnywhere_Label = new JLabel("CLICK ANYWHERE TO CONTINUE");
		ClickAnywhere_Label.setHorizontalAlignment(SwingConstants.CENTER);
		ClickAnywhere_Label.setBounds(95, 252, 260, 16);
		add(ClickAnywhere_Label);
		
		JLabel PicturePlaceholder_Label = new JLabel("PICTURE PLACEHOLDER???");
		PicturePlaceholder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		PicturePlaceholder_Label.setBounds(81, 77, 288, 148);
		add(PicturePlaceholder_Label);
		
		JButton Placeholder_Button = new JButton("PLACEHOLDER");
		Placeholder_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//IN CASE MOUSE ACTION DOES NOT WORK, USE THIS BUTTON AS PLACEHOLDER FOR GOING BETWEEN STATES
				//parentFrame.setVisible(false);
				//parentFrame.removeAll();
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				tmp_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
				tmp_Screen.setLayout(new BorderLayout(0, 0));
				parentFrame.setContentPane(tmp_Screen);
				
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		Placeholder_Button.setBounds(0, 265, 117, 29);
		add(Placeholder_Button);

		//parentFrame.pack();
		parentFrame.setSize(450, 320);
		parentFrame.setLocationRelativeTo(null);
		parentFrame.setVisible(true);
	}

}
