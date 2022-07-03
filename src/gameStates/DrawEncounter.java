package gameStates;

import controllers.Lists;
import controllers.Model;
import enums.EText;
import utils.Flow;

public class DrawEncounter extends AGameState {

	@Override
	public void execute() {

		if (Lists.INSTANCE.deck.getArrayList().isEmpty())
			Flow.INSTANCE.executeGameState(EndGameLost.class);
		else
			EText.DRAW_ENCOUNTER.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Model.INSTANCE.drawEncounter();
		Flow.INSTANCE.proceed();

	}

}
