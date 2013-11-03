package Animals;

//import Animal;
//import Attack;
//import Peck;

import java.util.ArrayList;

import Attacks.Attack;
import Attacks.Peck;

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
		hpTot=750;
		hpRem=750;
		apTot=100;
		apRem=100;
		att=95;
		def=100;
		evd=300;	
//set up attacks for bird
		attacksAvail=new ArrayList<Attack>();
		Peck Attack0 = new Peck();
		attacksAvail.add(Attack0);

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
		
		imgPath = "/Users/whm-ii/Desktop/WORKING_ANIMAL_DIR/Animawl-Brawl/Swing_GUI_TEST/Animawls_SWING/src/gui_WindowBuilder_TEST/GUI/bird.jpg";
		Description = "A HAPPY LITTLE BIRD. ABSOLUETELY USELESS";
	}
	
}

