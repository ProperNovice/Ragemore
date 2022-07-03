package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class KillNextCard extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.deck.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();
		else
			EText.RESOLVE_ABILITY.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
		Lists.INSTANCE.graveyard.getArrayList().addLast(card);
		Lists.INSTANCE.graveyard.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
