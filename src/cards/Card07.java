package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card07 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(7).eSuit(ESuit.CROSS).strength(2).hasScull(true)
				.ability(() -> Ability.INSTANCE.killNextCard()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(7).eSuit(ESuit.CROSS).strength(1).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.SUN).build();
	}

}
