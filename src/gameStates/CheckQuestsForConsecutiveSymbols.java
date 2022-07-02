package gameStates;

import controllers.Lists;
import models.ACard;
import utils.Flow;
import utils.ListImageViewAbles;
import utils.SelectImageViewManager;

public class CheckQuestsForConsecutiveSymbols extends AGameState {

	@SuppressWarnings("unchecked")
	@Override
	public void execute() {

		checkQuest(Lists.INSTANCE.questLeft);
		checkQuest(Lists.INSTANCE.questRight);

		if (SelectImageViewManager.INSTANCE.sizeSelectImageViewAbles() > 0)
			Flow.INSTANCE.getFlow().addAllFirst(DiscardQuest.class,
					CheckQuestsForConsecutiveSymbols.class);

		Flow.INSTANCE.proceed();

	}

	private void checkQuest(ListImageViewAbles<ACard> list) {

		ACard cardPrevious = null;

		for (ACard cardChecking : list) {

			if (cardPrevious != null) {

				if (cardPrevious.getSideEnemy().getESuit()
						.equals(cardChecking.getSideEnemy().getESuit())) {

					if (!cardPrevious.isSelected())
						cardPrevious.setSelected();

					cardChecking.setSelected();

				}

			}

			cardPrevious = cardChecking;

		}

	}

}
