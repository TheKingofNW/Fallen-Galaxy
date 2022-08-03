// added a comment

package core;

import java.awt.GraphicsEnvironment;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends BasicGameState {
	int id;
	

	Game(int id) {
		this.id = id;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}
	
	int x;
	int y;
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.fillRect(x, y, 100, 100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}

	public int getID() {
		return id;
	}
	
}
