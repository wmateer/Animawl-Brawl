package GameEngine;

//import Player;


public class Game {
//private variables
private Player pOne;
private Player pTwo;

//Constructor
public Game (Player inOne, Player inTwo){
	//set players and pass them their opponents
	pOne=inOne;
	pTwo=inTwo;

	pOne.setOpp(pTwo);
	pTwo.setOpp(pOne);
}


//getters
 public Player getPOne(){
	return pOne;
}
 public Player getPTow(){
	return pTwo;
}


//Start game

public Player play(){
	while(pOne.getActive().getHpRem()>0 & pTwo.getActive().getHpRem()>0){
		pOne.chooseAttack();
		pTwo.chooseAttack();
	}
if(pOne.getActive().getHpRem()<0){
	return pTwo;
}
else{
	return pOne;
}

}
}
