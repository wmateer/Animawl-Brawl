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
	JButton animalZero;
	JButton animalOne;
	JButton animalTwo;
public animalDead(Player myPlayer) {
		this.setAlwaysOnTop(true);
		this.setBounds(HEIGHT, WIDTH, 400, 300);
		this.setResizable(false);
		if(myPlayer.animalsCur.get(0).getHpRem()>0){
			animalZero=new JButton(myPlayer.animalsCur.get(0).getName());
			animalZero.setVisible(true);
		}
		if(myPlayer.animalsCur.get(1).getHpRem()>0){
			animalOne=new JButton(myPlayer.animalsCur.get(1).getName());
			animalOne.setVisible(true);

		}
		if(myPlayer.animalsCur.get(2).getHpRem()>0){
			animalTwo=new JButton(myPlayer.animalsCur.get(1).getName());
			animalTwo.setVisible(true);
		}
		
		JTextPane prompt = new JTextPane();
		prompt.setText("Your Animal Is Dead \n Please Choose a New Animal To Send Into Battle");
		this.add(prompt, BorderLayout.CENTER);
		
	
	}


}
