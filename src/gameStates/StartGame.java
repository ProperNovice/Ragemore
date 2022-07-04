package gameStates;

import controllers.Lists;
import controllers.Model;
import enums.EDifficultyLevel;
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

		EText.CHOOSE_DIFFICULTY_LEVEL.show();
		EText.NORMAL.show();
		EText.HARD.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		EDifficultyLevel eDifficultyLevel = null;

		switch (eText) {

		case NORMAL:
			eDifficultyLevel = EDifficultyLevel.NORMAL;
			break;

		case HARD:
			eDifficultyLevel = EDifficultyLevel.HARD;
			break;

		default:
			break;

		}

		Model.INSTANCE.setEDifficultyLevel(eDifficultyLevel);
		Model.INSTANCE.startGame();

		Flow.INSTANCE.executeGameState(StartNewTurn.class);

	}

}
