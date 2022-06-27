package cards;

import enums.ESuit;

public class Card14 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(14).eSuit(ESuit.ROAD).strength(3).hasScull(true)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(14).eSuit(ESuit.ROAD).strength(2).hasPlusIcon(false)
				.skills(ESuit.CROWN).build();
	}

}
