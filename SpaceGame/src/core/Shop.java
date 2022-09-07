
package core;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import entities.Entity;
import entities.planets.Planet;
import ore.OreTypes;
import userInterface.enteractables.Button;
import userInterface.enteractables.OreShopButton;

public class Shop extends BasicGameState {

	int id;

	Planet curPlanet;

	ArrayList<OreShopButton> buttons = new ArrayList<>();

	int quantity = 0;
	int price = 0;
	OreTypes currentOreSelected = null;

	Button totalMoneyDue = new Button(900, 730, 250, 100, "Price $" + price);
	Button quantitySelected = new Button(1200, 730, 250, 100, "Quantity Selected: " + quantity);
	Button playerMoney = new Button(1719, 5, 200, 40, "Money $" + Values.player.getMoney());
	Button playerQuantity = new Button(1514, 5, 200, 40, "Your Quantity: ");
	Button buy = new Button(900, 680, 250, 20, "Buy");
	Button sell = new Button(1200, 680, 250, 20, "Sell");
	Button confirm = new Button(1050, 870, 250, 100, "Buy");

	Button addOne = new Button(1500, 730, 80, 50, "Add +1");
	Button addTen = new Button(1500, 793, 80, 50, "Add +10");
	Button addFifty = new Button(1500, 856, 80, 50, "Add +50");
	Button addOneHundred = new Button(1500, 919, 80, 50, "Add +100");

	Button subtractOne = new Button(1600, 730, 80, 50, "Sub -1");
	Button subtractTen = new Button(1600, 793, 80, 50, "Sub -10");
	Button subtractFifty = new Button(1600, 856, 80, 50, "Sub -50");
	Button subtractOneHundred = new Button(1600, 919, 80, 50, "Sub -100");

	Shop(int id) {
		this.id = id;

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

	}

	public void enter(GameContainer gc, StateBasedGame sbg) {

		curPlanet = Values.player.getCurrentEnteractable();
		System.out.println(curPlanet);
		for (int i = 0; i < OreTypes.values().length; i++) {
			System.out.println(OreTypes.values()[i] + " " + curPlanet.getInventory().getStorage().get(i));
			buttons.add(new OreShopButton(100, 75 + (i * 51), 700, 50, OreTypes.values()[i],
					curPlanet.getInventory().getStorage().get(i)));
		}
		buy.setSelected(true);
		sell.setSelected(false);
		if(buttons.size() != 0) {
			buttons.get(0).setSelected(true);
			currentOreSelected = buttons.get(0).getOre();
		}

	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.blue);

		renderButtons(g);

		drawTitles(g);
		drawShopOutline(g);

	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Button.update(gc);
		for (OreShopButton mainButton : buttons) {
			if (mainButton.isPressed()) {
				mainButton.setSelected(true);
				currentOreSelected = mainButton.getOre();
				quantity = 0;
				for (OreShopButton sideButtons : buttons) {
					if (sideButtons != mainButton) {
						sideButtons.setSelected(false);
					}
				}
			}
		}

		if (currentOreSelected != null) {
			if (buy.isSelected())
				price = (int) (quantity * currentOreSelected.getDefaultPrice());
			else if (sell.isSelected())
				price = (int) (quantity * currentOreSelected.getDefaultSellPrice());
		}

		if (addOne.isPressed() && purchaceAllowed()) {
			quantity += 1;
		}
		if (addTen.isPressed() && purchaceAllowed()) {
			quantity += 10;
		}
		if (addFifty.isPressed() && purchaceAllowed()) {
			quantity += 50;
		}
		if (addOneHundred.isPressed() && purchaceAllowed()) {
			quantity += 100;
		}

		if (subtractOne.isPressed() && purchaceAllowed()) {
			quantity -= 1;
		}
		if (subtractTen.isPressed() && purchaceAllowed()) {
			quantity -= 10;
		}
		if (subtractFifty.isPressed() && purchaceAllowed()) {
			quantity -= 50;
		}
		if (subtractOneHundred.isPressed() && purchaceAllowed()) {
			quantity -= 100;
		}

		if (buy.isSelected()) {
			if (quantity > curPlanet.getInventory().getQuantity(currentOreSelected))
				quantity = curPlanet.getInventory().getQuantity(currentOreSelected);
		} else {
			if (quantity > Values.player.getInventory().getQuantity(currentOreSelected))
				quantity = Values.player.getInventory().getQuantity(currentOreSelected);
		}

		if (quantity < 0) {
			quantity = 0;
		}

		// updating live values to display
		totalMoneyDue.setMessage("Price $" + price);
		quantitySelected.setMessage("Quantity Selected: " + quantity);
		playerMoney.setMessage("Money $" + Values.player.getMoney());
		if (currentOreSelected != null)
			playerQuantity.setMessage("Your Quantity: " + Values.player.getInventory().getQuantity(currentOreSelected));

		for (int i = 0; i < buttons.size(); i++) {
			buttons.get(i).updateInformation(curPlanet.getInventory().getStorage().get(i));
		}

		if (buy.isSelected()) {
			confirm.setMessage("Buy");
			if (confirm.isPressed()) {
				if (Values.player.getMoney() > price) {
					Values.player.setMoney(Values.player.getMoney() - price);
					Values.player.getInventory().addOreType(currentOreSelected, quantity);
					curPlanet.getInventory().addOreType(currentOreSelected, -quantity);
				}
			}
		}
		if (sell.isSelected()) {
			confirm.setMessage("Sell");
			if (confirm.isPressed() && Values.player.getInventory().getQuantity(currentOreSelected) + 1 > quantity) {
				Values.player.setMoney(Values.player.getMoney() + price);
				Values.player.getInventory().addOreType(currentOreSelected, -quantity);
				curPlanet.getInventory().addOreType(currentOreSelected, quantity);
			}
		}

		if (buy.isPressed()) {
			buy.setSelected(true);
			sell.setSelected(false);
			quantity = 0;
		}

		if (sell.isPressed()) {
			buy.setSelected(false);
			sell.setSelected(true);
			quantity = 0;
		}

		if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(Engine.GAME_ID);
		}
	}

	public void leave(GameContainer gc, StateBasedGame sbg) {
		buttons.clear();
	}

	private void drawShopOutline(Graphics g) {
		g.setColor(Color.white);
		g.setLineWidth(1);
		g.drawLine(100, 75, 800, 75);
		g.drawLine(100, 75, 100, 1005);
		g.drawLine(100, 1005, 1820, 1005);
		g.drawLine(1820, 1005, 1820, 700);
		g.drawLine(1820, 700, 800, 700);
		g.drawLine(800, 700, 800, 75);

	}

	private void drawTitles(Graphics g) {
		g.drawString("Ore Type", 130, 55);
		g.drawString("Ore Buy Price", 255, 55);
		g.drawString("Ore Sell Price", 420, 55);
		g.drawString("Amount Remaining", 600, 55);
	}

	public void renderButtons(Graphics g) {
		for (OreShopButton b : buttons) {
			b.render(g);
		}
		totalMoneyDue.render(g);
		quantitySelected.render(g);
		playerMoney.render(g);
		playerQuantity.render(g);
		confirm.render(g);
		buy.render(g);
		sell.render(g);

		addOne.render(g);
		addTen.render(g);
		addFifty.render(g);
		addOneHundred.render(g);

		subtractOne.render(g);
		subtractTen.render(g);
		subtractFifty.render(g);
		subtractOneHundred.render(g);
	}

	public boolean purchaceAllowed() {
		if (buy.isSelected())
			return currentOreSelected != null && quantity < curPlanet.getInventory().getQuantity(currentOreSelected) + 1;
		else {
			return currentOreSelected != null
					&& quantity < Values.player.getInventory().getQuantity(currentOreSelected);
		}

	}

	public int getID() {
		return id;
	}
}
