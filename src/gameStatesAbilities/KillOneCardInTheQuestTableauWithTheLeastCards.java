package gameStatesAbilities;

import controllers.Lists;
import enums.EText;
import gameStates.AGameState;
import models.ACard;
import utils.ArrayList;
import utils.Flow;
import utils.ListImageViewAbles;
import utils.SelectImageViewManager;

public class KillOneCardInTheQuestTableauWithTheLeastCards extends AGameState {

	ArrayList<ListImageViewAbles<ACard>> quests = new ArrayList<>();

	@Override
	public void execute() {

		if (Lists.INSTANCE.questLeft.getArrayList().isEmpty())
			if (Lists.INSTANCE.questRight.getArrayList().size() == 1)
				killCardProceed(Lists.INSTANCE.questRight.getArrayList().getRandom(),
						Lists.INSTANCE.questRight);
			else
				this.quests.addLast(Lists.INSTANCE.questRight);

		else if (Lists.INSTANCE.questRight.getArrayList().isEmpty())
			if (Lists.INSTANCE.questLeft.getArrayList().size() == 1)
				killCardProceed(Lists.INSTANCE.questLeft.getArrayList().getRandom(),
						Lists.INSTANCE.questLeft);
			else
				this.quests.addLast(Lists.INSTANCE.questLeft);

		else if (Lists.INSTANCE.questLeft.getArrayList().size() < Lists.INSTANCE.questRight
				.getArrayList().size())
			this.quests.addLast(Lists.INSTANCE.questLeft);

		else if (Lists.INSTANCE.questLeft.getArrayList().size() > Lists.INSTANCE.questRight
				.getArrayList().size())
			this.quests.addLast(Lists.INSTANCE.questRight);

		else {

			this.quests.addLast(Lists.INSTANCE.questLeft);
			this.quests.addLast(Lists.INSTANCE.questRight);

		}

		for (ListImageViewAbles<ACard> list : this.quests)
			for (ACard card : list)
				card.setSelected();

		if (SelectImageViewManager.INSTANCE.sizeSelectImageViewAbles() > 0)
			EText.CHOOSE_CARD_TO_KILL.show();

	}

	@Override
	protected void handleCardPressedQuestLeft(ACard card) {

		if (!this.quests.contains(Lists.INSTANCE.questLeft))
			return;

		killCardProceed(card, Lists.INSTANCE.questLeft);

	}

	@Override
	protected void handleCardPressedQuestRight(ACard card) {

		if (!this.quests.contains(Lists.INSTANCE.questRight))
			return;

		killCardProceed(card, Lists.INSTANCE.questRight);

	}

	private void killCardProceed(ACard card, ListImageViewAbles<ACard> list) {

		concealText();
		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		list.getArrayList().remove(card);
		list.relocateImageViews();
		Lists.INSTANCE.graveyard.getArrayList().addLast(card);
		Lists.INSTANCE.graveyard.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
