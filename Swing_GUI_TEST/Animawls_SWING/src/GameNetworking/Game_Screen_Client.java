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
				findTurn= new Thread(new checkTurn(this));
				gameState.inactive.UI.updateAnimals();
				gameState.active.UI.updateAnimals();
				pZero.showUI();
				if(pZero!=gameState.active){
					pZero.UI.setEnabledButtons(false);
					findTurn.start();
					try {
						//turnFinder.doInBackground(this);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
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



