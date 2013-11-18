package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.util.ArrayList;
import Attacks.*;


public class Bat extends Animal {

	public Bat(String name) {
		super(name);
		// stat set for elephant
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
		
		//set attack array for bat
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Bite());
		attacksAvail.add(new Nightbite());
		//THIRD ATTACK PLACEHOLDER
		attacksAvail.add(new Knockdown());
		

		//lvl up statistics for bat
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
	}
}
	
