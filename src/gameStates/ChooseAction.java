package gameStates;

import controllers.Model;
import enums.EText;

public class ChooseAction extends AGameState {

	@Override
	public void execute() {

		if (Model.INSTANCE.canExplore())
			EText.EXPLORE.show();
		if (Model.INSTANCE.canRecruit())
			EText.RECRUIT.show();
		if (Model.INSTANCE.canFight())
			EText.FIGHT.show();

	}

}
