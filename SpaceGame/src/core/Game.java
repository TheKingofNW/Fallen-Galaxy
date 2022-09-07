// added a comment

package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.PlanetManager;
import entities.planets.Planet;
import userInterface.UI;

public class Game extends BasicGameState {

	int id;

	UI userInterface = new UI();
	PlanetManager planetManager = new PlanetManager();

//	Planet p = new Planet(1000, 100, 200);
//	Planet u = new Planet(1400, 100, 300);

	Game(int id) {
		this.id = id;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		for (int i = 0; i < 100; i++) {
			planetManager.addPlanet(new Planet((int) (Math.random() * 10000 - 5000), (int) (Math.random() * 10000 - 5000),
					(int) (Math.random() * 100 + 100)));
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.setBackground(Color.black);

		userInterface.render(g);
		
		planetManager.render(g);
		
//		p.render(g);
//		p.setX((int) (p.getOriginalX() + Values.camera.getCameraX()));
//		p.setY((int) (p.getOriginalY() + Values.camera.getCameraY()));
//		u.render(g);
//		u.setX((int) (u.getOriginalX() + Values.camera.getCameraX()));
//		u.setY((int) (u.getOriginalY() + Values.camera.getCameraY()));
		Values.player.render(g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		userInterface.update();
		
		planetManager.update(gc);
		
		Values.player.update(gc, sbg);
//		p.update(gc);
//		u.update(gc);

	}

	public int getID() {
		return id;
	}

}
