package gameStates;

import controllers.Hand;
import controllers.Lists;
import controllers.Model;
import enums.EText;
import models.ACard;

public class JUnit extends AGameState {

	@Override
	public void execute() {

//		Model.INSTANCE.startGame();

		EText.CONTINUE.show();

	}

	@Override
	protected void executeTextOption(EText eText) {

		while (Lists.INSTANCE.deck.getArrayList().size() > 1) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			card.flipSideHero();
			Hand.INSTANCE.addCard(card);

		}

	}

}
