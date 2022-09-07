package ore;

public enum OreTypes {

	IRON, GOLD, SILVER, COPPER, ALUMINIUM, PLATINUM;

	public float getDefaultPrice() {
		
		switch (this) {
		
			case IRON:			return 100;
			case GOLD:			return 500;
			case SILVER:		return 150;
			case COPPER:		return 200;
			case ALUMINIUM:		return 50;
			case PLATINUM:		return 1000;
			default:			return 0;

		}
	}
	
	public float getDefaultSellPrice() {
		switch (this) {
			
			case PLATINUM: 		return this.getDefaultPrice() / 5;
			case ALUMINIUM:		return (float) (this.getDefaultPrice() / 1.5);
			default: 			return this.getDefaultPrice() / 4;
			
		}
	}
}
