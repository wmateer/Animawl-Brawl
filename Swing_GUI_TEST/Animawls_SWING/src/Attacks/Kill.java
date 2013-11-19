package Attacks;
//test attack for killing animals
public class Kill extends Attack {
	public Kill(){
		this.setName("Kill");	
		this.setDmg(1000);
		this.setConsist(1);
		this.setAcc(1);
		this.setCritHitChance(1);
		this.setApCost(0);	
	}
}
