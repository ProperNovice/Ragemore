package controllers;

import interfaces.IEventAble;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum EventManager implements IEventAble {

	INSTANCE;

	public ArrayList<IEventAble> objectAddedToList = new ArrayList<>();
	public ArrayList<IEventAble> objectRemovedFromList = new ArrayList<>();

	private EventManager() {

	}

	@Override
	public void eventObjectAddedToList(ListImageViewAbles<IImageViewAble> list,
			IImageViewAble object) {

		for (IEventAble iEventAble : this.objectAddedToList)
			iEventAble.eventObjectAddedToList(list, object);

	}

	@Override
	public void eventObjectRemovedFromList(ListImageViewAbles<IImageViewAble> list,
			IImageViewAble object) {

		for (IEventAble iEventAble : this.objectRemovedFromList)
			iEventAble.eventObjectRemovedFromList(list, object);

	}

}
