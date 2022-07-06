package gameStates;

import controllers.Lists;
import controllers.Party;
import enums.EText;
import models.ACard;
import utils.ArrayList;
import utils.Flow;
import utils.SelectImageViewManager;
import utils.ShutDown;

public class ActionFight extends AGameState {

	private ArrayList<ACard> cardPartyNoPlusSelected = null;
	private ArrayList<ACard> cardPartyPlusSelected = null;
	private ArrayList<ACard> cardsPartyFightable = new ArrayList<>();

	@Override
	public void execute() {

		this.cardPartyNoPlusSelected = new ArrayList<>();
		this.cardPartyPlusSelected = new ArrayList<>();

		Lists.INSTANCE.encounter.getArrayList().getRandom().reverseSelectImageView();
		this.cardsPartyFightable.addAllFirst(Party.INSTANCE.getFightAbleCards());
		handleETextShowing();

	}

	private void executeFight() {

		int strengthMonster = Lists.INSTANCE.encounter.getArrayList().getRandom().getSideEnemy()
				.getStrength();

		int strengthHeroes = 0;

		if (!this.cardPartyNoPlusSelected.isEmpty())
			for (ACard card : this.cardPartyNoPlusSelected)
				strengthHeroes += card.getSideHero().getStrength();

		for (ACard card : this.cardPartyPlusSelected)
			strengthHeroes += card.getSideHero().getStrength();

		if (strengthHeroes > strengthMonster)
			resolveWin();
		else if (strengthHeroes < strengthMonster)
			resolveLoss();
		else
			resolveDraw();

	}

	private void resolveWin() {

		ACard card = Lists.INSTANCE.encounter.getArrayList().removeRandom();
		Party.INSTANCE.addCard(card);
		Party.INSTANCE.relocate();

	}

	private void resolveDraw() {

		Lists.INSTANCE.encounter.getArrayList().getRandom().reverseSelectImageView();

		if (!this.cardPartyNoPlusSelected.isEmpty())
			for (ACard card : this.cardPartyNoPlusSelected)
				card.reverseSelectImageView();

		if (!this.cardPartyPlusSelected.isEmpty())
			for (ACard card : this.cardPartyPlusSelected)
				card.reverseSelectImageView();

		Flow.INSTANCE.getFlow().addFirst(PutSelectedCardsToTheBottomOfTheDeck.class);

	}

	private void resolveLoss() {

		ACard cardEncounter = Lists.INSTANCE.encounter.getArrayList().removeRandom();
		Party.INSTANCE.addCard(cardEncounter);

		if (!this.cardPartyNoPlusSelected.isEmpty()) {

			for (ACard card : this.cardPartyNoPlusSelected) {

				Party.INSTANCE.removeCard(card);
				Lists.INSTANCE.graveyard.getArrayList().addLast(card);

			}

		}

		if (!this.cardPartyPlusSelected.isEmpty()) {

			for (ACard card : this.cardPartyPlusSelected) {

				Party.INSTANCE.removeCard(card);
				Lists.INSTANCE.graveyard.getArrayList().addLast(card);

			}

		}

		Lists.INSTANCE.graveyard.relocateImageViews();
		Party.INSTANCE.relocate();

	}

	@Override
	protected void executeTextOption(EText eText) {

		SelectImageViewManager.INSTANCE.releaseSelectImageViews();

		switch (eText) {

		case CONTINUE:
			executeFight();
			break;

		case CANCEL:
			Flow.INSTANCE.getFlow().addFirst(ChooseAction.class);
			break;

		default:
			ShutDown.INSTANCE.execute();
			break;

		}

		Flow.INSTANCE.proceed();

	}

	private void handleETextShowing() {

		concealText();

		EText.FIGHT_INDICATOR.show();

		if (this.cardPartyNoPlusSelected.size() + this.cardPartyPlusSelected.size() > 0)
			if (this.cardPartyNoPlusSelected.size() + this.cardPartyPlusSelected.size() <= 2)
				if (this.cardPartyNoPlusSelected.size() <= 1)
					EText.CONTINUE.show();

		EText.CANCEL.show();

	}

	@Override
	protected void handleCardPressedParty(ACard card) {

		if (!this.cardsPartyFightable.contains(card))
			return;

		if (card.getSideHero().hasPlusIcon()) {

			if (this.cardPartyPlusSelected.contains(card))
				this.cardPartyPlusSelected.remove(card);
			else
				this.cardPartyPlusSelected.addLast(card);

		} else if (!card.getSideHero().hasPlusIcon()) {

			if (this.cardPartyNoPlusSelected.contains(card))
				this.cardPartyNoPlusSelected.remove(card);
			else
				this.cardPartyNoPlusSelected.addLast(card);

		}

		card.reverseSelectImageView();
		handleETextShowing();

	}

}
