package Animals;

//import Animal;
//import Attack;
//import Maul;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class Bear extends Animal {

	public Bear(String name) {
		super(name);
		// stat set for bear
		type="Bear";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=650;
		hpRem=650;
		apTot=90;
		apRem=90;
		att=100;
		def=150;
		evd=25;
		poisoned=0;
		apRegen=8;
		//set attack array for bear
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Maul());
		attacksAvail.add(new Claw());
		attacksAvail.add(new Knockdown());
		//special
		specialZero= new Kamakazee();

		
		//lvl up statistics for bear
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
		
		imgPath = "IMAGES/CHAR_PICTS/Bear.jpg";
		Description = "A TERRIFYING BEAR, HELLBENT ON DESTRUCTION!!!";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortBear_PickSound.wav";
		specialDescription= "So powerfull it damages himself";

	}
	public void useSpecial(Player inactive){
		//very strong attack that also damages bear
		int dmg= specialZero.useAttack(this, inactive.getActive());
		this.subHpRem(dmg/2);

	}
}
	
