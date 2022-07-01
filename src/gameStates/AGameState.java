package gameStates;

import controllers.Lists;
import controllers.Party;
import enums.EText;
import javafx.scene.input.KeyCode;
import models.ACard;
import utils.KeyCodeHandler;
import utils.Logger;
import utils.Text;

public abstract class AGameState {

	public abstract void execute();

	public final void handleTextOptionPressed(EText textEnum) {

		Logger.INSTANCE.log("text option executing");
		Logger.INSTANCE.logNewLine(textEnum);

		concealText();
		executeTextOption(textEnum);

	}

	public final void executeKeyPressed(KeyCode keyCode) {

		int keyCodeID = KeyCodeHandler.INSTANCE.getKeyCodeInt(keyCode);

		if (keyCodeID == -1)
			return;

		EText textEnumPressed = Text.INSTANCE.getTextEnumOptionPressed(keyCodeID);

		if (textEnumPressed == null)
			return;

		Logger.INSTANCE.log("executing key pressed -> " + keyCode);
		handleTextOptionPressed(textEnumPressed);

	}

	protected void executeTextOption(EText eText) {

	}

	protected final void concealText() {
		Text.INSTANCE.concealText();
	}

	public final void handleCardPressed(ACard card) {

		if (Lists.INSTANCE.deck.getArrayList().contains(card))
			handleCardPressedDeck(card);

		else if (Lists.INSTANCE.encounter.getArrayList().contains(card))
			handleCardPressedEncounter(card);

		else if (Lists.INSTANCE.questLeft.getArrayList().contains(card)) {

			handleCardPressedQuest(card);
			handleCardPressedQuestLeft(card);

		} else if (Lists.INSTANCE.questRight.getArrayList().contains(card)) {

			handleCardPressedQuest(card);
			handleCardPressedQuestRight(card);

		}

		else if (Party.INSTANCE.contains(card))
			handleCardPressedParty(card);

	}

	protected void handleCardPressedDeck(ACard card) {

	}

	protected void handleCardPressedEncounter(ACard card) {

	}

	protected void handleCardPressedQuest(ACard card) {

	}

	protected void handleCardPressedQuestLeft(ACard card) {

	}

	protected void handleCardPressedQuestRight(ACard card) {

	}

	protected void handleCardPressedParty(ACard card) {

	}

}
