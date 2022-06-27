package cards;

import enums.ESuit;

public class Card06 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(6).eSuit(ESuit.CROSS).strength(1).hasScull(false)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(6).eSuit(ESuit.CROSS).strength(0).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.ROAD).build();
	}

}
