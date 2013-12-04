package GameNetworking;

import gui_WindowBuilder_TEST.GUI.animalDead;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import GameEngine.Player;

public abstract class Network_Game_Screen extends JPanel {
	//network stuff
	public networkGame gameState;
	public networkGame readState;
	
	public Socket myNetworkGameSocket;
	public ServerSocket myNetworkGameServerSocket;
	public OutputStream osNetworkGame;
	public ObjectOutputStream oosNetworkGame;
	public InputStream isNetworkGame;
	public ObjectInputStream oisNetworkGame;
	public char type;
	public Thread findTurn;
	//game info
			//local player
			public Player pZero;
			//network player
			public Player pOne;
			public int round=0;
			public int whoseTurn=0;
			public String newprompt;
			
			//Constant Gui Objects
			public JLabel prompt;
			public String text;
			public BufferedImage backgroundPict;
			public JLabel playAnimawl_title;
			public JToggleButton music;
			public JButton confirm;
			
			//left player
			public JLabel Hp;
			public JLabel Ap ;
			
			//right player
			public JLabel Hpr;
			public JLabel Apr;
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundPict, 0, 0, null);            
			}
			
			public void promptSwitch(){
				animalDead pickAnimal= new animalDead(gameState.active);
				pickAnimal.setVisible(true);
			}
			
			public class confirmListner implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent e) {
				//TODO need to check if active animal is dead and if so present only switch animals buttons
						if(gameState.active.UI.moveSelected()==false){
							System.out.println("Please Select a Valid Move");
							text="Please Select a Valid Move";
							prompt.setText(text);
							return;
						}
						if((gameState.active.UI.attackZero.isSelected()==true) |(gameState.active.UI.attackOne.isSelected()==true) | (gameState.active.UI.attackTwo.isSelected()==true)){
							int dmg=0;

							if(gameState.active.UI.attackZero.isSelected()==true){
							dmg= gameState.active.getActive().attacksAvail.get(0).useAttack(gameState.active.getActive(), gameState.inactive.getActive());
							
							
							}
							else if(gameState.active.UI.attackOne.isSelected()==true){
								dmg= gameState.active.getActive().attacksAvail.get(1).useAttack(gameState.active.getActive(), gameState.inactive.getActive());
								
							}	
						
							else if(gameState.active.UI.attackTwo.isSelected()==true){
								dmg= gameState.active.getActive().attacksAvail.get(2).useAttack(gameState.active.getActive(), gameState.inactive.getActive());
						
							}
						gameState.inactive.hpBar.setValue((int)gameState.inactive.getActive().getHpRem());
						gameState.active.apBar.setValue((int)gameState.active.getActive().getApRem());
						if (dmg == 0){
							text="Your attack missed the target!";
						}else{
						text="Your attack did "+dmg;
						}
						prompt.setText(text);
						
						if (gameState.inactive.checkLoss()==0){
							String temp =gameState.active.getName() + "Wins!";
							prompt.setText(temp);
						}
						}
					else{
						 if(gameState.active.UI.animalZero.isSelected()==true){
							gameState.active.switchAnimalGui(0);
						}
						else if(gameState.active.UI.animalOne.isSelected()==true){
							gameState.active.switchAnimalGui(1);
						}
						else if(gameState.active.UI.animalTwo.isSelected()==true){
							gameState.active.switchAnimalGui(2);
						}
					}
						if(gameState.active.UI.specialButton.isSelected()==true){
							//uses active animals unique special
							gameState.active.getActive().useSpecial(gameState.inactive);
							
							//update hp bars
							gameState.active.hpBar.setValue((int)gameState.active.getActive().getHpRem());
							gameState.inactive.hpBar.setValue((int)gameState.inactive.getActive().getHpRem());
							
							//update ap bars
							gameState.active.apBar.setValue((int)gameState.active.getActive().getApRem());
							gameState.inactive.apBar.setValue((int)gameState.inactive.getActive().getApRem());
							
							//TODO create better way to display effect of special (maybe own Jpanel?)
							prompt.setText(gameState.active.getActive().getName()+" used thier special!");
						}
						System.out.println("made it here");

					try {
						endTurn();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				

				
				}
				}
			
			public void endTurn() throws Exception{
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

				gameState.tmp=gameState.active;
				gameState.active=gameState.inactive;
				gameState.inactive=gameState.tmp;

				try {
					oosNetworkGame.writeObject(gameState);
					System.out.println("wrote to socket");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//TODO update screen here
				pZero.setEnabled(false);
				confirm.setEnabled(false);
				findTurn.start();
				}

	public void startTurn(){
		pZero.updateInfo();
		pOne.updateInfo();
		if(pZero.getActive().getHpRem()<=0){
			promptSwitch();
			pZero.UI.updateAnimals();
			}
		pZero.UI.setEnabledButtons(true);
		confirm.setEnabled(true);
		}
	
}
