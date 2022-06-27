package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card01 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(1).eSuit(ESuit.CROWN).strength(1).hasScull(false)
				.ability(() -> Ability.INSTANCE.playNextCard()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(1).eSuit(ESuit.CROWN).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROSS, ESuit.ROAD).build();
	}

}
