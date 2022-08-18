package ore;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Ore {
	
	//space physics here
	int x, y, w, h;
	int velocityX, velocityY;
	
	//variables that define ore
	private int sellPrice;
	private int buyPrice;
	private oreTypes type;
	
	//image stuff
	private Image shopOreImage;
	private Image spaceImageOfOre;

	protected Ore(int sellPrice, int buyPrice, oreTypes type) {
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.type = type;
	}

	protected Ore(int sellPrice, int buyPrice, oreTypes type, Image shopOreImage, Image spaceImageOfOre) {
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.type = type;
		this.shopOreImage = shopOreImage;
		this.spaceImageOfOre = spaceImageOfOre;
	}
	
	public void render(Graphics g) {
		//space physics here
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public int getBuyPrice() {
		return buyPrice;
	}

	public oreTypes getType() {
		return type;
	}

	public Image getShopOreImage() {
		return shopOreImage;
	}

	public Image getSpaceImageOfOre() {
		return spaceImageOfOre;
	}
	
	
	
}
