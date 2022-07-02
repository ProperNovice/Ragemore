package models;

import enums.ESuit;
import gameStates.AGameState;

public class SideEnemyBuilder {

	private ESuit eSuit = null;
	private int strength = -1, cardNumber = -1;
	private boolean hasScull = false;
	private Class<? extends AGameState> ability = null;

	public SideEnemyBuilder() {

	}

	public SideEnemyBuilder eSuit(ESuit eSuit) {
		this.eSuit = eSuit;
		return this;
	}

	public SideEnemyBuilder strength(int strength) {
		this.strength = strength;
		return this;
	}

	public SideEnemyBuilder hasScull(boolean hasScull) {
		this.hasScull = hasScull;
		return this;
	}

	public SideEnemyBuilder cardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
		return this;
	}

	public SideEnemyBuilder ability(Class<? extends AGameState> ability) {
		this.ability = ability;
		return this;
	}

	public SideEnemy build() {
		return new SideEnemy(this.cardNumber, this.eSuit, this.strength, this.hasScull,
				this.ability);
	}

}
