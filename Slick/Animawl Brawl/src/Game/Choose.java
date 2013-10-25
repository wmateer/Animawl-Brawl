package Game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Choose extends BasicGameState {

	public Choose(int state) {
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		// Prompt
		g.setColor(new Color(0, 255, 150));
		g.drawString("Please Select Two Animawls", 270, 50);

		// select button
		Image Select = new Image("res/select.png");
		Select.draw(100, 250, 75, 35);
		Select.draw(360, 250, 75, 35);
		Select.draw(620, 250, 75, 35);
		Select.draw(100, 490, 75, 35);
		Select.draw(360, 490, 75, 35);
		Select.draw(620, 490, 75, 35);

		// logout button
		Image logout = new Image("res/logout.png");
		logout.draw(620, 50, 125, 35);



		Image bear = new Image("res/pedobear.png");
		Image bird = new Image("res/bird.png");
		Image cosmo = new Image("res/Cosmo.png");
		Image gaucho = new Image("res/gaucho.png");
		Image patrick = new Image("res/patrick.png");
		Image pika = new Image("res/pika.png");
		bear.draw(90, 110, 115, 130);
		bird.draw(340, 110, 125, 130);
		cosmo.draw(600,110, 115, 130);
		gaucho.draw(75, 330, 125, 130);
		patrick.draw(340, 330, 125, 130);
		pika.draw(585, 330, 135, 130);

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

	}

	public static void main(String[] args) {
		/*
		 * try { AppGameContainer container = new AppGameContainer(new
		 * Game("Choose")); container.setDisplayMode(640, 480, false);
		 * 
		 * container.start(); } catch (SlickException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		int posX = Mouse.getX();
		int posY = 600 - Mouse.getY();

		if ((posX > 620 && posX < 745) && (posY > 50 && posY < 85)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(0);
		}
		
	}

	public int getID() {
		return 1;
	}

}
