package gameStates;

import utils.Flow;

public class ActionPass extends AGameState {

	@Override
	public void execute() {

		Flow.INSTANCE.proceed();

	}

}
