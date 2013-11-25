package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class FightingFrog extends Animal {

	public FightingFrog(String name) {
		super(name);
		// stat set for FightingFrog
		type="FightingFrog";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=400;
		hpRem=400;
		apTot=110;
		apRem=110;
		att=140;
		def=40;
		evd=140;
		poisoned=0;
		apRegen=12;
		//set attack array for FightingFrog
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Jumppunch());
		attacksAvail.add(new Jumpkick());
		attacksAvail.add(new Knockdown());
		//set up specials
		specialZero= new oneTwo();
		
		//lvl up statistics for FightingFrog
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
		
		imgPath = "IMAGES/CHAR_PICTS/FightingFrog.jpg";
		Description = "A DEMONIC FROG WISHING ONLY PESTILENCE AND DEATH TO EVERYONE!!!";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortFrog_PickSound.wav";
		specialDescription= "Jab with the left, and swing with the right";

	}
	public void useSpecial( Player inactive){
		//hits oppenent twice
	specialZero.useAttack(this, inactive.getActive());
	specialZero.useAttack(this, inactive.getActive());

		}
}
	