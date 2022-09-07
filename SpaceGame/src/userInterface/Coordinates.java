package userInterface;

import org.newdawn.slick.Graphics;

import core.Values;

public class Coordinates {
	
	int x = 1920;
	int adjustmentX = 0;
	
	public void render(Graphics g) {
		
		String playerCoordinate = -Values.player.getX() + ", " + Values.player.getY();
		
		adjustmentX = playerCoordinate.length() * 10;
		
		g.drawString(playerCoordinate, x + -adjustmentX, 0);
		
	}
	
}
