package gameStates;

import controllers.Lists;
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
import utils.ShutDown;

public class ActionRecruit extends AGameState {

	private ArrayList<ACard> cardsRecruitable = new ArrayList<>();
	private ACard cardPartySelected = null;
	private ArrayList<ACard> cardsMonsterSelected = new ArrayList<>();

	@Override
	public void execute() {

		populateCardsRecruitable();
		handleETextOptions();

	}

	private void executeRecruit() {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		ArrayList<ListImageViewAbles<ACard>> lists = new ArrayList<>();
		lists.addLast(Lists.INSTANCE.deck);
		lists.addLast(Lists.INSTANCE.encounter);
		lists.addLast(Lists.INSTANCE.questLeft);
		lists.addLast(Lists.INSTANCE.questRight);

		for (ACard card : this.cardsMonsterSelected) {

			card.flipSideHero();

			for (ListImageViewAbles<ACard> list : lists)
				if (list.getArrayList().contains(card))
					list.getArrayList().remove(card);

			Party.INSTANCE.addCard(card);

		}

		Party.INSTANCE.removeCard(this.cardPartySelected);
		this.cardPartySelected.flipSideEnemy();
		Lists.INSTANCE.deck.getArrayList().addLast(this.cardPartySelected);

		for (ListImageViewAbles<ACard> list : lists)
			list.relocateImageViews();
		Party.INSTANCE.relocate();

	}

	@Override
	protected void executeTextOption(EText eText) {

		switch (eText) {

		case CONTINUE:
			executeRecruit();
			Flow.INSTANCE.getFlow().addFirst(CheckQuestsForConsecutiveSymbols.class);
			break;

		case CANCEL:
			SelectImageViewManager.INSTANCE.releaseSelectImageViews();
			Flow.INSTANCE.getFlow().addFirst(ChooseAction.class);
			break;

		default:
			ShutDown.INSTANCE.execute();
			break;

		}

		Flow.INSTANCE.proceed();

	}

	private void handleCardMonsterPressed(ACard card) {

		if (!this.cardsRecruitable.contains(card))
			return;

		if (this.cardsMonsterSelected.contains(card))
			this.cardsMonsterSelected.remove(card);
		else
			this.cardsMonsterSelected.addLast(card);

		card.reverseSelectImageView();

		handleETextOptions();

	}

	@Override
	protected void handleCardPressedDeck(ACard card) {
		handleCardMonsterPressed(card);
	}

	@Override
	protected void handleCardPressedEncounter(ACard card) {
		handleCardMonsterPressed(card);
	}

	@Override
	protected void handleCardPressedQuestLeft(ACard card) {
		handleCardMonsterPressed(card);
	}

	@Override
	protected void handleCardPressedQuestRight(ACard card) {
		handleCardMonsterPressed(card);
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

	private void populateCardsRecruitable() {

		// deck

		if (!Lists.INSTANCE.deck.getArrayList().isEmpty())
			checkCard(Lists.INSTANCE.deck.getArrayList().getFirst());

		// encounter

		checkCard(Lists.INSTANCE.encounter.getArrayList().getFirst());

		// quests

		if (!Lists.INSTANCE.questLeft.getArrayList().isEmpty())
			for (ACard card : Lists.INSTANCE.questLeft)
				checkCard(card);

		if (!Lists.INSTANCE.questRight.getArrayList().isEmpty())
			for (ACard card : Lists.INSTANCE.questRight)
				checkCard(card);

	}

	private void checkCard(ACard card) {

		if (!card.getSideEnemy().hasScull())
			this.cardsRecruitable.addLast(card);

	}

	private void handleETextOptions() {

		concealText();

		HashMap<ESuit, IntegerNumber> eSuits = new HashMap<>();

		for (ESuit eSuit : ESuit.values())
			eSuits.put(eSuit, new IntegerNumber());

		EText.RECRUIT_INDICATOR.show();

		boolean canRecruit = true;

		if (this.cardPartySelected == null)
			canRecruit = false;

		else
			canRecruit = canRecruit();

		if (canRecruit)
			EText.CONTINUE.show();

		EText.CANCEL.show();

	}

	private boolean canRecruit() {

		ArrayList<ESuit> eSuitList = new ArrayList<>();

		for (ACard card : this.cardsMonsterSelected)
			eSuitList.addLast(card.getSideEnemy().getESuit());

		for (ESuit eSuit : this.cardPartySelected.getSideHero().getSkills()) {

			if (!eSuitList.contains(eSuit))
				return false;

			eSuitList.remove(eSuit);

		}

		return eSuitList.isEmpty();

	}

}
