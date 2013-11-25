package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class Bat extends Animal {

	public Bat(String name) {
		super(name);
		// stat set for Bat
		type="Bat";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=400;
		hpRem=400;
		apTot=110;
		apRem=110;
		att=80;
		def=60;
		evd=150;
		poisoned=0;
		apRegen=15;
		//set attack array for Bat
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Bite());
		attacksAvail.add(new Nightbite());
		attacksAvail.add(new Claw());

		//set up special
		specialZero= new Drain();
		//lvl up statistics for Bat
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
		
		imgPath = "IMAGES/CHAR_PICTS/Bat.jpg";
		Description = "A STEALTHY NOTCTURNAL AIRBOURNE BEAST!!!";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortBat_PickSound.wav";
		
		specialDescription= "Drains your oppenets AP";
	}
	public void useSpecial(Player inactive){
		//drains all opp's active's ap
		specialZero.useAttack(this, inactive.getActive());
		inactive.getActive().setApRem(0);
	}
}
	
