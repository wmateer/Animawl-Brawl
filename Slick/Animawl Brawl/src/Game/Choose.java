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
		g.drawString("Please Select Two Animawls", 280, 70);

		// select button
		Image Select = new Image("res/select.png");
		Select.draw(110, 250, 75, 35);
		Select.draw(350, 250, 75, 35);
		Select.draw(615, 250, 75, 35);
		Select.draw(110, 500, 75, 35);
		Select.draw(350, 500, 75, 35);
		Select.draw(615, 500, 75, 35);
		
		//logout button.
		Image logout = new Image("res/logout.png");
		logout.draw(680, 30, 100, 35);

		/* exit button
		g.setColor(Color.yellow);
		g.drawRect(575, 30, 40, 40);
		g.fillRect(575, 30, 40, 40);
		
		g.setColor(Color.black);
		g.drawLine(575, 30, 615, 70);
		g.drawLine(615, 30, 575, 70);
		*/

		Image bear = new Image("res/pedobear.png");
		Image bird = new Image("res/bird.png");
		Image cosmo = new Image("res/Cosmo.png");
		Image gaucho = new Image("res/gaucho.png");
		Image patrick = new Image("res/patrick.png");
		Image pika = new Image("res/pika.png");
		bear.draw(80, 110, 150, 140);
		bird.draw(330,110, 115, 140);
		cosmo.draw(600,110, 115, 140);
		gaucho.draw(70, 340, 150, 140);
		patrick.draw(320, 340, 150, 140);
		pika.draw(580, 340, 150, 140);

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

		if ((posX > 680 && posX < 780) && (posY > 30 && posY < 65)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(0);
		}
	}

	public int getID() {
		return 1;
	}

}
