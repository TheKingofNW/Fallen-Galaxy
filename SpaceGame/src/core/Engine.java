
package core;

import java.awt.Toolkit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import core.gameStates.Space;

public class Engine extends StateBasedGame
{
	public final static int RESOLUTION_X = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public final static int RESOLUTION_Y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public final static int FRAMES_PER_SECOND = 60;
	
    public static final int GAME_ID  = 1;
    
    private BasicGameState game;
    

	public Engine(String name)
	{
		super(name);
		game = new Space(GAME_ID);
	}

	public void initStatesList(GameContainer gc) throws SlickException
	{
		gc.setMinimumLogicUpdateInterval(17);
		gc.setMaximumLogicUpdateInterval(17);
//		gc.setTargetFrameRate(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getRefreshRate());
//		gc.setVSync(true);
	    addState(game);
	}

	public static void main(String[] args) 
	{
		try {
			AppGameContainer appgc = new AppGameContainer(new Engine("Sample Slick Game"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(RESOLUTION_X, RESOLUTION_Y, false);
//			appgc.setTargetFrameRate(FRAMES_PER_SECOND);
			appgc.start();
			appgc.setVSync(true);

		} catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}