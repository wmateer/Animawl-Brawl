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
<<<<<<< HEAD
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


=======
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
>>>>>>> upstream/master

		Image bear = new Image("res/pedobear.png");
		Image bird = new Image("res/bird.png");
		Image cosmo = new Image("res/Cosmo.png");
		Image gaucho = new Image("res/gaucho.png");
		Image patrick = new Image("res/patrick.png");
		Image pika = new Image("res/pika.png");
<<<<<<< HEAD
		bear.draw(90, 110, 115, 130);
		bird.draw(340, 110, 125, 130);
		cosmo.draw(600,110, 115, 130);
		gaucho.draw(75, 330, 125, 130);
		patrick.draw(340, 330, 125, 130);
		pika.draw(585, 330, 135, 130);
=======
		bear.draw(80, 110, 150, 140);
		bird.draw(330,110, 115, 140);
		cosmo.draw(600,110, 115, 140);
		gaucho.draw(70, 340, 150, 140);
		patrick.draw(320, 340, 150, 140);
		pika.draw(580, 340, 150, 140);
>>>>>>> upstream/master

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

<<<<<<< HEAD
		if ((posX > 620 && posX < 745) && (posY > 50 && posY < 85)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(0);
		}
		
=======
		if ((posX > 680 && posX < 780) && (posY > 30 && posY < 65)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(0);
		}
>>>>>>> upstream/master
	}

	public int getID() {
		return 1;
	}

}
