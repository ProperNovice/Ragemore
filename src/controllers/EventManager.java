package controllers;

import interfaces.IEventAble;
import utils.ArrayList;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public enum EventManager implements IEventAble {

	INSTANCE;

	public ArrayList<IEventAble> objectAddedToList = new ArrayList<>();
	public ArrayList<IEventAble> objectAddedToParty = new ArrayList<>();
	public ArrayList<IEventAble> objectRemovedFromList = new ArrayList<>();
	public ArrayList<IEventAble> objectRemovedFromParty = new ArrayList<>();
	public ArrayList<IEventAble> gameStateChange = new ArrayList<>();

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

	@Override
	public void eventGameStateChange() {

		for (IEventAble iEventAble : this.gameStateChange)
			iEventAble.eventGameStateChange();

	}

	@Override
	public void eventObjectAddedToParty(IImageViewAble object) {

		for (IEventAble iEventAble : this.objectAddedToParty)
			iEventAble.eventObjectAddedToParty(object);

	}

	@Override
	public void eventObjectRemovedFromParty(IImageViewAble object) {

		for (IEventAble iEventAble : this.objectRemovedFromParty)
			iEventAble.eventObjectRemovedFromParty(object);

	}

}
