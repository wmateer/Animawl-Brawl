


package gui_WindowBuilder_TEST.GUI;

import javax.swing.*;

import Animals.*;
import GameEngine.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Game_Screen extends JPanel {
	
	//private Tmp_Player pone;
	//private Tmp_Player ptwo;
	
	/*public void setPone(Tmp_Player player1){
		pone = player1;
	}
	
	public void setPtwo(Tmp_Player player2){
		pone = player2;
	}*/
	
	public Game_Screen(JFrame masterFrame) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
//----------------------------------
		
		
		Bear Willis= new Bear("Willis");
		Bear Frank = new Bear("Frank");
		Bear Cindy = new Bear("Cindy");
		
		Bird Kyle = new Bird("Kyle");
		Bird Mindy= new Bird("Mindy");
		Bird Alex= new Bird("Alex");
		
		
		
		Player pone = new Player("bill",Willis, Frank, Cindy);
		Player ptwo = new Player("bob",Kyle, Mindy, Alex);
//---------------------------------------		
		
		
		
		JLabel playAnimawl_title = new JLabel("BATTLE");
		playAnimawl_title.setHorizontalAlignment(SwingConstants.CENTER);
		playAnimawl_title.setFont(new Font("Zapf Dingbats", Font.PLAIN, 23));
		playAnimawl_title.setBounds(238, 25, 197, 33);
		add(playAnimawl_title);
		
		JToggleButton toggleButton = new JToggleButton("Music");
		toggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		toggleButton.setSelected(true);
		toggleButton.setForeground(Color.BLACK);
		toggleButton.setBackground(Color.YELLOW);
		toggleButton.setBounds(497, 17, 72, 17);
		add(toggleButton);

/// USER 1````````````````````````
		
		JLabel lblNewLabel = new JLabel(pone.getName());
		lblNewLabel.setBounds(93, 35, 80, 16);
		add(lblNewLabel);
	
		
		
//ANIMAL 1--------------------------------------------	
		
		JLabel lblUserName = new JLabel(ptwo.getActive().getName());
		lblUserName.setBounds(489, 98, 80, 16);
		add(lblUserName);
//---------------------------------------------------		
		
		

		JLabel Hp = new JLabel("HP ");
		Hp.setBounds(186, 410, 28, 16);
		add(Hp);
		
		JLabel Ap = new JLabel("AP");
		Ap.setBounds(186, 433, 22, 16);
		add(Ap);
		
		JLabel Hpr = new JLabel("HP");
		Hpr.setBounds(399, 410, 22, 16);
		add(Hpr);
		
		JLabel Apr = new JLabel("AP");
		Apr.setBounds(399, 433, 22, 16);
		add(Apr);
		
		
		JLabel pic = new JLabel("Picture Here");
		pic.setBounds(93, 121, 66, 125);
		add(pic);
		
		
		JLabel picr = new JLabel("Picture Here");
		picr.setBounds(454, 121, 80, 76);
		add(picr);
		
		
//ANIMAL 1 --------------------------------------------
		
		JLabel lblAnimal = new JLabel(pone.getActive().getName());
		lblAnimal.setBounds(83, 98, 80, 16);
		add(lblAnimal);
//--------------------------------------------			
		
		
//USER 2----------------------------------------------		
		
		JLabel label_3 = new JLabel(ptwo.getName());
		label_3.setBounds(471, 35, 80, 16);
		add(label_3);
//-----------------------------------------------------		
		
		
		
		UIManager.put("ProgressBar.background", Color.black);
		UIManager.put("ProgressBar.foreground", Color.black);
		UIManager.put("ProgressBar.selectionBackground", Color.black);
		UIManager.put("ProgressBar.selectionForeground", Color.red);
		
		
		
//HP 1 ------------------------------------------------------------
		JProgressBar progressBar = new JProgressBar(0,(int)pone.getActive().getHpTot());
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.red);
		progressBar.setValue((int)pone.getActive().getHpRem());
		
		progressBar.setBackground(Color.RED);
		progressBar.setBounds(210, 406, 60, 20);
		add(progressBar);
//------------------------------------------------------------	
	

//AP 1 ------------------------------------------------------------		
		UIManager.put("ProgressBar.selectionForeground", Color.blue);
		JProgressBar progressBar_1 = new JProgressBar(0,(int)pone.getActive().getApTot());
		progressBar_1.setValue((int)pone.getActive().getApRem());
		progressBar_1.setStringPainted(true);
		progressBar_1.setBackground(Color.RED);
		progressBar_1.setBounds(210, 429, 60, 20);
		add(progressBar_1);
// ------------------------------------------------------------			
		
	
//HP 1 ------------------------------------------------------------	
		UIManager.put("ProgressBar.selectionForeground", Color.red);
		JProgressBar progressBar_2 = new JProgressBar(0,(int)ptwo.getActive().getHpTot());
		progressBar_2.setValue((int)ptwo.getActive().getHpRem());
		progressBar_2.setStringPainted(true);
		progressBar_2.setBackground(Color.RED);
		progressBar_2.setBounds(329, 406, 60, 20);
		add(progressBar_2);
// ------------------------------------------------------------				
	
		
//AP 2 ------------------------------------------------------------				
		UIManager.put("ProgressBar.selectionForeground", Color.blue);
		JProgressBar progressBar_3 = new JProgressBar(0,(int)ptwo.getActive().getApTot());
		progressBar_3.setValue((int)ptwo.getActive().getApRem());
		progressBar_3.setStringPainted(true);
		progressBar_3.setBackground(Color.RED);
		progressBar_3.setBounds(329, 429, 60, 20);
		add(progressBar_3);
// ------------------------------------------------------------			
		
//BUTTONS 1!!------------------------------------------------------		
	
		
		
		final JRadioButton attack1 = new JRadioButton("Maul");
		attack1.setBounds(73, 258, 141, 23);
	
		add(attack1);
		attack1.setVisible(false);

		
		final JRadioButton attack2 = new JRadioButton("Attack2");
		attack2.setBounds(73, 280, 141, 23);

		add(attack2);
		attack2.setVisible(false);
		
		
		final JRadioButton attack3 = new JRadioButton("Attack3");
		attack3.setBounds(73, 302, 141, 23);

		add(attack3);
		attack3.setVisible(false);
		
		JRadioButton special = new JRadioButton("Special");
		special.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack3.setVisible(false);
				attack2.setVisible(false);
				attack1.setVisible(false);	
			}
		});
		special.setBounds(32, 337, 141, 23);
		add(special);
		
		JRadioButton defend = new JRadioButton("Defend");
		defend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack3.setVisible(false);
				attack2.setVisible(false);
				attack1.setVisible(false);	
			}
		});
		defend.setBounds(32, 383, 141, 23);
		add(defend);
		
		JRadioButton switchb = new JRadioButton("Switch Animal");
		switchb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack3.setVisible(false);
				attack2.setVisible(false);
				attack1.setVisible(false);	
			}
		});
		switchb.setBounds(32, 429, 141, 23);
		add(switchb);
		

		final JRadioButton attack = new JRadioButton("Attack");
		
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(attack.isSelected()){
				attack3.setVisible(true);
				attack2.setVisible(true);
				attack1.setVisible(true);	
				}
				if(!attack.isSelected()){
					attack3.setVisible(false);
					attack2.setVisible(false);
					attack1.setVisible(false);		
				}
			}
		});
		attack.setBounds(32, 232, 141, 23);

		add(attack);
		
		
//Buttongroup stufff ------------------
		ButtonGroup buttonGroup = new ButtonGroup();
		ButtonGroup buttonGroupB = new ButtonGroup();
		
		buttonGroup.add(attack1);
		buttonGroup.add(attack2);
		buttonGroup.add(attack3);
		buttonGroup.add(defend);
		buttonGroup.add(special);
		buttonGroup.add(switchb);
		
		buttonGroupB.add(attack);
		buttonGroupB.add(switchb);
		buttonGroupB.add(defend);
		buttonGroupB.add(special);
		
		
//Confirm Button-------------------------------------		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(attack1.isSelected())
				{
				
				}
				
			}
		});
		confirm.setBounds(238, 318, 117, 29);
		add(confirm);
		
//  Right Side buttons		
		
		
		final JRadioButton attack1r = new JRadioButton("Attack1r");
		attack1r.setBounds(453, 258, 141, 23);
		add(attack1r);
		
		final JRadioButton attack2r= new JRadioButton("Attack2r");
		attack2r.setBounds(453, 280, 141, 23);
		add(attack2r);
		
		final JRadioButton attack3r = new JRadioButton("Attack3r");
		attack3r.setBounds(454, 302, 141, 23);
		add(attack3r);
		
		attack1r.setVisible(false);
		attack2r.setVisible(false);
		attack3r.setVisible(false);
		
		JRadioButton specialr = new JRadioButton("Special");
		specialr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack3r.setVisible(false);
				attack2r.setVisible(false);
				attack1r.setVisible(false);
			}
		});
		specialr.setBounds(428, 337, 141, 23);
		add(specialr);
		
		JRadioButton defendr = new JRadioButton("Defend");
		defendr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack3r.setVisible(false);
				attack2r.setVisible(false);
				attack1r.setVisible(false);
			}
		});
		defendr.setBounds(428, 383, 141, 23);
		add(defendr);
		
		JRadioButton switchbr = new JRadioButton("Switch");
		switchbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attack3r.setVisible(false);
				attack2r.setVisible(false);
				attack1r.setVisible(false);
			}
		});
		switchbr.setBounds(428, 429, 141, 23);
		add(switchbr);
		
		final JRadioButton attackr = new JRadioButton("Attackr");
		attackr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(attackr.isSelected()){
					attack3r.setVisible(true);
					attack2r.setVisible(true);
					attack1r.setVisible(true);	
					}
				if(!attackr.isSelected()){
						attack3r.setVisible(false);
						attack2r.setVisible(false);
						attack1r.setVisible(false);		
					}
			}
		});
		attackr.setBounds(428, 232, 141, 23);
		add(attackr);
		
// Right side button group stuff
		
		ButtonGroup buttonGroupr = new ButtonGroup();
		ButtonGroup buttonGroupBr = new ButtonGroup();
		
		buttonGroupr.add(attack1r);
		buttonGroupr.add(attack2r);
		buttonGroupr.add(attack3r);
		buttonGroupr.add(defendr);
		buttonGroupr.add(specialr);
		buttonGroupr.add(switchbr);
		
		buttonGroupBr.add(attackr);
		buttonGroupBr.add(switchbr);
		buttonGroupBr.add(defendr);
		buttonGroupBr.add(specialr);
		
		masterFrame.setSize(900, 600);
		masterFrame.setLocationRelativeTo(null);
	}
}
		
		
		
