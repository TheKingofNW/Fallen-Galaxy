// added a comment

package core;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.PlanetManager;
import entities.planets.Planet;
import userInterface.UI;

public class Game extends BasicGameState {

	int id;

	int baseExitCoolDownTimer = 0;
	int exitGameCoolDownTimer = 60;

	UI userInterface = new UI();
	PlanetManager planetManager = new PlanetManager();

	Game(int id) {
		this.id = id;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		for (int i = 0; i < 100; i++) {
			planetManager.addPlanet(new Planet((int) (Math.random() * 10000 - 5000),
					(int) (Math.random() * 10000 - 5000), (int) (Math.random() * 100 + 100)));
		}
	}

	public void enter(GameContainer gc, StateBasedGame sbg) {
		baseExitCoolDownTimer = exitGameCoolDownTimer;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		g.setBackground(Color.black);

		userInterface.render(g);

		planetManager.render(g);
		
		Values.player.render(g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

		baseExitCoolDownTimer--;
		if(baseExitCoolDownTimer < 0) {
			baseExitCoolDownTimer = 0;
		}
		
		userInterface.update();

		planetManager.update(gc);

		Values.player.update(gc, sbg);
		
		
		if (gc.getInput().isKeyPressed(Input.KEY_ESCAPE) && baseExitCoolDownTimer == 0)
			exitingGame();

	}

	public void exitingGame() {
		System.out.println("leaving");
		System.exit(0);
	}

	public int getID() {
		return id;
	}

}
