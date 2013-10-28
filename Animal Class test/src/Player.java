//imports
import java.util.*;
import java.io.*;

public class Player {
	protected String name;
	protected Animal active;
	protected Player opp;
	protected ArrayList<Animal> animalsAvail;
	public ArrayList<Animal> animalsCur;
	
//constructors

Player(String input, Animal animal0,Animal animal1, Animal animal2){
	setName(input);
	animalsCur=new ArrayList<Animal>();
	animalsCur.add(animal0);
	animalsCur.add(animal1);
	animalsCur.add(animal2);
	active=animalsCur.get(0);
}

//getters and setter
public Animal getActive(){
	return active;
}

public void setOpp(Player opponent){
		opp=opponent;
}


public void setName(String myName){
	name=myName;
}

public String getName(){
	return name;        
	}
	
			
//choose animal functions. 
public Animal chooseAnimal() {
	System.out.print("Current animawls available are  ");
	int animalNumb=0;
	//loop through array of animals printing out their type and number
	while(animalNumb<= animalsAvail.size()){
		
		System.out.print(animalNumb);
		System.out.print(": ");
		System.out.print((animalsAvail.get(animalNumb)).type);
		System.out.print(", ");
		animalNumb++;
	}
	
	System.out.println("Please choose your animawl:");
	int inInt=500;
	while(inInt<0 | inInt>(animalsAvail.size())){
	try {
		inInt=(char)System.in.read();
	} catch (IOException e) {
		e.printStackTrace();
		if(inInt<0 | inInt>(animalsAvail.size())){
			System.out.println("Please enter a Valid Animal Number ");
		}
		}
	}
	return animalsAvail.get(inInt);
	}
	

// function to switch animals	
public void switchAnimal() {
	int inInt=500;
	//make sure input is valid
	while(inInt<0 | inInt>(animalsCur.size())){
	try {
		inInt=(char)System.in.read();
	} catch (IOException e) {
		e.printStackTrace();
		if(inInt<0 | inInt>(animalsCur.size())){
			System.out.println("Please enter a Valid Animal Number ");
		}
		}
	}
	//set active animal to users choice
	active=animalsCur.get(inInt);
}
	


public void chooseAttack(){
	Scanner in = new Scanner(System.in);

	System.out.print("Here is a list of your fighting animawls attacks:");
	//print attack list
	int attNumb=0;	
	while ((attNumb)<active.attacksAvail.size()){
		System.out.print(attNumb);
		System.out.print(": ");
		System.out.print(active.attacksAvail.get(attNumb).getName());
		System.out.print("\n");
		attNumb++;

	}
	//request user input
	System.out.print("Which attack would you like to use ? Input Attack Number:");
	System.out.print("\n");
	int inInt=0;
	inInt=in.nextInt();
	
	//verify user input
	System.out.print("\n\n\n");
	System.out.println(inInt);

	while(0<inInt | (inInt-1)>(active.attacksAvail.size())){
			System.out.println("is not a valid option. Please enter a valid option:" );
			inInt=in.nextInt();	
	}
	
	//perform chosen attack on active animal
	
	active.attacksAvail.get(inInt).useAttack(active , opp.getActive());
	
}
}	
	
