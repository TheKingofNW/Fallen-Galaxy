package entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import core.Values;
import entities.planets.Planet;

public class PlanetManager {

	ArrayList<Planet> planets = new ArrayList<>();

	public void render(Graphics g) {
		for (Planet p : planets) {
			if (Values.camera.isObjectOnScreen(p)) {
				p.render(g);

			}

		}
		if (Values.debug)
			g.drawLine(planets.get(planets.size() - 1).getX(), planets.get(planets.size() - 1).getY(),
					Values.player.getDrawShipX(), Values.player.getDrawShipY());
	}

	public void update(GameContainer gc) {
		for (Planet p : planets) {
			if (Values.camera.isObjectOnScreen(p)) {
				p.update(gc);
			}
			p.setX((int) (p.getOriginalX() + Values.camera.getCameraX()));
			p.setY((int) (p.getOriginalY() + Values.camera.getCameraY()));

		}

		for (Planet p : planets) {
			if (p.isPlayerNear(p.getSize() * 2)) {
				Values.player.setEnteractable(true);
				Values.player.setCurrentEnteractable(p);
				break;
			} else {
				Values.player.setEnteractable(false);
				Values.player.setCurrentEnteractable(null);
			}
		}
	}

	public void addPlanet(Planet p) {
		planets.add(p);
	}

}
