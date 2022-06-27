package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card06 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(6).eSuit(ESuit.CROSS).strength(1).hasScull(false)
				.ability(() -> Ability.INSTANCE.moveTopCardToTheBottom()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(6).eSuit(ESuit.CROSS).strength(0).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.ROAD).build();
	}

}
