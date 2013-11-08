package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import Animals.Animal;
import Animals.Bear;
import Animals.Bird;

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
	
	public CharacterSelect_Screen(JFrame masterFrame) {
		/*Player player1 = null;
		Player player2 = null;
		player1.setName("Player 1");
		player2.setName("Player 2");
		*/
		
		setBackground(Color.MAGENTA);
		setLayout(null);
		parentFrame = masterFrame;
		
		final JLabel selectedCharPict_Label = new JLabel("\n");
		selectedCharPict_Label.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		selectedCharPict_Label.setForeground(new Color(255, 255, 0));
		selectedCharPict_Label.setBackground(Color.WHITE);
		selectedCharPict_Label.setBounds(141, 105, 345, 277);
		add(selectedCharPict_Label);
		
		final JTextArea selectedCharSelectInfo_TextArea = new JTextArea();
		selectedCharSelectInfo_TextArea.setWrapStyleWord(true);
		selectedCharSelectInfo_TextArea.setLineWrap(true);
		selectedCharSelectInfo_TextArea.setEditable(false);
		selectedCharSelectInfo_TextArea.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		selectedCharSelectInfo_TextArea.setText("SELECTED CHARACTER DESCRIPTION");
		selectedCharSelectInfo_TextArea.setBounds(18, 409, 552, 147);
		add(selectedCharSelectInfo_TextArea);
		
		//tmp pop in list
		
		/*DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("BEAR");
        listModel.addElement("CAT");
        listModel.addElement("RHINO");
        listModel.addElement("SHARK");
        listModel.addElement("FALCON");
        listModel.addElement("SQUID");*/
		//availCharChoices_List = new JList(listModel);
		
		DefaultListModel listModel = new DefaultListModel();
		
		Choose_Lister_Passer();
		
		for(String key : TmpList.keySet()){
			listModel.addElement(key);
		}
		
		availCharChoices_List = new JList(listModel);
		availCharChoices_List.setFont(new Font("Engravers MT", Font.PLAIN, 20));
		
		availCharChoices_List.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//WHEN LIST SELECTION IS MADE, REFLECT CHANGES IN CHAR PICT AND CHAR INFO
				//need to link list selection with changes on pict char
				//TMP
				//int index = list.getSelectedIndex();
				String tmp = (String) availCharChoices_List.getSelectedValue();
				
				Animal tmpAnimal = TmpList.get(tmp);
				//SET IMAGE
				
				//SET DESCRIPTION
				selectedCharSelectInfo_TextArea.setText(tmpAnimal.Description);
				try{
					//JLabel selectedCharPict_Label = new JLabel("TESTER");
					BufferedImage AnimalPicture = ImageIO.read(new File(tmpAnimal.imgPath));
					//BufferedImage AnimalPicture = ImageIO.read(new File("/Users/whm-ii/Desktop/WORKING_ANIMAL_DIR/Animawl-Brawl/Swing_GUI_TEST/Animawls_SWING/src/gui_WindowBuilder_TEST/GUI/bear.jpg"));
					selectedCharPict_Label.setIcon(new ImageIcon(AnimalPicture));
					//selectedCharPict_Label.setBounds(5, 66, 170, 170);
					//add(selectedCharPict_Label);
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
		title_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		title_Label.setForeground(new Color(0, 0, 255));
		title_Label.setBounds(199, 0, 501, 72);
		add(title_Label);
		
		JButton confirmCharChoice_Button = new JButton("CONFIRM CHARACTER CHOICE");
		confirmCharChoice_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//WHEN BUTTON IS PRESSED SAVE THE CURRENTLY CHOSEN CHAR AND CONTINUE TO THE NEXT JPANEL
				//WILL LEAD TO GAME ACTUALLY STARTINGGGGGGGGGGG
				JPanel tmp_Screen = new Game_Screen(parentFrame);
				parentFrame.setContentPane(tmp_Screen);
				parentFrame.setVisible(true);
				parentFrame.setResizable(true);
			
			}
		});
		confirmCharChoice_Button.setBounds(582, 508, 290, 48);
		add(confirmCharChoice_Button);
		
		parentFrame.setSize(900, 600);
		parentFrame.setLocationRelativeTo(null);
	}	
		
		
	//public HashMap <String,Animal> Choose_Lister_Passer() {
	public void Choose_Lister_Passer() {
		//must be updated when new animawls are to be added			
		TmpList = new HashMap<String,Animal>();
		TmpList.put("Bear", new Bear("Bear"));
		TmpList.put("Bird", new Bird("Bird"));
	}
}
