package userInterface.enteractables;

import java.util.Locale;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import ore.OreTypes;

public class OreShopButton extends Button {

	private OreTypes ore;
	private boolean selected = false;
	private int oreAmount;

	int centerOfButtonForStrings = y + h / 2 - 10;

	public OreShopButton(int x, int y, int w, int h, OreTypes ore, int amount) {
		super(x, y, w, h);
		this.ore = ore;
		oreAmount = amount;
	}

	@Override
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.green);
		String oreName = ore.name().substring(0, 1) + ore.name().substring(1, ore.name().length()).toLowerCase();
		String oreBuyPrice = String.valueOf(String.format("%.0f", ore.getDefaultPrice()));
		String oreSellPrice = String.valueOf(String.format("%.0f", ore.getDefaultSellPrice()));
		String oreAmount = String.valueOf(this.oreAmount);
		int width = g.getFont().getWidth(oreName);
		g.drawString(oreName, 130 + (80 / 2) - (width / 2), centerOfButtonForStrings);
		g.drawString("$" + oreBuyPrice, 255 + 130 / 2 - (oreBuyPrice.length() + 1) * 10 / 2, centerOfButtonForStrings);
		g.drawString("$" + oreSellPrice, 420 + 140 / 2 - (oreSellPrice.length() + 1) * 10 / 2,
				centerOfButtonForStrings);
		g.drawString(oreAmount, 600 + 160 / 2 - oreAmount.length() * 10 / 2, centerOfButtonForStrings);
	}

	public void updateInformation(int amount) {
		oreAmount = amount;
	}

	public OreTypes getOre() {
		return ore;
	}

}
