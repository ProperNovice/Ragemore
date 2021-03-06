package enums;

import utils.Enums.TextTypeEnum;
import utils.Text;

public enum EText {

	START_GAME("Start game", TextTypeEnum.OPTION), CONTINUE("Continue", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION), YOU_WON("You won", TextTypeEnum.INDICATOR),
	YOU_LOST("You lost", TextTypeEnum.INDICATOR), VOID("", TextTypeEnum.INDICATOR),
	DRAW_ENCOUNTER("Draw encounter", TextTypeEnum.OPTION),
	CHOOSE_ACTION("Choose action", TextTypeEnum.INDICATOR),
	EXPLORE_OPTION("Explore", TextTypeEnum.OPTION), RECRUIT_OPTION("Recruit", TextTypeEnum.OPTION),
	FIGHT_OPTION("Fight", TextTypeEnum.OPTION), PASS("Pass", TextTypeEnum.OPTION),
	EXPLORE_INDICATOR("Explore", TextTypeEnum.INDICATOR),
	RECRUIT_INDICATOR("Recruit", TextTypeEnum.INDICATOR),
	FIGHT_INDICATOR("Fight", TextTypeEnum.INDICATOR), CANCEL("Cancel", TextTypeEnum.OPTION),
	DISCARD_QUEST("Discard quest", TextTypeEnum.INDICATOR),
	PUT_CARD_TO_BOTTOM("Put card to bottom", TextTypeEnum.INDICATOR),
	PUT_CARD_TO_PARTY("Put card to party", TextTypeEnum.INDICATOR),
	RESOLVE_ABILITY("Resolve ability", TextTypeEnum.OPTION),
	CHOOSE_QUEST_PILE("Choose quest pile", TextTypeEnum.INDICATOR),
	LEFT("Left", TextTypeEnum.OPTION), RIGHT("Right", TextTypeEnum.OPTION),
	RESOLVE_ENCOUNTER("Resolve encounter", TextTypeEnum.OPTION),
	CHOOSE_CARD_TO_KILL("Choose card to kill", TextTypeEnum.INDICATOR),
	CHOOSE_CARD("Choose card", TextTypeEnum.INDICATOR),
	CHOOSE_DIFFICULTY_LEVEL("Choose difficulty level", TextTypeEnum.INDICATOR),
	NORMAL("Normal", TextTypeEnum.OPTION), HARD("Hard", TextTypeEnum.OPTION),

	;

	private TextTypeEnum textTypeEnum = null;
	private String string = null;

	private EText(String string, TextTypeEnum textTypeEnum) {

		this.string = string;
		this.textTypeEnum = textTypeEnum;

	}

	public void show() {
		Text.INSTANCE.showText(this, getString());
	}

	public void showAdditionally(String string) {
		Text.INSTANCE.showText(this, getString() + string);
	}

	public void showAdditionally(int integer) {
		showAdditionally(Integer.toString(integer));
	}

	public void showInstead(String string) {
		Text.INSTANCE.showText(this, string);
	}

	public String getString() {
		return this.string;
	}

	public TextTypeEnum getTextTypeEnum() {
		return this.textTypeEnum;
	}

}
