//import java.util.*;
//import java.lang.*;
//import java.lang.System.*;
public class animalTest {

public static void main (String[] args) {
//test constructor
/*
Animal dog = new Animal("dog");	
System.out.print("your animal is named ");
System.out.print(dog.getName());
System.out.print("\nyour dogs name is ");
System.out.print(dog.getName());
System.out.print("\nyour dogs hp is ");
System.out.print(dog.getHpTot());
System.out.print("\nyour dogs Ap is ");
System.out.print(dog.getApTot());
System.out.print("\nyour dogs att is ");
System.out.print(dog.getAtt());
System.out.print("\nyour dogs def is ");
System.out.print(dog.getDef());
System.out.print("\nyour dogs evd is ");
System.out.print(dog.getEvd());
//test exp system
System.out.print("\nyour animal has ");		
System.out.print(dog.getExp());
System.out.print(" exp");
dog.addExpErnd(99);
dog.addExpTot(dog.getExpErnd());
System.out.print("\nyour animal has ");
System.out.print(dog.getExp());
System.out.print(" exp");
//test level up system
dog.addExpErnd(2);
dog.addExpTot(dog.getExpErnd());
System.out.print("\nyour animal has ");
System.out.print(dog.getExp());
System.out.print(" exp, he needs ");
System.out.print(dog.getExpToLvl());
System.out.print(" to lvl up");
dog.subHpRem(150);

//test bear subclass constructor
Bear willis = new Bear("willis");
Bird Sam = new Bird("Sam");

while (Sam.getHpRem()>0){
(willis.attacksAvail.get(0)).useAttack(willis, Sam);
}

System.out.print("\nyour bears name is ");
System.out.print(willis.getName());
System.out.print("\nyour bears hp is ");
System.out.print(willis.getHpTot());
System.out.print("\nyour bears Ap is ");
System.out.print(willis.getApTot());
System.out.print("\nyour bears att is ");
System.out.print(willis.getAtt());
System.out.print("\nyour bears def is ");
System.out.print(willis.getDef());
System.out.print("\nyour bears evd is ");
System.out.print(willis.getEvd());

	

//test bear lvl up systme
while (willis.getLvl()<100){
willis.addExpErnd(100);
willis.addExpTot(willis.getExpErnd());
}



//test bird lvl up systmem

while (Sam.getLvl()<10){
Sam.addExpErnd(100);
Sam.addExpTot(Sam.getExpErnd());
}

animationTest test = new animationTest();
test.creatWindow();
}

}
*/
	Bear Willis= new Bear();
	Willis.setName("Willis");
	Bear Frank = new Bear();
	Frank.setName("Frank");
	Bear Cindy = new Bear();
	Cindy.setName("Cindy");
	
	Bird Kyle = new Bird();
	Kyle.setName("Kyle");
	Bird Mindy= new Bird();
	Mindy.setName("Mindy");
	Bird Alex= new Bird();
	Alex.setName("Alex");
	
	Player playerOne= new Player("Henry", Willis, Frank, Cindy);
	Player playerTwo= new Player("Billy",Kyle,Mindy,Alex);
	Game gOne =  new Game(playerOne,playerTwo);
	System.out.println(gOne.play().getName());
	System.out.print(" Wins!");
	


}
}