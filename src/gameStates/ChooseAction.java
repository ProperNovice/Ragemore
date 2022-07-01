package gameStates;

import enums.EText;
import utils.Flow;
import utils.ShutDown;

public class ChooseAction extends AGameState {

	@Override
	public void execute() {

		EText.CHOOSE_ACTION.show();
		EText.EXPLORE.show();
		EText.RECRUIT.show();
		EText.FIGHT.show();
		EText.PASS.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Class<? extends AGameState> gameState = null;

		switch (eText) {

		case EXPLORE:
			gameState = ActionExplore.class;
			break;

		case RECRUIT:
			gameState = ActionRecruit.class;
			break;

		case FIGHT:
			gameState = ActionFight.class;
			break;

		case PASS:
			gameState = ActionPass.class;
			break;

		default:
			ShutDown.INSTANCE.execute();
			break;

		}

		Flow.INSTANCE.executeGameState(gameState);

	}

}
