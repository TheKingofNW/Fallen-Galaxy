package userInterface;

import org.newdawn.slick.Graphics;
import objects.Object;

public class Camera {

	private Object target;

	public void render(Graphics g) {
		if (target == null) return;
		
		g.translate(-target.getX() + 1920/2, -target.getY() + 1080/2);
		System.out.println(target.getX() + " " + target.getY());
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
	

}
