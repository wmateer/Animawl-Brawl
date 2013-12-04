package GameNetworking;

import java.io.*;
import GameEngine.Player;

//game state to be sent over network
public class networkGame implements Serializable {
	Player client;
	Player host;
	Player active;
	Player inactive;
	Player tmp;
	
networkGame(Player host, Player client, Player active, Player inactive){
	this.host=host;
	this.client=client;
	this.active=active;
	this.inactive=inactive;
}

void updateGame(Game_Screen_Client myGame){
	myGame.pZero=client;
	myGame.pOne=host;
}

void updateGame(Game_Screen_Server myGame){
	myGame.pZero=host;
	myGame.pOne=client;
}

void updateGameState(Game_Screen_Client myGame){
	this.host= myGame.pOne;
	this.client=myGame.pZero;
	this.active=myGame.gameState.active;
	this.inactive=myGame.gameState.inactive;
}

void updateGameState(Game_Screen_Server myGame){
	this.host= myGame.pOne;
	this.client=myGame.pZero;
	this.active=myGame.gameState.active;
	this.inactive=myGame.gameState.inactive;
}

void updateGame(networkGame myGame){
	this.host=myGame.host;
	this.client=myGame.client;
	this.active=myGame.active;
	this.inactive=myGame.inactive;
}

}
