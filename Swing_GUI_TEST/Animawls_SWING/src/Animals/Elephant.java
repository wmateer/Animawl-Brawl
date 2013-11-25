package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class Elephant extends Animal {

	public Elephant(String name) {
		super(name);
		// stat set for elephant
		type="Elephant";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=600;
		hpRem=600;
		apTot=90;
		apRem=90;
		att=100;
		def=200;
		evd=20;
		poisoned=0;
		apRegen=9;
		//set attack array for elephant
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Rest());
		attacksAvail.add(new Trunkslap());
		attacksAvail.add(new Watergun());
		
		specialZero= new SuckLife();
		//lvl up statistics for elephant
		hpScaler=8;
		hpBonus=.25;
		apScaler=10;
		apBonus= .15;
		attScaler= 9.5;
		attBonus= .1;
		defScaler=8;
		defBonus=.2;
		evdScaler=10;
		evdBonus=-.05;
		
		imgPath = "IMAGES/CHAR_PICTS/Elephant.jpg";
		Description = "A BEAST CAPABLE OF REMEMBERING THINGS!!!  CAN ALSO TRAMPLE THINGS!!!";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortElephant_PickSound.wav";
		specialDescription= "Suck life from your enemy";

	}
	public void useSpecial(Player inactive){
		//hits damages opp and adds hp to elephant 
		int ammount = specialZero.useAttack(this, inactive.getActive());
		this.addHpRem(ammount);
	}
}
	