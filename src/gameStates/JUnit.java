package gameStates;

import controllers.Model;

public class JUnit extends AGameState {

	@Override
	public void execute() {

		Model.INSTANCE.startGame();

	}

}
