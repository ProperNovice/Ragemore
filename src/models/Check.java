package models;

import controllers.Lists;
import utils.AnimationTimerFX;
import utils.Interfaces.IUpdateAble;
import utils.ShutDown;

public class Check implements IUpdateAble {

	public Check() {
		AnimationTimerFX.INSTANCE.updateEachFrame(this);
	}

	@Override
	public void update() {

		for (ACard card : Lists.INSTANCE.deck)
			if (card.isShowingSideHero())
				ShutDown.INSTANCE.execute();

	}

}
