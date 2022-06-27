package cards;

import enums.ESuit;
import utils.Image;
import utils.Logger;

public class SideEnemy {

	private ESuit eSuit = null;
	private int strength = -1;
	private boolean hasScull = false;
	private Runnable ability = null;
	private Image image = null;

	public SideEnemy(int cardNumber, ESuit eSuit, int strength, boolean hasScull,
			Runnable ability) {

		this.eSuit = eSuit;
		this.strength = strength;
		this.hasScull = hasScull;
		this.ability = ability;

		String path = "cards/enemy/";

		if (cardNumber < 10)
			path += 0;

		path += cardNumber;
		path += ".jpg";
		this.image = new Image(path);

	}

	public void executeAbility() {
		this.ability.run();
	}

	public ESuit getESuit() {
		return this.eSuit;
	}

	public Integer getStrength() {
		return this.strength;
	}

	public boolean hasScull() {
		return this.hasScull;
	}

	public Image getImage() {
		return this.image;
	}

	public void print() {

		Logger.INSTANCE.log("printing side enemy");
		Logger.INSTANCE.log("suit -> " + this.eSuit);
		Logger.INSTANCE.log("strength -> " + this.strength);
		Logger.INSTANCE.log("has scull -> " + this.hasScull);
		Logger.INSTANCE.newLine();

	}

}
