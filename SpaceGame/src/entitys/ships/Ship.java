package entitys.ships;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

import core.Engine;
import core.Values;
import entitys.Entity;

public class Ship implements Entity {

	private int x, y;

	private int velocityX, velocityY;
	private int maxVelocityX = 40, maxVelocityY = 40;

	private int drawShipX = Engine.RESOLUTION_X / 2, drawShipY = Engine.RESOLUTION_Y / 2;

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(drawShipX - 30, drawShipY - 40, 60, 80);
	}

	public void update(GameContainer gc) {
		slowlyRemoveVelocity();
		updateVelocityUsingPlayerInput(gc);
		addVelocityToPlayer();
		setCameraToPlayerXY();
		
	}

	public void updateVelocityUsingPlayerInput(GameContainer gc) {
		if (gc.getInput().isKeyDown(Input.KEY_W)) {
			velocityY += 2;
			if (velocityY > maxVelocityY) {
				velocityY = maxVelocityY;
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_S)) {
			velocityY -= 2;
			if (velocityY < -maxVelocityY) {
				velocityY = -maxVelocityY;
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_D)) {
			velocityX -= 2;
			if (velocityX < -maxVelocityX) {
				velocityX = -maxVelocityX;
			}
		}
		if (gc.getInput().isKeyDown(Input.KEY_A)) {
			velocityX += 2;
			if (velocityX > maxVelocityX) {
				velocityX = maxVelocityX;
			}
		}

	}

	public void addVelocityToPlayer() {
		x += velocityX;
		y += velocityY;
	}

	public void setCameraToPlayerXY() {
		Values.camera.setCameraX(x);
		Values.camera.setCameraY(y);
	}

	public void slowlyRemoveVelocity() {
		if (velocityX < 0) {
			velocityX += 1;
		} 
		else if (velocityX > 0) {
			velocityX -= 1;
		}

		if (velocityY < 0) {
			velocityY += 1;
		} else if (velocityY > 0) {
			velocityY -= 1;
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

	public int getSize() {
		return 0;
	}

	public void setSize(int size) {

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
