package ore;

import org.newdawn.slick.Graphics;

public class Meteor {
	int x, y;
	int rotationSpeed;
	int rotation;

	public Meteor(int x, int y, int rotationSpeed) {
		this.x = x;
		this.y = y;
		this.rotationSpeed = rotationSpeed;
	}

	public void render(Graphics g) {
		
	}

	public void update() {
		rotation += rotationSpeed;
	}
}
