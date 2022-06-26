package cards;

import enums.ESuit;
import utils.ImageView;
import utils.Interfaces.IEventHandlerAble;
import utils.Interfaces.IImageViewAble;

public abstract class Card implements IImageViewAble, IEventHandlerAble {

	private ESuit eSuit = null;
	private int strength = -1;

	public Card(int cardNumber, ESuit eSuit, int strength) {

		this.eSuit = eSuit;
		this.strength = strength;

		createImageView(cardNumber);

	}

	private void createImageView(int cardNumber) {

		String fileName = "cards/";
		fileName += getFolderName();
		fileName += cardNumber;
		fileName += ".png";

		new ImageView(fileName, this);

	}

	public ESuit getESuit() {
		return this.eSuit;
	}

	public Integer getStrength() {
		return this.strength;
	}

	protected abstract String getFolderName();

}
