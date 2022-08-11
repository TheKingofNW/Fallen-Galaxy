package entitys;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Entity {

	public void render(Graphics g);
	
	public void update(GameContainer gc);
	
	public int getX();
	public void setX(int x);
	
	public int getY();
	public void setY(int y);
	
	public int getSize();
	public void setSize(int size);
}
