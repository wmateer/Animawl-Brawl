package gui_WindowBuilder_TEST.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
//import javax.swing.JPanel;
//import javax.swing.JLabel;
//import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Title_Screen extends JPanel {

	private MusicFrame parentFrame;
	
	/* Class Constructor Creates the title Screen of the Animawl Brawl Game. It displays the Title picture, and is bypassed by 
	 * clicking anywhere on the screen.
	 * <p>
	 * Will Be invoked from the INIT_GUI.java class.
	 * @param masterFrame a MusicFrame that is passed from each panel to the next.
	 */
	public Title_Screen(MusicFrame masterFrame) {

		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				parentFrame.setVisible(false);
				JPanel tmp_Screen = new Login_Screen(parentFrame);
				tmp_Screen.setBorder(new EmptyBorder(5, 5, 5, 5));
				tmp_Screen.setLayout(new BorderLayout(0, 0));
				parentFrame.setContentPane(tmp_Screen);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				parentFrame.setLocation(dim.width/2-parentFrame.getSize().width/2, dim.height/2-parentFrame.getSize().height/2);
				parentFrame.setVisible(true);
				parentFrame.setResizable(false);
				
			}
			
		});
		setBackground(Color.gray);
		parentFrame = masterFrame;
		
		setLayout(null);
		
		JLabel Title_Label = new JLabel("ANIMAWL BRAWL!!!");
		Title_Label.setFont(new Font("Lithos Pro", Font.PLAIN, 25));
		Title_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Title_Label.setBounds(298, 24, 303, 59);
		add(Title_Label);
		
		
		
		JLabel PicturePlaceholder_Label = new JLabel();
		PicturePlaceholder_Label.setHorizontalAlignment(SwingConstants.CENTER);
		PicturePlaceholder_Label.setBounds(28, 76, 866, 447);
		BufferedImage Logo = null;
		try {
			Logo = ImageIO.read(new File("IMAGES/ABLogo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PicturePlaceholder_Label.setIcon(new ImageIcon(Logo));
		add(PicturePlaceholder_Label);
		
		JLabel clickanywhere = new JLabel("Click anywhere to continue");
		clickanywhere.setHorizontalAlignment(SwingConstants.CENTER);
		clickanywhere.setBounds(252, 547, 395, 23);
		add(clickanywhere);



		parentFrame.setSize(900, 600);
		parentFrame.setLocationRelativeTo(null);
		parentFrame.setVisible(true);
	}
}
