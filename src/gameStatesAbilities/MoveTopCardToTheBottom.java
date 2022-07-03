package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class MoveTopCardToTheBottom extends AGameState {

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
		Lists.INSTANCE.deck.getArrayList().addLast(card);
		Lists.INSTANCE.deck.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
