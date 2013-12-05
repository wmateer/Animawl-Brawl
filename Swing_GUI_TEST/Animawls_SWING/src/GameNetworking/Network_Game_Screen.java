package GameNetworking;

import gui_WindowBuilder_TEST.GUI.animalDead;
import gui_WindowBuilder_TEST.GUI.playerButtons;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

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
			public JLabel userNameZero;
			public Player pZero;
			public JLabel Hp;
			public JLabel Ap ;
			public playerButtons UI;
			public JLabel currentAnimalPicZero;
			public BufferedImage animalPictureZero;
			public JProgressBar hpBarZero;
			public JProgressBar apBarZero;
			public JLabel animalNameZero;

			
			//network player
			public JLabel userNameOne;
			public Player pOne;
			public JLabel Hpr;
			public JLabel Apr;
			public JLabel currentAnimalPicOne;
			transient public BufferedImage animalPictureOne;		
			public JProgressBar hpBarOne;
			public JProgressBar apBarOne;
			public JLabel animalNameOne;

			
			
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
			
				
			//right player
			
			
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(backgroundPict, 0, 0, null);            
			}
			
			public void promptSwitch(){
				deadAnimalPrompt pickAnimal= new deadAnimalPrompt(this);
				pickAnimal.setVisible(true);
			}
			
			public class confirmListner implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent e) {
				//TODO need to check if active animal is dead and if so present only switch animals buttons
						if(UI.moveSelected()==false){
							System.out.println("Please Select a Valid Move");
							text="Please Select a Valid Move";
							prompt.setText(text);
							return;
						}
						if((UI.attackZero.isSelected()==true) |(UI.attackOne.isSelected()==true) | (UI.attackTwo.isSelected()==true)){
							int dmg=0;

							if(UI.attackZero.isSelected()==true){
							dmg= pZero.getActive().attacksAvail.get(0).useAttack(pZero.getActive(), pOne.getActive());
							
							
							}
							else if(UI.attackOne.isSelected()==true){
								dmg= pZero.getActive().attacksAvail.get(1).useAttack(pZero.getActive(), pOne.getActive());
								
							}	
						
							else if(UI.attackTwo.isSelected()==true){
								dmg= pZero.getActive().attacksAvail.get(2).useAttack(pZero.getActive(), pOne.getActive());
							}
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
						 if(UI.animalZero.isSelected()==true){
							pZero.switchAnimalNetwork(0);
						}
						else if(UI.animalOne.isSelected()==true){
							pZero.switchAnimalNetwork(1);
						}
						else if(UI.animalTwo.isSelected()==true){
							pZero.switchAnimalNetwork(2);
						}
					}
						if(UI.specialButton.isSelected()==true){
							//uses active animals unique special
							pZero.getActive().useSpecial(gameState.inactive);
							
							
							//TODO create better way to display effect of special (maybe own Jpanel?)
							prompt.setText(gameState.active.getActive().getName()+" used thier special!");
						}
						//update hp bars
						hpBarZero.setValue((int)pZero.getActive().getHpRem());
						hpBarOne.setValue((int)pOne.getActive().getHpRem());
						
						//update ap bars
						apBarZero.setValue((int)gameState.active.getActive().getApRem());
						apBarOne.setValue((int)gameState.inactive.getActive().getApRem());
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
					UI.setEnabledButtons(false);
					prompt.setText(pOne.getName()+" Wins!");
					return;
				}
				if(pOne.checkLoss()==0){
						UI.setEnabledButtons(false);
						prompt.setText(pZero.getName()+" Wins!");
						return;
				}
				pZero.regenAp();
				
				
				gameState.active.updatePlayer(pZero);
				gameState.inactive.updatePlayer(pOne);
				gameState.tmp=gameState.active;
				gameState.active=gameState.inactive;
				gameState.inactive=gameState.tmp;
				
			
				try {
					System.out.println("host "+ gameState.host.getName());
					System.out.println("client "+ gameState.client.getName());
					System.out.println("active "+ gameState.active.getName());
					System.out.println("inactive "+ gameState.inactive.getName());
					gameState=new networkGame(gameState.host,gameState.client,gameState.active,gameState.inactive);
					oosNetworkGame.writeObject(gameState);
					System.out.println("wrote to socket");


				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//TODO update screen here
				UI.setEnabledButtons(false);
				confirm.setEnabled(false);
				updateGUI();
				findTurn= new Thread(new checkTurn(this));
				findTurn.start();
				}

	public void startTurn(){
		 		UI.setEnabledButtons(true);
		 		UI.updateAttacks();
				UI.updateAnimals();
				UI.checkAp();
				confirm.setEnabled(true);
				updateGUI();
				
				if(pZero.getActive().getHpRem()<=0){
					promptSwitch();
					}
				}
	
	public void placePone(){
		//place buttons for pOne in proper spot
		currentAnimalPicOne.setBounds(557, 126, 200, 200);
		hpBarOne.setBounds(515, 324, 180, 50);
		apBarOne.setBounds(515, 352, 180, 50);
		userNameOne.setBounds(587, 60, 132, 44);
		userNameOne.setHorizontalAlignment(SwingConstants.CENTER);
		animalNameOne.setBounds(587, 90, 132, 29);
		animalNameOne.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void placePzero(){
		UI.attackButton.setBounds(42, 289, 141, 23);
		UI.attackButton.setForeground(Color.white);
		UI.attackZero.setBounds(84, 324, 141, 23);
		UI.attackZero.setForeground(Color.white);
		UI.attackOne.setBounds(83, 359, 141, 23);
		UI.attackOne.setForeground(Color.white);
		UI.attackTwo.setBounds(84, 394, 141, 23);
		UI.attackTwo.setForeground(Color.white);
		UI.specialButton.setBounds(42, 429, 141, 23);
		UI.specialButton.setForeground(Color.white);
		UI.defendButton.setBounds(42, 479, 141, 23);
		UI.defendButton.setForeground(Color.white);
		UI.switchButton.setBounds(42, 514, 141, 23);
		UI.switchButton.setForeground(Color.white);
		UI.animalZero.setBounds(130, 536, 141, 23);
		UI.animalZero.setForeground(Color.white);
		UI.animalOne.setBounds(130, 560, 141, 23);
		UI.animalOne.setForeground(Color.white);
		UI.animalTwo.setBounds(130, 584, 141, 23);
		UI.animalTwo.setForeground(Color.white);
		currentAnimalPicZero.setBounds(185, 126, 200, 200);
		hpBarZero.setBounds(262, 324, 180, 50);	
		apBarZero.setBounds(262, 356, 180, 50);
		userNameZero.setBounds(185, 60, 132, 44);
		userNameZero.setHorizontalAlignment(SwingConstants.CENTER);
		animalNameZero.setBounds(185, 90, 132, 29);
		animalNameZero.setHorizontalAlignment(SwingConstants.CENTER);

	}

	public BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  
	
	public void updateGUI(){
		//update local players info
		hpBarZero.setMaximum((int)pZero.getActive().getHpTot());
		hpBarZero.setValue((int)pZero.getActive().getHpRem());
		
		apBarZero.setMaximum((int)pZero.getActive().getApTot());
		apBarZero.setValue((int)pZero.getActive().getApRem());
		
		animalNameZero.setText(pZero.getName());
		
		try {
			animalPictureZero = ImageIO.read(new File(pZero.getActive().imgPath));
			currentAnimalPicZero.setIcon(new ImageIcon(animalPictureZero));
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//update network players info
		hpBarOne.setMaximum((int)pOne.getActive().getHpTot());
		hpBarOne.setValue((int)pOne.getActive().getHpRem());
		apBarOne.setMaximum((int)pOne.getActive().getApTot());
		apBarOne.setValue((int)pOne.getActive().getApRem());
		animalNameOne.setText(pOne.getName());
		try {
			animalPictureOne = ImageIO.read(new File(pOne.getActive().imgPath));
			currentAnimalPicOne.setIcon(new ImageIcon(animalPictureOne));
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}
	
}
