
package core;

import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Engine extends StateBasedGame
{
	public final static int RESOLUTION_X = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public final static int RESOLUTION_Y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
    public static final int GAME_ID = 1;
    public static final int SHOP_ID = 2;
    
    private BasicGameState game;
    private BasicGameState shop;
    

	public Engine(String name)
	{
		super(name);
		game = new Game(GAME_ID);
		shop = new Shop(SHOP_ID);
	}

	public void initStatesList(GameContainer gc) throws SlickException
	{
		gc.setMinimumLogicUpdateInterval(17);
		gc.setMaximumLogicUpdateInterval(17);
//		gc.setTargetFrameRate(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate());
	    addState(game);
	    addState(shop);
	}

	public static void main(String[] args) 
	{
		try {
			AppGameContainer appgc = new AppGameContainer(new Engine("Sample Slick Game"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(RESOLUTION_X, RESOLUTION_Y, false);
			appgc.start();
			appgc.setVSync(true);

		} catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}