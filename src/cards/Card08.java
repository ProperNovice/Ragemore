package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card08 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(8).eSuit(ESuit.CROSS).strength(2).hasScull(false)
				.ability(() -> Ability.INSTANCE.gainNextCardIfItIsCrownOrSun()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(8).eSuit(ESuit.CROSS).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROWN, ESuit.ROAD).build();
	}

}