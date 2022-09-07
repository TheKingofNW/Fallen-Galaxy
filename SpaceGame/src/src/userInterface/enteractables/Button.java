package userInterface.enteractables;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button {

	int x, y, w, h;
	
	static int mouseX, mouseY;
	static int button;

	String message;

	public Button(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public Button(int x, int y, int w, int h, String message) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.message = message;
	}

	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, w, h);
		if (message != null) {
			g.setColor(Color.green);
			int xOffSet = message.length() * 10 / 2;
			g.drawString(message, x + w / 2 - xOffSet, y + h / 2 - 10);
		}
		
		if(isMouseOver()) {
			g.setColor(new Color(255, 255, 255, 40));
			g.fillRect(x, y, w, h);
		}
	}

	public static void update(GameContainer gc) {
		updateMouseInformation(gc);
	}
	
	private static void updateMouseInformation(GameContainer gc) {
		mouseX = gc.getInput().getMouseX();
		mouseY = gc.getInput().getMouseY();
		
		button = 0;
		if(gc.getInput().isMouseButtonDown(0)) {
			button = 1;
		} else if (gc.getInput().isMouseButtonDown(1)) {
			button = 2;
		} else if (gc.getInput().isMouseButtonDown(2)) {
			button = 3;
		}
	}
	
	public boolean isMouseOver() {
		return mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h;
	}
	
	public boolean isPressed(){
		return isMouseOver() && button == 1;
	}
	
}
