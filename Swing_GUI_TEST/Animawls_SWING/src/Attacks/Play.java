package Attacks;
//USED IN DOGS SPECIAL MOVE, DO NOT GIVE TO ANIMALS
public class Play extends Attack {
	 public Play(){
			this.setName("Play");	
			this.setDmg(0);
			this.setConsist(.65);
			this.setAcc(.9);
			this.setCritHitChance(.2);
			this.setApCost(70);
			this.setHeal(.3);
		}
}
