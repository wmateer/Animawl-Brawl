package Attacks;
//Used in Special Move for Bull. DO NOT ASSIGN TO OTHER ANIMALS
public class Rush extends Attack {
public Rush(){
			this.setName("Rush");	
			this.setDmg(75);
			this.setConsist(.8);
			this.setAcc(.9);
			this.setCritHitChance(.1);
			this.setApCost(60);
			this.setHeal(0);
		}
}

