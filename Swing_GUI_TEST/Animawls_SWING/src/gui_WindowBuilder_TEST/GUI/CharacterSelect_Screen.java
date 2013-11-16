package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import Animals.Animal;
import Animals.Bat;
import Animals.Bear;
import Animals.Bird;
import Animals.Bull;
import Animals.Dog;
import Animals.Elephant;
import Animals.FightingFrog;
import Animals.Snake;
import GameEngine.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.io.*;


public class CharacterSelect_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame parentFrame;
	private JList availCharChoices_List;
	private HashMap <String,Animal> TmpList;
	
	public CharacterSelect_Screen(JFrame masterFrame, User currentUser) {
		
		//set up frame
		setBackground(new Color(60, 179, 113));
		setLayout(null);
		parentFrame = masterFrame;
		
		//set tmpUser so we can pass animals to it
		final User tmpUser = currentUser;
		
		//set up various labels and textarea components
		final JLabel selectedCharPict_Label = new JLabel("\n");
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
		Choose_Lister_Passer();
		
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
				//WILL LEAD TO GAME ACTUALLY STARTINGGGGGGGGGGG
				//if chosen animals is = to three then goes to the game screen
				//int i=0;
				/*for(String key : tmpUser.getChosen().keySet()){
					i++;
				}
				*/
				//if(i<=2){
					
					String tmp = (String) availCharChoices_List.getSelectedValue();
					Animal tmpAnimal = TmpList.get(tmp);
					/*
					if(tmpUser.HasNotChosenAlready(tmpAnimal)){
						tmpUser.addToChosen(tmp, tmpAnimal);
						i++;
					}
					else{
						JOptionPane.showMessageDialog(null, "PLEASE CHOOSE ANOTHER ANIMAL. YOU ALREADY HAVE CHOSEN THIS ANIMAL BEFORE","Error", JOptionPane.ERROR_MESSAGE);
					}
					*/
					if(tmpUser.chosenAnimals.size()<3){
					tmpUser.chosenAnimals.add(tmpAnimal);
					//if(i<3){
						JPanel tmp_Screen = new CharacterSelect_Screen(parentFrame,tmpUser);
						parentFrame.setContentPane(tmp_Screen);
						parentFrame.setVisible(true);
						parentFrame.setResizable(true);
					//}
					}
				//}
				//if(i==3){
					//if not then it goes to another version of the choose screen
					//must choose 3 different animals
					if(tmpUser.chosenAnimals.size()==3){
					JPanel tmp_Screen = new Game_Screen(parentFrame,tmpUser);
					parentFrame.setContentPane(tmp_Screen);
					parentFrame.setVisible(true);
					parentFrame.setResizable(true);
					}
				//}
			
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
		
		JTextArea Animal1_AREA = new JTextArea();
		Animal1_AREA.setBounds(172, 77, 74, 16);
		add(Animal1_AREA);
		
		JTextArea Animal2_AREA = new JTextArea();
		Animal2_AREA.setBounds(172, 103, 74, 16);
		add(Animal2_AREA);
		
		JTextArea Animal3_AREA = new JTextArea();
		Animal3_AREA.setBounds(172, 131, 73, 16);
		add(Animal3_AREA);
		
		
			
			/*
				Animal1_AREA.setText(tmpUser.getChosen().get(key).getName());
			
			
				Animal2_AREA.setText(tmpUser.getChosen().get(key).getName());
			
			
				Animal3_AREA.setText(tmpUser.getChosen().get(key).getName());
			*/
		
		
		parentFrame.setSize(900, 600);
		parentFrame.setLocationRelativeTo(null);
	}	
		
	//public HashMap <String,Animal> Choose_Lister_Passer() {
	public void Choose_Lister_Passer() {
		//must be updated when new animawls are to be added			
		TmpList = new HashMap<String,Animal>();
		TmpList.put("Bear", new Bear("Bear"));
		TmpList.put("Bird", new Bird("Bird"));
		TmpList.put("Bat", new Bat("Bat"));
		TmpList.put("Bull", new Bull("Bird"));
		TmpList.put("Dog", new Dog("Bird"));
		TmpList.put("Elephant", new Elephant("Bird"));
		TmpList.put("Fighting Frog", new FightingFrog("Bird"));
		TmpList.put("Snake", new Snake("Snake"));
	}
}
