


package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Animals.*;
import GameEngine.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Game_Screen extends JPanel {
	//game info
	private Player pZero;
	private Player pOne;
	private Player active;
	private Player inactive;
	private Player tmp;
	private int round=0;
	private int  play=1;
	private int whoseTurn=0;
	public String newprompt;
	
	
	private JLabel prompt;
	private String text;
	
	

	//TODO incorperate as variables in player class
	private JLabel usernameZero;
	private JLabel animalNameZero;
	private JLabel animalZeroGraphic;
	private JProgressBar apBar;
	private JLabel userNameOne;
	private JLabel animalNameOne;
	private JLabel animalZeroOne;
	private JProgressBar apBarr;

	private BufferedImage backgroundPict;

	public Game_Screen(JFrame masterFrame, User user1, String chosenBattleground) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		//SET BACKGROUND
		try {                
			backgroundPict = ImageIO.read(new File(chosenBattleground));
		} 
		catch (Exception ex) {
		       ex.printStackTrace();
		}

		masterFrame.setSize(900, 600);
		masterFrame.setLocationRelativeTo(null);
		masterFrame.setResizable(false);

		
//----------------------------------
	//intilize player objects	
		
		Bear Willis= new Bear("Willis");
		Bear Frank = new Bear("Frank");
		Bear Cindy = new Bear("Cindy");
		
		Bear Kyle = new Bear("Kyle");
		Bear Mindy= new Bear("Mindy");
		Bear Alex= new Bear("Alex");
		
		
		
		final Player pZero = new Player(user1.getName(),user1.getAnimalAtIndex(0), user1.getAnimalAtIndex(1), user1.getAnimalAtIndex(2));
		active = pZero;
		final Player pOne = new Player("bob",Kyle, Mindy, Alex);
		inactive=pOne;
//---------------------------------------		
	//test pop of for dead animal	
		//animalDead pickAnimal= new animalDead(inactive);
		//pickAnimal.setVisible(true);
		
		//initialize constant screen objects

		JLabel Hp = new JLabel("HP ");
		Hp.setForeground(Color.RED);
		Hp.setBounds(244, 324, 28, 16);
		add(Hp);
		
		JLabel Ap = new JLabel("AP");
		Ap.setForeground(Color.blue);
		Ap.setBounds(244, 356, 22, 16);
		add(Ap);
		
		JLabel Hpr = new JLabel("HP");
		Hpr.setForeground(Color.RED);
		Hpr.setBounds(650, 324, 22, 16);
		add(Hpr);
		
		JLabel Apr = new JLabel("AP");
		Apr.setForeground(Color.blue);
		Apr.setBounds(650, 356, 22, 16);
		add(Apr);
		
		JLabel playAnimawl_title = new JLabel("BATTLE");
		playAnimawl_title.setHorizontalAlignment(SwingConstants.CENTER);
		playAnimawl_title.setFont(new Font("Zapf Dingbats", Font.PLAIN, 23));
		playAnimawl_title.setBounds(351, 25, 197, 33);
		add(playAnimawl_title);
		
		JToggleButton toggleButton = new JToggleButton("Music");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toggleButton.setSelected(true);
		toggleButton.setForeground(Color.BLACK);
		toggleButton.setBackground(Color.YELLOW);
		toggleButton.setBounds(797, 36, 72, 16);
		add(toggleButton);
		
	//Confirm Button-------------------------------------		
			JButton confirm = new JButton("Confirm");
			confirm.addActionListener(new confirmListner());
			confirm.setBounds(391, 428, 117, 29);
			add(confirm);
		
		prompt=new JLabel("Begin!");
		prompt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		prompt.setForeground(Color.ORANGE);
		prompt.setHorizontalAlignment( SwingConstants.CENTER ); 
		prompt.setBounds(340, 100, 220, 40);
		add(prompt);
		
		
	

			

			
		//Player Zero UI------------------------------------------------------		
	
			//add pZero's buttons to GUI screen
			pZero.placePzero();
			add(pZero.UI.attackButton);
			add(pZero.UI.specialButton);
			add(pZero.UI.defendButton);
			add(pZero.UI.switchButton);
			add(pZero.UI.attackZero);
			add(pZero.UI.attackOne);
			add(pZero.UI.attackTwo);
			add(pZero.UI.animalZero);
			add(pZero.UI.animalOne);
			add(pZero.UI.animalTwo);
			add(pZero.currentAnimalPic);
			add(pZero.getHpBar());
			add(pZero.getApBar());
			add(pZero.userName);
			add(pZero.animalName);
		
		
		//Player One UI----------------------------------------------		
			pOne.placePone();
			add(pOne.UI.attackButton);
			add(pOne.UI.specialButton);
			add(pOne.UI.defendButton);
			add(pOne.UI.switchButton);
			add(pOne.UI.attackZero);
			add(pOne.UI.attackOne);
			add(pOne.UI.attackTwo);
			add(pOne.UI.animalZero);
			add(pOne.UI.animalOne);
			add(pOne.UI.animalTwo);
			add(pOne.currentAnimalPic);
			add(pOne.getHpBar());
			add(pOne.getApBar());
			add(pOne.userName);
			add(pOne.animalName);
		
	
		inactive.hideUI();
		active.showUI();

	
	}
//------------------------------------------------------------------ 
	//Start Implimentation




public void endTurn(){
if(whoseTurn==1){
		round++;
		whoseTurn=0;
}
	
else if(whoseTurn==0){
	whoseTurn++;
}
if(inactive.checkLoss()==0){
	inactive.hideUI();
	active.hideUI();
	prompt.setText(active.getName()+" Wins!");
	return;
}
if(inactive.getActive().getHpRem()<=0){
promptSwitch();
}
active.hideUI();
tmp=active;
active=inactive;
inactive=tmp;
active.showUI();

}

public void performSelected(){
	
	
	
	
		return;
	}



public class confirmListner implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	//TODO need to check if active animal is dead and if so present only switch animals buttons
			if(active.UI.moveSelected()==false){
				System.out.println("Please Select a Valid Move");
			}
			if((active.UI.attackZero.isSelected()==true) |(active.UI.attackOne.isSelected()==true) | (active.UI.attackOne.isSelected()==true)){
				int dmg=0;

				if(active.UI.attackZero.isSelected()==true){
				dmg= active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive());
				
				
				}
				else if(active.UI.attackOne.isSelected()==true){
					dmg= active.getActive().attacksAvail.get(1).useAttack(active.getActive(), inactive.getActive());
					
				}	
			
				else if(active.UI.attackTwo.isSelected()==true){
					dmg= active.getActive().attacksAvail.get(2).useAttack(active.getActive(), inactive.getActive());
			
				}
			active.getActive().addExpErnd(dmg);
			inactive.hpBar.setValue((int)inactive.getActive().getHpRem());
			text="Your attack did "+dmg;
			prompt.setText(text);
			
			if (inactive.checkLoss()==0){
				String temp =active.getName() + "Wins!";
				prompt.setText(temp);
			}
			}
		else{
			 if(active.UI.animalZero.isSelected()==true){
				active.switchAnimalGui(0);
			}
			else if(active.UI.animalOne.isSelected()==true){
				active.switchAnimalGui(1);
			}
			else if(active.UI.animalTwo.isSelected()==true){
				active.switchAnimalGui(2);
			}
		}
			if(active.UI.specialButton.isSelected()==true){
				//using as tmp button to allow active player automatic win
				inactive.animalsCur.get(0).subHpRem((int)inactive.animalsCur.get(0).getHpRem());
				inactive.animalsCur.get(1).subHpRem((int)inactive.animalsCur.get(1).getHpRem());
				inactive.animalsCur.get(2).subHpRem((int)inactive.animalsCur.get(2).getHpRem());

			}
		
		endTurn();
		//checks for inactive player loss after active attacks. have not yet tested but should work fine
		
		
		

	
	}
	}

	public void promptSwitch(){
		animalDead pickAnimal= new animalDead(inactive);
		pickAnimal.setVisible(true);
	}
	
	public void updateScreen() {
	//TODO 
	}

	//to make background image//can use for animations later...
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundPict, 0, 0, null);            
	}

}

		
		
		
