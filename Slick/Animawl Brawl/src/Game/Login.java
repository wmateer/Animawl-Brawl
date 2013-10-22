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
		// select button
		Image Select = new Image("res/select.png");
		Select.draw(80, 200, 75, 35);

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {

		int posX = Mouse.getX();
		int posY = 600 - Mouse.getY();

		if ((posX > 80 && posX < 155) && (posY > 200 && posY < 235)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(1);
		}
	}

	public int getID() {
		return 0;
	}

}
