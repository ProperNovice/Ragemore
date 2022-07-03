package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class MoveOneCardFromFinishedQuestsToTheBottom extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.questsFinished.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();

		else if (Lists.INSTANCE.questsFinished.getArrayList().size() == 1)
			handleCardPressedQuestsFinished(
					Lists.INSTANCE.questsFinished.getArrayList().getRandom());

		else
			EText.CHOOSE_CARD.show();

	}

	@Override
	protected void handleCardPressedQuestsFinished(ACard card) {

		Lists.INSTANCE.questsFinished.getArrayList().remove(card);
		Lists.INSTANCE.questsFinished.relocateImageViews();

		Lists.INSTANCE.deck.getArrayList().addLast(card);
		Lists.INSTANCE.deck.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
