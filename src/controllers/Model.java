package controllers;

public enum Model {

	INSTANCE;

	public void startGame() {

		Lists.INSTANCE.loadListsOriginal();

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

	}

}
