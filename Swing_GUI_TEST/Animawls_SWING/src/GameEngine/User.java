package GameEngine;

import java.io.Serializable;
import java.util.ArrayList;
import Animals.*;


public class User implements Serializable {

	private static final long serialVersionUID = 2722041087287975845L;
private String name;
private String password;
//private HashMap<String, Animal> animalMap;

//private HashMap<String, Animal> animalMap;
//private HashMap<String, Animal> chosenAnimals;
public ArrayList<Animal> chosenAnimals;
private int wins;
private int losses;

//new user constructor
public User(String inName,String inPass){
	name=inName;
	password=inPass;
	wins=0;
	losses=0;

	//animalMap=new HashMap<String, Animal>();
	/*
	Bear Bear = new Bear("bear");
	Bird Bird = new Bird("bird");
	animalMap.put("Bird", Bird);
	animalMap.put("Bear", Bear);
	*/

	//animalMap=new HashMap<String, Animal>();
	//chosenAnimals=new HashMap<String, Animal>();
	chosenAnimals=new ArrayList<Animal>();
	
	//IF ANIMAL MAP EMPTY NEED TO REPOPULATE IT LATER
	/*
	animalMap.put("Bear", new Bear("Bear"));
	animalMap.put("Bird", new Bird("Bird"));
	animalMap.put("Bat", new Bat("Bat"));
	animalMap.put("Bull", new Bull("Bird"));
	animalMap.put("Dog", new Dog("Bird"));
	animalMap.put("Elephant", new Elephant("Bird"));
	animalMap.put("Fighting Frog", new FightingFrog("Bird"));
	animalMap.put("Snake", new Snake("Snake"));
	*/
}


//setters and getters
/*
public Boolean HasNotChosenAlready(Animal chosenAnimal){
	if(chosenAnimals.containsValue(chosenAnimal)){
		return false;
	}
	else{
		return true;
	}
}
*/
/*
public HashMap<String,Animal> getChosen(){
	return chosenAnimals;
}
/*

public void addToChosen(String name, Animal chosenAnimal){
	chosenAnimals.put(name, chosenAnimal);
}

public void removeAllChosen(){
	chosenAnimals.clear();
}

/*public HashMap<String,Animal> getSavedAnimals(){
	return animalMap;
}
*/
public int getWins() {
	return wins;
}

public void addWins( ) {
	wins++;
}

public int getLosses() {
	return losses;
}
public void addLosses( ) {
	losses++;
}
public String getName(){
	return name;
}

public void setName(String name){
	this.name=name;
}

public String getPassword(){
	return password;
}

public void setPassword(String password){
	this.password=password;
}

}
