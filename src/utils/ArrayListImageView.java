package utils;

import controllers.EventManager;
import utils.Interfaces.IImageViewAble;

public class ArrayListImageView<T> extends ArrayList<T> {

	private ListImageViewAbles<IImageViewAble> list = null;
	private Runnable runnable = null;

	public ArrayListImageView(ListImageViewAbles<IImageViewAble> list, Runnable runnable) {

		this.list = list;
		this.runnable = runnable;

	}

	@Override
	public void add(int index, T element) {

		super.add(index, element);
		objectAddedToList((IImageViewAble) element);

	}

	@Override
	public void addLast(T element) {

		super.addLast(element);
		objectAddedToList((IImageViewAble) element);

	}

	@Override
	public void set(int index, T element) {

		super.set(index, element);
		objectAddedToList((IImageViewAble) element);

	}

	@Override
	public T remove(int index) {

		T t = super.remove(index);
		objectRemovedFromList((IImageViewAble) t);

		return t;

	}

	@Override
	public T remove(T t) {

		super.remove(t);
		objectRemovedFromList((IImageViewAble) t);

		return t;

	}

	@Override
	public void loadOriginal() {
		super.loadOriginal();
		this.runnable.run();
	}

	@Override
	public void loadState() {
		super.loadState();
		this.runnable.run();
	}

	private void objectAddedToList(IImageViewAble object) {

		RealTimeDuplicateProtection.INSTANCE.executeDuplicateProtect();
		this.runnable.run();
		EventManager.INSTANCE.eventObjectAddedToList(this.list, object);

	}

	private void objectRemovedFromList(IImageViewAble object) {

		RealTimeDuplicateProtection.INSTANCE.executeDuplicateProtect();
		this.runnable.run();
		EventManager.INSTANCE.eventObjectRemovedFromList(this.list, object);

	}

}
