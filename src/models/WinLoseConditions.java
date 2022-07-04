package models;

import controllers.Lists;
import controllers.Model;
import controllers.Party;
import enums.ESuit;
import gameStates.AEndGame;
import gameStates.AGameState;
import gameStates.ChooseDifficultyLevel;
import gameStates.EndGameLost;
import gameStates.EndGameWon;
import gameStates.JUnit;
import gameStates.RestartGame;
import gameStates.StartGame;
import utils.AnimationTimerFX;
import utils.ArrayList;
import utils.Flow;
import utils.HashMap;
import utils.IntegerNumber;
import utils.Interfaces.IUpdateAble;

public enum WinLoseConditions implements IUpdateAble {

	INSTANCE;

	private ArrayList<Class<? extends AGameState>> gameStatesExcluded = null;

	private WinLoseConditions() {

		AnimationTimerFX.INSTANCE.updateEachFrame(this);

		this.gameStatesExcluded = new ArrayList<>();

		this.gameStatesExcluded.addLast(JUnit.class);
		this.gameStatesExcluded.addLast(EndGameWon.class);
		this.gameStatesExcluded.addLast(EndGameLost.class);
		this.gameStatesExcluded.addLast(StartGame.class);
		this.gameStatesExcluded.addLast(RestartGame.class);
		this.gameStatesExcluded.addLast(ChooseDifficultyLevel.class);

	}

	@Override
	public void update() {

		if (Flow.INSTANCE.getGameStateCurrent() == null)
			return;

		if (this.gameStatesExcluded.contains(Flow.INSTANCE.getGameStateCurrent().getClass()))
			return;

		if (gameWon())
			handleEndGame(EndGameWon.class);
		else if (gameLost())
			handleEndGame(EndGameLost.class);

	}

	private void handleEndGame(Class<? extends AEndGame> classObject) {
		Flow.INSTANCE.executeGameState(classObject);
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
