package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.lang.reflect.Method;
import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class Bull extends Animal {

	public Bull(String name) {
		super(name);
		// stat set for elephant
		type="Bull";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=500;
		hpRem=500;
		apTot=110;
		apRem=110;
		att=140;
		def=80;
		evd=80;
		poisoned=0;
		
		//set attack array for elephant
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Headbutt());
		attacksAvail.add( new Charge());
		attacksAvail.add(new Kill());
		
		//set moves needed for special
		specialZero=new Rush();		
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
		
		imgPath = "IMAGES/CHAR_PICTS/Bull.jpg";
		Description = "A RAMPAGING BULL!!! YEARNS FOR BLOOD ON HIS HEELS AND FLESH IN HIS MOUTH!!!";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortBull_PickSound.wav";
	}
	
	public void useSpecial(Player inactive){
		specialZero.useAttack(this, inactive.animalsCur.get(0));
		specialZero.useAttack(this, inactive.animalsCur.get(1));
		specialZero.useAttack(this, inactive.animalsCur.get(2));



	}
}
	