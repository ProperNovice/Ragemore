package controllers;

import enums.ESuit;
import models.ACard;
import utils.ArrayList;
import utils.Enums.DirectionEnum;
import utils.Enums.LayerZListEnum;
import utils.Enums.RelocateTypeEnum;
import utils.HashMap;
import utils.ListImageViewAbles;
import utils.Vector2;

public enum Party {

	INSTANCE;

	private ArrayList<ListImageViewAbles<ACard>> lists = new ArrayList<>();
	private HashMap<Integer, ArrayList<Vector2>> coordinates = new HashMap<>();

	private Party() {

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

		x = Credentials.INSTANCE.dFrame.x / 2;
		addCoordinates(1, new Vector2(x, y));

		// 2 columns

		x = Credentials.INSTANCE.dFrame.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x / 2;
		x -= Credentials.INSTANCE.dCard.x / 2;
		addCoordinates(2, new Vector2(x, y));

		// 3 columns

		x = Credentials.INSTANCE.dFrame.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x;
		x -= Credentials.INSTANCE.dCard.x;
		addCoordinates(3, new Vector2(x, y));

		// 4 columns

		x = Credentials.INSTANCE.dFrame.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x / 2;
		x -= Credentials.INSTANCE.dGapBetweenComponents.x;
		x -= Credentials.INSTANCE.dCard.x / 2;
		x -= Credentials.INSTANCE.dCard.x;
		addCoordinates(4, new Vector2(x, y));

	}

	private void addCoordinates(int number, Vector2 coordinates) {

		for (int counter = 1; counter <= number; counter++) {

			this.coordinates.getValue(number).addLast(coordinates);

			coordinates = coordinates.clone();
			coordinates.x += Credentials.INSTANCE.dGapBetweenComponents.x;
			coordinates.x += Credentials.INSTANCE.dCard.x;

		}

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

	}

	public void relocate() {

		for (ListImageViewAbles<ACard> list : this.lists) {

			ArrayList<Vector2> vectors = this.coordinates.getValue(this.lists.size());
			int listIndex = this.lists.indexOf(list);

			list.getListCredentials().coordinatesList = vectors.get(listIndex);
			list.getListCredentials().objectsPerRow = 1;
			list.getListCredentials().directionEnumVertical = DirectionEnum.UP;
			list.getListCredentials().layerZListEnum = LayerZListEnum.TO_BACK_FIRST_IMAGEVIEW;
			list.getListCredentials().relocateTypeEnum = RelocateTypeEnum.CENTER;
			list.getListCredentials().gapBetweenComponents.y = 0.2 * Credentials.INSTANCE.dCard.y;

		}

		for (ListImageViewAbles<ACard> list : this.lists)
			list.relocateImageViews();

	}

	public boolean contains(ACard card) {

		for (ListImageViewAbles<ACard> list : this.lists)
			if (list.getArrayList().contains(card))
				return true;

		return false;

	}

	public ArrayList<ACard> getAllCards() {

		ArrayList<ACard> cards = new ArrayList<>();

		for (ListImageViewAbles<ACard> list : this.lists)
			cards.addAllLast(list.getArrayList());

		return cards;

	}

	public ArrayList<ACard> getFightAbleCards() {

		ArrayList<ACard> cards = new ArrayList<>();

		for (ListImageViewAbles<ACard> list : this.lists)
			cards.addLast(list.getArrayList().getLast());

		return cards;

	}

	public void clearCards() {
		this.lists.clear();
	}

	public boolean isEmpty() {

		int size = 0;

		for (ListImageViewAbles<ACard> list : this.lists)
			size += list.getArrayList().size();

		return size == 0;

	}

}
