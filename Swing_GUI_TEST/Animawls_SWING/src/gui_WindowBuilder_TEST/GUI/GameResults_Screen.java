package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class GameResults_Screen extends JPanel{

	private JFrame parentFrame;
	private JTextField txtTitle;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	
	public GameResults_Screen(JFrame masterFrame) {
		parentFrame = masterFrame;
		setBackground(Color.gray);
		setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setText("TITLE");
		txtTitle.setBounds(376, 98, 134, 28);
		add(txtTitle);
		txtTitle.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(240, 218, 134, 28);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 279, 134, 28);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(240, 344, 134, 28);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(60, 218, 134, 28);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(60, 279, 134, 28);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(60, 344, 134, 28);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(60, 403, 134, 28);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(240, 403, 134, 28);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(376, 528, 134, 28);
		add(textField_8);
		textField_8.setColumns(10);
		parentFrame.setLocationRelativeTo(null);
		parentFrame.setSize(900, 600);
		parentFrame.setVisible(true);
	}
}
