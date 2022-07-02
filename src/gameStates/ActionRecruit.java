package gameStates;

import controllers.Lists;
import enums.EText;
import models.ACard;
import utils.ArrayList;

public class ActionRecruit extends AGameState {

	private ArrayList<ACard> cardsRecruitable = new ArrayList<>();

	@Override
	public void execute() {

		populateCardsRecruitable();
		
		EText.RECRUIT_INDICATOR.show();

	}

	private void populateCardsRecruitable() {

		// deck

		if (!Lists.INSTANCE.deck.getArrayList().isEmpty())
			checkCard(Lists.INSTANCE.deck.getArrayList().getFirst());

		// encounter

		checkCard(Lists.INSTANCE.encounter.getArrayList().getFirst());

		// quests

		if (!Lists.INSTANCE.questLeft.getArrayList().isEmpty())
			for (ACard card : Lists.INSTANCE.questLeft)
				checkCard(card);

		if (!Lists.INSTANCE.questRight.getArrayList().isEmpty())
			for (ACard card : Lists.INSTANCE.questRight)
				checkCard(card);

	}

	private void checkCard(ACard card) {

		if (!card.getSideEnemy().hasScull())
			this.cardsRecruitable.addLast(card);

	}

}
