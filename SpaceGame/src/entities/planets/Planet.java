package entities.planets;

import java.util.ArrayList;
import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import ore.Ore;
import ore.ores.Gold;
import ore.ores.Iron;
import ore.ores.Platinum;
import ore.ores.Silver;

public class Planet implements Entity {

	private int x, y;
	private int originalX, originalY;
	private int size;

	ArrayList<ArrayList<Ore>> Inventory = new ArrayList<>();

	Color color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));

	public Planet(int x, int y, int size) {
		this.x = x;
		this.y = y;
		originalX = x;
		originalY = y;
		this.size = size;
		for (int i = 0; i < 5; i++)
			this.addOre(new Iron());
		for (int i = 0; i < 2; i++)
			this.addOre(new Gold());
		for (int i = 0; i < 7; i++)
			this.addOre(new Silver());
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(x - size / 2, y - size / 2, size, size);
	}

	public void update(GameContainer gc, StateBasedGame sbg) {
		System.out.println(Inventory.size() + " Ore Groups ------------------------------------>");
		for (ArrayList<Ore> s : Inventory) {
			System.out.println(s.size() + " " + s.get(0).getType());
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_O)) {
			this.addOre(new Platinum());
		}
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

	public void addOre(Ore newOre) {
		for (ArrayList<Ore> oreGroup : Inventory) {
			if (oreGroup.get(0).getType() == newOre.getType()) {
				oreGroup.add(newOre);
				return;
			}
		}
		ArrayList<Ore> newOreGroup = new ArrayList<>();
		newOreGroup.add(newOre);
		Inventory.add(newOreGroup);
	}

	public void update(GameContainer gc) {

	}
}
