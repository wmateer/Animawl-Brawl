package Game;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Register extends BasicGameState{

	public int getID(){
		return 2;
	}
	
	public Register(int state){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		Image back = new Image("res/back.png");
		back.draw(200, 320, 180, 30);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
	}


}
