package Game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Login extends BasicGameState {

	public Login(int state) {
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
<<<<<<< HEAD
		 g.setBackground(Color.gray);
		// login button
		Image Login = new Image("res/login.png");
		Login.draw(200, 320, 190, 55);
		// new account button
		Image Register = new Image("res/new_account.png");
		Register.draw(385,327,190, 40);
		
		g.setColor(Color.white);
		g.fillRect(210, 300, 360, 20);
		g.fillRect(210, 275, 360, 20);
		
		g.drawString("Username",135, 275);
		g.drawString("Password", 130, 300);

	}

=======
		// select button
		Image login = new Image("res/login.png");
		login.draw(200, 310, 195, 60);
		// register button
		Image register = new Image("res/new_account.png");
		register.draw(400, 320, 180, 40);
		
		g.setColor(Color.white);
		g.fillRect(210, 295, 370, 20);
		g.fillRect(210, 270, 370, 20);
		g.drawString("Username", 130, 270);
		g.drawString("Password", 130, 295);
	
		

	}

	

>>>>>>> upstream/master
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {

		int posX = Mouse.getX();
		int posY = 600 - Mouse.getY();
<<<<<<< HEAD
		//login
		if ((posX > 200 && posX < 390) && (posY > 320 && posY < 375)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(1);
		}
		//register
		if ((posX > 385 && posX < 575) && (posY > 320 && posY < 367)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(2);
		}
		
=======

		// login button
		if ((posX > 200 && posX < 395) && (posY > 310 && posY < 370)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(1);
		}
		
		//register button
		if ((posX>400 && posX < 580) && (posY > 320 && posY < 360 ) && (Mouse.isButtonDown(0))){
			sbg.enterState(2);
		}
>>>>>>> upstream/master
	}

	public int getID() {
		return 0;
	}

}
