package controllers;

import models.ACard;
import utils.ArrayList;
import utils.Enums.LayerZListEnum;
import utils.Enums.RearrangeTypeEnum;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum Lists {

	INSTANCE;

	public final ArrayList<ListImageViewAbles<IImageViewAble>> lists = new ArrayList<ListImageViewAbles<IImageViewAble>>();
	public ListImageViewAbles<ACard> deck, encounter;

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
