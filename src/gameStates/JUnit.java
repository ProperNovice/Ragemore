package gameStates;

import controllers.Lists;
import controllers.Model;
import controllers.Party;
import models.ACard;
import utils.ArrayList;
import utils.Flow;

public class JUnit extends AGameState {

	@Override
	public void execute() {

		Model.INSTANCE.drawEncounter();

		addCardsToQuests(3, 2);
		addCardsToParty(4);
		addCardsToQuestsFinished(0);
		addCardsToGraveyard(0);
//		putSelectedCardsToTheBottomOfTheDeck();

		Flow.INSTANCE.getFlow().addLast(ResolveEncounter.class);
		Flow.INSTANCE.proceed();

	}

	public void putSelectedCardsToTheBottomOfTheDeck() {

		Lists.INSTANCE.encounter.getArrayList().getRandom().setSelected();

		ArrayList<ACard> party = Party.INSTANCE.getFightAbleCards();

		for (int counter = 1; counter <= 1; counter++)
			if (!party.isEmpty())
				party.removeRandom();

		for (ACard card : party)
			card.setSelected();

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
			Party.INSTANCE.relocate();

		}

	}

	public void addCardsToQuestsFinished(int cardsToAdd) {

		for (int counter = 1; counter <= cardsToAdd; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			Lists.INSTANCE.questsFinished.getArrayList().addLast(card);

		}

		Lists.INSTANCE.questsFinished.relocateImageViews();

	}

	public void addCardsToGraveyard(int cardsToAdd) {

		for (int counter = 1; counter <= cardsToAdd; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			Lists.INSTANCE.graveyard.getArrayList().addLast(card);

		}

		Lists.INSTANCE.graveyard.relocateImageViews();

	}

}
