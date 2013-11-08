package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.util.ArrayList;
import Attacks.*;


public class FightingFrog extends Animal {

	public FightingFrog(String name) {
		super(name);
		// stat set for elephant
		type="FightingFrog";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=400;
		hpRem=400;
		apTot=110;
		apRem=110;
		att=140;
		def=40;
		evd=140;
		poisoned=0;
		
		//set attack array for elephant
		attacksAvail=new ArrayList<Attack>();
		Jumppunch Attack0 = new Jumppunch();
		attacksAvail.add(Attack0);
		
		Jumpkick Attack1 = new Jumpkick();
		attacksAvail.add(Attack1);
		

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
		
		imgPath = "/Users/whm-ii/Desktop/WORKING_ANIMAL_DIR/Animawl-Brawl/Swing_GUI_TEST/Animawls_SWING/src/gui_WindowBuilder_TEST/GUI/bear.jpg";
		Description = "A TERRIFYING BEAR, HELLBENT ON DESTRUCTION!!!";
	}
}
	