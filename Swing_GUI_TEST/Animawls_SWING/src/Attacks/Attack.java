package Attacks;

//import Animal;

import java.io.Serializable;
import java.util.Random;

import Animals.Animal;


//generalized class for all animawl attacks
public class Attack implements Serializable{

//variables for all attacks
	public String name;

	//dmg of attack  (used to calculate damage along with animals attack stat) 
	protected double dmg;

	//used to calc % of damage that this attack will do 
	protected double consist;

	//used to calc chance that attack will land
	protected double acc;

	//chance of crit hit
	protected double critHitChance;
	
	//used for some healing moves
	protected double heal;
	
	//used for poisoning
	protected double poisonchance;

	//ap cost
	protected int apCost;
	
	//TODO description
	protected String description;
	
	Random rand= new Random();
//setters and getters
	public double getDmg(){
		return dmg;
	}
	public void setDmg(double input){
		 dmg=input;
	}
	
	public double getConsist(){
		return consist;
	}
	public void setConsist(double input){
		 consist=input;
	}
	
	public double getCritHitChance(){
		return critHitChance;
	}
	public void setCritHitChance(double input){
		 critHitChance=input;
	}
	public double getAcc(){
		return acc;
	}
	public void setAcc(double input){
		 acc=input;
	}
	public double getApCost(){
		return apCost;
	}
	public void setApCost(int input){
		 apCost=input;
	}
	public String getName(){
		return name;
	}
	public void setName(String input){
		 name=input;
	}
	public double getPoisonchance(){
		return poisonchance;
	}
	public void setPoisonchance(double input){
		 poisonchance=input;
	}
	public double getHeal(){
		return heal;
	}
	public void setHeal(double input){
		heal=input;
	}

	//attack functions
	public int calcDmg(double att, double def){
		
	double r= Math.random();
	double r2=Math.random();

	int dmgDone= (int) Math.round((dmg)+(att)-(def*(.5+(.3*r))));

	double percentDamage= consist + ((1-consist)*r2);

	if(dmgDone>5){
	//if critical hit damage gets up to 30% boost
		if((1-percentDamage)<=critHitChance){
			percentDamage= (.2*r+.15) + percentDamage;
			System.out.print("Critical Hit");
		}
	}

	//calc damage done
	dmgDone=(int)Math.round(dmgDone*percentDamage);

	return dmgDone;	
	}


	public int useAttack(Animal attacker, Animal target){
	double r= Math.random();

	//subrtact ap
	attacker.subApRem(apCost);
	int damage=0;
	//calculate amount of heal
	if(heal>0){
		System.out.println("consist is" + consist);
		double percentHeal= ((consist) + ((1-consist)*r));
		System.out.println(percentHeal);
		if((1-percentHeal)<=critHitChance){
			percentHeal= (int) ((.2*r+.15) + percentHeal);
			System.out.print("Critical Hit");
		}
	
		int ammountHeal = (int)((heal*attacker.getHpTot())*percentHeal);
		attacker.addHpRem(ammountHeal);
		attacker.addExpErnd(ammountHeal);
		return ammountHeal;
	}
	
	
	if (poisonchance == 1) {
		if(target.getPoisoned() == 1)
			System.out.print("Enemy is already poisoned. No effect.");
		else{
			target.setPoisoned(1);
		}
	}

	
		 r=Math.random();

		//see if attack hits
		double missChance=(1-acc);
		missChance=missChance+((target.getEvd()*2)/1000);


		//if random number is > than miss chance attacks hits
		if(r>=missChance){
			 damage=calcDmg(attacker.getAtt(), target.getDef());
		
			//scale r  

			if(damage<2){
				System.out.print("Attack completely blocked.\n");
				damage = 0;
			}
			else{
				target.subHpRem((int) Math.round(damage));
				attacker.addExpErnd((int)damage);
				System.out.print("\n");
				System.out.println("Your attack did ");
				System.out.println(damage);
				System.out.print("\n");
			}
		}
		//otherwise attack misses
		else{
			System.out.print("\n");
			System.out.println("Your Attack Missed");
			damage = 0;
		}

		
	if(attacker.getPoisoned()==1) {
		attacker.subHpRem(20);
	}
	System.out.print("\n AttackerAp");
	System.out.print(attacker.getApRem());
	System.out.print("\n TargetAp");
	System.out.print(target.getApRem());
	System.out.print("\n AttackerHp");
	System.out.print(attacker.getHpRem());
	System.out.print("\n TargetHp");
	System.out.print(target.getHpRem());
	return damage;
	}
	}
