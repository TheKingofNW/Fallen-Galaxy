package userInterface;

import org.newdawn.slick.Graphics;

public class UI {
	
	StarBackground s = new StarBackground();
	Coordinates t = new Coordinates();
	
	public void render(Graphics g) {
		s.render(g);
		t.render(g);
	}
	
	public void update() {
		s.update();
	}
}
