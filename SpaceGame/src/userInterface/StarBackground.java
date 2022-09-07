package userInterface;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;

import core.Engine;
import core.Values;
import entities.Star;

public class StarBackground {

	ArrayList<Star> farStars = new ArrayList<>();
	ArrayList<Star> midStars = new ArrayList<>();
	ArrayList<Star> closeStars = new ArrayList<>();

	public StarBackground() {
		int x = Engine.RESOLUTION_X + 50;
		int y = Engine.RESOLUTION_Y + 50;
		for (int i = 0; i < 75; i++) {
			farStars.add(new Star((int) (Math.random() * x) - 25, (int) (Math.random() * y) - 25,
					(int) (Math.random() * 2) + 1));
		}
		
		for (int i = 0; i < 75; i++) {
			midStars.add(new Star((int) (Math.random() * x) - 25, (int) (Math.random() * y) - 25,
					(int) (Math.random() * 4 + 1)));
		}
		
		for (int i = 0; i < 75; i++) {
			closeStars.add(new Star((int) (Math.random() * x) - 25, (int) (Math.random() * y) - 25,
					(int) (Math.random() * 5 + 2)));
		}
	}

	public void render(Graphics g) {
		for (Star s : farStars) {
			s.render(g);
			s.setX((int) (s.getOriginalX() + Values.camera.getCameraX() / 4));
			s.setY((int) (s.getOriginalY() + Values.camera.getCameraY() / 4));

		}
		for (Star s : midStars) {
			s.render(g);
			s.setX((int) (s.getOriginalX() + Values.camera.getCameraX() / 3));
			s.setY((int) (s.getOriginalY() + Values.camera.getCameraY() / 3));

		}
		for (Star s : closeStars) {
			s.render(g);
			s.setX((int) (s.getOriginalX() + Values.camera.getCameraX() / 2));
			s.setY((int) (s.getOriginalY() + Values.camera.getCameraY() / 2));
		}
	}

	public void update() {
		moveStars(farStars);
		moveStars(midStars);
		moveStars(closeStars);
	}
	
	private void moveStars(ArrayList<Star> stars) {
		for (Star star: stars) {
			if(star.getY() > 1090) {
				star.setOriginalY(star.getOriginalY() - 1090);
			} else if(star.getY() < - 10){
				star.setOriginalY(star.getOriginalY() + 1090);
			}
			
			if(star.getX() > 1930) {
				star.setOriginalX(star.getOriginalX() - 1930);
			} else if(star.getX() < - 10) {
				star.setOriginalX(star.getOriginalX() + 1930);
			}
		}
	}

//	private void findPlayerDerection() {
//		if (Values.player.getVelocityY() > 0) {
//			//up
//		} else if (Values.player.getVelocityY() < 0) {
//			//down
//		} else {
//			//nothing
//		}
//
//		if (Values.player.getVelocityX() > 0) {
//			//left
//		} else if (Values.player.getVelocityX() < 0) {
//			//right
//		} else {
//			//nothing
//		}
//	}
}
