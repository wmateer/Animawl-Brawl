package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;

import Animals.Animal;
import GameEngine.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class animalName extends JDialog {
	private JDialog window;
	private JLabel animalPic;
	private JTextField animalName;
	
	
	public animalName(final Animal animal) {
		window = this;
		
		getContentPane().setBackground(Color.BLUE);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		this.setBounds(300, 200, 400, 300);
		getContentPane().setLayout(null);
		this.setAlwaysOnTop(true);
		
		JLabel prompt = new JLabel("Please Name Your Animal");
		prompt.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		prompt.setForeground(Color.WHITE);
		prompt.setHorizontalAlignment(SwingConstants.CENTER);
		prompt.setBounds(71, 53, 258, 36);
		getContentPane().add(prompt);
	
// implementation of setting the name
		animalName = new JTextField();
		animalName.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String name = new String(animalName.getText());
				if (name.isEmpty()){
					JOptionPane.showMessageDialog(null, "Please input a name","Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if (!name.isEmpty()){

					animal.setName(name);
					window.dispose();
				}
			}
			
		});
		animalName.setHorizontalAlignment(SwingConstants.CENTER);
		animalName.setText("");
		animalName.setBounds(133, 244, 134, 28);
		getContentPane().add(animalName);
		animalName.setColumns(10);
		
		animalPic = new JLabel();
		try {
			 BufferedImage animalPicture = ImageIO.read(new File(animal.imgPath));
			animalPic.setIcon(new ImageIcon(animalPicture));
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}
		animalPic.setBounds(124, 87, 152, 145);
		getContentPane().add(animalPic);
		this.setResizable(false);

	}
}
