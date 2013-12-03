package GameNetworking;

import GameEngine.Player;

public class checkTurn extends Thread {
public void run(Game_Screen_Server myGame){
	int i=0;
		while(i==0){
			try {
				System.out.println("stuck in loop");
				if(myGame.oisActivePlayer.available()!=0){
				myGame.active= (Player)myGame.oisActivePlayer.readObject();
				if(myGame.active==myGame.pZero){
					i=1;
						myGame.pZero=(Player)myGame.oisHostPlayer.readObject();
						myGame.pOne=(Player)myGame.oisClientPlayer.readObject();
						myGame.pZero.updateInfo();
						myGame.pOne.updateInfo();
						if(myGame.pZero.getActive().getHpRem()<=0){
							myGame.promptSwitch();
							myGame.pZero.UI.updateAnimals();
							}
						myGame.pZero.UI.setEnabledButtons(true);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}

public void run(Game_Screen_Client myGame){
	int i=0;
		while(i==0){
			try {
				System.out.println("stuck in loop");
				if(myGame.oisActivePlayer.available()!=0){
				myGame.active= (Player)myGame.oisActivePlayer.readObject();
				if(myGame.active==myGame.pZero){
					i=1;
						myGame.pZero=(Player)myGame.oisHostPlayer.readObject();
						myGame.pOne=(Player)myGame.oisClientPlayer.readObject();
						myGame.pZero.updateInfo();
						myGame.pOne.updateInfo();
						if(myGame.pZero.getActive().getHpRem()<=0){
							myGame.promptSwitch();
							myGame.pZero.UI.updateAnimals();
							}
						myGame.pZero.UI.setEnabledButtons(true);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
}


