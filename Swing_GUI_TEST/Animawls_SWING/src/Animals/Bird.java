package Animals;

//import Animal;
//import Attack;
//import Peck;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;

public class Bird extends Animal {
	public Bird(String name) {
		super(name);
// stat set for bird
		type="Bird";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=900;
		hpTot=400;
		hpRem=400;
		apTot=100;
		apRem=100;
		att=130;
		def=80;
		evd=175;
		poisoned=0;
//set up attacks for bird
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Peck());
		attacksAvail.add(new Wingattack());
		//NEEDS 3 ATTACKS OR IT BREAKS...
		attacksAvail.add(new Rest());

		//set up Special
		specialZero=new Scavange();
		
//lvl up statistics for bird
		hpScaler=11;
		hpBonus=0;
		apScaler=10;
		apBonus= 0;
		attScaler= 10;
		attBonus= 0;
		defScaler=10;
		defBonus=.2;
		evdScaler=7.5;
		evdBonus=.45;
		
		imgPath = "IMAGES/CHAR_PICTS/Bird.jpg";
		Description = "A HAPPY LITTLE BIRD. ABSOLUETELY USELESS";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortBird_PickSound.wav";
	}
	public void useSpecial(Player inactive){
		//hits animal with least remaining health
		int animalNumb=0;
		
		if(inactive.animalsCur.get(0).getHpRem()>inactive.animalsCur.get(1).getHpRem()){
			 animalNumb=1;
		}
		
		if(inactive.animalsCur.get(animalNumb).getHpRem()>inactive.animalsCur.get(2).getHpRem()){
			animalNumb=2;
		}
		specialZero.useAttack(this, inactive.animalsCur.get(animalNumb));
		
	}
}

