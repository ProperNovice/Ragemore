package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class MoveOneCardFromTheGraveyardToTheBottom extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.graveyard.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();

		else if (Lists.INSTANCE.graveyard.getArrayList().size() == 1)
			handleCardPressedGraveyard(Lists.INSTANCE.graveyard.getArrayList().getRandom());

		else
			EText.CHOOSE_CARD.show();

	}

	@Override
	protected void handleCardPressedGraveyard(ACard card) {

		concealText();

		Lists.INSTANCE.graveyard.getArrayList().remove(card);
		Lists.INSTANCE.graveyard.relocateImageViews();

		Lists.INSTANCE.deck.getArrayList().addLast(card);
		Lists.INSTANCE.deck.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
