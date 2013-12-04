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
			//system.out.print("checking");
					try {
						if(myGame.oisNetworkGame.available()!=0){
						System.out.print("found an update");
						myGame.readState= (networkGame)myGame.oisNetworkGame.readObject();
						myGame.gameState.updateGame(myGame.readState);
						if(myGame.gameState.active.getName()==myGame.pZero.getName()){
							i=1;
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
					}
					}
					 catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		}	
	}








}

