package GameNetworking;

import gui_WindowBuilder_TEST.GUI.*;
import javax.swing.*;

import Animals.*;
import GameEngine.User;

public class Launch_Server {
	public static void main(String[] args) {
	User Henry = new User("Henry","henry");
	Henry.addToChosen(new Bull("Matt"));
	Henry.addToChosen(new Bear("Simon"));
	Henry.addToChosen(new Bat("Hunter"));

	MusicFrame frame = new MusicFrame();
	frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	frame.setTitle("Server");
	frame.setBounds(500, 200, 900, 600);
	frame.getContentPane().setLayout(null);
	JPanel myPanel=new Game_Screen_Server(frame,Henry,"IMAGES/BATTLEGROUND_PICTS/snowstormBig.jpg");
	myPanel.setSize(900,600);
	frame.add(myPanel);
	frame.setVisible(true);
	myPanel.setVisible(true);

	}
}
