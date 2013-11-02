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
	
//attack functions
public int calcDmg(double att){
	
double r= rand.nextDouble();
double r2= rand.nextDouble();
int dmgDone= (int) Math.round((dmg)*(att));
double percentDamage= r+consist;
//check to see what percent of total damage will land, maxing out at 100
if(r+consist>1){
	percentDamage=1;
}
//if critical hit damage gets up to 30% boost
if((1-percentDamage)>=critHitChance){
	percentDamage=percentDamage+percentDamage*((r2/2)+.5);
	System.out.print("Critical Hit");
}

//calc damage done
dmgDone=(int)Math.round(dmgDone*percentDamage);

return dmgDone;	
}


public void useAttack(Animal attacker, Animal target){
//subrtact ap
attacker.subApRem(apCost);

double r=rand.nextDouble();

//see if attack hits
double missChance=(1-acc);
missChance=missChance/(target.getEvd()/1000);


//if random number is > than miss chance attacks hits
if(r>=missChance){
	double dmg=calcDmg(attacker.getAtt());
	
	//scale r  
	r=rand.nextDouble();
	r=r/2;
	r=(1-r);
	
	dmg=(dmg/(target.getDef()*r));
	target.subHpRem((int) Math.round(dmg));
	System.out.print("\n");
	System.out.println("Your attack did ");
	System.out.println(dmg);
	System.out.print("\n");

}
//otherwise attack misses
else{
	System.out.print("\n");
	System.out.println("Your Attack Missed");
}

}

}
