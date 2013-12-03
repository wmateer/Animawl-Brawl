package GameNetworking;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.*;
import javax.swing.*;
import gui_WindowBuilder_TEST.GUI.*;
import Animals.*;
import GameEngine.*;
import java.awt.*;
import java.awt.event.*;



public class Game_Screen_Client extends JPanel {
		//Game Stuff
		
		
		//Network Stuff		
		public Socket myHostSocket;
		public OutputStream osHostPlayer;
		public ObjectOutputStream oosHostPlayer;
		public InputStream isHostPlayer;
		public ObjectInputStream oisHostPlayer;
		
		public Socket myClientSocket;
		public OutputStream osClientPlayer;
		public ObjectOutputStream oosClientPlayer;
		public InputStream isClientPlayer;
		public ObjectInputStream oisClientPlayer;
		
		public Socket myActiveSocket;
		public OutputStream osActivePlayer;
		public ObjectOutputStream oosActivePlayer;
		public InputStream isActivePlayer;
		public ObjectInputStream oisActivePlayer;
		
		public checkTurn turnFinder;

		
		//game info
		public Player pZero;
		public Player pOne;
		public Player active;
		public Player inactive;
		public Player tmp;
		private int round=0;
		private int whoseTurn=0;
		public String newprompt;
		
		//Constant Gui Objects
		private JLabel prompt;
		private String text;
		private BufferedImage backgroundPict;
		private JLabel playAnimawl_title;
		private JToggleButton music;
		private JButton confirm;
		
		//left player
		private JLabel Hp;
		private JLabel Ap ;
		
		//right player
		private JLabel Hpr;
		private JLabel Apr;
		
public Game_Screen_Client (JFrame masterFrame, User user1, String chosenBattleground) {
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
			
			//Set constant game objects
			
			prompt=new JLabel("Begin!");
			prompt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
			prompt.setForeground(Color.ORANGE);
			prompt.setHorizontalAlignment( SwingConstants.CENTER ); 
			prompt.setBounds(263, 499, 371, 40);
			add(prompt);
			

			playAnimawl_title = new JLabel("BATTLE");
			playAnimawl_title.setHorizontalAlignment(SwingConstants.CENTER);
			playAnimawl_title.setFont(new Font("Zapf Dingbats", Font.PLAIN, 23));
			playAnimawl_title.setBounds(351, 25, 197, 33);
			add(playAnimawl_title);
			
			JToggleButton music = new JToggleButton("Music");
			music.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			music.setSelected(true);
			music.setForeground(Color.BLACK);
			music.setBackground(Color.YELLOW);
			music.setBounds(797, 36, 72, 16);
			add(music);
			
//intilize local player object

		 pZero = new Player(user1.getName(),user1.getAnimalAtIndex(0), user1.getAnimalAtIndex(1), user1.getAnimalAtIndex(2));
		 pOne=null;
		//set up network stuff
		connect();
		
		
		 while(pOne==null){
				try {
					System.out.println("suck here");
					pOne= (Player)oisHostPlayer.readObject();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("client couldnt read object");
				}
				}
			
	  
			System.out.println("made it here");
			System.out.println(pOne.getName());
			inactive = pZero;
			active=  pOne;
			active.setOpp(inactive);
			inactive.setOpp(active);
		//Confirm Button-------------------------------------		
			confirm = new JButton("Confirm");
			confirm.addActionListener(new confirmListner());
			confirm.setBounds(391, 428, 117, 29);
			add(confirm);

			
		
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
			
				Hp = new JLabel("HP ");
				Hp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				Hp.setHorizontalAlignment(SwingConstants.CENTER);
				Hp.setForeground(Color.RED);
				Hp.setBounds(227, 307, 45, 33);
				add(Hp);
				
				Ap = new JLabel("AP");
				Ap.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				Ap.setHorizontalAlignment(SwingConstants.CENTER);
				Ap.setForeground(Color.blue);
				Ap.setBounds(227, 345, 45, 33);
				add(Ap);
				
				
			//Player One UI----------------------------------------------		
				pOne.placePone();
				
				
				add(pOne.currentAnimalPic);
				add(pOne.getHpBar());
				add(pOne.getApBar());
				add(pOne.userName);
				add(pOne.animalName);
				
				Hpr = new JLabel("HP");
				Hpr.setForeground(Color.RED);
				Hpr.setBounds(650, 324, 22, 16);
				add(Hpr);
				
				Apr = new JLabel("AP");
				Apr.setForeground(Color.blue);
				Apr.setBounds(650, 356, 22, 16);
				add(Apr);
				
		
		
				//set up game
				inactive.UI.updateAnimals();
				active.UI.updateAnimals();
				pZero.showUI();
				if(pZero!=active){
					pZero.UI.setEnabledButtons(false);
				}

				turnFinder= new checkTurn();
				turnFinder.run();

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
if(pZero.checkLoss()==0){
	pZero.UI.setEnabledButtons(false);
	prompt.setText(pOne.getName()+" Wins!");
	return;
}
if(pOne.checkLoss()==0){
		pZero.UI.setEnabledButtons(false);
		prompt.setText(pZero.getName()+" Wins!");
		return;
}
pZero.UI.setEnabledButtons(false);
pZero.regenAp();

tmp=active;
active=inactive;
inactive=tmp;

try {
	oosHostPlayer.writeObject(pZero);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	oosClientPlayer.writeObject(pOne);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	oosActivePlayer.writeObject(active);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
//TODO update screen here
pZero.setEnabled(false);
turnFinder.run(this);
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
					prompt.setText(active.getActive().getName()+" used thier special!");
				}
			System.out.println("made it here");
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

public void connect(){
	  try {
		    //create server
		  	myHostSocket = new Socket("localhost",4444);
		  	myClientSocket = new Socket("localhost",4445);
		  	myActiveSocket = new Socket("localhost",4446);

		  	//set up stream for host
			osHostPlayer = myHostSocket.getOutputStream();
			oosHostPlayer = new ObjectOutputStream(osHostPlayer);
			isHostPlayer = myHostSocket.getInputStream();
			oisHostPlayer = new ObjectInputStream(isHostPlayer);
			
			//set up in and out streams for client
			osClientPlayer = myClientSocket.getOutputStream();
			oosClientPlayer = new ObjectOutputStream(osClientPlayer);
			isClientPlayer = myClientSocket.getInputStream();
			oisClientPlayer = new ObjectInputStream(isClientPlayer);
			
			//set up in and out streams for Active
			osActivePlayer = myActiveSocket.getOutputStream();
			oosActivePlayer = new ObjectOutputStream(osActivePlayer);
			isActivePlayer = myActiveSocket.getInputStream();
			oisActivePlayer = new ObjectInputStream(isActivePlayer);


			oosClientPlayer.writeObject(pZero);
	  }
			catch (Exception e) {
			System.out.println("couldnt connect to server");
		}
}

public void checkForTurn(){
	int i=0;
	while(i==0){
		try {
			active= (Player)oisActivePlayer.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(active==pZero){
			try {
				pZero=(Player)oisHostPlayer.readObject();
				pOne=(Player)oisClientPlayer.readObject();
				pZero.updateInfo();
				pOne.updateInfo();
				if(active.getActive().getHpRem()<=0){
					promptSwitch();
					pZero.UI.updateAnimals();
					}
				pZero.UI.setEnabledButtons(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i=1;
		}
	}
}

}



