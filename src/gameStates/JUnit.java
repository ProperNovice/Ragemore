package gameStates;

import controllers.Lists;
import controllers.Model;
import controllers.Party;
import models.ACard;
import utils.Flow;

public class JUnit extends AGameState {

	@Override
	public void execute() {

		Model.INSTANCE.drawEncounter();

		addCardsToQuests(3, 2);
		addCardsToParty(3);

		Flow.INSTANCE.getFlow().addLast(ChooseAction.class);
		Flow.INSTANCE.proceed();

	}

	public void addCardsToQuests(int left, int right) {

		for (int counter = 1; counter <= left; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			Lists.INSTANCE.questLeft.getArrayList().addFirst(card);

		}

		for (int counter = 1; counter <= right; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			Lists.INSTANCE.questRight.getArrayList().addLast(card);

		}

		Lists.INSTANCE.questLeft.relocateImageViews();
		Lists.INSTANCE.questRight.relocateImageViews();

	}

	public void addCardsToParty(int cardsToAdd) {

		for (int counter = 1; counter <= cardsToAdd; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			card.flipSideHero();
			Party.INSTANCE.addCard(card);

		}

	}

}
