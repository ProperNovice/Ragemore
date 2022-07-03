package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import gameStates.DrawEncounter;
import gameStates.ResolveEncounter;
import utils.Flow;

public class PlayNextCard extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.deck.getArrayList().isEmpty())
			Flow.INSTANCE.proceed();
		else
			EText.RESOLVE_ABILITY.show();

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void executeTextOption(EText eText) {

		Flow.INSTANCE.getFlow().addAllFirst(DrawEncounter.class, ResolveEncounter.class);
		Flow.INSTANCE.proceed();

	}

}
