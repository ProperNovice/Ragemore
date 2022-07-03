package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import utils.Flow;

public class ShuffleTheDeck extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.deck.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();
		else
			EText.RESOLVE_ABILITY.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
