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



public class Game_Screen_Client extends Network_Game_Screen {
public Game_Screen_Client (JFrame masterFrame, User user1, String chosenBattleground) {
			type= 'c';
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
		 
		gameState= new networkGame(pOne,pZero,pOne,pZero);

		//set up network stuff
		connect();
		
		
		 while(pOne==null){
				try {
					System.out.println("stuck in loop 1");
					readState= (networkGame)oisNetworkGame.readObject();
					pOne=readState.host;
					gameState.host=pOne;
					//gameState.updateGameState(this);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("client couldnt read object");
				}
				}
		 
		while(gameState.active==null | gameState.inactive==null){
			try {
				System.out.println("stuck in loop 2");
				readState= (networkGame)oisNetworkGame.readObject();
				if(readState.active==pZero | readState.active==pOne){
					gameState.active=readState.active;
				}
				if(readState.inactive==pZero | readState.inactive==pOne){
					gameState.inactive=readState.inactive;
				}
				System.out.println(gameState.inactive.getName());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("client couldnt read game state");
			}
		}
		
		//Confirm Button-------------------------------------		
			confirm = new JButton("Confirm");
			confirm.addActionListener(new confirmListner());
			confirm.setBounds(391, 428, 117, 29);
			add(confirm);

			
		
	//Player Zero UI------------------------------------------------------		
		
				//add pZero's buttons to GUI screen
			//create username object
			userNameZero= new JLabel(pZero.getName());
			userNameZero.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
			userNameZero.setForeground(Color.white);
			userNameZero.setVisible(true);
			
			//create animal pic 
			currentAnimalPicZero = new JLabel(pZero.getActive().getName());
			try {
				BufferedImage unsizedAnimalPicture = ImageIO.read(new File(pZero.getActive().imgPath));
				BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
				currentAnimalPicZero.setIcon(new ImageIcon(sizedAnimalPicture));
				
			} catch (IOException e1) {
				 //TODO Auto-generated catch block
				e1.printStackTrace();
			}
			currentAnimalPicZero.setVisible(true);
			
			//create animal name label
			animalNameZero=new JLabel(pZero.getActive().getName());
			animalNameZero.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			animalNameZero.setForeground(Color.CYAN);
			animalNameZero.setVisible(true);
			
			//creat hp bar
			hpBarZero = new JProgressBar(0,(int)Math.round(pZero.getActive().getHpTot()));
			hpBarZero.setValue((int)Math.round(pZero.getActive().getHpTot()));
			hpBarZero.setForeground(Color.red);
			hpBarZero.setStringPainted(true);
			hpBarZero.setBackground(Color.white);
			hpBarZero.setVisible(true);
			
			//creat ap bar
			apBarZero= new JProgressBar(0,(int)Math.round(pZero.getActive().getApTot()));
			apBarZero.setValue((int)Math.round(pZero.getActive().getApTot()));
			apBarZero.setForeground(Color.blue);
			apBarZero.setStringPainted(true);
			apBarZero.setBackground(Color.white);
			apBarZero.setVisible(true);
				
			UI=new playerButtons(pZero);
				//add pOne Gui object to screen
			
				
				placePzero();
				add(UI.attackButton);
				add(UI.specialButton);
				add(UI.defendButton);
				add(UI.switchButton);
				
				add(UI.attackZero);
				add(UI.attackOne);
				add(UI.attackTwo);
				
				add(UI.animalZero);
				add(UI.animalOne);
				add(UI.animalTwo);
				
				add(currentAnimalPicZero);
				add(hpBarZero);
				add(apBarZero);
				add(userNameZero);
				add(animalNameZero);
			
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
				
				//create username object
				userNameOne= new JLabel(pOne.getName());
				userNameOne.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
				userNameOne.setForeground(Color.white);
				userNameOne.setVisible(true);
				
				//create animal pic 
				currentAnimalPicOne = new JLabel(pOne.getActive().getName());
				try {
					BufferedImage unsizedAnimalPicture = ImageIO.read(new File(pOne.getActive().imgPath));
					BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
					currentAnimalPicOne.setIcon(new ImageIcon(sizedAnimalPicture));
					
				} catch (IOException e1) {
					 //TODO Auto-generated catch block
					e1.printStackTrace();
				}
				currentAnimalPicOne.setVisible(true);
				
				//create animal name label
				animalNameOne=new JLabel(pOne.getActive().getName());
				animalNameOne.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				animalNameOne.setForeground(Color.CYAN);
				animalNameOne.setVisible(true);
				
				//creat hp bar
				hpBarOne = new JProgressBar(0,(int)Math.round(pOne.getActive().getHpTot()));
				hpBarOne.setValue((int)Math.round(pOne.getActive().getHpTot()));
				hpBarOne.setForeground(Color.red);
				hpBarOne.setStringPainted(true);
				hpBarOne.setBackground(Color.white);
				hpBarOne.setVisible(true);
				
				//creat ap bar
				apBarOne= new JProgressBar(0,(int)Math.round(pOne.getActive().getApTot()));
				apBarOne.setValue((int)Math.round(pOne.getActive().getApTot()));
				apBarOne.setForeground(Color.blue);
				apBarOne.setStringPainted(true);
				apBarOne.setBackground(Color.white);
				apBarOne.setVisible(true);
				
				placePone();

				add(currentAnimalPicOne);
				add(hpBarOne);
				add(apBarOne);
				add(userNameOne);
				add(animalNameOne);
				
				Hpr = new JLabel("HP");
				Hpr.setForeground(Color.RED);
				Hpr.setBounds(650, 324, 22, 16);
				add(Hpr);
				
				Apr = new JLabel("AP");
				Apr.setForeground(Color.blue);
				Apr.setBounds(650, 356, 22, 16);
				add(Apr);
				

		
		
				//set up game
				findTurn= new Thread(new checkTurn(this));
				UI.updateAnimals();
				
			
				if(pZero!=gameState.active){
					UI.setEnabledButtons(false);
					confirm.setEnabled(false);
					findTurn.start();
					
				}
		}
	//------------------------------------------------------------------ 
		//Start Implimentation



public void connect(){
	  try {
		    
		  //create server
		  	myNetworkGameSocket = new Socket("localhost", 4444);
		  	
		 
			//set up in and out streams for network game states
		  	osNetworkGame = myNetworkGameSocket.getOutputStream();
			oosNetworkGame = new ObjectOutputStream(osNetworkGame);
			isNetworkGame = myNetworkGameSocket.getInputStream();
			oisNetworkGame = new ObjectInputStream(isNetworkGame);

			System.out.println("finished open conection");

			oosNetworkGame.writeObject(gameState);
	  }
			catch (Exception e) {
			System.out.println("couldnt connect to server");
		}
}




}



