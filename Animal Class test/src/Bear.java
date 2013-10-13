import java.util.Random;


public class Bear extends Animal {

	public Bear(String name) {
		super(name);
		//lvl 1 stat set for bear
		lvl=1;
		expTot=0;
		expErnd=0;
		expToLvl=120;
		hpTot=1150;
		hpRem=1150;
		apTot=110;
		apRem=110;
		att=175;
		def=220;
		evd=50;	
		//lvl up statistics for bear
		hpScaler=8;
		hpBonus=.25;
		apScaler=10;
		apBonus= .15;
		attScaler= 9.5;
		attBonus= .1;
		defScaler=8;
		defBonus=.2;
		evdScaler=10;
		evdBonus=-.05;
		
	}
}
	