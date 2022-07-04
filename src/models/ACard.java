package models;

import controllers.Credentials;
import controllers.Lists;
import utils.Flow;
import utils.Image;
import utils.ImageView;
import utils.Interfaces.IEventHandlerAble;
import utils.Interfaces.IImageViewAble;
import utils.ListImageViewAbles;

public abstract class ACard implements IImageViewAble, IEventHandlerAble {

	private SideEnemy sideEnemy = null;
	private SideHero sideHero = null;
	private Image imageShowing = null;

	public ACard() {

		this.sideEnemy = createSideEnemy();
		this.sideHero = createSideHero();

		new ImageView(this.sideEnemy.getImage(), this);

		getImageView().setDimensions(Credentials.INSTANCE.dCard);

		getImageView().setSelectImageViewAbleRatioDimensions(
				Credentials.INSTANCE.selectCardRatioDimension);

		getImageView()
				.setSelectImageViewAbleRatioPosition(Credentials.INSTANCE.selectCardRatioPosition);

		flipSideEnemy();

	}

	public final void flipSideEnemy() {
		this.imageShowing = this.sideEnemy.getImage();
		getImageView().setImage(this.imageShowing);
	}

	public final void flipSideHero() {
		this.imageShowing = this.sideHero.getImage();
		getImageView().setImage(this.imageShowing);
	}

	protected abstract SideEnemy createSideEnemy();

	protected abstract SideHero createSideHero();

	public final SideEnemy getSideEnemy() {
		return this.sideEnemy;
	}

	public final SideHero getSideHero() {
		return this.sideHero;
	}

	public final void print() {

		if (this.imageShowing.equals(this.sideEnemy.getImage()))
			this.sideEnemy.print();
		else if (this.imageShowing.equals(this.sideHero.getImage()))
			this.sideHero.print();

	}

	@Override
	public void handleMousePressed() {

		print();
		Flow.INSTANCE.getGameStateCurrent().handleCardPressed(this);

	}

	@Override
	public void handleMouseEntered() {
		getImageView().toFront();
	}

	@Override
	public void handleMouseExited() {
		for (ListImageViewAbles<IImageViewAble> list : Lists.INSTANCE.lists)
			list.layerZSort();
	}

}
