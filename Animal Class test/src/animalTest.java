//import java.util.*;
//import java.lang.*;
//import java.lang.System.*;
public class animalTest {

public static void main (String[] args) {
//test constructor
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
while (willis.getLvl()<10){
willis.addExpErnd(100);
willis.addExpTot(willis.getExpErnd());
}
}

}


