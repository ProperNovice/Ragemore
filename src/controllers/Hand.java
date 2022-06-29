package controllers;

import enums.ESuit;
import models.ACard;
import utils.ArrayList;
import utils.Enums.DirectionEnum;
import utils.Enums.LayerZListEnum;
import utils.Enums.RelocateTypeEnum;
import utils.HashMap;
import utils.ListImageViewAbles;
import utils.Lock;
import utils.Vector2;

public enum Hand {

	INSTANCE;

	private ArrayList<ListImageViewAbles<ACard>> lists = new ArrayList<>();
	private HashMap<Integer, ArrayList<Vector2>> coordinates = new HashMap<>();

	private Hand() {

		createCoordinates();

	}

	private void createCoordinates() {

		for (int counter = 1; counter <= 4; counter++)
			this.coordinates.put(counter, new ArrayList<>());

		double x;
		double y = Credentials.INSTANCE.dFrame.y;
		y -= Credentials.INSTANCE.gapBetweenBorders;
		y -= Credentials.INSTANCE.dCard.y / 2;

		// 1 column

		// 1

		x = Credentials.INSTANCE.dFrame.x / 2;
		this.coordinates.getValue(1).addLast(new Vector2(x, y));

		// 2 columns

		// 1

		x = Credentials.INSTANCE.dFrame.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x / 2;
		x -= Credentials.INSTANCE.dCard.x / 2;
		this.coordinates.getValue(2).addLast(new Vector2(x, y));

		// 2

		x += Credentials.INSTANCE.dGapBetweenComponents.x;
		x += Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(2).addLast(new Vector2(x, y));

		// 3 columns

		// 1

		x = Credentials.INSTANCE.dFrame.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x;
		x -= Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(3).addLast(new Vector2(x, y));

		// 2

		x += Credentials.INSTANCE.dGapBetweenComponents.x;
		x += Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(3).addLast(new Vector2(x, y));

		// 3

		x += Credentials.INSTANCE.dGapBetweenComponents.x;
		x += Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(3).addLast(new Vector2(x, y));
		
		// 4 columns

		// 1

		x = Credentials.INSTANCE.dFrame.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x;
		x -= Credentials.INSTANCE.dCard.x / 2;
		x -= Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(4).addLast(new Vector2(x, y));

		// 2

		x += Credentials.INSTANCE.dGapBetweenComponents.x;
		x += Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(4).addLast(new Vector2(x, y));
		
		// 3
		
		x += Credentials.INSTANCE.dGapBetweenComponents.x;
		x += Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(4).addLast(new Vector2(x, y));
		
		// 4
		
		x += Credentials.INSTANCE.dGapBetweenComponents.x;
		x += Credentials.INSTANCE.dCard.x;
		this.coordinates.getValue(4).addLast(new Vector2(x, y));

	}

	public void addCard(ACard card) {

		ESuit eSuitCardToAdd = card.getSideHero().getESuit();
		boolean added = false;

		for (ListImageViewAbles<ACard> list : this.lists) {

			ESuit eSuitCardList = list.getArrayList().getRandom().getSideHero().getESuit();

			if (!eSuitCardToAdd.equals(eSuitCardList))
				continue;

			added = true;
			list.getArrayList().addLast(card);
			break;

		}

		if (!added) {

			this.lists.addLast(new ListImageViewAbles<>());
			this.lists.getLast().getArrayList().addLast(card);

		}

		relocate();

	}

	public void removeCard(ACard card) {

		for (ListImageViewAbles<ACard> list : this.lists.clone()) {

			if (!list.getArrayList().contains(card))
				continue;

			list.getArrayList().remove(card);

			if (list.getArrayList().isEmpty())
				this.lists.remove(list);

			break;

		}

		relocate();

	}

	private void relocate() {

		for (ListImageViewAbles<ACard> list : this.lists) {

			ArrayList<Vector2> vectors = this.coordinates.getValue(this.lists.size());
			int listIndex = this.lists.indexOf(list);

			list.getListCredentials().coordinatesList = vectors.get(listIndex);
			list.getListCredentials().objectsPerRow = 1;
			list.getListCredentials().directionEnumVertical = DirectionEnum.UP;
			list.getListCredentials().layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;
			list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
			list.getListCredentials().gapBetweenComponents.y = 0.2 * Credentials.INSTANCE.dCard.y;
			list.animateSynchronous();

		}

		Lock.INSTANCE.lock();

	}

	public boolean contains(ACard card) {

		for (ListImageViewAbles<ACard> list : this.lists)
			if (list.getArrayList().contains(card))
				return true;

		return false;

	}

}
