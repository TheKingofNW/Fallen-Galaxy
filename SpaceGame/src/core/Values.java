package core;

import java.util.ArrayList;

import entities.planets.Planet;
import entities.ships.Ship;
import userInterface.Camera;

public class Values {
	
	public static Camera camera = new Camera();
	
	public static Ship player = new Ship();
	
	public static ArrayList<Planet> planets = new ArrayList<>();
}
