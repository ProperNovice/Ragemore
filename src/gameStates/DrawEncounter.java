package gameStates;

import controllers.Model;
import enums.EText;
import utils.Flow;

public class DrawEncounter extends AGameState {

	@Override
	public void execute() {

		EText.DRAW_ENCOUNTER.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Model.INSTANCE.drawEncounter();
		Flow.INSTANCE.proceed();

	}

}
