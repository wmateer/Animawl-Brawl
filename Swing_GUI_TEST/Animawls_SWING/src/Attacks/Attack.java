package Attacks;

//import Animal;

import java.util.Random;

import Animals.Animal;


//generalized class for all animawl attacks
public class Attack {

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
		if((1-percentDamage)<=critHitChance & (r<.3)){
			//percentDamage=percentDamage+(.3*r);
			percentDamage= .3 + percentDamage;
			System.out.print("Critical Hit");
		}
	}

	//calc damage done
	dmgDone=(int)Math.round(dmgDone*percentDamage);

	return dmgDone;	
	}


	public int useAttack(Animal attacker, Animal target){
	//subrtact ap
	attacker.subApRem(apCost);

	if(heal>0){
		attacker.addHpRem((int) (heal*4));
	}

	else if (poisonchance == 1) {
		if(target.getPoisoned() == 1)
			System.out.print("Enemy is already poisoned. No effect.");
		else
			target.setPoisoned(1);
	}

	else{
		double r=Math.random();

		//see if attack hits
		double missChance=(1-acc);
		missChance=missChance+((target.getEvd()*2)/1000);


		//if random number is > than miss chance attacks hits
		if(r>=missChance){
			double dmg=calcDmg(attacker.getAtt(), target.getDef());
		
			//scale r  

			if(dmg<2){
				System.out.print("Attack completely blocked.\n");
				dmg = 0;
			}
			else{
				target.subHpRem((int) Math.round(dmg));
				target.setHpBar((int) Math.round(target.getHpRem()));
				System.out.print("\n");
				System.out.println("Your attack did ");
				System.out.println(dmg);
				System.out.print("\n");
				//TODO remove this return statement and figure out why dmg is changing between here and return
				return (int)Math.round(dmg);	
			}
		}
		//otherwise attack misses
		else{
			System.out.print("\n");
			System.out.println("Your Attack Missed");
			dmg = 0;
		}

		}
	if(attacker.getPoisoned()==1) {
		attacker.subHpRem(20);
	}
	return (int)Math.round(dmg);	
	}
	}
