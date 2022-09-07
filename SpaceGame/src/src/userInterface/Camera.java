package userInterface;

import org.newdawn.slick.GameContainer;

import core.Engine;
import entities.Entity;

public class Camera {
	float x, y;
	
	public void update(GameContainer gc) {
		
	}
	
	public float getCameraX() {
		return x;
	}
	
	public float getCameraY() {
		return y;
	}
	
	public void setCameraX(int x) {
		this.x = x;
	}
	
	public void setCameraY(int y) {
		this.y = y;
	}
	
	public boolean isObjectOnScreen(Entity object) {
		return (object.getX() + object.getSize() / 2 > 0 && 
				object.getX() - object.getSize() / 2 < Engine.RESOLUTION_X &&
				object.getY() + object.getSize() / 2 > 0 && 
				object.getY() - object.getSize() / 2 < Engine.RESOLUTION_Y);
	}
	
	public boolean isObjectOnScreen(Entity object, int modifier) {
		return (object.getX() + object.getSize() / 2 > 0 - modifier&& 
				object.getX() - object.getSize() / 2 < Engine.RESOLUTION_X + modifier &&
				object.getY() + object.getSize() / 2 > 0 - modifier && 
				object.getY() - object.getSize() / 2 < Engine.RESOLUTION_Y + modifier);
	}
}
