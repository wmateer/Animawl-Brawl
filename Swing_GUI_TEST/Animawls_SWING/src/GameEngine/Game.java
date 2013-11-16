package GameEngine;

//import Player;


public class Game {
//private variables
private Player pZero;
private Player pOne;
private Player active;
private Player inactive;
private Player tmp;
private int round=0;
private int  play=1;
private int whoseTurn=0;

//Constructor
public Game (Player inZero, Player inOne, int movesFirst){
	//set players and pass them their opponents
	pZero=inZero;
	pOne=inOne;
	pZero.setOpp(pOne);
	pOne.setOpp(pZero);
	//load them into player array
	//set pZero to active player
	if(movesFirst==0){
		active=pZero;
		inactive=pOne;
	}
	else{
		inactive=pZero;
		active=pOne;
	}
	
}


//getters
public Player getPZer(){
	return pZero;
}
public Player getPOne(){
	return pOne;
}


//System to test animals, attacks and lvl up system
public Player systemTest(){
	int round=0;
	int play=1;
	int whoseTurn=0;
	while(play == 1){
	//check to see if all animals are dead
	if (active.checkLoss()==0){
		play=0;
	}
	
	else if(active.getActive().getHpRem()<=0){
		//play next animal
			//find index of dead active
		active.switchAnimal();	
		//set next animal as active and print results to screen
	}
	
	
	//make move	
	active.chooseAttack();
	//switch turn
	tmp=inactive;
	inactive=active;
	active=tmp;
	
	//increment round if both players have moved
	if(whoseTurn==0){
		whoseTurn++;
	}
	if(whoseTurn==1){
		round++;
		whoseTurn=0;
	}
		
}
//end of battle
	//apply exp earned to total exp to all fighting animals.
	for(int i=0;i<3;i++){
		pZero.getAnimalsCur().get(i).addExpTot(pZero.getAnimalsCur().get(i).getExpErnd());
		pOne.getAnimalsCur().get(i).addExpTot(pOne.getAnimalsCur().get(i).getExpErnd());
	}
return inactive;
}
	

public Player play(){
	int round=0;
	int play=1;
	int whoseTurn=0;
	while(play == 1){
	//check to see if all animals are dead
	if (active.checkLoss()==0){
		play=0;
	}
	if(active.getActive().getHpRem()<=0){
		//prompt switch charicters bc active is dead
	}
	
	//prompt pick move 
	
	//switch turn
	tmp=inactive;
	inactive=active;
	active=tmp;
	
	//increment round if both players have moved
	if(whoseTurn==0){
		whoseTurn++;
	}
	if(whoseTurn==1){
		round++;
		whoseTurn=0;
	}
		
}
//end of battle
	//apply exp earned to total exp to all fighting animals.
	for(int i=0;i<3;i++){
		pZero.getAnimalsCur().get(i).addExpTot(pZero.getAnimalsCur().get(i).getExpErnd());
		pOne.getAnimalsCur().get(i).addExpTot(pOne.getAnimalsCur().get(i).getExpErnd());
	}
	return inactive;
}
}
