package gameStates;

import controllers.Lists;
import controllers.Model;
import controllers.Party;
import enums.ESuit;
import enums.EText;
import models.ACard;
import utils.ArrayList;
import utils.Flow;
import utils.HashMap;
import utils.IntegerNumber;
import utils.ListImageViewAbles;
import utils.SelectImageViewManager;

public class ActionExplore extends AGameState {

	private ACard cardPartySelected = null;
	private ArrayList<ACard> cardsQuestLeftSelected, cardsQuestRightSelected;

	public ActionExplore() {

		this.cardsQuestLeftSelected = new ArrayList<>();
		this.cardsQuestRightSelected = new ArrayList<>();

	}

	@Override
	public void execute() {
		handleETextOptions();
	}

	private void handleETextOptions() {

		concealText();

		HashMap<ESuit, IntegerNumber> eSuits = new HashMap<>();

		for (ESuit eSuit : ESuit.values())
			eSuits.put(eSuit, new IntegerNumber());

		EText.EXPLORE_INDICATOR.show();

		boolean canExplore = true;

		if (this.cardPartySelected == null)
			canExplore = false;

		else if (this.cardsQuestLeftSelected.isEmpty() && this.cardsQuestRightSelected.isEmpty())
			canExplore = false;

		else if (!this.cardsQuestLeftSelected.isEmpty())
			canExplore = canExplore(this.cardsQuestLeftSelected);

		else if (!this.cardsQuestRightSelected.isEmpty())
			canExplore = canExplore(this.cardsQuestRightSelected);

		if (canExplore)
			EText.CONTINUE.show();

		EText.CANCEL.show();

	}

	private boolean canExplore(ArrayList<ACard> questList) {

		ArrayList<ESuit> eSuitsList = new ArrayList<>();

		for (ACard card : questList)
			eSuitsList.addLast(card.getSideEnemy().getESuit());

		for (ESuit eSuit : this.cardPartySelected.getSideHero().getSkills())
			if (!eSuitsList.contains(eSuit))
				return false;
			else
				eSuitsList.remove(eSuit);

		if (eSuitsList.isEmpty())
			return true;
		else
			return false;

	}

	@Override
	protected void handleCardPressedQuestLeft(ACard card) {
		executeCardPressedQuest(card, this.cardsQuestLeftSelected, this.cardsQuestRightSelected);
	}

	@Override
	protected void handleCardPressedQuestRight(ACard card) {
		executeCardPressedQuest(card, this.cardsQuestRightSelected, this.cardsQuestLeftSelected);
	}

	private void executeCardPressedQuest(ACard card, ArrayList<ACard> questPressed,
			ArrayList<ACard> questNotPressed) {

		if (questPressed.contains(card))
			questPressed.remove(card);
		else
			questPressed.addLast(card);

		card.reverseSelectImageView();

		for (ACard aCard : questNotPressed.clone())
			aCard.reverseSelectImageView();

		questNotPressed.clear();

		handleETextOptions();

	}

	@Override
	protected void handleCardPressedParty(ACard card) {

		if (this.cardPartySelected == null) {

			this.cardPartySelected = card;
			this.cardPartySelected.reverseSelectImageView();

		} else if (this.cardPartySelected.equals(card)) {

			this.cardPartySelected.reverseSelectImageView();
			this.cardPartySelected = null;

		} else {

			this.cardPartySelected.reverseSelectImageView();
			this.cardPartySelected = card;
			this.cardPartySelected.reverseSelectImageView();

		}

		if (this.cardPartySelected != null)
			handleETextOptions();

	}

	@Override
	protected void executeTextOption(EText eText) {

		switch (eText) {

		case CANCEL:
			Flow.INSTANCE.getFlow().addFirst(ChooseAction.class);
			break;

		case CONTINUE:
			executeExplore();
			Flow.INSTANCE.getFlow().addFirst(CheckQuestsForConsecutiveSymbols.class);
			break;

		default:
			break;

		}

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();
		Flow.INSTANCE.proceed();

	}

	private void executeExplore() {

		ListImageViewAbles<ACard> listImageViewAbles = null;

		if (!this.cardsQuestLeftSelected.isEmpty())
			listImageViewAbles = Lists.INSTANCE.questLeft;
		else if (!this.cardsQuestRightSelected.isEmpty())
			listImageViewAbles = Lists.INSTANCE.questRight;

		for (ACard card : listImageViewAbles.getArrayList().clone()) {

			if (!card.isSelected())
				continue;

			listImageViewAbles.getArrayList().remove(card);
			Lists.INSTANCE.questsFinished.getArrayList().addLast(card);

		}

		listImageViewAbles.relocateImageViews();
		Model.INSTANCE.rearrangeQuestsFinished();

		Party.INSTANCE.removeCard(this.cardPartySelected);
		Party.INSTANCE.relocate();

		this.cardPartySelected.flipSideEnemy();

		Lists.INSTANCE.deck.getArrayList().addLast(this.cardPartySelected);
		Lists.INSTANCE.deck.relocateImageViews();

	}

}
