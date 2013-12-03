package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;

import java.awt.event.*;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import GameEngine.User;
import Sound.Sound_Playback;

public class BattlegroundSelect_Screen extends JPanel {

	private static final long serialVersionUID = 1L;
	private String currentBattlegroundChoice = "NONE";
	
	private MusicFrame parentFrame;
	private JLabel BattlegroundONE_Picture;
	private JLabel BattlegroundTWO_Picture;
	private JLabel BattlegroundTHREE_Picture;

	private Sound_Playback ForestSound = new Sound_Playback("SOUNDS/PICK_SOUNDS/ShortForest_Sound.wav");
	private Sound_Playback VolcanoSound = new Sound_Playback("SOUNDS/PICK_SOUNDS/ShortVolcano_Sound.wav");
	private Sound_Playback SnowstormSound = new Sound_Playback("SOUNDS/PICK_SOUNDS/ShortSnowstorm_Sound.wav");
	
	private Boolean ForestStart = false;
	private Boolean VolcanoStart = false;
	private Boolean SnowstormStart = false;
	
	/**
	 * The Constructor for the Battle screen.  Takes the MusicFrame to load into as well as the User to save.
	 * Displays Battleground choices to the user and waits for the choice.
	 * @param masterFrame The passed MusicFrame that is used to display the panel data.
	 * @param currentUser The user that is passed to the Game_Screen, and later saved.
	 */
	public BattlegroundSelect_Screen(MusicFrame masterFrame,User currentUser) {
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
		BattlegroundONE_Picture.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/forestBig.jpg";
				setImagesAllBW();
				try{
					BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/forestSmall.jpg"));
					BattlegroundONE_Picture.setIcon(new ImageIcon(BattlePicture));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				//PLAY PICK SOUND//
				stopAllSound();
				ForestSound.play();
				ForestStart = true;
			}
		});
		add(BattlegroundONE_Picture);
		
		JLabel Forest_Label = new JLabel("Forest");
		Forest_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Forest_Label.setBounds(60, 153, 220, 16);
		add(Forest_Label);
		
		//SECOND BATTLEGROUND PICTURE
		BattlegroundTWO_Picture = new JLabel("PICTURE #2");
		BattlegroundTWO_Picture.setHorizontalAlignment(SwingConstants.CENTER);
		BattlegroundTWO_Picture.setBounds(340, 181, 220, 200);
		BattlegroundTWO_Picture.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/volcanoBig.jpg";
				setImagesAllBW();
				try{
					BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/volcanoSmall.jpg"));
					BattlegroundTWO_Picture.setIcon(new ImageIcon(BattlePicture));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				//PLAY PICK SOUND//
				stopAllSound();
				VolcanoSound.play();
				VolcanoStart = true;
			}
			
		});
		add(BattlegroundTWO_Picture);
		
		JLabel Volcano_Label = new JLabel("Volcano");
		Volcano_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Volcano_Label.setBounds(340, 153, 220, 16);
		add(Volcano_Label);
		
		//THIRD BATTLEGROUND PICTURE
		BattlegroundTHREE_Picture = new JLabel("Picture #3");
		BattlegroundTHREE_Picture.setHorizontalAlignment(SwingConstants.CENTER);
		BattlegroundTHREE_Picture.setBounds(620, 181, 220, 200);
		BattlegroundTHREE_Picture.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/snowstormBig.jpg";
				setImagesAllBW();
				try{
					BufferedImage BattlePicture = ImageIO.read(new File("IMAGES/BATTLEGROUND_PICTS/snowstormSmall.jpg"));
					BattlegroundTHREE_Picture.setIcon(new ImageIcon(BattlePicture));
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				//PLAY PICK SOUND//
				stopAllSound();
				SnowstormSound.play();
				SnowstormStart = true;
			}
		});
		add(BattlegroundTHREE_Picture);
		
		JLabel Snow_Label = new JLabel("Snow Storm");
		Snow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Snow_Label.setBounds(620, 153, 220, 16);
		add(Snow_Label);
		
		setImagesAllBW();
		
		//BUTTON DEFINITIONS//
		
		//CONFIRM BUTTON - CHECKS SELECTION, AND MOVES TO GAME SCREEN
		JButton ConfirmChoice_Button = new JButton("Confirm Battleground Choice");
		ConfirmChoice_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!currentBattlegroundChoice.equals("NONE")){
					stopAllSound();
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
		
		JButton whiteDefaultBackground_Button = new JButton("WHITE DEFAULT FOR TESTING");
		whiteDefaultBackground_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setImagesAllBW();
				currentBattlegroundChoice = "IMAGES/BATTLEGROUND_PICTS/whiteDefault.jpg";
			}
		});
		whiteDefaultBackground_Button.setBounds(639, 519, 237, 29);
		add(whiteDefaultBackground_Button);
		
		parentFrame.setSize(900,600);
	}
	//SETS ALL THE IMAGES TO BLACK AND WHITE BY LOADING DIFF IMAGES. //PRIVATE METHOD
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
	
	//MEHTOD THAT STOPS ALL THE ACTIVE SOUNDS //PRIVATE
	private void stopAllSound(){
		if(ForestStart == true){
			ForestSound.stop();
			ForestSound.close();
			ForestStart = false;
		}
		if(VolcanoStart == true){
			VolcanoSound.stop();
			VolcanoSound.close();
			VolcanoStart = false;
		}
		if(SnowstormStart == true){
			SnowstormSound.stop();
			SnowstormSound.close();
			SnowstormStart = false;
		}
	}
}
