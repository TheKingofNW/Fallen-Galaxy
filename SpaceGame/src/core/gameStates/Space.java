// added a comment

package core.gameStates;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.SpaceValues;
import objects.SpaceShip;

public class Space extends BasicGameState {
	int id;

	public Space(int id) {
		this.id = id;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void enter(GameContainer container, StateBasedGame game) throws SlickException {
		SpaceValues.player = new SpaceShip(0, 0);
		SpaceValues.spaceCam.setTarget((SpaceValues.spaceCam.getTarget() == null) ? SpaceValues.player : null);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		SpaceValues.spaceCam.render(g);
		SpaceValues.player.render(g);
		g.drawRect(100, 100, 100, 100);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		SpaceValues.player.updateInput(gc);
		SpaceValues.player.update();
		
		if(gc.getInput().isKeyPressed(Input.KEY_C)) {
			SpaceValues.spaceCam.setTarget((SpaceValues.spaceCam.getTarget() == null) ? SpaceValues.player : null);
		}
	}

	public void mouseWheelMoved(int changed) {

	}

	public int getID() {
		return id;
	}
}
