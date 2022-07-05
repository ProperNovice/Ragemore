package interfaces;

import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public interface IEventAble {

	public default void eventObjectAddedToList(
			ListImageViewAbles<IImageViewAble> list, IImageViewAble object) {

	}

	public default void eventObjectRemovedFromList(
			ListImageViewAbles<IImageViewAble> list, IImageViewAble object) {

	}

	public default void eventGameStateChange() {

	}

}
