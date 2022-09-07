
package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.planets.Planet;
import ore.OreTypes;
import userInterface.enteractables.Button;
import userInterface.enteractables.OreShopButton;

public class Shop extends BasicGameState {

	int id;

	Planet curPlanet;

	ArrayList<OreShopButton> buttons = new ArrayList<>();

	Shop(int id) {
		this.id = id;

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void enter(GameContainer gc, StateBasedGame sbg) {

		curPlanet = Values.player.getCurrentEnteractable();
		System.out.println(curPlanet);
		for (int i = 0; i < OreTypes.values().length; i++) {
			System.out.println(OreTypes.values()[i]);
			buttons.add(new OreShopButton(100, 75 + (i * 51), 700, 50, OreTypes.values()[i], curPlanet.getInventory().getStorage().get(i)));

		}

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.blue);
		
		for (OreShopButton b : buttons) {
			b.render(g);
		}
		drawTitles(g);
		drawShopOutline(g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Button.update(gc);
		for (OreShopButton mainButton : buttons) {
			if (mainButton.isPressed()) {
				mainButton.setSelected(true);
				for (OreShopButton sideButtons : buttons) {
					if (sideButtons != mainButton) {
						sideButtons.setSelected(false);
					}
				}
			}
		}
		if(gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Engine.GAME_ID);
		}
	}
	
	public void leave(GameContainer gc, StateBasedGame sbg) {
		buttons.clear();
	}

	public int getID() {
		return id;
	}

	private void drawShopOutline(Graphics g) {
		g.setColor(Color.white);
		g.setLineWidth(1);
		g.drawLine(100, 75, 800, 75);
		g.drawLine(100, 75, 100, 1005);
		g.drawLine(100, 1005, 1820, 1005);
		g.drawLine(1820, 1005, 1820, 800);
		g.drawLine(1820, 800, 800, 800);
		g.drawLine(800, 800, 800, 75);

	}
	
	private void drawTitles(Graphics g) {
		g.drawString("Ore Type", 130, 55);
		g.drawString("Ore Buy Price", 255, 55);
		g.drawString("Ore Sell Price", 420, 55);
		g.drawString("Amount Remaining", 600, 55);
	}

}
