package Attacks;
//DO NOT ASSIGN TO ANIMAL, USED FOR BIRDS SPECIAL
public class Scavange extends Attack {
	public Scavange(){
		this.setName("Scavange");	
		this.setDmg(150);
		this.setConsist(.9);
		this.setAcc(.98);
		this.setCritHitChance(.35);
		this.setApCost(55);	
		this.setHeal(0);
	}
}
