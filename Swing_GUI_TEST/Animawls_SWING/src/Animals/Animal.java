package Animals;

//imports
import java.util.*;
import java.io.*;

import Attacks.Attack;

public class Animal {
//Animal Class Protected Variables
protected String name;
public String type;
protected double lvl;	//animals level
protected double expTot;	//exp earned since last lvl up
protected double expToLvl; //exp before next lvl up
protected double expErnd; //exp earned during current battle before applied to animal 
protected double hpTot;	//total hp animal can have
protected double hpRem;	//hp animal has remaining
protected double apTot;	//total ap animal can have
protected double apRem;	//ap animal has remaining
protected double att;	//animal's attack strength
protected double def;	//animals defense strength
protected double evd;	//animals evasiveness 
protected int poisoned;  //determines if animal is poisoned

//lvl up statistics 
protected double hpScaler;
protected double hpBonus;
protected double apScaler;
protected double apBonus;
protected double attScaler;
protected double attBonus;
protected double defScaler;
protected double defBonus;
protected double evdScaler;
protected double evdBonus;
//attacks unlocked
public ArrayList<Attack> attacksAvail;
//all attacks a type can have
protected ArrayList<Attack> allAttacks;
Random rand= new Random();

//PICTURE PATH
public String imgPath;
//DESCRIPTION
public String Description;
//PICK SOUND EFFECT PATH
public String soundPath;

//constructor
public Animal(String name){
//basic animal stats
this.name=name;
lvl=1;
expTot=0;
expErnd=0;
expToLvl=1000;
hpTot=1000;
hpRem=1000;
apTot=1000;
apRem=1000;
att=1;
def=1;
evd=1;	
poisoned=0;

//basic lvl up stats
hpScaler=10;
hpBonus=0;
apScaler=10;
apBonus=0;
attScaler=10;
attBonus=0;
defScaler=10;
defBonus=0;
evdScaler=10;
evdBonus=0;

imgPath = "tmp";
Description = "tmp";
}

//getters and setter
public String getName(){
	return name;	
}

//for LVL
public double getLvl() {
	return 	lvl;
}

public void addLvl(double hpScaler , double hpBonus, double apScaler, double apBonus,double attScaler, double attBonus, double defScaler, double defBonus, double evdScaler, double evdBonus){
		lvl++;
		
		if((lvl/5) == (int)(lvl/5)){
			selectStatModifier();	
		}
	
		System.out.print("\n \n");
		System.out.print(name);
		System.out.print(" is now lvl ");
		System.out.print(lvl);
		System.out.print("\n");
		double r= rand.nextDouble();
		double rTwo=rand.nextDouble();
		int tmp;
		
		//increase hp
		tmp= (int) Math.round(((lvl*10)*((r/hpScaler)+(hpBonus*rTwo))));
		hpTot=hpTot+tmp;
		System.out.print("hp is = ");
		System.out.print(hpTot);
		System.out.print("\n");
		
		//increase ap
		r= rand.nextDouble();
		rTwo=rand.nextDouble();
		tmp= (int) Math.round((lvl*10)*((r/apScaler)+(apBonus*rTwo)));
		apTot=apTot+tmp;
		System.out.print("ap is = ");
		System.out.print(apTot);
		System.out.print("\n");
		
		//increase att
		r= rand.nextDouble();
		rTwo=rand.nextDouble();
		tmp= (int) Math.round((lvl*10)*((r/attScaler)+(attBonus*rTwo)));
		att=att+tmp;
		System.out.print("att is = ");
		System.out.print(att);
		System.out.print("\n");
		
		//increase def
		r= rand.nextDouble();
		rTwo=rand.nextDouble();
		tmp= (int) Math.round((lvl*10)*((r/defScaler)+(defBonus*rTwo)));
		def=def+tmp;
		System.out.print("def is = ");
		System.out.print(def);
		System.out.print("\n");
		
		//increase evd
		r= rand.nextDouble();
		rTwo=rand.nextDouble();
		tmp= (int) Math.round((lvl*10)*((r/evdScaler)+(evdBonus*rTwo)));
		evd=evd+tmp;
		System.out.print("evd is = ");
		System.out.print(evd);
		System.out.print("\n");


		
	}

//for expTot
public double getExp() {
	return 	expTot;
}

public void addExpTot(double amount ) {
	expTot=expTot+amount;
	//print info to screen
	System.out.println(name);
	System.out.print(" gained ");
	System.out.print(amount);
	System.out.print("/");
	System.out.print(expToLvl);
	System.out.print("\n");

	//reset expErnd earned bc it has been applied to expTot
	expErnd=0; 
	//check to see if animal lvled up
	
	if(expTot>=expToLvl){
		
		//call addLvl function using animals animals lvl up statistics 
		addLvl(hpScaler,  hpBonus,  apScaler,  apBonus, attScaler, attBonus, defScaler, defBonus, evdScaler, evdBonus);
		//reset exp
		expTot=expTot-expToLvl;
		//set new amount for next lvl
		expToLvlReset();
		//print to screen
		System.out.println(name);
		System.out.print(" gained a lvl ");
		System.out.print(lvl);
		System.out.print("\n");
	}
}

//for expToLvl
public double expToLvlReset() {
	expToLvl=expToLvl*2;
	return expToLvl;
	
}
public double getExpToLvl(){
	return expToLvl;
}

//for expErnd
public double getExpErnd(){
	return expErnd;
}
public void addExpErnd(int amount){
	expErnd= expErnd+amount;
}

//for hpTot
public double getHpTot(){
	return hpTot;
}
public void addHpTot(int amount){
	hpTot=hpTot+amount;
	
}

//for hpRem
public double getHpRem(){
	return hpRem;
}

public void subHpRem(int amount){
	hpRem=hpRem-amount;
	if (hpRem<=0){
		System.out.print("\nyour ");
		System.out.print(type);
		System.out.print(" ");
		System.out.print(name);
		System.out.print(" is dead");
	}
}

public void addHpRem(int amount){
	hpRem=hpRem+amount;	
}


//for apTot
public double getApTot(){
	return apTot;
}
public void addApTot(int amount){
	apTot=apTot+amount;
	
}
//for apRem
public double getApRem(){
	return apRem;
}

public void subApRem(int amount){
	apRem=apRem-amount;
}

public void addApRem(int amount){
	apRem=apRem+amount;	
}
//for att
public double getAtt() {
	return 	att;
}

//for def
public double getDef() {
	return 	def;
}

//for evd
public double getEvd() {
	return 	evd;
}

//for poisoned
public int getPoisoned() {
	return poisoned;
}

public void setPoisoned(int amount) {
	poisoned = amount;
}

//Stat Modifier 
public void selectStatModifier(){
	System.out.print("You've gained a permenant stat modifier.\n This will Effect the way your charicter levels up throughout the rest of gameplay. \n Enter H (Hp) A (AP) T (att) D (def) or E (evd)  "); 
	char inChar = 0;
	
	char go= 't';
	//loop that gets input until a valid input is found
	do{
		//get input from user
		try {
			inChar=(char)System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	switch (inChar){
	case 'H' : 
		modHp();
		go='f';
		break;
	case 'A' : 
		modAp();
		go='f';
		break;
	case 'T' : 
		modAtt();
		go='f';
		break;
	case 'D' : 
		modDef();
		go='f';
		break;
	case 'E' : 
		modEvd();
		go='f';
		break;
	default :  
		System.out.print("please enter a valid input");
		break;
	}
	
	}while( go=='t');
}

//stat booster functions that modify how your animal grows by altering their lvl up bonuses
public void modHp(){
	double r=rand.nextDouble();
	hpBonus = hpBonus+((r*.35)/hpScaler);
}
public void modAp(){
	double r=rand.nextDouble();
	apBonus = apBonus+((r*.35)/apScaler);
}
public void modAtt(){
	double r=rand.nextDouble();
	attBonus = attBonus+((r*.35)/attScaler);	
}
public void modDef(){
	double r=rand.nextDouble();
	defBonus = defBonus+((r*.35)/defScaler);	
}
public void modEvd(){
	double r=rand.nextDouble();
	evdBonus = evdBonus+((r*.35)/evdScaler);	
}

}

	

