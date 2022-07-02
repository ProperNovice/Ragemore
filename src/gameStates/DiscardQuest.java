package gameStates;

import controllers.Lists;
import enums.EText;
import models.ACard;
import utils.Flow;
import utils.ListImageViewAbles;
import utils.SelectImageViewManager;

public class DiscardQuest extends AGameState {

	@Override
	public void execute() {

		EText.DISCARD_QUEST.show();

	}

	@Override
	protected void handleCardPressedQuestLeft(ACard card) {

		if (card.isSelected())
			discardCard(card, Lists.INSTANCE.questLeft);

	}

	@Override
	protected void handleCardPressedQuestRight(ACard card) {

		if (card.isSelected())
			discardCard(card, Lists.INSTANCE.questRight);

	}

	private void discardCard(ACard card, ListImageViewAbles<ACard> quest) {
		
		concealText();

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		quest.getArrayList().remove(card);
		Lists.INSTANCE.graveyard.getArrayList().addLast(card);

		quest.relocateImageViews();
		Lists.INSTANCE.graveyard.relocateImageViews();

		Flow.INSTANCE.proceed();

	}

}
