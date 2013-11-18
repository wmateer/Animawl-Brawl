package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import GameEngine.User;

public class BattlegroundSelect_Screen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String currentBattlegroundChoice = "NONE";
	/**
	 * Create the panel.
	 */
	private JFrame parentFrame;
	private JLabel BattlegroundONE_Picture;
	private JLabel BattlegroundTWO_Picture;
	private JLabel BattlegroundTHREE_Picture;
	
	public BattlegroundSelect_Screen(JFrame masterFrame,User currentUser) {
		setBackground(new Color(218, 165, 32));
		setLayout(null);
		
		final User tmpUser = currentUser;
		parentFrame = masterFrame;
		
		JLabel BattlegroundSelectTitle_Label = new JLabel("Choose a Battleground");
		BattlegroundSelectTitle_Label.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		BattlegroundSelectTitle_Label.setHorizontalAlignment(SwingConstants.CENTER);
		BattlegroundSelectTitle_Label.setBounds(286, 87, 327, 62);
		add(BattlegroundSelectTitle_Label);
		
		//FIRST BATTLEGROUND PICTURE
		BattlegroundONE_Picture = new JLabel("PICTURE #1");
		BattlegroundONE_Picture.setHorizontalAlignment(SwingConstants.CENTER);
		BattlegroundONE_Picture.setBounds(60, 181, 220, 200);
		add(BattlegroundONE_Picture);
		
		//SECOND BATTLEGROUND PICTURE
		BattlegroundTWO_Picture = new JLabel("PICTURE #2");
		BattlegroundTWO_Picture.setHorizontalAlignment(SwingConstants.CENTER);
		BattlegroundTWO_Picture.setBounds(340, 181, 220, 200);
		add(BattlegroundTWO_Picture);
		
		//THIRD BATTLEGROUND PICTURE
		BattlegroundTHREE_Picture = new JLabel("Picture #3");
		BattlegroundTHREE_Picture.setHorizontalAlignment(SwingConstants.CENTER);
		BattlegroundTHREE_Picture.setBounds(620, 181, 220, 200);
		add(BattlegroundTHREE_Picture);
		
		setImagesAllBW();
		
		//Try catch to retrieve images
		/*try{
			//SET CHOOSE PICTURE
			BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/forestSmallBW.jpg"));
			BattlegroundONE_Picture.setIcon(new ImageIcon(BattlePicture));
			//SET CHOOSE PICTURE 2
			BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/volcanoSmallBW.jpg"));
			BattlegroundTWO_Picture.setIcon(new ImageIcon(BattlePicture));
			//SET CHOOSE PICTURE 3
			BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/snowstormSmallBW.jpg"));
			BattlegroundTHREE_Picture.setIcon(new ImageIcon(BattlePicture));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}*/
		//BUTTON DEFINITIONS//
		
		//CONFIRM BUTTON - CHECKS SELECTION, AND MOVES TO GAME SCREEN
		JButton ConfirmChoice_Button = new JButton("Confirm Battleground Choice");
		ConfirmChoice_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!currentBattlegroundChoice.equals("NONE")){
					JPanel tmp_Screen = new Game_Screen(parentFrame,tmpUser,currentBattlegroundChoice);
					parentFrame.setContentPane(tmp_Screen);
					parentFrame.setVisible(true); 
					parentFrame.setResizable(true);
				}
				else{
					//PLEASE MAKE A CHOICE
					JOptionPane.showMessageDialog(null, "PLEASE CHOOSE A BATTLEGROUND","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		ConfirmChoice_Button.setBounds(305, 502, 289, 62);
		add(ConfirmChoice_Button);
		
		//FOREST BUTTON - CHANGES CURRENT CHOICE TO FOREST
		JButton ForestButton = new JButton("FOREST");
		ForestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/forestBig.jpg";
				setImagesAllBW();
				try{
					BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/forestSmall.jpg"));
					BattlegroundONE_Picture.setIcon(new ImageIcon(BattlePicture));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		ForestButton.setBounds(113, 431, 117, 29);
		add(ForestButton);

		//VOLCANO BUTTON - CHANGES CURRENT CHOICE TO VOLCANO
		JButton VolcanoButton = new JButton("VOLCANO");
		VolcanoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/volcanoBig.jpg";
				setImagesAllBW();
				try{
					BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/volcanoSmall.jpg"));
					BattlegroundTWO_Picture.setIcon(new ImageIcon(BattlePicture));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		VolcanoButton.setBounds(391, 431, 117, 29);
		add(VolcanoButton);
		
		//SNOWSTORM BUTTON - CHANGES CURRENT CHOICE TO SNOWSTORM
		JButton SnowstormButton = new JButton("SNOWSTORM");
		SnowstormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/snowstormBig.jpg";
				setImagesAllBW();
				try{
					BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/snowstormSmall.jpg"));
					BattlegroundTHREE_Picture.setIcon(new ImageIcon(BattlePicture));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		SnowstormButton.setBounds(680, 431, 117, 29);
		add(SnowstormButton);
		
		parentFrame.setSize(900,600);

	}
	
	private void setImagesAllBW(){
		try{
			//SET CHOOSE PICTURE
			BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/forestSmallBW.jpg"));
			BattlegroundONE_Picture.setIcon(new ImageIcon(BattlePicture));
			//SET CHOOSE PICTURE 2
			BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/volcanoSmallBW.jpg"));
			BattlegroundTWO_Picture.setIcon(new ImageIcon(BattlePicture));
			//SET CHOOSE PICTURE 3
			BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/snowstormSmallBW.jpg"));
			BattlegroundTHREE_Picture.setIcon(new ImageIcon(BattlePicture));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
