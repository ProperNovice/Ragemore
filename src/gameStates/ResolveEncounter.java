package gameStates;

import controllers.Lists;
import controllers.Model;
import enums.EText;
import gameStatesAbilities.PlayNextCard;
import models.ACard;
import utils.Flow;
import utils.ShutDown;

public class ResolveEncounter extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.encounter.getArrayList().isEmpty()) {
			Flow.INSTANCE.proceed();
			return;

		} else
			EText.RESOLVE_ENCOUNTER.show();

	}

	@SuppressWarnings("unchecked")
	@Override
	protected void executeTextOption(EText eText) {

		ACard card = Lists.INSTANCE.encounter.getArrayList().getRandom();
		Class<? extends AGameState> ability = card.getSideEnemy().getAbility();

		// TODO

		ability = PlayNextCard.class;

		// TODO

		if (Model.INSTANCE.abilityResolvesBeforePlacing(ability))
			Flow.INSTANCE.getFlow().addAllFirst(ability, PutEncounterCardToQuest.class);

		else if (Model.INSTANCE.abilityResolvesAfterPlacing(ability))
			Flow.INSTANCE.getFlow().addAllFirst(PutEncounterCardToQuest.class, ability);

		else
			ShutDown.INSTANCE.execute();

		Flow.INSTANCE.proceed();

	}

}
