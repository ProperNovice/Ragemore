package gameStates;

import controllers.Lists;
import controllers.Party;
import enums.ESuit;
import enums.EText;
import models.ACard;
import utils.ArrayList;
import utils.Flow;
import utils.HashMap;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;
import utils.SelectImageViewManager;

public class PutSelectedCardsToParty extends AGameState {

	private HashMap<ESuit, ArrayList<ACard>> cards = new HashMap<>();
	private ArrayList<ListImageViewAbles<ACard>> lists = new ArrayList<>();

	@Override
	public void execute() {

		for (ESuit eSuit : ESuit.values())
			this.cards.put(eSuit, new ArrayList<>());

		this.lists.addLast(Lists.INSTANCE.deck);
		this.lists.addLast(Lists.INSTANCE.encounter);
		this.lists.addLast(Lists.INSTANCE.questLeft);
		this.lists.addLast(Lists.INSTANCE.questRight);

		for (IImageViewAble imageViewAble : SelectImageViewManager.INSTANCE
				.getSelectedImageViewAbles()) {

			ACard card = (ACard) imageViewAble;
			ESuit eSuit = card.getSideHero().getESuit();
			this.cards.getValue(eSuit).addLast(card);

		}

		handleETextShowing();

	}

	private void handleCardSelectedPressed(ACard card, ListImageViewAbles<ACard> list) {

		card.reverseSelectImageView();

		for (ESuit eSuit : ESuit.values()) {

			if (!this.cards.containsKey(eSuit))
				continue;

			ArrayList<ACard> listTemp = this.cards.getValue(eSuit);

			if (!listTemp.contains(card))
				continue;

			listTemp.remove(card);

			for (ListImageViewAbles<ACard> listT : this.lists) {

				if (!listT.getArrayList().contains(card))
					continue;

				listT.getArrayList().remove(card);
				listT.relocateImageViews();

			}

			Party.INSTANCE.addCard(card);
			Party.INSTANCE.relocate();

		}

		handleETextShowing();

	}

	@Override
	protected void handleCardPressedDeck(ACard card) {
		handleCardSelectedPressed(card, Lists.INSTANCE.deck);
	}

	@Override
	protected void handleCardPressedEncounter(ACard card) {
		handleCardSelectedPressed(card, Lists.INSTANCE.encounter);
	}

	@Override
	protected void handleCardPressedQuestLeft(ACard card) {
		handleCardSelectedPressed(card, Lists.INSTANCE.questLeft);
	}

	@Override
	protected void handleCardPressedQuestRight(ACard card) {
		handleCardSelectedPressed(card, Lists.INSTANCE.questRight);
	}

	private void handleETextShowing() {
		
		concealText();

		for (ESuit eSuit : ESuit.values()) {

			if (!this.cards.containsKey(eSuit))
				continue;

			ArrayList<ACard> list = this.cards.getValue(eSuit);

			if (list.isEmpty()) {

				this.cards.removeKey(eSuit);
				continue;

			} else if (list.size() == 1) {

				ACard card = list.removeFirst();
				card.reverseSelectImageView();
				this.cards.removeKey(eSuit);

				for (ListImageViewAbles<ACard> listTemp : this.lists) {

					if (!listTemp.getArrayList().contains(card))
						continue;

					listTemp.getArrayList().remove(card);
					listTemp.relocateImageViews();

				}

				Party.INSTANCE.addCard(card);
				Party.INSTANCE.relocate();

			}

		}

		if (this.cards.isEmpty())
			Flow.INSTANCE.proceed();
		else
			EText.PUT_CARD_TO_PARTY.show();

	}

}
