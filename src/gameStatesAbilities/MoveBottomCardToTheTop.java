package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class MoveBottomCardToTheTop extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.deck.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();
		else
			EText.RESOLVE_ABILITY.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ACard card = Lists.INSTANCE.deck.getArrayList().removeLast();
		Lists.INSTANCE.deck.getArrayList().addFirst(card);
		Lists.INSTANCE.deck.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
