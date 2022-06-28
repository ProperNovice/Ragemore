package controllers;

import models.ACard;
import utils.ArrayList;
import utils.Enums.DirectionEnum;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum Lists {

	INSTANCE;

	public final ArrayList<ListImageViewAbles<IImageViewAble>> lists = new ArrayList<ListImageViewAbles<IImageViewAble>>();
	public ListImageViewAbles<ACard> deck, encounter, questLeft, questRight;

	public void instantiate() {

		// deck

		this.deck = new ListImageViewAbles<>();
		this.deck.getListCredentials().coordinatesList = Credentials.INSTANCE.cDeck;
		this.deck.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.deck.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;

		// encounter

		this.encounter = new ListImageViewAbles<>();
		this.encounter.getListCredentials().coordinatesList = Credentials.INSTANCE.cEncounter;
		this.encounter.getListCredentials().rearrangeTypeEnum = RearrangeTypeEnum.STATIC;
		this.encounter
				.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;

		// quest left

		this.questLeft = new ListImageViewAbles<>();
		this.questLeft.getListCredentials().coordinatesList = Credentials.INSTANCE.cQuestLeft;
		this.questLeft
				.getListCredentials().layerZListEnum = LayerZListEnum.TO_FRONT_FIRST_IMAGEVIEW;
		this.questLeft.getListCredentials().gapBetweenComponents.x = Credentials.INSTANCE.dCard.x
				* 0.3;
		this.questLeft.getListCredentials().directionEnumHorizontal = DirectionEnum.LEFT;
		this.questLeft.getArrayList().setCapacity(3);

		// quest right

		this.questRight = new ListImageViewAbles<>();
		this.questRight.getListCredentials().coordinatesList = Credentials.INSTANCE.cQuestRight;
		this.questRight
				.getListCredentials().layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;
		this.questRight.getListCredentials().gapBetweenComponents = this.questLeft
				.getListCredentials().gapBetweenComponents;
		this.questRight.getArrayList().setCapacity(3);

	}

	public void saveListsOriginal() {

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().saveOriginal();

	}

	public void loadListsOriginal() {

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().clear();

		for (ListImageViewAbles<IImageViewAble> list : this.lists)
			list.getArrayList().loadOriginal();

	}

}
