package Animals;

//import Animal;
//import Attack;
//import Rest;
//import Trunkslap;
//import Watergun;

import java.util.ArrayList;

import Attacks.*;
import GameEngine.Player;


public class Snake extends Animal {

	public Snake(String name) {
		super(name);
		// stat set for elephant
		type="Snake";
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=1200;
		hpTot=400;
		hpRem=400;
		apTot=110;
		apRem=110;
		att=90;
		def=60;
		evd=120;
		poisoned=0;
		apRegen=12;
		//set attack array for snake
		attacksAvail=new ArrayList<Attack>();
		attacksAvail.add(new Wrap());
		attacksAvail.add(new Poisonbite());
		attacksAvail.add(new Bite());
		
		//TEMP SPECIAL
		specialZero= new Bite();
		
		//lvl up statistics for snake
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
		
		imgPath = "IMAGES/CHAR_PICTS/snake_left.png";
		Description = "A SWEET LOVEABLE PLAYMATE, STILL WILL KILL YOU!!!";
		soundPath = "SOUNDS/PICK_SOUNDS/ShortSnake_PickSound.wav";
		specialDescription= "PLACE HOLDER";

	}
	public void useSpecial(Player inactive){
			attacksAvail.get(1).useAttack(this, inactive.animalsCur.get(0));
			attacksAvail.get(1).useAttack(this, inactive.animalsCur.get(1));
			attacksAvail.get(1).useAttack(this, inactive.animalsCur.get(2));

		}
}
	
