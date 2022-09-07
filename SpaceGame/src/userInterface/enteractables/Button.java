package userInterface.enteractables;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button {

	int x, y, w, h;

	static int mouseX, mouseY;
	static int buttonHeld;
	static int buttonPressed;
	static boolean pressed = false;
	
	boolean selected = false;

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

	public Button(int x, int y, int w, int h, int amount) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.message = String.valueOf(amount);
	}

	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(x, y, w, h);
		
		if (selected) {
			g.setColor(new Color(200, 200, 200, 100));
			g.fillRect(x, y, w, h);
		}
		
		if (message != null) {
			g.setColor(Color.green);
			int xOffSet = g.getFont().getWidth(message) / 2;
			g.drawString(message, x + w / 2 - xOffSet, y + h / 2 - 10);
		}

		if (isMouseOver()) {
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

		buttonHeld = 0;
		if (gc.getInput().isMouseButtonDown(0)) {
			buttonHeld = 1;
		} else if (gc.getInput().isMouseButtonDown(1)) {
			buttonHeld = 2;
		} else if (gc.getInput().isMouseButtonDown(2)) {
			buttonHeld = 3;
		}
		
		buttonPressed = 0;
		if (gc.getInput().isMousePressed(0)) {
			buttonPressed = 1;
		} else if (gc.getInput().isMousePressed(1)) {
			buttonPressed = 2;
		} else if (gc.getInput().isMousePressed(2)) {
			buttonPressed = 3;
		}
	}

	public boolean isMouseOver() {
		return mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h;
	}

	public boolean isPressed() {
			return isMouseOver() && buttonPressed == 1;
	}
	
	public boolean isHeld() {
		return isMouseOver() && buttonHeld == 1;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(int number) {
		message = String.valueOf(number);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean isSelected) {
		this.selected = isSelected;
	}

}
