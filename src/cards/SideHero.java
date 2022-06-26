package cards;

import enums.ESuit;
import utils.ArrayList;

public class SideHero {

	private ESuit eSuit = null;
	private int strength = -1;
	private boolean hasPlusIcon = false;
	private ArrayList<ESuit> skills = null;

	public SideHero(ESuit eSuit, int strength, boolean hasScull, ESuit... eSuits) {

		this.eSuit = eSuit;
		this.strength = strength;
		this.hasPlusIcon = hasScull;
		this.skills = new ArrayList<>(eSuits);

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

}
