package objects;

import org.newdawn.slick.geom.Point;

public abstract class Entity extends Object{

	protected int maxVelocityX, maxVelocityY;
	protected int velocityX, velocityY;

	public Entity(int x, int y, int width, int height) {
		// defaults max velocities to 40
		this(x, y, width, height, 40, 40);
	}
	
	public Entity(int x, int y, int width, int height, int maxVelocityX, int maxVelocityY) {
		super(x, y, width, height);
		this.maxVelocityX = maxVelocityX;
		this.maxVelocityY = maxVelocityY;
	}

	public void update() {
		addVelocityToPlayer();
	}
	
	protected void addVelocityToPlayer() {
		setX(getX() + getVelocityX());
		setY(getY() + getVelocityY());
	}

	public int getMaxVelocityX() {
		return maxVelocityX;
	}

	public void setMaxVelocityX(int maxVelocityX) {
		this.maxVelocityX = maxVelocityX;
	}

	public int getMaxVelocityY() {
		return maxVelocityY;
	}

	public void setMaxVelocityY(int maxVelocityY) {
		this.maxVelocityY = maxVelocityY;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
	
	

}
