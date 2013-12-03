package gui_WindowBuilder_TEST.GUI;

//BUILT IN LIBRARIES
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;

import javax.swing.event.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.io.*;

//USER CREATED CLASSES
import Animals.*;
import GameEngine.User;
import Sound.Sound_Playback;


public class CharacterSelect_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	private MusicFrame parentFrame;
	private JList availCharChoices_List;
	private HashMap <String,Animal> TmpList;
	private Boolean hasChosenSomething = false;
	
	private Sound_Playback AnimalSound;
	private Boolean soundStarted = false;
	private JLabel animalType0;
	private JLabel animalType1;
	private JLabel animalType2;
	private JTextArea animalName0;
	private JTextArea animalName1;
	private JTextArea animalName2;
	private JButton   setName2;
	private JButton   setName1;
	private JButton   setName0;
	private Bear Willis = new Bear("Willis");
	private Bird Toby= new Bird("Toby");
	private Bat Nathaniel= new Bat("Nathaniel");
	
	private boolean checkNamed(){
		if(animalType0.getText().equals(animalName0.getText()) && animalType1.getText().equals(animalName1.getText()) && animalType2.getText().equals(animalName2.getText()) ){
			return false;
		}
		return true;
	}
	
	private void skiptogamescreen(User tmpUser){
		stopAnimalSoundPlayback();
		tmpUser.addToChosen(Willis);
		tmpUser.addToChosen(Toby);
		tmpUser.addToChosen(Nathaniel);
		JPanel tmp_Screen = new BattlegroundSelect_Screen(parentFrame,tmpUser);
		parentFrame.setContentPane(tmp_Screen);
		parentFrame.setVisible(true); 
		parentFrame.setResizable(true);
		
	}
	
	
	public CharacterSelect_Screen(MusicFrame masterFrame, User currentUser) {
		//STOP MUSIC//
		//TitleThemeSound.stop();
		//TitleThemeSound.close();
		
		//set up frame
		setBackground(new Color(60, 179, 113));
		setLayout(null);
		parentFrame = masterFrame;
		parentFrame.StopMusic();
		
		
		//set tmpUser so we can pass animals to it
		final User tmpUser = currentUser;
		
		//set up various labels and textarea components
		final JLabel selectedCharPict_Label = new JLabel("");
		selectedCharPict_Label.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		selectedCharPict_Label.setForeground(new Color(255, 255, 0));
		selectedCharPict_Label.setBackground(Color.WHITE);
		selectedCharPict_Label.setBounds(18, 200, 200, 200);
		add(selectedCharPict_Label);
		
		final JTextArea selectedCharSelectInfo_TextArea = new JTextArea();
		selectedCharSelectInfo_TextArea.setWrapStyleWord(true);
		selectedCharSelectInfo_TextArea.setLineWrap(true);
		selectedCharSelectInfo_TextArea.setEditable(false);
		selectedCharSelectInfo_TextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		selectedCharSelectInfo_TextArea.setText("SELECTED CHARACTER DESCRIPTION");
		selectedCharSelectInfo_TextArea.setBounds(18, 409, 552, 147);
		add(selectedCharSelectInfo_TextArea);
		
		JLabel LEVEL_LABEL = new JLabel("LEVEL");
		LEVEL_LABEL.setBounds(230, 192, 48, 16);
		add(LEVEL_LABEL);
		
		JLabel EXP_EARNED_LABEL = new JLabel("EXP EARNED");
		EXP_EARNED_LABEL.setBounds(230, 220, 94, 16);
		add(EXP_EARNED_LABEL);
		
		JLabel EXP_TO_NEXT_LVL_LABEL = new JLabel("EXP TO LEVEL");
		EXP_TO_NEXT_LVL_LABEL.setBounds(230, 248, 94, 16);
		add(EXP_TO_NEXT_LVL_LABEL);
		
		JLabel HP_TOTAL = new JLabel("HP TOTAL");
		HP_TOTAL.setBounds(230, 276, 74, 16);
		add(HP_TOTAL);
		
		JLabel AP_TOTAL = new JLabel("AP TOTAL");
		AP_TOTAL.setBounds(230, 304, 74, 16);
		add(AP_TOTAL);
		
		JLabel ATTACK = new JLabel("ATTACk");
		ATTACK.setBounds(230, 328, 61, 16);
		add(ATTACK);
		
		JLabel DEFENSE = new JLabel("DEFENSE");
		DEFENSE.setBounds(230, 356, 61, 16);
		add(DEFENSE);
		
		JLabel EVADE = new JLabel("EVADE");
		EVADE.setBounds(230, 384, 61, 16);
		add(EVADE);
		
		final JTextArea LEVEL_AREA = new JTextArea();
		LEVEL_AREA.setBounds(376, 192, 54, 16);
		add(LEVEL_AREA);
		
		final JTextArea EXP_EARNED_AREA = new JTextArea();
		EXP_EARNED_AREA.setBounds(376, 220, 54, 16);
		add(EXP_EARNED_AREA);
		
		final JTextArea EXP_TO_LEVEL_AREA = new JTextArea();
		EXP_TO_LEVEL_AREA.setBounds(376, 248, 54, 16);
		add(EXP_TO_LEVEL_AREA);
		
		final JTextArea HP_TOTAL_AREA = new JTextArea();
		HP_TOTAL_AREA.setBounds(376, 276, 54, 16);
		add(HP_TOTAL_AREA);
		
		final JTextArea AP_TOTAL_AREA = new JTextArea();
		AP_TOTAL_AREA.setBounds(376, 304, 54, 16);
		add(AP_TOTAL_AREA);
		
		final JTextArea ATTACK_AREA = new JTextArea();
		ATTACK_AREA.setBounds(376, 328, 54, 16);
		add(ATTACK_AREA);
		
		final JTextArea DEFENSE_AREA = new JTextArea();
		DEFENSE_AREA.setBounds(376, 356, 54, 16);
		add(DEFENSE_AREA);
		
		final JTextArea EVADE_AREA = new JTextArea();
		EVADE_AREA.setBounds(376, 384, 54, 16);
		add(EVADE_AREA);
		
		//Set up list to show available character choices for the user.
		DefaultListModel listModel = new DefaultListModel();
		//Set up the available characters
		Choose_Lister_Passer(tmpUser);
		
		//iterate to add elements to the visual list
		for(String key : TmpList.keySet()){
			listModel.addElement(key);
		}
		
		availCharChoices_List = new JList(listModel);
		availCharChoices_List.setFont(new Font("Engravers MT", Font.PLAIN, 20));
		
		//define the listener for the list of choices of the animals.
		//currently it displays the stats and picture/description of the chosen animal
		availCharChoices_List.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				hasChosenSomething = true;
				
				String tmp = (String) availCharChoices_List.getSelectedValue();
				Animal tmpAnimal = TmpList.get(tmp);

				//SET DESCRIPTION
				selectedCharSelectInfo_TextArea.setText(tmpAnimal.Description);
				try{
					//SET PICTURE
					BufferedImage AnimalPicture = ImageIO.read(new File(tmpAnimal.imgPath));
					selectedCharPict_Label.setIcon(new ImageIcon(AnimalPicture));
					//SET ANIMAL STATS
					LEVEL_AREA.setText(""+tmpAnimal.getLvl());
					EXP_EARNED_AREA.setText(""+tmpAnimal.getExp());
					EXP_TO_LEVEL_AREA.setText(""+tmpAnimal.getExpToLvl());
					HP_TOTAL_AREA.setText(""+tmpAnimal.getHpTot());
					AP_TOTAL_AREA.setText(""+tmpAnimal.getApTot());
					ATTACK_AREA.setText(""+tmpAnimal.getAtt());
					DEFENSE_AREA.setText(""+tmpAnimal.getDef());
					EVADE_AREA.setText(""+tmpAnimal.getEvd());
					
					//PLAY SOUND OF ANIMAL SELECTED EACH TIME//
					playAnimalSound(tmpAnimal.soundPath);
					//Sound_Playback AnimalSound = new Sound_Playback(tmpAnimal.soundPath);
					//AnimalSound.play();
					
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		//need to link to animawl list
		availCharChoices_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availCharChoices_List.setBounds(617, 116, 255, 345);
		add(availCharChoices_List);
		
		JLabel title_Label = new JLabel("CHARACTER SELECTION");
		title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		title_Label.setFont(new Font("Modern No. 20", Font.BOLD, 40));
		title_Label.setForeground(new Color(0, 0, 0));
		title_Label.setBounds(199, 0, 501, 74);
		add(title_Label);
		
		JButton confirmCharChoice_Button = new JButton("CONFIRM CHARACTER CHOICE");
		confirmCharChoice_Button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//WHEN BUTTON IS PRESSED SAVE THE CURRENTLY CHOSEN CHAR AND CONTINUE TO THE NEXT JPANEL
				//WILL LEAD TO GAME ACTUALLY STARTING
				//if number of chosen animals is = to three then goes to the game screen
				
				String tmp = (String) availCharChoices_List.getSelectedValue();
				Animal tmpAnimal = TmpList.get(tmp);
				
				if(tmpUser.getChosenSize()==3){
					
					if(checkNamed()){
						stopAnimalSoundPlayback();
						
						JPanel tmp_Screen = new BattlegroundSelect_Screen(parentFrame,tmpUser);
						parentFrame.setContentPane(tmp_Screen);
						parentFrame.setVisible(true); 
						parentFrame.setResizable(true);
					}else{
						JOptionPane.showMessageDialog(null, "One or more members of your team are not named","Error", JOptionPane.ERROR_MESSAGE);
						
					}
					
				}else if(!tmpUser.HasChosenAlready(tmpAnimal) && hasChosenSomething){
					//String tmpname = tmpAnimal.getName();
						//if there are already 3chosen animals then it goes to next screen
						//must choose 3 different animals at this point (can change later)
						if(tmpUser.getChosenSize()==3){
							
							if(!tmpUser.getChosen().get(2).getName().equals(tmpUser.getChosen().get(2).getType())){
							stopAnimalSoundPlayback();
			
							JPanel tmp_Screen = new BattlegroundSelect_Screen(parentFrame,tmpUser);
							parentFrame.setContentPane(tmp_Screen);
							parentFrame.setVisible(true); 
							parentFrame.setResizable(true);
							}
							animalType2.setText(tmpUser.getAnimalAtIndex(2).getType());
							animalName2.setText(tmpUser.getAnimalAtIndex(2).getName());
							if( animalType2.getText().equals(animalName2.getText())){
								setName2.setVisible(true);
							}
						
							
						}
					
						if(tmpUser.getChosenSize()<3){	
							//animalName nameWindow= new animalName(tmpAnimal);
							//nameWindow.setVisible(true);
							tmpUser.addToChosen(tmpAnimal);						
						}	
						//if less than 3 animals already chosen, then repeat for another animal to choose.
						if(tmpUser.getChosenSize()<3){
							stopAnimalSoundPlayback();
		
							JPanel tmp_Screen = new CharacterSelect_Screen(parentFrame,tmpUser);
							parentFrame.setContentPane(tmp_Screen);
							parentFrame.setVisible(true);
							parentFrame.setResizable(true);
								
						}
						if(tmpUser.getChosenSize()==3){
							
							if(!tmpUser.getChosen().get(2).getName().equals(tmpUser.getChosen().get(2).getType())){
							stopAnimalSoundPlayback();
			
							JPanel tmp_Screen = new BattlegroundSelect_Screen(parentFrame,tmpUser);
							parentFrame.setContentPane(tmp_Screen);
							parentFrame.setVisible(true); 
							parentFrame.setResizable(true);
							}
							if(!animalType1.getText().equals(animalName1.getText())){
							setName1.setVisible(false);
							}
							animalType2.setText(tmpUser.getAnimalAtIndex(2).getType());
							animalName2.setText(tmpUser.getAnimalAtIndex(2).getName());
							if( animalType2.getText().equals(animalName2.getText())){
								setName2.setVisible(true);
							}
						
							
						}

				}else{
					JOptionPane.showMessageDialog(null, "PLEASE CHOOSE ANOTHER ANIMAL.  YOU MAY ONLY HAVE ONE OF EACH ANIMAl","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		

		
		
		
		confirmCharChoice_Button.setBounds(582, 508, 290, 48);
		add(confirmCharChoice_Button);
		
		JLabel Animal1_label = new JLabel("Chosen Animal 1");
		Animal1_label.setBounds(42, 77, 118, 16);
		add(Animal1_label);
		
		JLabel Animal2_label = new JLabel("Chosen Animal 2");
		Animal2_label.setBounds(42, 105, 107, 16);
		add(Animal2_label);
		
		JLabel Animal3_label = new JLabel("Chosen Animal 3");
		Animal3_label.setBounds(42, 131, 107, 16);
		add(Animal3_label);
		
		animalType0 = new JLabel();
		animalType0.setBounds(172, 77, 74, 16);
		add(animalType0);
		
	    animalType1 = new JLabel();
		animalType1.setBounds(172, 103, 74, 16);
		add(animalType1);
		
		animalType2 = new JLabel();
		animalType2.setBounds(172, 131, 73, 16);
		add(animalType2);
		
		animalName0 = new JTextArea();
		animalName0.setBounds(286, 77, 74, 16);
		add(animalName0);
		
		
		animalName1 = new JTextArea();
		animalName1.setBounds(286, 103, 74, 16);
		add(animalName1);
		
	    animalName2 = new JTextArea();
		animalName2.setBounds(286, 131, 74, 16);
		add(animalName2);
		
		JLabel typeLabel = new JLabel("Type");
		typeLabel.setBounds(184, 52, 48, 16);
		add(typeLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(299, 52, 61, 16);
		add(nameLabel);
		
		setName0 = new JButton("Set Name");
		setName0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {				
				if(animalType0.getText().equals(animalName0.getText()) || animalName0.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please choose a valid name for your animal","Error", JOptionPane.ERROR_MESSAGE);
				}else{
				tmpUser.getChosen().get(0).setName(animalName0.getText());
				animalName0.setText(tmpUser.getAnimalAtIndex(0).getName());	
				setName0.setVisible(false);
				}
				
			}
			
		});
		setName0.setBounds(362, 72, 117, 29);
		add(setName0);
		
		setName1 = new JButton("Set Name");
		setName1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//tmpUser.getChosen().get(1).setName(requestName1.getText());
				//requestName1.setText(tmpUser.getAnimalAtIndex(1).getName());
				if(animalType1.getText().equals(animalName1.getText()) || animalName1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please choose a valid name for your animal","Error", JOptionPane.ERROR_MESSAGE);
				}else{
				tmpUser.getChosen().get(1).setName(animalName1.getText());
				animalName1.setText(tmpUser.getAnimalAtIndex(1).getName());	
				setName1.setVisible(false);
				}
				
			}
			
		});
		setName1.setBounds(362, 100, 117, 29);
		add(setName1);
		
		setName2 = new JButton("Set Name");
		setName2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(animalType2.getText().equals(animalName2.getText()) || animalName2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Please choose a valid name for your animal","Error", JOptionPane.ERROR_MESSAGE);
				}else{
				tmpUser.getChosen().get(2).setName(animalName2.getText());
				animalName2.setText(tmpUser.getAnimalAtIndex(2).getName());	
				setName2.setVisible(false);
				}
				
				
			}
			
		});
		setName2.setBounds(362, 126, 117, 29);
		add(setName2);
		
		JButton skipButton = new JButton("next screen");
		skipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				skiptogamescreen(tmpUser);
			}
		});
		skipButton.setBounds(18, 187, 142, 29);
		add(skipButton);
		
		setName0.setVisible(false);
		setName1.setVisible(false);
		setName2.setVisible(false);
		
		
			
		if(tmpUser.getChosenSize()>=1){
			animalType0.setText(tmpUser.getAnimalAtIndex(0).getType());
			animalName0.setText(tmpUser.getAnimalAtIndex(0).getName());
			if( animalType0.getText().equals(animalName0.getText())){
				setName0.setVisible(true);
			}
		}
		if(tmpUser.getChosenSize()>=2){
			animalType1.setText(tmpUser.getAnimalAtIndex(1).getType());
			animalName1.setText(tmpUser.getAnimalAtIndex(1).getName());
			if( animalType1.getText().equals(animalName1.getText())){
				setName1.setVisible(true);
			}
		}
		if(tmpUser.getChosenSize()==3){
			animalType2.setText(tmpUser.getAnimalAtIndex(2).getType());
			animalName2.setText(tmpUser.getAnimalAtIndex(2).getName());
			if( animalType2.getText().equals(animalName2.getText())){
				setName2.setVisible(true);
			}
		}
		
		parentFrame.setSize(900, 600);
		parentFrame.setLocationRelativeTo(null);
	}	
		
	//public HashMap <String,Animal> Choose_Lister_Passer() {
	public void Choose_Lister_Passer(User user) {
		//must be updated when new animawls are to be added
		//SHOULD BE PASSED USER IN
		TmpList = new HashMap<String,Animal>();
		TmpList.putAll(user.getSavedAnimals());
		/*TmpList.put("Bear", new Bear("Roger"));
		TmpList.put("Bird", new Bird("Jemaine"));
		TmpList.put("Bat", new Bat("Bruce"));
		TmpList.put("Bull", new Bull("Silvia"));
		TmpList.put("Dog", new Dog("Doge"));
		TmpList.put("Elephant", new Elephant("Samwise"));
		TmpList.put("Fighting Frog", new FightingFrog("BattleToad"));
		TmpList.put("Snake", new Snake("Stryla"));*/
	}
	
	public void playAnimalSound(String inputPath){
		stopAnimalSoundPlayback();
		AnimalSound = new Sound_Playback(inputPath);
		AnimalSound.play();
		soundStarted = true;
	}
	
	public void stopAnimalSoundPlayback(){
		if(soundStarted == true){
			AnimalSound.stop();
			AnimalSound.close();
		}
	}
}
