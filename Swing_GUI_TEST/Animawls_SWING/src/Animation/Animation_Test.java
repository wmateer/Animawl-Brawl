package Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
//import java.util.Timer;

//import javax.management.timer.Timer;
//import javax.swing.ImageIcon;

public class Animation_Test extends JPanel implements ActionListener{

	private Timer animator;
	private ImageIcon imageArray[];
	private int delay = 220, totalFrames = 4, currentFrame = 0;

	
		public Animation_Test() {
			imageArray = new ImageIcon[totalFrames];
			for (int i = 0; i<imageArray.length; i++){
				imageArray[i] = new ImageIcon("frame" + i + ".png");
				
			}
			animator = new Timer(delay, this);
			animator.start();
		}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentFrame >= imageArray.length){
			currentFrame = 0; //restart animation
		}
		
		imageArray[currentFrame].paintIcon(this,  g,  0,  0);
		currentFrame++;
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
}

	

	

