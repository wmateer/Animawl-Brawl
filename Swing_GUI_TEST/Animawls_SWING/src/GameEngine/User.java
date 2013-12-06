package GameEngine;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import Animals.*;


public class User implements Serializable {

	private static final long serialVersionUID = 2722041087287975845L;
private String name;
private String password;

//private HashMap<String, Animal> animalMap;
//private HashMap<String, Animal> chosenAnimals;

private HashMap<String, Animal> allAvailAnimalList;
private ArrayList<Animal> chosenAnimals;
private int wins;
private int losses;

/** 
* new user constructor. Makes a user and sets his name and password.
* initializes win and loses to 0.
* @param inName is the user's desired name
* @param inPass is the user's password
*/
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
	
		
		//chosenAnimals=new HashMap<String, Animal>();
		
		chosenAnimals=new ArrayList<Animal>();
		allAvailAnimalList=new HashMap<String, Animal>();
		
		//allAvailAnimalList = new ArrayList<Animal>();
		
		
		//IF ANIMAL MAP EMPTY NEED TO REPOPULATE IT LATER
		allAvailAnimalList.put("Bear", new Bear("Bear"));
		allAvailAnimalList.put("Bird", new Bird("Bird"));
		allAvailAnimalList.put("Bat", new Bat("Bat"));
		allAvailAnimalList.put("Bull", new Bull("Bull"));
		allAvailAnimalList.put("Dog", new Dog("Dog"));
		allAvailAnimalList.put("Elephant", new Elephant("Elephant"));
		allAvailAnimalList.put("Fighting Frog", new FightingFrog("FightingFrog"));
		allAvailAnimalList.put("Snake", new Snake("Snake"));
	}
	

	/** 
	 * if the user selects a animal that he already picked before, returns true.
	 * 
	 * @param paramter
	 */	
	public Boolean HasChosenAlready(Animal chosenAnimal){
		if(chosenAnimals.contains(chosenAnimal)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public ArrayList<Animal> getChosen(){
		return chosenAnimals;
	}
	
	public void addToChosen(Animal chosenAnimal){
		chosenAnimals.add(chosenAnimal);
	}
	
	public void removeAllChosen(){
		chosenAnimals.clear();
	}
	
	public Animal getAnimalAtIndex(int index){
		return chosenAnimals.get(index);
	}
	
	public int getChosenSize() {
		return chosenAnimals.size();
	}
	

	public HashMap<String,Animal> getSavedAnimals(){
		return allAvailAnimalList;
	}
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
	public void clearChosen(){
		chosenAnimals.clear();
	}
	public void removeFromSaved(String removeType){
		allAvailAnimalList.remove(removeType);
	}
	public void addToSaved(String addType, Animal addAni){
		allAvailAnimalList.put(addType,addAni);
	}

}
