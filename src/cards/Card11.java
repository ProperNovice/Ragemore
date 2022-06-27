package cards;

import enums.ESuit;

public class Card11 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(11).eSuit(ESuit.ROAD).strength(1).hasScull(false)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(11).eSuit(ESuit.ROAD).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROSS, ESuit.CROSS).build();
	}

}
