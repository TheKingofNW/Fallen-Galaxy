package objects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class SpaceShip extends Entity{

	
	public SpaceShip(int x, int y) {
		super(x, y, 40, 40);
	}
	
	public void render(Graphics g) {
		super.render(g);
	}
	
	public void update() {
		super.update();
	}
	
	public void updateInput(GameContainer gc) {
		if(gc.getInput().isKeyDown(Input.KEY_W)) {
			velocityY--;
		}
		if(gc.getInput().isKeyDown(Input.KEY_S)) {
			velocityY++;
		}
		if(gc.getInput().isKeyDown(Input.KEY_A)) {
			velocityX--;
		}
		if(gc.getInput().isKeyDown(Input.KEY_D)) {
			velocityX++;
		}
	}
	
	
}
