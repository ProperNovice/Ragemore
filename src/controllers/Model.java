package controllers;

import enums.ESuit;
import models.ACard;
import utils.ArrayList;
import utils.ListImageViewAbles;

public enum Model {

	INSTANCE;

	public void rearrangeQuestsFinished() {

		ArrayList<ESuit> eSuits = new ArrayList<>();

		// create suits list

		for (ACard card : Lists.INSTANCE.questsFinished) {

			ESuit eSuit = card.getSideEnemy().getESuit();

			if (!eSuits.contains(eSuit))
				eSuits.addLast(eSuit);

		}

		// rearrange list

		for (ESuit eSuit : eSuits) {

			for (ACard card : Lists.INSTANCE.questsFinished.getArrayList().clone()) {

				ESuit eSuitCard = card.getSideEnemy().getESuit();

				if (!eSuitCard.equals(eSuit))
					continue;

				Lists.INSTANCE.questsFinished.getArrayList().remove(card);
				Lists.INSTANCE.questsFinished.getArrayList().addLast(card);

			}

		}
		
		Lists.INSTANCE.questsFinished.relocateImageViews();

	}

	public void drawEncounter() {

		ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
		Lists.INSTANCE.encounter.getArrayList().addLast(card);
		Lists.INSTANCE.encounter.relocateImageViews();

	}

	public void startGame() {

		// load lists

		Lists.INSTANCE.loadListsOriginal();
		Party.INSTANCE.clearCards();

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		for (ACard card : Lists.INSTANCE.deck)
			card.flipSideEnemy();

		// set up quests

		setUpQuest(Lists.INSTANCE.questLeft, 3, true);
		setUpQuest(Lists.INSTANCE.questRight, 2, false);

		// set up party

		setUpPartyLock();

	}

	private void setUpPartyLock() {

		for (int counter = 1; counter <= 3; counter++) {

			ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
			card.flipSideHero();
			Party.INSTANCE.addCard(card);

		}

		Party.INSTANCE.relocate();

	}

	private void setUpQuest(ListImageViewAbles<ACard> quest, int numberOfCards, boolean left) {

		while (quest.getArrayList().size() < numberOfCards) {

			boolean addCard = false;

			ACard card = Lists.INSTANCE.deck.getArrayList().getRandom();

			if (quest.getArrayList().isEmpty())
				addCard = true;

			else if (left && !card.getSideEnemy().getESuit()
					.equals(quest.getArrayList().getFirst().getSideEnemy().getESuit()))
				addCard = true;

			else if (!left && !card.getSideEnemy().getESuit()
					.equals(quest.getArrayList().getLast().getSideEnemy().getESuit()))
				addCard = true;

			if (!addCard)
				continue;

			Lists.INSTANCE.deck.getArrayList().remove(card);

			if (left)
				quest.getArrayList().addFirst(card);
			else
				quest.getArrayList().addLast(card);

		}

		quest.relocateImageViews();

	}

}
