package controllers;

import utils.ArrayList;
import utils.Background;
import utils.Enums.RearrangeTypeEnum;
import utils.SelectImageView;
import utils.Vector2;

public enum Credentials {

	INSTANCE;

	public final String primaryStageTitle = "JavaFX", numbersImageViewColor = "black";
	public final boolean colliderVisibility = true;
	public final double gapBetweenBorders = 25, textHeight = 50,
			selectEventHandlerAbleDimension = 100, listQuantityRatioDimensions = 0.5,
			animationStep = 4;
	public Vector2 dFrame, dGapBetweenComponents, dGapBetweenComponentsLineCast;
	public Vector2 cTextPanel;
	public ArrayList<Class<?>> lineCastExcludeList = new ArrayList<Class<?>>();
	public RearrangeTypeEnum rearrangeTypeEnumText = RearrangeTypeEnum.LINEAR;
	public Vector2 dCard;
	public Vector2 cDeck;

	private Credentials() {

		this.lineCastExcludeList.addLast(SelectImageView.class);
		this.lineCastExcludeList.addLast(Background.class);

		double x = 0, y = 0;

		this.dFrame = new Vector2(1920, 1368);
		this.dGapBetweenComponents = new Vector2(4, 4);
		this.dGapBetweenComponentsLineCast = this.dGapBetweenComponents;

		// c text panel

		this.cTextPanel = new Vector2(x, y);

		// d card

		y = this.dFrame.y;
		y -= 2 * this.gapBetweenBorders;
		y -= 2 * this.dGapBetweenComponents.y;
		y /= 3;
		x = (y / 1050) * 750;

		this.dCard = new Vector2(x, y);

		// c deck

		x = this.dFrame.x / 2;
		x -= this.dGapBetweenComponents.x;
		x -= this.dCard.x;
		y = this.gapBetweenBorders;

		this.cDeck = new Vector2(x, y);

	}

}
