package GameNetworking;

import javax.swing.JButton;
import javax.swing.SwingWorker;

import GameEngine.Player;

public class checkTurn implements Runnable {
	private Network_Game_Screen myGame;
	public checkTurn(Network_Game_Screen input){
		myGame=input;
	}
	
	//checkTurn
	public void run() {
		int i=0;
		while(i==0){
					try {
						
						myGame.readState = (networkGame)myGame.oisNetworkGame.readObject();	
						myGame.gameState=myGame.readState;
						System.out.println("found input");
						

							i=1;
							System.out.println("active player is"+ myGame.gameState.active.getName());
							if(myGame.type=='s'){
								myGame.pZero=myGame.gameState.host;
								myGame.pOne=myGame.gameState.client;
							}
							if(myGame.type=='c'){
								myGame.pZero=myGame.gameState.client;
								myGame.pOne=myGame.gameState.host;
							}
						
							myGame.startTurn();
							
						
					}
					
					
					 catch (Exception e) {
							
							System.out.println("no input found");
							e.printStackTrace();
						}
		}	
	}








}

