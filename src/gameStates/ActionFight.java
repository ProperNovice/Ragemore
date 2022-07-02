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

	private ACard cardPartyNoPlusSelected = null;
	private ACard cardPartyPlusSelected = null;
	private ArrayList<ACard> cardsPartyFightable = new ArrayList<>();

	@Override
	public void execute() {

		Lists.INSTANCE.encounter.getArrayList().getRandom().reverseSelectImageView();
		this.cardsPartyFightable.addAllFirst(Party.INSTANCE.getFightAbleCards());
		handleETextShowing();

	}

	private void executeFight() {

		int strengthMonster = Lists.INSTANCE.encounter.getArrayList().getRandom().getSideEnemy()
				.getStrength();

		int strengthHeroes = 0;

		if (this.cardPartyNoPlusSelected != null)
			strengthHeroes += this.cardPartyNoPlusSelected.getSideHero().getStrength();

		if (this.cardPartyPlusSelected != null)
			strengthHeroes += this.cardPartyPlusSelected.getSideHero().getStrength();

		if (strengthHeroes > strengthMonster)
			resolveWin();
		else if (strengthHeroes < strengthMonster)
			resolveLoss();
		else
			resolveDraw();

	}

	private void resolveWin() {

		ACard card = Lists.INSTANCE.encounter.getArrayList().removeRandom();
		card.flipSideHero();
		Party.INSTANCE.addCard(card);
		Party.INSTANCE.relocate();

	}

	private void resolveDraw() {

		Lists.INSTANCE.encounter.getArrayList().getRandom().reverseSelectImageView();

		if (this.cardPartyNoPlusSelected != null)
			this.cardPartyNoPlusSelected.reverseSelectImageView();

		if (this.cardPartyPlusSelected != null)
			this.cardPartyPlusSelected.reverseSelectImageView();

		Flow.INSTANCE.getFlow().addFirst(PutSelectedCardsToTheBottomOfTheDeck.class);

	}

	private void resolveLoss() {

		ACard card = Lists.INSTANCE.encounter.getArrayList().removeRandom();
		card.flipSideHero();
		Party.INSTANCE.addCard(card);

		if (this.cardPartyNoPlusSelected != null) {

			this.cardPartyNoPlusSelected.flipSideEnemy();
			Party.INSTANCE.removeCard(this.cardPartyNoPlusSelected);
			Lists.INSTANCE.graveyard.getArrayList().addLast(this.cardPartyNoPlusSelected);

		}

		if (this.cardPartyPlusSelected != null) {

			this.cardPartyPlusSelected.flipSideEnemy();
			Party.INSTANCE.removeCard(this.cardPartyPlusSelected);
			Lists.INSTANCE.graveyard.getArrayList().addLast(this.cardPartyPlusSelected);

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

		if (this.cardPartyNoPlusSelected != null || this.cardPartyPlusSelected != null)
			EText.CONTINUE.show();

		EText.CANCEL.show();

	}

	@Override
	protected void handleCardPressedParty(ACard card) {

		if (!this.cardsPartyFightable.contains(card))
			return;

		if (card.getSideHero().hasPlusIcon()) {

			if (this.cardPartyPlusSelected == null) {

				this.cardPartyPlusSelected = card;
				this.cardPartyPlusSelected.reverseSelectImageView();

			} else if (this.cardPartyPlusSelected.equals(card)) {

				this.cardPartyPlusSelected.reverseSelectImageView();
				this.cardPartyPlusSelected = null;

			} else {

				this.cardPartyPlusSelected.reverseSelectImageView();
				this.cardPartyPlusSelected = card;
				this.cardPartyPlusSelected.reverseSelectImageView();

			}

		} else if (!card.getSideHero().hasPlusIcon()) {

			if (this.cardPartyNoPlusSelected == null) {

				this.cardPartyNoPlusSelected = card;
				this.cardPartyNoPlusSelected.reverseSelectImageView();

			} else if (this.cardPartyNoPlusSelected.equals(card)) {

				this.cardPartyNoPlusSelected.reverseSelectImageView();
				this.cardPartyNoPlusSelected = null;

			} else {

				this.cardPartyNoPlusSelected.reverseSelectImageView();
				this.cardPartyNoPlusSelected = card;
				this.cardPartyNoPlusSelected.reverseSelectImageView();

			}

		}

		handleETextShowing();

	}

}
