package Game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;

public class Register extends BasicGameState{
	public Register(int state){
	}
	
	public int getID() {
		return 2;
	}
	
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		g.setColor(Color.white);
		g.fillRect(250, 300, 360, 30);
		g.fillRect(250, 265, 360, 30);
		g.fillRect(250, 335, 360, 30);
		
		g.drawString("Desired Username", 90, 265);
		g.drawString("Password", 160, 300);
		g.drawString("Re-type Password", 90, 335);
		
		//confirm button
		Image confirm = new Image("res/confirm.png");
		confirm.draw(380,375, 110, 40);
		
		//back button
		Image back = new Image("res/back.png");
		back.draw(500,375,110,40);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		int posX = Mouse.getX();
		int posY = 600 - Mouse.getY();

		if ((posX > 500 && posX < 610) && (posY > 375 && posY < 415)
				&& (Mouse.isButtonDown(0))) {
			sbg.enterState(0);
		}
	}
}
