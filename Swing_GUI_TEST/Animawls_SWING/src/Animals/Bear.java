package Animals;

//import Animal;
//import Attack;
//import Maul;

import java.util.ArrayList;
import Attacks.*;
import Attacks.Maul;


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
		apTot=110;
		apRem=110;
		att=125;
		def=150;
		evd=25;
		poisoned=0;
		
		//set attack array for bear
		attacksAvail=new ArrayList<Attack>();
		Maul Attack0 = new Maul();
		attacksAvail.add(Attack0);
		
		Claw Attack1 = new Claw();
		attacksAvail.add(Attack1);
		
		Knockdown Attack2 = new Knockdown();
		attacksAvail.add(Attack2);
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
	}
}
	
