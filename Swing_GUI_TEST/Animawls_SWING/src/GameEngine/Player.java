package GameEngine;

//imports
import Animation.*;
import gui_WindowBuilder_TEST.GUI.playerButtons;

import java.util.*;

import Animals.*;
import Animation.mover;

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
	
	/** 
	 * method that takes in a buffered image and resizes it to the inputted dimensions
	 * 
	 * @param originalImage the buffered image to be resized
	 * @param width the width the resize image will be
	 * @param height the height of the resized image
	 * @type  the type of the inputted buffered image
	 */
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  
//constructors
	/** 
	 * The copy constructor, which sets up a player with animals that belong to the player passed in. 
	 * 
	 * @param input the player that is passed in with his/her animals.
	 */
public void updatePlayer(Player input){
	this.active=input.getActive();
	this.animalsCur.set(0, input.animalsCur.get(0));
	this.animalsCur.set(1, input.animalsCur.get(1));
	this.animalsCur.set(2, input.animalsCur.get(2));
}

/** 
 * constructor for the player. Sets his name, and animals 0-2 into an array list
 * Also initializes the active animal to the first one in array list.
 * Creates the buttons for the player that will be used by the game screen.
 * 
 * @param input the player name
 * @param animal0 first animal
 * @param animal1 second animal
 * @param animal2 third animal
 */
public Player(String input, Animal animal0,Animal animal1, Animal animal2){
	setName(input);
	animalsCur=new ArrayList<Animal>();
	animalsCur.add(animal0);
	animalsCur.add(animal1);
	animalsCur.add(animal2);
	active=animalsCur.get(0);
	
	//establish starting gui objects
	UI= new playerButtons(this);
	
	//create username object
	userName= new JLabel(name);
	userName.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
	userName.setForeground(Color.white);
	
	//create animal pic 
	currentAnimalPic = new JLabel(getActive().getName());
	try {
		//add( new attackmover("IMAGES/CHAR_PICTS/bird_left.png", 0, 200, 5, 0, 1, 1, 80) );
		BufferedImage unsizedAnimalPicture = ImageIO.read(new File(getActive().imgPath));
		BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
		currentAnimalPic.setIcon(new ImageIcon(sizedAnimalPicture));
		//currentAnimalPic.setIcon( new attackmover(getActive().imgPath, 0, 200, 5, 0, 1, 1, 80) );
		//currentAnimalPic.setIcon(new attackmover(sizedAnimalPicture, 0, 200, 5, 0, 1, 1, 80) );
		
		
		
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
	
}


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


/** 
* chooseAnimal() method was made for command line game, no longer used.
* 
* @param paramter
*/
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
	
/** 
* method to switch animals for command line game. not used in main project anymore
* 
* @param paramter
*/
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

/** 
* Switches to the animals that correspond to the input paramter
* 
* @param animalNumb the number of the chosen animal to be switched to.
*/
public void  switchAnimalNetwork(int animalNumb){
	active=animalsCur.get(animalNumb);
	animalName.setText(active.getName());
}

/** 
* Switches the animals for the local game. Also updates all the switch animal buttons and
* the animal picture. Also switches the HP bar and AP bars
* 
* @param animalNumb the number that corresponds to the animal to switch to
*/
public void switchAnimalGui(int animalNumb){
	active=animalsCur.get(animalNumb);
	animalName.setText(active.getName());
	
	try {
		animalPicture = ImageIO.read(new File(getActive().imgPath));
		 BufferedImage sizedAnimalPicture = resizeImage(animalPicture,200,200, animalPicture.getType());
		 
		currentAnimalPic.setIcon(new ImageIcon(sizedAnimalPicture));
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

/** 
* method for choosing attack in command line game
* 
* @param paramter
*/
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

/** 
* checks all animal's HP level and returns 0 if dead and 1 if one of them is alive.
* 
* 
*/
public int checkLoss(){
if(animalsCur.get(0).getHpRem()<=0 & animalsCur.get(1).getHpRem()<=0 & animalsCur.get(2).getHpRem()<=0){
	return 0;
}
else{
	return 1;
}


}

/** 
* Shows the all the buttons for the player.
* 
*/
public void showUI(){
	UI.showButtons(true);
	UI.checkAp();
}
/** 
* Hides the buttons for the player
* 
* 
*/
public void hideUI(){
UI.showButtons(false);
UI.showAttack(false);
UI.showSwitch(false);
}

/** 
* places all of the first players buttons and pictures on the screen.
* also edits the formats 
* 
*/
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
	hpBar.setBounds(222, 324, 180, 50);	
	apBar.setBounds(222, 356, 180, 50);
	userName.setBounds(185, 60, 132, 44);
	userName.setHorizontalAlignment(SwingConstants.CENTER);
	animalName.setBounds(185, 90, 132, 29);
	animalName.setHorizontalAlignment(SwingConstants.CENTER);

}

/** 
* places the player on the network screen.
* 
*/
public void placeNetworkPlayer(){
	currentAnimalPic.setBounds(557, 126, 200, 200);
	hpBar.setBounds(515, 324, 180, 50);
	apBar.setBounds(515, 352, 180, 50);
	userName.setBounds(587, 60, 132, 44);
	userName.setHorizontalAlignment(SwingConstants.CENTER);
	animalName.setBounds(587, 90, 132, 29);
	animalName.setHorizontalAlignment(SwingConstants.CENTER);
}

/** 
* Places all of player 2's buttons on the screen for the local game
* 
* 
*/
public void placePone(){
	//place buttons for pOne in proper spot
	
	UI.attackButton.setBounds(712, 289, 141, 23);
	UI.attackButton.setForeground(Color.white);
	UI.attackZero.setBounds(753, 327, 141, 23);
	UI.attackZero.setForeground(Color.white);
	UI.attackOne.setBounds(753, 359, 141, 23);
	UI.attackOne.setForeground(Color.white);
	UI.attackTwo.setBounds(753, 394, 141, 23);
	UI.attackTwo.setForeground(Color.white);
	UI.specialButton.setBounds(712, 429, 141, 23);
	UI.specialButton.setForeground(Color.white);
	UI.defendButton.setBounds(712, 479, 141, 23);
	UI.defendButton.setForeground(Color.white);
	UI.switchButton.setBounds(712, 514, 141, 23);
	UI.switchButton.setForeground(Color.white);
	UI.animalZero.setBounds(788, 536, 141, 23);
	UI.animalZero.setForeground(Color.white);
	UI.animalOne.setBounds(788, 560, 141, 23);
	UI.animalOne.setForeground(Color.white);
	UI.animalTwo.setBounds(788, 584, 141, 23);
	UI.animalTwo.setForeground(Color.white);
	
	currentAnimalPic.setBounds(557, 126, 200, 200);
	hpBar.setBounds(515, 324, 180, 50);
	apBar.setBounds(515, 352, 180, 50);
	userName.setBounds(587, 60, 132, 44);
	userName.setHorizontalAlignment(SwingConstants.CENTER);
	animalName.setBounds(587, 90, 132, 29);
	animalName.setHorizontalAlignment(SwingConstants.CENTER);
}

/** 
*
* regenerates AP for all the player's animal
* 
*/
public void regenAp(){
	for(int animalNumb=0; animalNumb<3; animalNumb++){
		animalsCur.get(animalNumb).regen();
	}
}

/** 
*
* used to set the buttons enabled when its the player's turn or disabled if not.
* 
*/
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

/** 
* updates the ap/hp bars
*/
public void updateInfo(){
	hpBar.setValue((int)active.getHpRem());
	apBar.setValue((int)active.getApRem());
}
	
}	
