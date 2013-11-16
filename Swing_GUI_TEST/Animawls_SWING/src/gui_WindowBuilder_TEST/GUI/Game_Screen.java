


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
		private JRadioButton subAnimal1;
		private JRadioButton subAnimal2;
		private JRadioButton subAnimal1r;
		private JRadioButton subAnimal2r;
		

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
		
		attackr.setSelected(false);
		specialr.setSelected(false);
		defendr.setSelected(false);
		switchAnimalr.setSelected(false);
		attack2r.setSelected(false);
		attack1r.setSelected(false);
		attack0r.setSelected(false);
		subAnimal1r.setSelected(false);
		subAnimal2r.setSelected(false);
		
		attack.setVisible(false);
		special.setVisible(false);
		defend.setVisible(false);
		switchAnimal.setVisible(false);
		attack2.setVisible(false);
		attack1.setVisible(false);
		attack0.setVisible(false);
		subAnimal1.setVisible(false);
		subAnimal2.setVisible(false);
		
		
		
		
	}
	
}




	//will fill for other buttons

public void endTurn(){
if(whoseTurn==1){
		round++;
		whoseTurn=0;
}
	
else if(whoseTurn==0){
	whoseTurn++;
}
active.UI.hideAll();
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
				active.getActive().addExpErnd(active.getActive().attacksAvail.get(0).useAttack(active.getActive(), inactive.getActive()));
			}
			if(active.UI.attackOne.isSelected()==true){
				active.getActive().addExpErnd(active.getActive().attacksAvail.get(1).useAttack(active.getActive(), inactive.getActive()));
			}
			
			if(active.UI.attackTwo.isSelected()==true){
				active.getActive().addExpErnd(active.getActive().attacksAvail.get(2).useAttack(active.getActive(), inactive.getActive()));
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

		
		
		
