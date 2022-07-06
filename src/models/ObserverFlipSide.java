package models;

import controllers.EventManager;
import controllers.Lists;
import interfaces.IEventAble;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum ObserverFlipSide implements IEventAble {

	INSTANCE;

	private ObserverFlipSide() {

		EventManager.INSTANCE.objectAddedToList.addLast(this);
		EventManager.INSTANCE.objectAddedToParty.addLast(this);
		EventManager.INSTANCE.objectRemovedFromParty.addLast(this);

	}

	@Override
	public void eventObjectAddedToList(ListImageViewAbles<IImageViewAble> list,
			IImageViewAble object) {

		if (!list.equals(Lists.INSTANCE.deck))
			return;

		ACard card = (ACard) object;
		card.flipSideEnemy();

	}

	@Override
	public void eventObjectAddedToParty(IImageViewAble object) {

		ACard card = (ACard) object;
		card.flipSideHero();

	}

	@Override
	public void eventObjectRemovedFromParty(IImageViewAble object) {

		ACard card = (ACard) object;
		card.flipSideEnemy();

	}

}
