package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;

import GameEngine.Player;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class animalDead extends JDialog {
	private JDialog window;
	private JButton animalZero;
	private JButton animalOne;
	private JButton animalTwo;
	private JLabel prompt;
	private Player myPlayer;
public animalDead(Player input) {
	myPlayer=input;
	window=this;
	myPlayer.setEnabled(false);
	myPlayer.getOpp().setEnabled(false);
	this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	
		this.setBounds(HEIGHT, WIDTH, 400, 300);
		this.setLayout(new BorderLayout(0, 0));
		this.setResizable(false);
		if(myPlayer.animalsCur.get(0).getHpRem()>0){
			animalZero=new JButton(myPlayer.animalsCur.get(0).getName());
			animalZero.addActionListener(new zeroListner());
			animalZero.setVisible(true);
			animalZero.setBounds(100,100,100,100);
			this.add(animalZero);
		}
		if(myPlayer.animalsCur.get(1).getHpRem()>0){
			animalOne=new JButton(myPlayer.animalsCur.get(1).getName());
			animalOne.addActionListener(new oneListner());
			animalOne.setVisible(true);
			animalOne.setBounds(200,100,100,100);
			this.add(animalOne);
		}
		if(myPlayer.animalsCur.get(2).getHpRem()>0){
			animalTwo=new JButton(myPlayer.animalsCur.get(2).getName());
			animalTwo.addActionListener(new twoListner());
			animalTwo.setVisible(true);
			animalTwo.setBounds(300,100,100,100);
			this.add(animalTwo);
		}
		
		prompt = new JLabel();
		prompt.setText("Your Animal Is Dead \n Please Choose a New Animal To Send Into Battle");
		prompt.setBounds(10, 10, 390, 0);
		this.add(prompt);
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
