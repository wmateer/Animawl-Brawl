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

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {

		int posX = Mouse.getX();
		int posY = 600 - Mouse.getY();
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
		
	}

	public int getID() {
		return 0;
	}

}
