package entitys.planets;

import java.util.Vector;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import entitys.Entity;

public class Planet implements Entity{
	
	int x, y;
	int originalX, originalY;
	int size;
	Color color = new Color(
			(int) (Math.random() * 255), 
			(int) (Math.random() * 255), 
			(int) (Math.random() * 255));
	 
	public Planet(int x, int y, int size) {
		this.x = x;
		this.y = y;
		originalX = x;
		originalY = y;
		this.size = size;
	}
	
	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(x - size / 2, y - size / 2, size, size);
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
}
