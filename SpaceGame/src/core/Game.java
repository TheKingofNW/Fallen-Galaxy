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

import entitys.planets.Planet;
import userInterface.Coordinates;
import userInterface.StarBackground;
import userInterface.UI;

public class Game extends BasicGameState {

	int id;

	UI userInterface = new UI();

	Game(int id) {
		this.id = id;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		for (int i = 0; i < 100; i++) {
			Values.planets.add(new Planet((int) (Math.random() * 10000 - 5000), (int) (Math.random() * 10000 - 5000),
					(int) (Math.random() * 100 + 100)));
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		userInterface.render(g);
		Values.player.render(g);
		for (Planet p : Values.planets) {
			if (Values.camera.isObjectOnScreen(p))
				p.render(g);
			p.setX((int) (p.getOriginalX() + Values.camera.getCameraX()));
			p.setY((int) (p.getOriginalY() + Values.camera.getCameraY()));
		}

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		userInterface.update();
		Values.player.update(gc);

	}

	public int getID() {
		return id;
	}

}
