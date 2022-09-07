package userInterface.enteractables;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import ore.OreTypes;


public class OreShopButton extends Button{
	
	private OreTypes ore;
	private boolean selected = false;
	int oreAmount;
	
	int centerOfButtonForStrings = y + h / 2 - 10;
	
	public OreShopButton(int x, int y, int w, int h, OreTypes ore, int amount) {
		super(x, y, w, h);
		this.ore = ore;
		oreAmount = amount;
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		if(selected) {
			g.setColor(new Color(200, 200, 200, 100));
			g.fillRect(x, y, w, h);
		}
		g.setColor(Color.green);
		String oreName = ore.name();
		String oreBuyPrice = String.valueOf(String.format("%.0f", ore.getDefaultPrice()));
		String oreSellPrice = String.valueOf(String.format("%.0f", ore.getDefaultSellPrice()));
		String oreAmount = String.valueOf(this.oreAmount);
		g.drawString(oreName, 130 + (80 / 2) - ((oreName.length() * 8) / 2), centerOfButtonForStrings);
		g.drawString(oreBuyPrice, 255 + 130 / 2 - oreBuyPrice.length() * 10 / 2, centerOfButtonForStrings);
		g.drawString(oreSellPrice, 420 + 140 / 2 - oreSellPrice.length() * 10 / 2, centerOfButtonForStrings);
		g.drawString(oreAmount, 600 + 160 / 2 - oreAmount.length() * 10 / 2, centerOfButtonForStrings);
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public OreTypes getOre() {
		return ore;
	}

}
