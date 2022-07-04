package enums;

public enum EDifficultyLevel {

	NORMAL(3), HARD(4);

	private int cardsNeeded = -1;

	private EDifficultyLevel(int cardsNeeded) {
		this.cardsNeeded = cardsNeeded;
	}

	public int getCardsNeeded() {
		return this.cardsNeeded;
	}

}
