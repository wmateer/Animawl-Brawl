package Animals;

//import Animal;
//import Attack;
//import Bite;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class Dog extends Animal {

	public Dog(String name) {
		super(name);
		// stat set for bear
		type="Dog";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=500;
		hpRem=500;
		apTot=110;
		apRem=110;
		att=100;
		def=100;
		evd=100;
		poisoned = 0;
		
		//set attack array for dog
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Bite());
		attacksAvail.add(new Maul());
		attacksAvail.add(new Headbutt());
		
		//lvl up statistics for dog
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
		
		imgPath = "IMAGES/CHAR_PICTS/Dog.jpg";
		Description = "A LOVELY CORGI!!!  KILLS WITH CUTENESS";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortDog_PickSound.wav";
	}
	public void useSpecial(Player inactive){
		attacksAvail.get(1).useAttack(this, inactive.animalsCur.get(0));
		attacksAvail.get(1).useAttack(this, inactive.animalsCur.get(1));
		attacksAvail.get(1).useAttack(this, inactive.animalsCur.get(2));

	}
}
	