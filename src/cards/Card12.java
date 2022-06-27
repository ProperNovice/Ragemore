package cards;

import controllers.Ability;
import enums.ESuit;

public class Card12 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(12).eSuit(ESuit.ROAD).strength(2).hasScull(true)
				.ability(() -> Ability.INSTANCE.killNextCard()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(12).eSuit(ESuit.ROAD).strength(1).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.SUN).build();
	}

}
