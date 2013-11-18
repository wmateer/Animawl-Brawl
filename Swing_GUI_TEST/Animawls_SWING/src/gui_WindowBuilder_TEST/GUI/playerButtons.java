package gui_WindowBuilder_TEST.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GameEngine.Player;

public class playerButtons extends ButtonGroup {
	//main buttons
	public JRadioButton attackButton;
	public JRadioButton defendButton;
	public JRadioButton specialButton;
	public JRadioButton switchButton;
	
	//attack selections
	public ButtonGroup attackButtons;
	public JRadioButton attackZero;
	public JRadioButton attackOne;
	public JRadioButton attackTwo;
	
	//switch selections
	public ButtonGroup switchButtons;
	public JRadioButton animalZero;
	public JRadioButton animalOne;
	public JRadioButton animalTwo;
	
	//player who buttons belong to
	private Player myPlayer;
	
public playerButtons(Player myPlayer){
	this.myPlayer=myPlayer;
	//create buttons and groups & give them their names & listners
	attackButtons=new ButtonGroup();
	
	attackButton= new JRadioButton("Attack");
	attackButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			playerButtons.this.clearSelection();
			attackButtons.clearSelection();
			switchButtons.clearSelection();
			attackButton.setSelected(true);
			playerButtons.this.showSwitch(false);
			playerButtons.this.showAttack(true);
			
		}
	});
	
	attackZero= new JRadioButton(myPlayer.getActive().attacksAvail.get(0).getName());
	attackButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			attackButtons.clearSelection();
			attackZero.setSelected(true);
			
		}
	});
	
	attackOne= new JRadioButton(myPlayer.getActive().attacksAvail.get(1).getName());
	attackOne.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			attackButtons.clearSelection();
			attackOne.setSelected(true);
			
		}
	});
	
	attackTwo= new JRadioButton(myPlayer.getActive().attacksAvail.get(2).getName());
	attackTwo.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			attackButtons.clearSelection();
			attackTwo.setSelected(true);
			
		}
	});
	
	defendButton= new JRadioButton("Defend");
	defendButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			playerButtons.this.clearSelection();
			attackButtons.clearSelection();
			switchButtons.clearSelection();
			defendButton.setSelected(true);
			playerButtons.this.showSwitch(false);
			playerButtons.this.showAttack(false);
			
		}
	});
	specialButton= new JRadioButton("Special");
	specialButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			playerButtons.this.clearSelection();
			attackButtons.clearSelection();
			switchButtons.clearSelection();
			specialButton.setSelected(true);
			playerButtons.this.showSwitch(false);
			playerButtons.this.showAttack(false);
			
		}
	});
	switchButtons= new ButtonGroup();
	switchButton= new JRadioButton("Switch");
	switchButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			playerButtons.this.clearSelection();
			attackButtons.clearSelection();
			switchButtons.clearSelection();
			switchButton.setSelected(true);
			playerButtons.this.showSwitch(true);
			playerButtons.this.showAttack(false);
			
		}
	});
	animalZero= new JRadioButton(myPlayer.animalsCur.get(0).getName());
	animalZero.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			switchButtons.clearSelection();
			animalZero.setSelected(true);
			
		}
	});
	animalOne= new JRadioButton(myPlayer.animalsCur.get(1).getName());
	animalOne.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			switchButtons.clearSelection();
			animalOne.setSelected(true);
			
		}
	});
	animalTwo= new JRadioButton(myPlayer.animalsCur.get(2).getName());
	animalTwo.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			switchButtons.clearSelection();
			animalTwo.setSelected(true);
			
		}
	});
	//add them to their groups
	this.add(attackButton);
	this.add(defendButton);
	this.add(specialButton);
	this.add(switchButton);
	
	attackButtons.add(attackZero);
	attackButtons.add(attackOne);
	attackButtons.add(attackTwo);
	
	switchButtons.add(animalZero);
	switchButtons.add(animalOne);
	switchButtons.add(animalTwo);
	
	showButtons(true);
}
public void showAttack(boolean input){
	if(input==true){
		attackButtons.clearSelection();;
		attackZero.setVisible(true);
		attackOne.setVisible(true);
		attackTwo.setVisible(true);
		return;
	}
	if(input==false){
		attackButtons.clearSelection();
		attackZero.setVisible(false);
		attackOne.setVisible(false);
		attackTwo.setVisible(false);
		return;
	}
		
	}


public void showSwitch(boolean input){
	if(input==true){
		switchButtons.clearSelection();;
		animalZero.setVisible(true);
		animalOne.setVisible(true);
		animalTwo.setVisible(true);
		return;
	}
	if(input==false){
		switchButtons.clearSelection();
		animalZero.setVisible(false);
		animalOne.setVisible(false);
		animalTwo.setVisible(false);
		return;
	}
		
	}
public void showButtons(boolean input){
	if(input==true){
		this.clearSelection();
		attackButton.setVisible(true);
		defendButton.setVisible(true);
		specialButton.setVisible(true);
		switchButton.setVisible(true);
		showAttack(false);
		showSwitch(false);
		return;
	}
	if(input==false){
		this.clearSelection();
		attackButton.setVisible(false);
		defendButton.setVisible(false);
		specialButton.setVisible(false);
		switchButton.setVisible(false);
		showAttack(false);
		showSwitch(false);
		return;
	}
}
public boolean  moveSelected(){
	if(attackZero.isSelected()==true | attackOne.isSelected()==true | attackTwo.isSelected()==true | animalZero.isSelected()==true | animalOne.isSelected()==true | animalTwo.isSelected()==true |defendButton.isSelected()==true | specialButton.isSelected()==true){
	return true;
	}
	return false;
}

public void updateAttacks(){
	attackZero.setText(myPlayer.getActive().attacksAvail.get(0).getName());
	attackOne.setText(myPlayer.getActive().attacksAvail.get(1).getName());
	attackOne.setText(myPlayer.getActive().attacksAvail.get(1).getName());
	
	}

public void updateAnimals(){
	if(myPlayer.getActive()==myPlayer.animalsCur.get(0)){
		animalZero.setEnabled(false);
		animalOne.setEnabled(true);
		animalTwo.setEnabled(true);
	}
	if(myPlayer.getActive()==myPlayer.animalsCur.get(1)){
		animalZero.setEnabled(true);
		animalOne.setEnabled(false);
		animalTwo.setEnabled(true);
	}
	if(myPlayer.getActive()==myPlayer.animalsCur.get(2)){
		animalZero.setEnabled(true);
		animalOne.setEnabled(true);
		animalTwo.setEnabled(false);
	}
	if(myPlayer.animalsCur.get(0).getHpRem()<=0){
		animalZero.setEnabled(false);
	}
	if(myPlayer.animalsCur.get(1).getHpRem()<=0){
		animalOne.setEnabled(false);
	}
	if(myPlayer.animalsCur.get(2).getHpRem()<=0){
		animalTwo.setEnabled(false);
	}
	}
}



