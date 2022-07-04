package gameStates;

import controllers.Lists;
import controllers.Party;
import enums.EText;
import models.ACard;
import utils.ArrayList;
import utils.Flow;

public class PutSelectedCardsToTheBottomOfTheDeck extends AGameState {

	private ACard cardEncounter = null;
	private ArrayList<ACard> cardsParty = new ArrayList<>();

	@Override
	public void execute() {

		this.cardEncounter = Lists.INSTANCE.encounter.getArrayList().getRandom();

		for (ACard card : Party.INSTANCE.getFightAbleCards()) {

			if (!card.isSelected())
				continue;

			this.cardsParty.addLast(card);

		}

		EText.PUT_CARD_TO_BOTTOM.show();

	}

	private void checkForLastCardAndProceed() {

		int cardsRemaining = this.cardsParty.size();

		if (this.cardEncounter != null)
			cardsRemaining++;

		if (cardsRemaining > 1)
			return;

		else if (cardsRemaining == 1) {

			if (this.cardEncounter != null)
				handleCardPressedEncounter(this.cardEncounter);

			else
				handleCardPressedParty(this.cardsParty.getFirst());

		} else {

			concealText();
			Party.INSTANCE.relocate();
			Flow.INSTANCE.proceed();

		}

	}

	@Override
	protected void handleCardPressedEncounter(ACard card) {

		Lists.INSTANCE.encounter.getArrayList().remove(card);
		card.reverseSelectImageView();

		card.flipSideEnemy();
		Lists.INSTANCE.deck.getArrayList().addLast(card);
		Lists.INSTANCE.deck.relocateImageViews();

		this.cardEncounter = null;

		checkForLastCardAndProceed();

	}

	@Override
	protected void handleCardPressedParty(ACard card) {

		if (!this.cardsParty.contains(card))
			return;

		Party.INSTANCE.removeCard(card);
		this.cardsParty.remove(card);
		card.reverseSelectImageView();

		Lists.INSTANCE.deck.getArrayList().addLast(card);
		Lists.INSTANCE.deck.relocateImageViews();

		checkForLastCardAndProceed();

	}

}
