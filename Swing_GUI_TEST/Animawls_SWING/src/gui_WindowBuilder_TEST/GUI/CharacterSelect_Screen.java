package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CharacterSelect_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame parentFrame;
	private JList availCharChoices_List;
	
	public CharacterSelect_Screen(JFrame masterFrame) {
		/*Player player1 = null;
		Player player2 = null;
		player1.setName("Player 1");
		player2.setName("Player 2");
		*/
		
		setBackground(Color.MAGENTA);
		setLayout(null);
		parentFrame = masterFrame;
		
		JLabel selectedCharPict_Label = new JLabel("CHARACTER PICTURE");
		selectedCharPict_Label.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		selectedCharPict_Label.setForeground(new Color(255, 255, 0));
		selectedCharPict_Label.setBackground(Color.WHITE);
		selectedCharPict_Label.setBounds(5, 66, 170, 170);
		add(selectedCharPict_Label);
		
		final JTextArea selectedCharSelectInfo_TextArea = new JTextArea();
		selectedCharSelectInfo_TextArea.setLineWrap(true);
		selectedCharSelectInfo_TextArea.setText("SELECTED CHARACTER DESCRIPTION");
		selectedCharSelectInfo_TextArea.setBounds(180, 66, 156, 170);
		add(selectedCharSelectInfo_TextArea);
		
		//tmp pop in list
		
		DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("BEAR");
        listModel.addElement("CAT");
        listModel.addElement("RHINO");
        listModel.addElement("SHARK");
        listModel.addElement("FALCON");
        listModel.addElement("SQUID");
		
        
        
		availCharChoices_List = new JList(listModel);
		availCharChoices_List.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				//WHEN LIST SELECTION IS MADE, REFLECT CHANGES IN CHAR PICT AND CHAR INFO
				//need to link list selection with changes on pict char
				//TMP
				//int index = list.getSelectedIndex();
				String tmp = (String) availCharChoices_List.getSelectedValue();
				selectedCharSelectInfo_TextArea.setText(tmp);
			
				
			}
		});
		//need to link to animawl list
		availCharChoices_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		availCharChoices_List.setBounds(341, 66, 103, 170);
		add(availCharChoices_List);
		
		JLabel title_Label = new JLabel("CHARACTER SELECTION");
		title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		title_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title_Label.setForeground(new Color(0, 0, 255));
		title_Label.setBounds(98, 20, 255, 34);
		add(title_Label);
		
		JButton confirmCharChoice_Button = new JButton("CONFIRM CHARACTER CHOICE");
		confirmCharChoice_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//WHEN BUTTON IS PRESSED SAVE THE CURRENTLY CHOSEN CHAR AND CONTINUE TO THE NEXT JPANEL
				//WILL LEAD TO GAME ACTUALLY STARTINGGGGGGGGGGG
				//
				//
			}
		});
		confirmCharChoice_Button.setBounds(107, 248, 237, 29);
		add(confirmCharChoice_Button);
		
		JLabel lblBear = new JLabel("Bear");
		lblBear.setHorizontalAlignment(SwingConstants.CENTER);
		lblBear.setForeground(Color.GREEN);
		lblBear.setBounds(348, 66, 96, 21);
		add(lblBear);

	}
}
