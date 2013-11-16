


package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Animals.*;
import GameEngine.*;

import java.awt.Font;
import java.awt.Color;
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

		

	public Game_Screen(JFrame masterFrame, User user1) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		

		
//----------------------------------
		
		
		Bear Willis= new Bear("Willis");
		Bear Frank = new Bear("Frank");
		Bear Cindy = new Bear("Cindy");
		
		Bear Kyle = new Bear("Kyle");
		Bear Mindy= new Bear("Mindy");
		Bear Alex= new Bear("Alex");
		
		
		
		final Player pZero = new Player(user1.getName(),user1.chosenAnimals.get(0), user1.chosenAnimals.get(1), user1.chosenAnimals.get(2));
		active = pZero;
		final Player pOne = new Player("bob",Kyle, Mindy, Alex);
		inactive=pOne;
//---------------------------------------		
		
		
		//initialize constant screen objects

		JLabel Hp = new JLabel("HP ");
		Hp.setForeground(Color.RED);
		Hp.setBounds(232, 324, 28, 16);
		add(Hp);
		
		JLabel Ap = new JLabel("AP");
		Ap.setForeground(Color.blue);
		Ap.setBounds(238, 356, 22, 16);
		add(Ap);
		
		JLabel Hpr = new JLabel("HP");
		Hpr.setForeground(Color.RED);
		Hpr.setBounds(635, 331, 22, 16);
		add(Hpr);
		
		JLabel Apr = new JLabel("AP");
		Apr.setForeground(Color.blue);
		Apr.setBounds(635, 356, 22, 16);
		add(Apr);
		
		
		
		JLabel pic = new JLabel(pZero.getActive().getName());
		try {
			BufferedImage AnimalPicture1 = ImageIO.read(new File(user1.chosenAnimals.get(0).imgPath));
			pic.setIcon(new ImageIcon(AnimalPicture1));
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}
		pic.setBounds(208, 126, 132, 126);
		add(pic);
		
		
		JLabel picr = new JLabel("Picture Here");
		try {
			BufferedImage AnimalPicture2 = ImageIO.read(new File(pOne.getActive().imgPath));
			picr.setIcon(new ImageIcon(AnimalPicture2));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		picr.setBounds(555, 126, 132, 126);
		add(picr);
		
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

			masterFrame.setSize(900, 600);
			masterFrame.setLocationRelativeTo(null);
			
			
			
			
/// USER 0````````````````````````
		
		usernameZero = new JLabel(pZero.getName());
		usernameZero.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		usernameZero.setBounds(83, 55, 213, 44);
		add(usernameZero);
		//ANIMAL 0 --------------------------------------------
		
			animalNameZero = new JLabel(pZero.getActive().getName());
			animalNameZero.setBounds(198, 98, 80, 16);
			add(animalNameZero);
		//HP 0 ------------------------------------------------------------
			
	
			pZero.getActive().getHpBar().setForeground(Color.red);
			pZero.getActive().getHpBar().setStringPainted(true);
			pZero.getActive().getHpBar().setBackground(Color.white);
			pZero.getActive().getHpBar().setBounds(262, 324, 120, 20);
			add(pZero.getActive().getHpBar());
		//AP 0 ------------------------------------------------------------	
		/*
			//UIManager.put("ProgressBar.selectionForeground", Color.blue);
		    apBar = new JProgressBar(0,(int)pZero.getActive().getApTot());
			apBar.setValue((int)pZero.getActive().getApRem());
			apBar.setForeground(Color.blue);
			apBar.setStringPainted(true);
			apBar.setBackground(Color.white);
			apBar.setBounds(262, 352, 120, 20);
			add(apBar);
		*/	
			
		//BUTTONS 0!!------------------------------------------------------		
			
			//add pZero's buttons to GUI screen
			pZero.UI.placePzero();
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
		
			
		
		
//USER 1----------------------------------------------		
		
		userNameOne = new JLabel(pOne.getName());
		userNameOne.setBounds(669, 64, 139, 35);
		add(userNameOne);		
		//ANIMAL 1--------------------------------------------	
		
			animalNameOne = new JLabel(pOne.getActive().getName());
			animalNameOne.setBounds(577, 98, 80, 16);
			add(animalNameOne);
			
		//HP 1 ------------------------------------------------------------	
			//UIManager.put("ProgressBar.selectionBackground", Color.red);
				
			pOne.getActive().getHpBar().setForeground(Color.red);
			pOne.getActive().getHpBar().setStringPainted(true);
			pOne.getActive().getHpBar().setBackground(Color.white);
			pOne.getActive().getHpBar().setBounds(515, 345, 120, 20);
			add(pOne.getActive().getHpBar());

		//AP 1 ------------------------------------------------------------				
				//UIManager.put("ProgressBar.selectionBackground", Color.blue);
		/*		apBarr = new JProgressBar(0,(int)pOne.getActive().getApTot());
				apBarr.setValue((int)pOne.getActive().getApRem());
				apBarr.setForeground(Color.blue);
				apBarr.setStringPainted(true);
				apBarr.setBackground(Color.white);
				apBarr.setBounds(515, 352, 120, 20);
				add(apBarr);
				*/
	    //  Right Side buttons		
		
			pOne.UI.placePone();
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
		
	
		inactive.hideUI();
		active.UI.showButtons(true);
		prompt=new JLabel("Begin!");
		prompt.setBounds(375, 100, 200, 20);
		add(prompt);
	
	}
//------------------------------------------------------------------ 
	//Start Implimentation






	//will fill for other buttons

public void endTurn(){
if(whoseTurn==1){
		round++;
		whoseTurn=0;
}
	
else if(whoseTurn==0){
	whoseTurn++;
}
active.hideUI();
tmp=active;
active=inactive;
inactive=tmp;
active.UI.showButtons(true);

}

public void performSelected(){
	
	
	
	
		return;
	}



public class confirmListner implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	//TODO need to check if active animal is dead and if so present only switch animals buttons
			if(active.UI.moveSelected()==false){
				System.out.println("Please Select a Valid Move");
			}
			if(active.UI.attackZero.isSelected()==true){
				int dmg=0;
				dmg= active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive());
				active.getActive().addExpErnd(dmg);
				text="Your attack did "+dmg;
				prompt.setText(text);
				
			}
			else if(active.UI.attackOne.isSelected()==true){
				int dmg=0;
				dmg= active.getActive().attacksAvail.get(1).useAttack(active.getActive(), inactive.getActive());
				active.getActive().addExpErnd(dmg);
				text="Your attack did "+dmg;
				prompt.setText(text);
			}
			
			else if(active.UI.attackTwo.isSelected()==true){
				int dmg=0;
				dmg= active.getActive().attacksAvail.get(2).useAttack(active.getActive(), inactive.getActive());
				active.getActive().addExpErnd(dmg);
				text="Your attack did "+dmg;
				prompt.setText(text);
			}
			else if(active.UI.animalZero.isSelected()==true){
				active.setActive(active.animalsCur.get(0));
				updateScreen();
			}


			
		endTurn();
		//checks for inactive player loss after active attacks. have not yet tested but should work fine
		if (inactive.checkLoss()==0){
			String temp =active.getName() + "Wins!";
			prompt.setText(temp);
		}
		
		

	
	}
	}



public void updateScreen() {
//TODO update bars, animal names, attack buttons, disable current animal in switch button group	
}


}

		
		
		
