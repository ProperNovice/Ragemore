package gameStates;

import controllers.Lists;
import enums.ESuit;
import enums.EText;
import models.ACard;
import utils.Flow;
import utils.ShutDown;

public class PutEncounterCardToQuest extends AGameState {

	private ACard cardEncounter = null;

	@Override
	public void execute() {

		if (Lists.INSTANCE.encounter.getArrayList().isEmpty()) {
			Flow.INSTANCE.proceed();
			return;
		}

		this.cardEncounter = Lists.INSTANCE.encounter.getArrayList().removeRandom();

		ESuit eSuitEncounter = this.cardEncounter.getSideEnemy().getESuit();

		boolean canBePlacedOnQuestLeft = false;
		boolean canBePlacedOnQuestRight = false;

		if (!Lists.INSTANCE.questLeft.getArrayList().isEmpty()) {

			ACard cardQuest = Lists.INSTANCE.questLeft.getArrayList().getFirst();
			ESuit eSuitQuest = cardQuest.getSideHero().getESuit();

			if (!eSuitEncounter.equals(eSuitQuest))
				canBePlacedOnQuestLeft = true;

		}

		if (!Lists.INSTANCE.questRight.getArrayList().isEmpty()) {

			ACard cardQuest = Lists.INSTANCE.questRight.getArrayList().getLast();
			ESuit eSuitQuest = cardQuest.getSideHero().getESuit();

			if (!eSuitEncounter.equals(eSuitQuest))
				canBePlacedOnQuestRight = true;

		}

		if (canBePlacedOnQuestLeft && canBePlacedOnQuestRight) {

			EText.CHOOSE_QUEST_PILE.show();
			EText.LEFT.show();
			EText.RIGHT.show();

		} else if (canBePlacedOnQuestLeft)
			placeEncounterOnLeftQuest();

		else if (canBePlacedOnQuestRight)
			placeEncounterOnRightQuest();

		else
			placeEncounterOnGraveyard();

	}

	@Override
	protected void executeTextOption(EText eText) {

		switch (eText) {

		case LEFT:
			placeEncounterOnLeftQuest();
			break;

		case RIGHT:
			placeEncounterOnRightQuest();
			break;

		default:
			ShutDown.INSTANCE.execute();
			break;

		}

	}

	private void placeEncounterOnLeftQuest() {

		Lists.INSTANCE.questLeft.getArrayList().addFirst(this.cardEncounter);
		Lists.INSTANCE.questLeft.relocateImageViews();
		Flow.INSTANCE.proceed();

	}

	private void placeEncounterOnRightQuest() {

		Lists.INSTANCE.questRight.getArrayList().addLast(this.cardEncounter);
		Lists.INSTANCE.questRight.relocateImageViews();
		Flow.INSTANCE.proceed();

	}

	private void placeEncounterOnGraveyard() {

		Lists.INSTANCE.graveyard.getArrayList().addLast(this.cardEncounter);
		Lists.INSTANCE.graveyard.relocateImageViews();
		Flow.INSTANCE.proceed();

	}

}
