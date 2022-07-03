package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class IfThereIsAtLeastOneCardInTheGraveyardAddThisCardToTheGraveyard extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.graveyard.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();
		else
			EText.RESOLVE_ABILITY.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ACard card = Lists.INSTANCE.encounter.getArrayList().removeRandom();
		Lists.INSTANCE.graveyard.getArrayList().addLast(card);
		Lists.INSTANCE.graveyard.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
