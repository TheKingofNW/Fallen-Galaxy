package entities.planets;

import java.util.ArrayList;
import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Values;
import entities.Entity;
import ore.OreInventory;
import ore.OreTypes;

public class Planet implements Entity {

	private int x, y;
	private int originalX, originalY;
	private int size;

	OreInventory oreInventory = new OreInventory();

	Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

	public Planet(int x, int y, int size) {
		this.x = x;
		this.y = y;
		originalX = x;
		originalY = y;
		this.size = size;

		for (OreTypes ore : OreTypes.values()) {
			oreInventory.addOreType(ore, (int) (Math.random() * 100));
		}

	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(x - size / 2, y - size / 2, size, size);
		if (Values.debug)
			g.drawOval(x - size * 4 / 2, y - size * 4 / 2, size * 4, size * 4);

	}

	public void update(GameContainer gc) {

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getOriginalX() {
		return originalX;
	}

	public int getOriginalY() {
		return originalY;
	}

	public int getPlanetSize() {
		return size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public OreInventory getInventory() {
		return oreInventory;
	}

	public boolean isPlayerNear(int area) {
		return (int) Math.sqrt(((Values.player.getDrawShipX() - x) * (Values.player.getDrawShipX() - x))
				+ ((Values.player.getDrawShipY() - y) * (Values.player.getDrawShipY() - y))) < area;
	}

	public int distanceFromPlayer() {
		return (int) Math.sqrt(((Values.player.getDrawShipX() - x) * (Values.player.getDrawShipX() - x))
				+ ((Values.player.getDrawShipY() - y) * (Values.player.getDrawShipY() - y)));
	}
}
