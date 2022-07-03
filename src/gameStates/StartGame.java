package gameStates;

import controllers.Lists;
import controllers.Model;
import enums.EText;
import models.ACard;
import utils.Flow;

public class StartGame extends AGameState {

	@Override
	public void execute() {

		Lists.INSTANCE.loadListsOriginal();
		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		for (ACard card : Lists.INSTANCE.deck)
			card.flipSideEnemy();

		EText.START_GAME.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Model.INSTANCE.startGame();
		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

}
