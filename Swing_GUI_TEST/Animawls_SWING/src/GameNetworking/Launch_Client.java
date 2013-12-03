package GameNetworking;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Animals.*;
import GameEngine.User;

public class Launch_Client {
	public static void main(String[] args) {

	User Henry = new User("Billy","billy");
	Henry.addToChosen(new Bird("Tyler"));
	Henry.addToChosen(new Elephant("Eric"));
	Henry.addToChosen(new Dog("Miles"));

	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
	frame.setTitle("Client");
	frame.setBounds(500, 200, 900, 600);
	frame.getContentPane().setLayout(null);
	JPanel myPanel=new Game_Screen_Client(frame,Henry,"IMAGES/BATTLEGROUND_PICTS/snowstormBig.jpg");
	myPanel.setSize(900,600);
	frame.add(myPanel);
	frame.setVisible(true);
	myPanel.setVisible(true);
	}
}
