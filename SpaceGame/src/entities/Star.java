package entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Star implements Entity{

	int x, y;
	int size;
	int originalX, originalY;
	
	public Star(int x, int y, int size) {
		this.x = x;
		this.y = y;
		originalX = x;
		originalY = y;
		this.size = size;
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		if(size > 2)
			g.fillOval(x, y, size, size);
		else {
			g.fillRect(x, y, size, size);
		}
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public int getOriginalX() {
		return originalX;
	}
	
	public int getOriginalY() {
		return originalY;
	}

	public void setOriginalX(int originalX) {
		this.originalX = originalX;
	}

	public void setOriginalY(int originalY) {
		this.originalY = originalY;
	}

}
