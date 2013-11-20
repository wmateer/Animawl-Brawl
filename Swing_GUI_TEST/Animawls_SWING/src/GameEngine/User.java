package GameEngine;

import java.io.Serializable;
import java.util.ArrayList;
import Animals.*;


public class User implements Serializable {

	private static final long serialVersionUID = 2722041087287975845L;
private String name;
private String password;

//private HashMap<String, Animal> animalMap;
//private HashMap<String, Animal> chosenAnimals;
//private ArrayList<Animal> allAvailAnimalList;

private ArrayList<Animal> chosenAnimals;
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
	
		
		//chosenAnimals=new HashMap<String, Animal>();
		
		chosenAnimals=new ArrayList<Animal>();
		//animalMap=new HashMap<String, Animal>();
		
		//allAvailAnimalList = new ArrayList<Animal>();
		
		//IF ANIMAL MAP EMPTY NEED TO REPOPULATE IT LATER
		/*
		animalMap.put("Bear", new Bear("Bear"));
		animalMap.put("Bird", new Bird("Bird"));
		animalMap.put("Bat", new Bat("Bat"));
		animalMap.put("Bull", new Bull("Bull"));
		animalMap.put("Dog", new Dog("Dog"));
		animalMap.put("Elephant", new Elephant("Elephant"));
		animalMap.put("Fighting Frog", new FightingFrog("FightingFrog"));
		animalMap.put("Snake", new Snake("Snake"));
		*/
	}
	
	
	//setters and getters
	
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
	
	/*public void addToChosen(String name, Animal chosenAnimal){
		chosenAnimals.put(name, chosenAnimal);
	}*/
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
