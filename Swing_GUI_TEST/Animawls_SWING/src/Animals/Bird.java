package Animals;

//import Animal;
//import Attack;
//import Peck;

import java.util.ArrayList;

import Attacks.Attack;
import Attacks.Peck;
import Attacks.Wingattack;

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
	}
	
}

