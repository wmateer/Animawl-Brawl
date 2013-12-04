package GameNetworking;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import GameEngine.Player;

public class checkTurn implements Runnable {
	private Network_Game_Screen myGame;
	public checkTurn(Network_Game_Screen input){
		myGame=input;
	}
	
	//checkTurn
	public void run() {
		
		System.out.println("host in checkturn "+ myGame.gameState.host.getName());
		System.out.println("client in checkturn "+ myGame.gameState.client.getName());
		System.out.println("active in checkturn "+ myGame.gameState.active.getName());
		System.out.println("inactive in checkturn "+ myGame.gameState.inactive.getName() +"\n");
 					try {
						myGame.readState = (networkGame)myGame.oisNetworkGame.readObject();
					
						myGame.gameState.host=myGame.readState.host;
						myGame.gameState.client=myGame.readState.client;
						myGame.gameState.active=myGame.readState.active;
						myGame.gameState.inactive=myGame.readState.inactive;
							System.out.println("active player is"+ myGame.gameState.active.getName());
							if(myGame.type=='s'){
								myGame.pZero=myGame.gameState.host;
								myGame.pOne=myGame.gameState.client;
							}
							if(myGame.type=='c'){
								System.out.println("set client");
								myGame.pZero=myGame.gameState.client;
								myGame.pOne=myGame.gameState.host;
							}
							

						   myGame.startTurn();
						   System.out.println("active ap "+ myGame.gameState.active.getActive().getApRem()+'/'+ myGame.gameState.active.getActive().getApTot());
						   System.out.println("active hp "+ myGame.gameState.active.getActive().getHpRem()+'/'+ myGame.gameState.active.getActive().getHpTot());

						   return;
							
						
					}
					
					
					 catch (Exception e) {
							
							System.out.println("no input found");
							e.printStackTrace();
						}
		}	
	








}

