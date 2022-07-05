package controllers;

import utils.ArrayList;
import utils.Background;
import utils.Enums.RearrangeTypeEnum;
import utils.SelectImageView;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "Ragemore", numbersImageViewColor = "black";
	public final boolean colliderVisibility = true;
	public final double gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = 100, listQuantityRatioDimensions = 0.25,
			animationStep = 4;
	public Vector2 dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel;
	public ArrayList<Class<?>> lineCastExcludeList = new ArrayList<Class<?>>();
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;
	public Vector2 dCard;
	public Vector2 cDeck, cEncounter, cQuestLeft, cQuestRight, cQuestsFinished, cGraveyard;
	public Vector2 selectCardRatioPosition = new Vector2(0.2, 0.88);
	public double selectCardRatioDimension = 0.25;

	private Credentials() {

		this.lineCastExcludeList.addLast(SelectImageView.class);
		this.lineCastExcludeList.addLast(Background.class);

		double x = 0, y = 0;

		this.dFrame = new Vector2(1920, 1368);
		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// d card

		y = this.dFrame.y;
		y -= 2 * this.gapBetweenBorders;
		y -= 2 * this.dGapBetweenComponents.y;
		y /= 3.4;
		x = (y / 437) * 312;
		this.dCard = new Vector2(x, y);

		// c deck

		x = this.dFrame.x / 2;
		x -= 2 * this.dGapBetweenComponents.x;
		x -= this.dCard.x;
		y = this.gapBetweenBorders;
		this.cDeck = new Vector2(x, y);

		// c encounter

		x = this.dFrame.x / 2;
		x += 2 * this.dGapBetweenComponents.x;
		y = this.cDeck.y;
		this.cEncounter = new Vector2(x, y);

		// c quest left

		x = this.cDeck.x;
		y = this.gapBetweenBorders;
		y += this.dCard.y;
		y += this.dGapBetweenComponents.y;
		this.cQuestLeft = new Vector2(x, y);

		// c quest right

		x = this.cEncounter.x;
		y = this.gapBetweenBorders;
		y += this.dCard.y;
		y += this.dGapBetweenComponents.y;
		this.cQuestRight = new Vector2(x, y);

		// c text panel

		x = this.cEncounter.x;
		x += this.dCard.x;
		x += 4 * this.dGapBetweenComponents.x;
		y = this.cEncounter.y;
		y += this.dCard.y / 2;
		this.cTextPanel = new Vector2(x, y);
		this.rearrangeTypeEnumText = RearrangeTypeEnum.PIVOT;

		// c quests finished

		x = this.dFrame.x;
		x -= this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cQuestsFinished = new Vector2(x, y);

		// c grave yard

		x = this.gapBetweenBorders;
		y = this.gapBetweenBorders;
		this.cGraveyard = new Vector2(x, y);

	}

}
