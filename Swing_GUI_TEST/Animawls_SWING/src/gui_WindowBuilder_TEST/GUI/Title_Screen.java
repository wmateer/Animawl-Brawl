package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Title_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame parentFrame;
	
	public Title_Screen(JFrame masterFrame) {
		/*addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				Random tmpTest = new Random();
				setBackground(new Color(tmpTest.nextInt(256),tmpTest.nextInt(256),tmpTest.nextInt(256)));
			}
		});*/
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				tmp_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
				tmp_Screen.setLayout(new BorderLayout(0, 0));
				parentFrame.setContentPane(tmp_Screen);
				
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
				
			}
			
		});
		setBackground(Color.gray);
		//super();
		//this.addMouseListener(new MouseAdapter() {
			//@Override
			//public void mouseClicked(MouseEvent arg0) {
				//WHAT HAPPENS IF CLICKED, USE BUTTON FOR TIME BEING UP TO US
			//}
		//});
		parentFrame = masterFrame;
		
		//setBackground(new Color(0, 191, 255));
		setLayout(null);
		
		JLabel Title_Label = new JLabel("ANIMAWL BRAWL!!!");
		Title_Label.setFont(new Font("Lithos Pro", Font.PLAIN, 25));
		Title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Label.setBounds(298, 24, 303, 59);
		add(Title_Label);
		
		
		
		JLabel PicturePlaceholder_Label = new JLabel();
		PicturePlaceholder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		PicturePlaceholder_Label.setBounds(28, 76, 866, 447);
		BufferedImage Logo = null;
		try {
			Logo = ImageIO.read(new File("IMAGES/ABLogo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PicturePlaceholder_Label.setIcon(new ImageIcon(Logo));
		add(PicturePlaceholder_Label);
		
		JLabel lblClickAnywhereTo = new JLabel("Click anywhere to continue");
		lblClickAnywhereTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickAnywhereTo.setBounds(252, 547, 395, 23);
		add(lblClickAnywhereTo);
		/*
		JButton Placeholder_Button = new JButton("PLACEHOLDER");
		Placeholder_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//IN CASE MOUSE ACTION DOES NOT WORK, USE THIS BUTTON AS PLACEHOLDER FOR GOING BETWEEN STATES
				//parentFrame.setVisible(false);
				//parentFrame.removeAll();
				parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				tmp_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
				tmp_Screen.setLayout(new BorderLayout(0, 0));
				parentFrame.setContentPane(tmp_Screen);
				
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
			}
		});
		Placeholder_Button.setBounds(381, 533, 117, 29);
		add(Placeholder_Button);
		*/

		//parentFrame.pack();
		//parentFrame.setSize(450, 320);
		parentFrame.setLocationRelativeTo(null);
		parentFrame.setSize(900, 600);
		//parentFrame.setLocationRelativeTo(null);
		parentFrame.setVisible(true);
	}
}
