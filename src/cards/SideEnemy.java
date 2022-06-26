package cards;

import enums.ESuit;

public class SideEnemy {

	private ESuit eSuit = null;
	private int strength = -1;
	private boolean hasScull = false;

	public SideEnemy(ESuit eSuit, int strength, boolean hasScull) {

		this.eSuit = eSuit;
		this.strength = strength;
		this.hasScull = hasScull;

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

}
