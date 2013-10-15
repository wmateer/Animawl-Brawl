public class Bird extends Animal {
	public Bird(String name) {
		super(name);
// stat set for bird
		this.name=name;
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=900;
		hpTot=900;
		hpRem=900;
		apTot=100;
		apRem=100;
		att=95;
		def=100;
		evd=300;	
//lvl up statistics for bird
		hpScaler=11;
		hpBonus=0;
		apScaler=10;
		apBonus= 0;
		attScaler= 10;
		attBonus= 0;
		defScaler=10;
		defBonus=.2;
		evdScaler=7.5;
		evdBonus=.45;	
	}
	
}
