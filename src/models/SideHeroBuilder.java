package models;

import enums.ESuit;
import utils.ArrayList;

public class SideHeroBuilder {

	private ESuit eSuit = null;
	private int strength = -1, cardNumber = -1;
	private boolean hasPlusIcon = false;
	private ArrayList<ESuit> skills = null;

	public SideHeroBuilder() {

	}

	public SideHeroBuilder eSuit(ESuit eSuit) {
		this.eSuit = eSuit;
		return this;
	}

	public SideHeroBuilder strength(int strength) {
		this.strength = strength;
		return this;
	}

	public SideHeroBuilder hasPlusIcon(boolean hasPlusIcon) {
		this.hasPlusIcon = hasPlusIcon;
		return this;
	}

	public SideHeroBuilder cardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
		return this;
	}

	public SideHeroBuilder skills(ESuit... eSuits) {
		this.skills = new ArrayList<>(eSuits);
		return this;
	}

	public SideHero build() {
		return new SideHero(this.cardNumber, this.eSuit, this.strength, this.hasPlusIcon,
				this.skills);
	}

}
