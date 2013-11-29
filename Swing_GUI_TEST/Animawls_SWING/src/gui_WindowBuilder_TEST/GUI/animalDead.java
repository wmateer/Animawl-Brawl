package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import GameEngine.Player;




//import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class animalDead extends JDialog {
	private JDialog window;
	private JButton animalZero;
	private JButton animalOne;
	private JButton animalTwo;
	private JLabel prompt1;
	private JLabel prompt2;
	private Player myPlayer;
	private BufferedImage backgroundPict;
	public  JLabel AnimalPic0;
	public  JLabel AnimalPic1;
	public  JLabel AnimalPic2;

public animalDead(Player input) {

	myPlayer=input;
	window=this;
	myPlayer.setEnabled(false);
	myPlayer.getOpp().setEnabled(false);
	this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	
		this.setBounds(300, 200, 640, 480);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		
		prompt1 = new JLabel("Your Animal Is Dead");
		prompt1.setForeground(Color.WHITE);
		prompt1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		prompt1.setHorizontalAlignment(SwingConstants.CENTER);
		prompt1.setBounds(221, 55, 197, 36);
		getContentPane().add(prompt1);
		
		prompt2 = new JLabel("Please Choose a New Animal To Send Into Battle");
		prompt2.setForeground(Color.WHITE);
		prompt2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		prompt2.setHorizontalAlignment(SwingConstants.CENTER);
		prompt2.setBounds(97, 83, 445, 45);
		getContentPane().add(prompt2);
		
		if(myPlayer.animalsCur.get(0).getHpRem()>0){
			animalZero=new JButton(myPlayer.animalsCur.get(0).getName());
			animalZero.addActionListener(new zeroListner());
			animalZero.setVisible(true);
			animalZero.setBounds(100,400,100,30);
			getContentPane().add(animalZero);
			
			AnimalPic0 = new JLabel();
			try {
				 BufferedImage animalPicture = ImageIO.read(new File(myPlayer.animalsCur.get(0).imgPath));
				AnimalPic0.setIcon(new ImageIcon(animalPicture));
			} catch (IOException e1) {
				 //TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AnimalPic0.setBounds(80,250, 132, 126);
			getContentPane().add(AnimalPic0);
		}
		
		if(myPlayer.animalsCur.get(1).getHpRem()>0){
			animalOne=new JButton(myPlayer.animalsCur.get(1).getName());
			animalOne.addActionListener(new oneListner());
			animalOne.setVisible(true);
			animalOne.setBounds(270,400,100,30);
			getContentPane().add(animalOne);
			
			AnimalPic1 = new JLabel();
			try {
				 BufferedImage animalPicture = ImageIO.read(new File(myPlayer.animalsCur.get(1).imgPath));
				AnimalPic1.setIcon(new ImageIcon(animalPicture));
			} catch (IOException e1) {
				 //TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AnimalPic1.setBounds(250,250, 132, 126);
			getContentPane().add(AnimalPic1);
		}
		if(myPlayer.animalsCur.get(2).getHpRem()>0){
			animalTwo=new JButton(myPlayer.animalsCur.get(2).getName());
			animalTwo.addActionListener(new twoListner());
			animalTwo.setVisible(true);
			animalTwo.setBounds(450,400,100,30);
			getContentPane().add(animalTwo);
			
			AnimalPic2 = new JLabel();
			try {
				 BufferedImage animalPicture = ImageIO.read(new File(myPlayer.animalsCur.get(2).imgPath));
				AnimalPic2.setIcon(new ImageIcon(animalPicture));
			} catch (IOException e1) {
				 //TODO Auto-generated catch block
				e1.printStackTrace();
			}
			AnimalPic2.setBounds(430,250, 132, 126);
			getContentPane().add(AnimalPic2);
		}
	
	}

public class zeroListner implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	myPlayer.switchAnimalGui(0);
	myPlayer.setEnabled(true);
	myPlayer.getOpp().setEnabled(true);
	window.dispose();
	}
	}

public class oneListner implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	myPlayer.switchAnimalGui(1);
	myPlayer.setEnabled(true);
	myPlayer.getOpp().setEnabled(true);
	window.dispose();
	}
	}

public class twoListner implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	myPlayer.switchAnimalGui(2);
	myPlayer.setEnabled(true);
	myPlayer.getOpp().setEnabled(true);
	window.dispose();
	}
	}

}
