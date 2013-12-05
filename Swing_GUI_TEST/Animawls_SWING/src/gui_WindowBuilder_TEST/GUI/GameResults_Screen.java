package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import GameEngine.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;


public class GameResults_Screen extends JPanel{

	private JFrame parentFrame;
	
	private BufferedImage resizeImage(BufferedImage originalImage, int width, int height, int type) throws IOException {  
        BufferedImage resizedImage = new BufferedImage(width, height, type);  
        Graphics2D g = resizedImage.createGraphics();  
        g.drawImage(originalImage, 0, 0, width, height, null);  
        g.dispose();  
        return resizedImage;  
    }  
	
	public GameResults_Screen(JFrame masterFrame, User user, String gameWinner,double lvl0, double lvl1, double lvl2) {
		parentFrame = masterFrame;
		setBackground(Color.gray);
		setLayout(null);
		
		//get different between animals lvls after battle and before
		double lvld0 = user.getAnimalAtIndex(0).getLvl() - lvl0;
		double lvld1 = user.getAnimalAtIndex(1).getLvl() - lvl1;
		double lvld2 = user.getAnimalAtIndex(2).getLvl() - lvl2;
		
		
		
		
		JLabel title = new JLabel("Winner has defeated the loser!");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Lao Sangam MN", Font.PLAIN, 24));
		title.setBounds(85, 55, 730, 59);
		add(title);
		
		JLabel animalPic0 = new JLabel("New label");
		try {
			BufferedImage unsizedAnimalPicture = ImageIO.read(new File(user.getAnimalAtIndex(0).imgPath));
			BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
			animalPic0.setIcon(new ImageIcon(sizedAnimalPicture));
			
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}
		animalPic0.setHorizontalAlignment(SwingConstants.CENTER);
		animalPic0.setBounds(74, 159, 200, 200);
		add(animalPic0);
		
		JLabel animalPic1 = new JLabel("New label");
		try {
			BufferedImage unsizedAnimalPicture = ImageIO.read(new File(user.getAnimalAtIndex(1).imgPath));
			BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
			animalPic1.setIcon(new ImageIcon(sizedAnimalPicture));
			
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}
		animalPic1.setHorizontalAlignment(SwingConstants.CENTER);
		animalPic1.setBackground(new Color(238, 238, 238));
		animalPic1.setBounds(350, 159, 200, 200);
		add(animalPic1);
		
		JLabel animalPic2 = new JLabel("New label");
		try {
			BufferedImage unsizedAnimalPicture = ImageIO.read(new File(user.getAnimalAtIndex(2).imgPath));
			BufferedImage sizedAnimalPicture = resizeImage(unsizedAnimalPicture,200,200, unsizedAnimalPicture.getType());
			animalPic2.setIcon(new ImageIcon(sizedAnimalPicture));
			
		} catch (IOException e1) {
			 //TODO Auto-generated catch block
			e1.printStackTrace();
		}
		animalPic2.setHorizontalAlignment(SwingConstants.CENTER);
		animalPic2.setBackground(new Color(238, 238, 238));
		animalPic2.setBounds(629, 159, 200, 200);
		add(animalPic2);
		
		JLabel lblNewLabel = new JLabel("Your Team");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(350, 97, 200, 39);
		add(lblNewLabel);
		
		JLabel animalName0 = new JLabel(user.getAnimalAtIndex(0).getName());
		animalName0.setHorizontalAlignment(SwingConstants.CENTER);
		animalName0.setBounds(74, 140, 200, 16);
		add(animalName0);
		
		JLabel animalName1 = new JLabel(user.getAnimalAtIndex(1).getName());
		animalName1.setHorizontalAlignment(SwingConstants.CENTER);
		animalName1.setBounds(350, 140, 200, 16);
		add(animalName1);
		
		JLabel animalName2 = new JLabel(user.getAnimalAtIndex(2).getName());
		animalName2.setHorizontalAlignment(SwingConstants.CENTER);
		animalName2.setBounds(629, 140, 200, 16);
		add(animalName2);
		
		JLabel lvlPrompt0 = new JLabel("New label");
		if(lvld0 == 0){
			lvlPrompt0.setText("Level is "+(user.getAnimalAtIndex(0).getLvl()));		
		}else{
			lvlPrompt0.setText("Leveled up by " +lvld0);
		}
		lvlPrompt0.setBounds(96, 383, 162, 16);
		add(lvlPrompt0);
		
		JLabel lvlPrompt1 = new JLabel("New label");
		if(lvld1 == 0){
			lvlPrompt1.setText("Level is "+(user.getAnimalAtIndex(1).getLvl()));		
		}else{
			lvlPrompt1.setText("Leveled up by " +lvld1);
		}
		lvlPrompt1.setBounds(350, 383, 200, 16);
		add(lvlPrompt1);
		
		JLabel lvlPrompt2 = new JLabel("New label");
		if(lvld2 == 0){
			lvlPrompt2.setText("Level is "+(user.getAnimalAtIndex(2).getLvl()));		
		}else{
			lvlPrompt2.setText("Leveled up by "+lvld2);
		}
		lvlPrompt2.setBounds(629, 383, 200, 16);
		add(lvlPrompt2);
		parentFrame.setLocationRelativeTo(null);
		parentFrame.setSize(900, 600);
		parentFrame.setVisible(true);
	}
}
