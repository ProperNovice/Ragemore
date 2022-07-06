package gameStatesAbilities;

import controllers.Lists;
import controllers.Party;
import enums.ESuit;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.Flow;

public class GainNextCardIfItIsCrossOrRoad extends AGameState {

	@Override
	public void execute() {

		boolean resolveAbility = false;

		if (!Lists.INSTANCE.deck.getArrayList().isEmpty()) {

			ACard card = Lists.INSTANCE.deck.getArrayList().getFirst();
			ESuit eSuit = card.getSideEnemy().getESuit();

			if (eSuit.equals(ESuit.CROSS) || eSuit.equals(ESuit.ROAD))
				resolveAbility = true;

		}

		if (resolveAbility)
			EText.RESOLVE_ABILITY.show();
		else
			Flow.INSTANCE.proceed();

	}

	@Override
	protected void executeTextOption(EText eText) {

		ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
		Party.INSTANCE.addCard(card);
		Party.INSTANCE.relocate();

		Flow.INSTANCE.proceed();

	}

}
