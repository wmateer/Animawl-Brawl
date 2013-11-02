package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	public static final String gamename = "Animawl Brawl";
	public static final int login = 0;
	public static final int choose = 1;
<<<<<<< HEAD
	public static final int register =2;
=======
	public static final int register = 2;
>>>>>>> upstream/master

	public Game(String gamename) {
		super(gamename);
		this.addState(new Login(login));
		this.addState(new Choose(choose));
		this.addState(new Register(register));
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(800, 600, false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(login).init(gc, this);
		this.getState(choose).init(gc, this);
		this.getState(register).init(gc, this);
		this.enterState(login);

	}

}
