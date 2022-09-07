package entities.ships;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.Engine;
import core.Values;
import entities.Entity;
import entities.planets.Planet;
import ore.OreInventory;
import ore.OreTypes;

public class Player implements Entity {

	private int x, y;

	private int velocityX, velocityY;
	private int maxVelocityX = 20, maxVelocityY = 20;

	private int drawShipX = Engine.RESOLUTION_X / 2, drawShipY = Engine.RESOLUTION_Y / 2;

	boolean enteractable = false;
	Planet currentEnteractable;

	Color color = Color.white;
	
	OreInventory inventory = new OreInventory();
	private int money = 100000;
	
	public Player() {
		for (OreTypes ore : OreTypes.values()) {
			inventory.addOreType(ore, (int) (Math.random() * 100));
		}
	}

	public void render(Graphics g) {
		if (currentEnteractable != null && Values.debug)
			g.setColor(currentEnteractable.getColor());
		else
			g.setColor(Color.white);
		
		g.drawRect(drawShipX - 30, drawShipY - 40, 60, 80);
		
		if (enteractable) {
			g.drawString("E", drawShipX - 5, drawShipY - 55);
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg) {
		money++;
		slowlyRemoveVelocity();
		updateVelocityUsingPlayerInput(gc);
		addVelocityToPlayer();
		setCameraToPlayerXY();
		if (gc.getInput().isKeyPressed(Input.KEY_E) && enteractable) {
			sbg.enterState(Engine.SHOP_ID);
		}
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
		} else if (velocityX > 0) {
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public OreInventory getInventory() {
		return inventory;
	}

	public int getDrawShipX() {
		return drawShipX;
	}

	public int getDrawShipY() {
		return drawShipY;
	}

	public boolean isEnteractable() {
		return enteractable;
	}

	public void setEnteractable(boolean enteractable) {
		this.enteractable = enteractable;
	}

	public Planet getCurrentEnteractable() {
		return currentEnteractable;
	}

	public void setCurrentEnteractable(Planet currentEnteractable) {
		this.currentEnteractable = currentEnteractable;
	}

	@Override
	public void update(GameContainer gc) {
		// TODO Auto-generated method stub

	}

}
