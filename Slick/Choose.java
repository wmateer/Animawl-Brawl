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
		g.drawString("Please Select Two Animawls", 200, 50);

		// select button
		Image Select = new Image("res/select.png");
		Select.draw(80, 200, 75, 35);
		Select.draw(280, 200, 75, 35);
		Select.draw(470, 200, 75, 35);
		Select.draw(80, 400, 75, 35);
		Select.draw(280, 400, 75, 35);
		Select.draw(470, 400, 75, 35);

		// exit button
		g.setColor(Color.yellow);
		g.drawRect(575, 30, 40, 40);
		g.fillRect(575, 30, 40, 40);

		g.setColor(Color.black);
		g.drawLine(575, 30, 615, 70);
		g.drawLine(615, 30, 575, 70);

		Image bear = new Image("res/pedobear.png");
		Image bird = new Image("res/bird.png");
		Image cosmo = new Image("res/Cosmo.png");
		Image gaucho = new Image("res/gaucho.png");
		Image patrick = new Image("res/patrick.png");
		Image pika = new Image("res/pika.png");
		bear.draw(60, 80, 115, 110);
		bird.draw(260, 80, 115, 110);
		cosmo.draw(450, 80, 115, 110);
		gaucho.draw(60, 280, 115, 110);
		patrick.draw(260, 280, 115, 110);
		pika.draw(450, 280, 115, 110);

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
		int posY = 480 - Mouse.getY();

		if ((posX > 575 && posX < 615) && (posY > 30 && posY < 70)
				&& (Mouse.isButtonDown(0))) {
			System.exit(0);
		}
	}

	public int getID() {
		return 1;
	}

}
