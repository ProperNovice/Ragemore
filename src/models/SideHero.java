package models;

import enums.ESuit;
import utils.ArrayList;
import utils.Image;
import utils.Logger;

public class SideHero {

	private ESuit eSuit = null;
	private int strength = -1;
	private boolean hasPlusIcon = false;
	private ArrayList<ESuit> skills = null;
	private Image image = null;

	public SideHero(int cardNumber, ESuit eSuit, int strength, boolean hasScull,
			ArrayList<ESuit> skills) {

		this.eSuit = eSuit;
		this.strength = strength;
		this.hasPlusIcon = hasScull;
		this.skills = skills;

		String path = "cards/hero/";

		if (cardNumber < 10)
			path += 0;

		path += cardNumber;
		path += ".jpg";
		this.image = new Image(path);

	}

	public ESuit getESuit() {
		return this.eSuit;
	}

	public Integer getStrength() {
		return this.strength;
	}

	public boolean hasPlusIcon() {
		return this.hasPlusIcon;
	}

	public ArrayList<ESuit> getSkills() {
		return this.skills;
	}

	public Image getImage() {
		return this.image;
	}

	public void print() {

		Logger.INSTANCE.log("printing side hero");
		Logger.INSTANCE.log("suit -> " + this.eSuit);
		Logger.INSTANCE.log("strength -> " + this.strength);
		Logger.INSTANCE.log("has plus icon -> " + this.hasPlusIcon);
		Logger.INSTANCE.log("skills");

		for (ESuit eSuit : this.skills)
			Logger.INSTANCE.log(eSuit);

		Logger.INSTANCE.newLine();

	}

}
