package GameEngine;

import java.io.Serializable;
import java.util.HashMap;

import Animals.*;


public class User implements Serializable {
private String name;
private String password;
private HashMap<String, Animal> animalMap;
private int wins;
private int losses;

//new user constructor
User(String inName,String inPass){
	name=inName;
	password=inPass;
	wins=0;
	losses=0;
	animalMap=new HashMap<String, Animal>();
	Bear Bear = new Bear("bear");
	Bird Bird = new Bird("bird");
	animalMap.put("Bird", Bird);
	animalMap.put("Bear", Bear);
}


//setters and getters
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