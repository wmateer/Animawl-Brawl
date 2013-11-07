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
		hpTot=1150;
		hpRem=1150;
		apTot=110;
		apRem=110;
		att=175;
		def=220;
		evd=50;	
		
		//set attack array for bear
		attacksAvail=new ArrayList<Attack>();
		Maul Attack0 = new Maul();
		attacksAvail.add(Attack0);
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
		
		imgPath = "IMAGES/CHAR_PICTS/bear.jpg";
		Description = "A TERRIFYING BEAR, HELLBENT ON DESTRUCTION!!!";
	}
}
	