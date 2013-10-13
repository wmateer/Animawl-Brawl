//imports
import java.util.*;

public class Animal {
//Animal Class Protected Variables
protected String name;
protected int lvl;	//animals level
protected int expTot;	//exp earned since last lvl up
protected int expToLvl; //exp before next lvl up
protected int expErnd; //exp earned during current battle before applied to animal 
protected int hpTot;	//total hp animal can have
protected int hpRem;	//hp animal has remaining
protected int apTot;	//total ap animal can have
protected int apRem;	//ap animal has remaining
protected int att;	//animal's attack strength
protected int def;	//animals defense strength
protected int evd;	//animals evasiveness 
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

Random rand= new Random();

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
}

//getters and setter
public String getName(){
	return name;	
}

//for LVL
public int getLvl() {
	return 	lvl;
}

	public void addLvl(double hpScaler , double hpBonus, double apScaler, double apBonus,double attScaler, double attBonus, double defScaler, double defBonus, double evdScaler, double evdBonus){
		lvl++;
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
public int getExp() {
	return 	expTot;
}
public void addExpTot(int amount ) {
	expTot=expTot+amount;
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
	}
}

//for expToLvl
public int expToLvlReset() {
	expToLvl=expToLvl*2;
	return expToLvl;
	
}
public int getExpToLvl(){
	return expToLvl;
}

//for expErnd
public int getExpErnd(){
	return expErnd;
}
public void addExpErnd(int amount){
	expErnd= expErnd+amount;
}


//for hpTot
public int getHpTot(){
	return hpTot;
}
public void addHpTot(int amount){
	hpTot=hpTot+amount;
	
}

//for hpRem
public int getHpRem(){
	return hpRem;
}

public void subHpRem(int amount){
	hpRem=hpRem-amount;
	if (hpRem<=0){
		System.out.print("\nyour ");
		System.out.print(name);
		System.out.print(" is dead");
	}
}

public void addHpRem(int amount){
	hpRem=hpRem+amount;	
}


//for apTot
public int getApTot(){
	return apTot;
}
public void addApTot(int amount){
	apTot=apTot+amount;
	
}
//for apRem
public int getApRem(){
	return apRem;
}

public void subApRem(int amount){
	apRem=apRem-amount;
}

public void addApRem(int amount){
	apRem=apRem+amount;	
}
//for att
public int getAtt() {
	return 	att;
}

//for def
public int getDef() {
	return 	def;
}

//for evd
public int getEvd() {
	return 	evd;
}
}



