package gameStates;

import utils.Flow;

public class StartNewTurn extends AGameState {

	@Override
	public void execute() {

		Flow.INSTANCE.getFlow().addLast(DrawEncounter.class);
		Flow.INSTANCE.getFlow().addLast(ChooseAction.class);

		Flow.INSTANCE.proceed();

	}

}
