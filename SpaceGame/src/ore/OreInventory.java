package ore;

import java.util.ArrayList;

public class OreInventory {

	private ArrayList<Integer> storage = new ArrayList<>();

	public OreInventory() {
		for (int i = 0; i < OreTypes.values().length; i++) {
			storage.add(0);
		}
	}

	public void addOreType(OreTypes type) {
		for (int i = 0; i < OreTypes.values().length; i++) {
			if (OreTypes.values()[i].equals(type)) {
				storage.set(i, storage.get(i).intValue() + 1);
			}
		}
	}
	
	public void addOreType(OreTypes type, int amount) {
		for (int i = 0; i < OreTypes.values().length; i++) {
			if (OreTypes.values()[i].equals(type)) {
				storage.set(i, storage.get(i).intValue() + amount);
			}
		}
	}

	public ArrayList<Integer> getStorage() {
		return storage;
	}

}
