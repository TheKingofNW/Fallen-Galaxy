package ore;

public enum OreTypes {

	IRON, GOLD, SILVER, PLATINUM;

	public float getDefaultPrice() {
		
		switch (this) {
		
			case IRON:			return 100;
			case GOLD:			return 500;
			case SILVER:		return 150;
			case PLATINUM:		return 1000;
			default:			return 0;

		}
	}
	
	public float getDefaultSellPrice() {
		switch (this) {
			
			case PLATINUM: 		return this.getDefaultPrice() / 5;
			default: 			return this.getDefaultPrice() / 4;
			
		}
	}
}
