package gameStates;

import controllers.Lists;
import controllers.Model;
import controllers.Party;
import models.ACard;
import models.WinLoseConditions;
import utils.ArrayList;
import utils.Flow;

public class JUnit extends AGameState {

	@Override
	public void execute() {

		WinLoseConditions.INSTANCE.toString();
//
//		Model.INSTANCE.drawEncounter();
//
//		addCardsToQuests(2, 1);
//		addCardsToParty(8);
//		addCardsToQuestsFinished(9);
//		addCardsToGraveyard(2);
//		putSelectedCardsToTheBottomOfTheDeck();

//		Flow.INSTANCE.getFlow().addLast(ActionFight.class);
		Flow.INSTANCE.getFlow().addLast(StartGame.class);
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

		Model.INSTANCE.rearrangeQuestsFinished();

	}

	public void addCardsToGraveyard(int cardsToAdd) {

		for (int counter = 1; counter <= cardsToAdd; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			Lists.INSTANCE.graveyard.getArrayList().addLast(card);

		}

		Lists.INSTANCE.graveyard.relocateImageViews();

	}

}
