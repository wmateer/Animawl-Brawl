


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
	
	
	
	private JLabel prompt;
	
	
	//left player info
		//left player gui info
	private JLabel usernameZero;
	private JLabel animalNameZero;
	private JLabel animalZeroGraphic;
	private JRadioButton attack;
	private JRadioButton attack0;
	private JRadioButton attack1;
	private JRadioButton attack2;
	private	JRadioButton attack3;
	private JRadioButton special;
	private JRadioButton defend;
	private JRadioButton switchAnimal;
	private JProgressBar hpBar;
	private JProgressBar apBar;
	
	//left player info
			//left player gui info
		private JLabel userNameOne;
		private JLabel animalNameOne;
		private JLabel animalZeroOne;
		private JRadioButton attackr;
		private JRadioButton attack0r;
		private JRadioButton attack1r;
		private JRadioButton attack2r;
		private	JRadioButton attack3r;
		private JRadioButton specialr;
		private JRadioButton defendr;
		private JRadioButton switchAnimalr;
		private JProgressBar hpBarr;
		private JProgressBar apBarr;

	public Game_Screen(JFrame masterFrame) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
//prompt header
		JLabel prompt = new JLabel();
		prompt.setBounds(290, 94, 288, 30);
		
//----------------------------------
		
		
		Bear Willis= new Bear("Willis");
		Bear Frank = new Bear("Frank");
		Bear Cindy = new Bear("Cindy");
		
		Bird Kyle = new Bird("Kyle");
		Bird Mindy= new Bird("Mindy");
		Bird Alex= new Bird("Alex");
		
		
		
		final Player pZero = new Player("bill",Willis, Frank, Cindy);
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
		
		
		
		JLabel pic = new JLabel("Picture Here");
		try {
			BufferedImage AnimalPicture1 = ImageIO.read(new File(pZero.getActive().imgPath));
			pic.setIcon(new ImageIcon(AnimalPicture1));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
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
		usernameZero.setBounds(130, 70, 80, 16);
		add(usernameZero);
		//ANIMAL 0 --------------------------------------------
		
			animalNameZero = new JLabel(pZero.getActive().getName());
			animalNameZero.setBounds(198, 98, 80, 16);
			add(animalNameZero);
		//HP 0 ------------------------------------------------------------
			
			hpBar = new JProgressBar(0,(int)pZero.getActive().getHpTot());
			hpBar.setForeground(Color.red);
			hpBar.setStringPainted(true);
			hpBar.setBackground(Color.white);
			hpBar.setValue((int)pZero.getActive().getHpRem());
			hpBar.setBounds(262, 324, 120, 20);
			add(hpBar);		

		//AP 0 ------------------------------------------------------------	
		
			//UIManager.put("ProgressBar.selectionForeground", Color.blue);
		    apBar = new JProgressBar(0,(int)pZero.getActive().getApTot());
			apBar.setValue((int)pZero.getActive().getApRem());
			apBar.setForeground(Color.blue);
			apBar.setStringPainted(true);
			apBar.setBackground(Color.white);
			apBar.setBounds(262, 352, 120, 20);
			add(apBar);
		//BUTTONS 0!!------------------------------------------------------		
			
			
			
		    attack0 = new JRadioButton(pZero.getActive().attacksAvail.get(0).getName());
			attack0.setBounds(84, 324, 141, 23);
			
			add(attack0);
			attack0.setVisible(false);

			
			attack1 = new JRadioButton("Attack2");
			attack1.setBounds(83, 359, 141, 23);

			add(attack1);
			attack1.setVisible(false);
			
			
			attack2 = new JRadioButton("Attack3");
			attack2.setBounds(84, 394, 141, 23);

			add(attack2);
			attack2.setVisible(false);
			
			special = new JRadioButton("Special");
			special.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					attack2.setVisible(false);
					attack1.setVisible(false);
					attack0.setVisible(false);	
				}
			});
			special.setBounds(42, 429, 141, 23);
			add(special);
			// ------------------------------------------------------------		
			defend = new JRadioButton("Defend");
			defend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					attack2.setVisible(false);
					attack1.setVisible(false);
					attack0.setVisible(false);	
				}
			});
			defend.setBounds(42, 479, 141, 23);
			add(defend);
			
			switchAnimal = new JRadioButton("Switch Animal");
			switchAnimal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					attack2.setVisible(false);
					attack1.setVisible(false);
					attack0.setVisible(false);	
				}
			});
			switchAnimal.setBounds(42, 545, 141, 23);
			add(switchAnimal);
			
			attack = new JRadioButton("Attack");
			
			attack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(attack.isSelected()){
					attack2.setVisible(true);
					attack1.setVisible(true);
					attack0.setVisible(true);	
					}
					if(!attack.isSelected()){
						attack2.setVisible(false);
						attack1.setVisible(false);
						attack0.setVisible(false);		
					}
				}
			});
			attack.setBounds(42, 289, 141, 23);
			add(attack);
			
			//Buttongroup stufff for pZero ------------------
			ButtonGroup buttonGroup = new ButtonGroup();
			ButtonGroup buttonGroupB = new ButtonGroup();
			
			buttonGroup.add(attack0);
			buttonGroup.add(attack1);
			buttonGroup.add(attack2);
			buttonGroup.add(defend);
			buttonGroup.add(special);
			buttonGroup.add(switchAnimal);
			
			buttonGroupB.add(attack);
			buttonGroupB.add(switchAnimal);
			buttonGroupB.add(defend);
			buttonGroupB.add(special);
			
		
		
//USER 1----------------------------------------------		
		
		userNameOne = new JLabel(pOne.getName());
		userNameOne.setBounds(728, 64, 80, 16);
		add(userNameOne);		
		//ANIMAL 1--------------------------------------------	
		
			animalNameOne = new JLabel(pOne.getActive().getName());
			animalNameOne.setBounds(577, 98, 80, 16);
			add(animalNameOne);
			
		//HP 1 ------------------------------------------------------------	
			//UIManager.put("ProgressBar.selectionBackground", Color.red);
				hpBarr= new JProgressBar(0,(int)pOne.getActive().getHpTot());
				hpBarr.setValue((int)pOne.getActive().getHpRem());
				hpBarr.setForeground(Color.red);
				hpBarr.setBackground(Color.white);
				hpBarr.setStringPainted(true);
				
				hpBarr.setBounds(515, 324, 120, 20);
				add(hpBarr);

		//AP 1 ------------------------------------------------------------				
				//UIManager.put("ProgressBar.selectionBackground", Color.blue);
				apBarr = new JProgressBar(0,(int)pOne.getActive().getApTot());
				apBarr.setValue((int)pOne.getActive().getApRem());
				apBarr.setForeground(Color.blue);
				apBarr.setStringPainted(true);
				apBarr.setBackground(Color.white);
				apBarr.setBounds(515, 352, 120, 20);
				add(apBarr);
	    //  Right Side buttons		
		
		
		attack0r = new JRadioButton("Attack0r");
		attack0r.setBounds(774, 327, 141, 23);
		add(attack0r);
		
		attack1r= new JRadioButton("Attack1r");
		attack1r.setBounds(774, 359, 141, 23);
		add(attack1r);
		
		attack2r = new JRadioButton("Attack2r");
		attack2r.setBounds(774, 394, 141, 23);
		add(attack2r);
		
		attack0r.setVisible(false);
		attack1r.setVisible(false);
		attack2r.setVisible(false);
		
		specialr = new JRadioButton("Special");
		specialr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack2r.setVisible(false);
				attack1r.setVisible(false);
				attack0r.setVisible(false);
			}
		});
		specialr.setBounds(728, 429, 141, 23);
		add(specialr);
		
	    defendr = new JRadioButton("Defend");
		defendr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack2r.setVisible(false);
				attack1r.setVisible(false);
				attack0r.setVisible(false);
			}
		});
		defendr.setBounds(728, 479, 141, 23);
		add(defendr);
		
		switchAnimalr = new JRadioButton("Switch");
		switchAnimalr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack2r.setVisible(false);
				attack1r.setVisible(false);
				attack0r.setVisible(false);
			}
		});
		switchAnimalr.setBounds(728, 545, 141, 23);
		add(switchAnimalr);
		
		attackr = new JRadioButton("Attack");
		attackr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(attackr.isSelected()){
					attack2r.setVisible(true);
					attack1r.setVisible(true);
					attack0r.setVisible(true);	
					}
				if(!attackr.isSelected()){
						attack2r.setVisible(false);
						attack1r.setVisible(false);
						attack0r.setVisible(false);		
					}
			}
		});
		attackr.setBounds(728, 289, 141, 23);
		add(attackr);
		
		// Right side button group stuff
		
			ButtonGroup buttonGroupr = new ButtonGroup();
			ButtonGroup buttonGroupBr = new ButtonGroup();
			
			buttonGroupr.add(attack1r);
			buttonGroupr.add(attack2r);
			buttonGroupr.add(attack3r);
			buttonGroupr.add(defendr);
			buttonGroupr.add(specialr);
			buttonGroupr.add(switchAnimalr);
			
			buttonGroupBr.add(attackr);
			buttonGroupBr.add(switchAnimalr);
			buttonGroupBr.add(defendr);
			buttonGroupBr.add(specialr);
		showpOne(false);
	
	}
//------------------------------------------------------------------ 
	//Start Implimentation
public void showpZero(boolean input){
	if(input == true){
		attack.setVisible(true);
		special.setVisible(true);
		defend.setVisible(true);
		switchAnimal.setVisible(true);
		
		attack.setSelected(false);
		special.setSelected(false);
		defend.setSelected(false);
		switchAnimal.setSelected(false);
		attack2.setSelected(false);
		attack1.setSelected(false);
		attack0.setSelected(false);
		
		}
	if(input == false){
		
		attack.setSelected(false);
		special.setSelected(false);
		defend.setSelected(false);
		switchAnimal.setSelected(false);
		attack2.setSelected(false);
		attack1.setSelected(false);
		attack0.setSelected(false);
		
		attack.setVisible(false);
		special.setVisible(false);
		defend.setVisible(false);
		switchAnimal.setVisible(false);
		attack2.setVisible(false);
		attack1.setVisible(false);
		attack0.setVisible(false);
		
		
		
		
	}
	
}
public void showpOne(boolean input){
	if(input == true){
		attackr.setVisible(true);
		specialr.setVisible(true);
		defendr.setVisible(true);
		switchAnimalr.setVisible(true);
		
		attackr.setSelected(false);
		specialr.setSelected(false);
		defendr.setSelected(false);
		switchAnimalr.setSelected(false);
		attack2r.setSelected(false);
		attack1r.setSelected(false);
		attack0r.setSelected(false);
		}
	if(input == false)
	{

		attackr.setSelected(false);
		specialr.setSelected(false);
		defendr.setSelected(false);
		switchAnimalr.setSelected(false);
		attack2r.setSelected(false);
		attack1r.setSelected(false);
		attack0r.setSelected(false);
		
		attackr.setVisible(false);
		specialr.setVisible(false);
		defendr.setVisible(false);
		switchAnimalr.setVisible(false);
		attack2r.setVisible(false);
		attack1r.setVisible(false);
		attack0r.setVisible(false);
		
	}
	
}

public boolean checkNoneSelected(){
	//false means player has selected a move.
	// check for player 1 side buttons
	if(attack.isSelected()){
		if( !(attack0.isSelected()) && !(attack1.isSelected()) && !(attack2.isSelected())){
			return true;
		}else{
			return false;
		}
	}
	
	if(!(attack.isSelected()) && !(special.isSelected()) && !(defend.isSelected()) & !(switchAnimal.isSelected())) {
		return true;
	}else{
		return false;
	}

}

public boolean checkNoneSelectedr(){
	//false means player has selected a move
	// check for player 2 side buttons
	if(attackr.isSelected()){
		if( !(attack0r.isSelected()) && !(attack1r.isSelected()) && !(attack2r.isSelected())){
			return true;
		}else{
			return false;
		}
	}
	
	if(!(attack.isSelected()) && !(special.isSelected()) && !(defend.isSelected()) & !(switchAnimal.isSelected())) {
		return true;
	}else{
		return false;
	}
	
	
}




	//will fill for other buttons

public void endTurn(){
if(whoseTurn==1){
		round++;
		whoseTurn=0;
		showpOne(false);
		showpZero(true);
}
	
else if(whoseTurn==0){
	whoseTurn++;
	showpZero(false);
	showpOne(true);
}

tmp=active;
active=inactive;
inactive=tmp;
}

public void performSelected(){
	if(attack0.isSelected()){
		active.getActive().addExpErnd(active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive()));
		inactive.getActive().subHpRem(active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive()));
		active.getActive().subApRem((int)active.getActive().attacksAvail.get(0).getApCost());
		hpBarr.setValue((int)inactive.getActive().getHpRem());
		apBar.setValue((int)active.getActive().getApRem());
		
    }
	
	if(attack0r.isSelected()){
		active.getActive().addExpErnd(active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive()));
		inactive.getActive().subHpRem(active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive()));
		active.getActive().subApRem((int)active.getActive().attacksAvail.get(0).getApCost());
		hpBar.setValue((int)inactive.getActive().getHpRem());
		apBarr.setValue((int)active.getActive().getApRem());
	}
}

public class confirmListner implements ActionListener {
	public void actionPerformed(ActionEvent e) {
	//TODO need to check if active animal is dead and if so present only switch animals buttons
		if(whoseTurn == 0){
			if(checkNoneSelected()==false){
				performSelected();
				
				}
		}
		
		if(whoseTurn == 1){
			if(checkNoneSelectedr()==false){
				performSelected();
			
				}
		}
		
		endTurn();
		//checks for inactive player loss after active attacks. have not yet tested but should work fine
		if (inactive.checkLoss()==0){
			String temp =active.getName() + "Wins!";
			prompt.setText(temp);
		}
		
		

	
	}
	}


}

		
		
		
