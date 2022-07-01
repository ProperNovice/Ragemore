package gameStates;

import enums.EText;
import utils.Flow;
import utils.ShutDown;

public class ChooseAction extends AGameState {

	@Override
	public void execute() {

		EText.CHOOSE_ACTION.show();
		EText.EXPLORE_OPTION.show();
		EText.RECRUIT_OPTION.show();
		EText.FIGHT_OPTION.show();
		EText.PASS.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		Class<? extends AGameState> gameState = null;

		switch (eText) {

		case EXPLORE_OPTION:
			gameState = ActionExplore.class;
			break;

		case RECRUIT_OPTION:
			gameState = ActionRecruit.class;
			break;

		case FIGHT_OPTION:
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
