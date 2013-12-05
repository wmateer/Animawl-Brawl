


package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import Animals.*;
import GameEngine.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Hashtable;


public class Game_Screen extends JPanel {
	//game info
	private Player pZero;
	private Player pOne;
	private Player active;
	private Player inactive;
	private Player tmp;
	private int round=0;
	private int whoseTurn=0;
	public String newprompt;
	
	
	private JLabel prompt;
	private String text;
	
	private MusicFrame parentFrame;
	private Hashtable<String,User> dataLoadedFromFile;

	//TODO incorperate as variables in player class


	private BufferedImage backgroundPict;
	
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  

	public Game_Screen(MusicFrame masterFrame, User user1, String chosenBattleground) {
		parentFrame = masterFrame;
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		//SET BACKGROUND
		try {               
			
			backgroundPict = ImageIO.read(new File(chosenBattleground));
		} 
		catch (Exception ex) {
		       ex.printStackTrace();
		}

		parentFrame.setSize(900, 635);
		parentFrame.setLocationRelativeTo(null);
		parentFrame.setResizable(false);

		
//----------------------------------
	//intilize player objects	
		

		Bull Kyle = new Bull("Kyle");
		Bat Mindy= new Bat("Mindy");
		Bull Alex= new Bull("Alex");
		
		
		
		final Player pZero = new Player(user1.getName(),user1.getAnimalAtIndex(0), user1.getAnimalAtIndex(1), user1.getAnimalAtIndex(2));
		active = pZero;

		final Player pOne = new Player("bob",Kyle, Mindy, Alex);
		inactive=pOne;
		active.setOpp(inactive);
		inactive.setOpp(active);
	//---------------------------------------		
	//test pop of for dead animal	
		//animalDead pickAnimal= new animalDead(inactive);
		//pickAnimal.setVisible(true);
		
		//initialize constant screen objects

		JLabel Hp = new JLabel("HP ");
		Hp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Hp.setHorizontalAlignment(SwingConstants.CENTER);
		Hp.setForeground(Color.RED);
		Hp.setBounds(189, 331, 45, 33);
		add(Hp);
		
		JLabel Ap = new JLabel("AP");
		Ap.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Ap.setHorizontalAlignment(SwingConstants.CENTER);
		Ap.setForeground(Color.blue);
		Ap.setBounds(187, 364, 45, 33);
		add(Ap);
		
		JLabel Hpr = new JLabel("HP");
		Hpr.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Hpr.setHorizontalAlignment(SwingConstants.CENTER);
		Hpr.setForeground(Color.RED);
		Hpr.setBounds(690, 334, 45, 33);
		add(Hpr);
		
		JLabel Apr = new JLabel("AP");
		Apr.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Apr.setHorizontalAlignment(SwingConstants.CENTER);
		Apr.setForeground(Color.blue);
		Apr.setBounds(690, 361, 45, 33);
		add(Apr);
		
		JLabel playAnimawl_title = new JLabel("BATTLE");
		playAnimawl_title.setHorizontalAlignment(SwingConstants.CENTER);
		playAnimawl_title.setFont(new Font("Zapf Dingbats", Font.PLAIN, 23));
		playAnimawl_title.setBounds(351, 25, 197, 33);
		add(playAnimawl_title);
		
		final JToggleButton toggleButton = new JToggleButton("Music");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (toggleButton.isSelected()) 
				{ 
					parentFrame.LoopCont();
					//parentFrame.StartMusic(5);
				} 
				else 
				{ 
					parentFrame.StopMusic(); 
				} 
			}
		});
		toggleButton.setSelected(false);
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
		prompt.setBounds(263, 499, 371, 40);
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
		
		inactive.UI.updateAnimals();
		active.UI.updateAnimals();
		inactive.hideUI();
		active.showUI();

	
	}
//------------------------------------------------------------------ 
	//Start Implementation




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
		//GAME ENDS GO TO END GAME SCREEN?
		//SAVE USER STATS
		//HAVE USERS LEVEL UP CHARS
		//dataLoadedFromFile = LoadTable();
		
		
		
		return;
	}
	if(active.checkLoss()==0){
		inactive.hideUI();
		active.hideUI();
		prompt.setText(inactive.getName()+" Wins!");
		//GAME ENDS GO TO END GAME SCREEN?
		//SAVE USER STATS
		//HAVE USERS LEVEL UP CHARS
				
		
		
		return;
	}

	active.hideUI();
	tmp=active;
	active=inactive;
	inactive=tmp;
	active.showUI();
	active.regenAp();
	
	if(active.getActive().getHpRem()<=0){
	promptSwitch();
	active.UI.updateAnimals();
	}
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
				text="Please Select a Valid Move";
				prompt.setText(text);
				return;
			}
			if((active.UI.attackZero.isSelected()==true) |(active.UI.attackOne.isSelected()==true) | (active.UI.attackTwo.isSelected()==true)){
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
			inactive.hpBar.setValue((int)inactive.getActive().getHpRem());
			active.apBar.setValue((int)active.getActive().getApRem());
			if (dmg == 0){
				text="Your attack missed the target!";
			}else{
			text="Your attack did "+dmg;
			}
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
				//uses active animals unique special
				active.getActive().useSpecial(inactive);
				
				//update hp bars
				active.hpBar.setValue((int)active.getActive().getHpRem());
				inactive.hpBar.setValue((int)inactive.getActive().getHpRem());
				
				//update ap bars
				active.apBar.setValue((int)active.getActive().getApRem());
				inactive.apBar.setValue((int)inactive.getActive().getApRem());
				
				//TODO create better way to display effect of special (maybe own Jpanel?)
				prompt.setText(active.getActive().getName()+" used their special!");
			}
		
		endTurn();
	

	
	}
	}

	public void promptSwitch(){
		animalDead pickAnimal= new animalDead(active);
		pickAnimal.setVisible(true);
	}


	//to make background image//can use for animations later...
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundPict, 0, 0, null);            
	}
	
	//USER SAVING
	/*private Hashtable<String,User> LoadTable(){
		try{ 
			Hashtable<String,User> savedDataFromFile;
			FileInputStream fileIn = new FileInputStream("Savefiles/Saved_users_passwords.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Object objectIN = in.readObject();
			if(objectIN instanceof Hashtable<?,?>){
				savedDataFromFile = (Hashtable<String, User>)objectIN;
			}
			else{
				savedDataFromFile = new Hashtable<String, User>();
			}
			in.close();
			fileIn.close();
			return savedDataFromFile;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return new Hashtable<String,User>();
		}
		
	}*/
}

		
		
		
