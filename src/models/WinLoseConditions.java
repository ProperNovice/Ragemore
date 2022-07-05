package models;

import controllers.EventManager;
import controllers.Lists;
import controllers.Model;
import controllers.Party;
import enums.ESuit;
import gameStates.AEndGame;
import gameStates.EndGameLost;
import gameStates.EndGameWon;
import interfaces.IEventAble;
import utils.Flow;
import utils.HashMap;
import utils.IntegerNumber;

public enum WinLoseConditions implements IEventAble {

	INSTANCE;

	private WinLoseConditions() {
		EventManager.INSTANCE.gameStateChange.addLast(this);
	}

	@Override
	public void eventGameStateChange() {

		if (gameWon())
			handleEndGame(EndGameWon.class);
		else if (gameLost())
			handleEndGame(EndGameLost.class);

	}

	private void handleEndGame(Class<? extends AEndGame> classObject) {
		Flow.INSTANCE.getFlow().addFirst(classObject);
	}

	private boolean gameWon() {

		HashMap<ESuit, IntegerNumber> map = new HashMap<>();

		for (ESuit eSuit : ESuit.values())
			map.put(eSuit, new IntegerNumber(0));

		for (ACard card : Lists.INSTANCE.questsFinished)
			map.getValue(card.getSideEnemy().getESuit()).add(1);

		int cardsNeeded = Model.INSTANCE.getEDifficultyLevel().getCardsNeeded(), completed = 0;

		for (ESuit eSuit : map)
			if (map.getValue(eSuit).get() >= cardsNeeded)
				completed++;

		return completed >= 2;
	}

	private boolean gameLost() {

		if (Party.INSTANCE.isEmpty())
			return true;

		else if (Lists.INSTANCE.graveyard.getArrayList().size() >= 3)
			return true;

		else if (Lists.INSTANCE.questLeft.getArrayList().size() >= 4)
			return true;

		else if (Lists.INSTANCE.questRight.getArrayList().size() >= 4)
			return true;

		else if (Lists.INSTANCE.questLeft.getArrayList().size()
				+ Lists.INSTANCE.questRight.getArrayList().size() == 0)
			return true;

		return false;

	}

}
