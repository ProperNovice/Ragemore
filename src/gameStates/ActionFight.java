package gameStates;

import controllers.Lists;
import controllers.Party;
import enums.EText;
import models.ACard;
import utils.ArrayList;
import utils.Flow;
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

	}

	@Override
	protected void executeTextOption(EText eText) {

		Lists.INSTANCE.encounter.getArrayList().getRandom().reverseSelectImageView();

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
