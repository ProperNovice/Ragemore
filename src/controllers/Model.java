package controllers;

import models.ACard;
import utils.ListImageViewAbles;
import utils.Sleep;

public enum Model {

	INSTANCE;

	public void drawEncounter() {

		ACard card = Lists.INSTANCE.deck.getArrayList().removeFirst();
		Lists.INSTANCE.encounter.getArrayList().addLast(card);
		Lists.INSTANCE.encounter.animateSynchronousLock();

	}

	public void startGame() {

		// load lists

		Lists.INSTANCE.loadListsOriginal();

		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

		// set up quests

		setUpQuest(Lists.INSTANCE.questLeft, 3);
		setUpQuest(Lists.INSTANCE.questRight, 2);

		// draw encounter
		
		drawEncounter();

	}

	private void setUpQuest(ListImageViewAbles<ACard> quest, int numberOfCards) {

		while (quest.getArrayList().size() < numberOfCards) {

			boolean addCard = false;

			ACard card = Lists.INSTANCE.deck.getArrayList().getRandom();

			if (quest.getArrayList().isEmpty())
				addCard = true;

			else if (!card.getSideEnemy().getESuit()
					.equals(quest.getArrayList().getLast().getSideEnemy().getESuit()))
				addCard = true;

			if (!addCard)
				continue;

			Lists.INSTANCE.deck.getArrayList().remove(card);

			quest.getArrayList().addLast(card);
			quest.animateSynchronousLock();
			Sleep.INSTANCE.sleep(150);

		}

	}

}
