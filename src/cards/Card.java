package cards;

import utils.Interfaces.IEventHandlerAble;
import utils.Interfaces.IImageViewAble;

public abstract class Card implements IImageViewAble, IEventHandlerAble {

	protected SideEnemy sideEnemy = null;
	protected SideHero sideHero = null;

	public Card() {

		createSideEnemy();
		createSideHero();

	}

	protected abstract void createSideEnemy();

	protected abstract void createSideHero();

	protected abstract int cardNumber();

	public final SideEnemy getSideEnemy() {
		return this.sideEnemy;
	}

	public final SideHero getSideHero() {
		return this.sideHero;
	}

	@Override
	public void handleMousePressed() {

	}

}
