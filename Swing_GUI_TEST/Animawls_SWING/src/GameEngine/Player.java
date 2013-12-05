package GameEngine;

//imports
import gui_WindowBuilder_TEST.GUI.playerButtons;

import java.util.*;

import Animals.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Player implements Serializable {
	private static final long serialVersionUID = 2722041087287975845L;
	protected String name;
	protected Animal active;
	protected Player opp;
	protected ArrayList<Animal> animalsAvail;
	protected boolean myTurn=false;
	public ArrayList<Animal> animalsCur;
	
	//gui objects
	public JLabel userName;
	transient public playerButtons UI;
	public JLabel animalName;
	public JLabel currentAnimalPic;
	transient public BufferedImage animalPicture;
	public JProgressBar hpBar;
	public JProgressBar apBar;
	
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  
//constructors

public Player(String input, Animal animal0,Animal animal1, Animal animal2){
	setName(input);
	animalsCur=new ArrayList<Animal>();
	animalsCur.add(animal0);
	animalsCur.add(animal1);
	animalsCur.add(animal2);
	active=animalsCur.get(0);
	
	//establish starting gui objects
	UI= new playerButtons(this);
/*	
	//create username object
	userName= new JLabel(name);
	userName.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
	userName.setForeground(Color.white);
	
	//create animal pic 
	currentAnimalPic = new JLabel(getActive().getName());
	try {
		BufferedImage unsizedAnimalPicture = ImageIO.read(new File(getActive().imgPath));
		BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
		currentAnimalPic.setIcon(new ImageIcon(sizedAnimalPicture));
		
	} catch (IOException e1) {
		 //TODO Auto-generated catch block
		e1.printStackTrace();
	}
	currentAnimalPic.setVisible(true);
	
	//creat animal name label
	animalName=new JLabel(active.getName());
	animalName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	animalName.setForeground(Color.CYAN);
	animalName.setVisible(true);
	
	
	//creat hp bar
	hpBar = new JProgressBar(0,(int)Math.round(getActive().getHpTot()));
	hpBar.setValue((int)Math.round(getActive().getHpTot()));
	hpBar.setForeground(Color.red);
	hpBar.setStringPainted(true);
	hpBar.setBackground(Color.white);
	hpBar.setVisible(true);
	//creat ap bar
	apBar= new JProgressBar(0,(int)Math.round(getActive().getApTot()));
	apBar.setValue((int)Math.round(getActive().getApTot()));
	apBar.setForeground(Color.blue);
	apBar.setStringPainted(true);
	apBar.setBackground(Color.white);
	apBar.setVisible(true);
	*/
}
//create hashmap of animals

//getters and setter
public Animal getActive(){
	return  active;
}

public ArrayList<Animal> getAnimalsCur(){
	return animalsCur;
}

public void setOpp(Player opponent){
		opp=opponent;
}
public Player getOpp(){
	return opp;
}

public void setName(String myName){
	name=myName;
}

public String getName(){
	return name;        
	}
	
public JProgressBar getHpBar(){
	return hpBar;
}
public void  setHpBar(int input){
	hpBar.setValue(input);
}

public JProgressBar getApBar(){
	return apBar;
}

public void setApBar(int input){
	apBar.setValue(input);
}

//TODO move choose animals to USER CLASS and remove animals avail list
//choose animal functions. 
public Animal chooseAnimal() {
	System.out.print("Current animawls available are  ");
	int animalNumb=0;
	
	//loop through array of animals printing out their type and number
	while(animalNumb<= animalsAvail.size()){
		
		System.out.print(animalNumb);
		System.out.print(": ");
		System.out.print((animalsAvail.get(animalNumb)).getType());
		System.out.print(", ");
		animalNumb++;
	}
	
	System.out.println("Please choose your animawl:");
	int inInt=500;
	while(animalNumb<= animalsAvail.size()){
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
	Scanner in = new Scanner(System.in);
	//read input
	System.out.print("Which animal would you like to use ?");
	//make sure input is valid
	int inInt=0;
	inInt=in.nextInt();

	while(0>inInt | (inInt-1)>(animalsCur.size())){
			System.out.println("is not a valid option. Please enter a valid option:" );
			inInt=in.nextInt();	
	}
	
	//set active animal to users choice
	active=animalsCur.get(inInt);
	System.out.println(active.getName());
}

public void switchAnimalGui(int animalNumb){
	active=animalsCur.get(animalNumb);
	animalName.setText(active.getName());
	
	try {
		 animalPicture = ImageIO.read(new File(getActive().imgPath));
		currentAnimalPic.setIcon(new ImageIcon(animalPicture));
	} catch (IOException e1) {
		 //TODO Auto-generated catch block
		e1.printStackTrace();
	}
	UI.updateAttacks();
	UI.checkAp();
	UI.updateAnimals();
	hpBar.setMaximum((int)active.getHpTot());
	hpBar.setValue((int)active.getHpRem());
	
	apBar.setMaximum((int)active.getApTot());
	apBar.setValue((int)active.getApRem());
	
}
	
public String setActive(Animal input){
	active=input;
	return active.getName();
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
	
	active.addExpErnd(active.attacksAvail.get(inInt).useAttack(active , opp.getActive()));
	;
	
}

//check if all animals are dead
public int checkLoss(){
if(animalsCur.get(0).getHpRem()<=0 & animalsCur.get(1).getHpRem()<=0 & animalsCur.get(2).getHpRem()<=0){
	return 0;
}
else{
	return 1;
}


}
public void showUI(){
	UI.showButtons(true);
	UI.checkAp();
}

public void hideUI(){
UI.showButtons(false);
UI.showAttack(false);
UI.showSwitch(false);
}


public void placePzero(){
	//place buttons for pZero in proper spot
	UI.attackButton.setBounds(42, 289, 141, 23);
	UI.attackButton.setForeground(Color.white);
	UI.attackZero.setBounds(84, 324, 141, 23);
	UI.attackZero.setForeground(Color.white);
	UI.attackOne.setBounds(83, 359, 141, 23);
	UI.attackOne.setForeground(Color.white);
	UI.attackTwo.setBounds(84, 394, 141, 23);
	UI.attackTwo.setForeground(Color.white);
	UI.specialButton.setBounds(42, 429, 141, 23);
	UI.specialButton.setForeground(Color.white);
	UI.defendButton.setBounds(42, 479, 141, 23);
	UI.defendButton.setForeground(Color.white);
	UI.switchButton.setBounds(42, 514, 141, 23);
	UI.switchButton.setForeground(Color.white);
	UI.animalZero.setBounds(130, 536, 141, 23);
	UI.animalZero.setForeground(Color.white);
	UI.animalOne.setBounds(130, 560, 141, 23);
	UI.animalOne.setForeground(Color.white);
	UI.animalTwo.setBounds(130, 584, 141, 23);
	UI.animalTwo.setForeground(Color.white);
	//place other player objects
	//currentAnimalPic.setBounds(185, 126, 132, 126);
	currentAnimalPic.setBounds(185, 126, 200, 200);
	hpBar.setBounds(262, 324, 180, 50);	
	apBar.setBounds(262, 356, 180, 50);
	userName.setBounds(185, 60, 132, 44);
	userName.setHorizontalAlignment(SwingConstants.CENTER);
	animalName.setBounds(185, 90, 132, 29);
	animalName.setHorizontalAlignment(SwingConstants.CENTER);




}
public void placeNetworkPlayer(){
	currentAnimalPic.setBounds(557, 126, 200, 200);
	hpBar.setBounds(515, 324, 180, 50);
	apBar.setBounds(515, 352, 180, 50);
	userName.setBounds(587, 60, 132, 44);
	userName.setHorizontalAlignment(SwingConstants.CENTER);
	animalName.setBounds(587, 90, 132, 29);
	animalName.setHorizontalAlignment(SwingConstants.CENTER);
}

public void regenAp(){
	for(int animalNumb=0; animalNumb<3; animalNumb++){
		animalsCur.get(animalNumb).regen();
	}
}

public void setEnabled(Boolean input){
	if (input==false){
	UI.setEnabledButtons(false);
	apBar.setEnabled(false);
	hpBar.setEnabled(false);
	}
	if(input==true){
		UI.setEnabledButtons(true);
		apBar.setEnabled(true);
		hpBar.setEnabled(true);
	}
	
}
public void updateInfo(){
	hpBar.setValue((int)active.getHpRem());
	apBar.setValue((int)active.getApRem());
}
	
}	
