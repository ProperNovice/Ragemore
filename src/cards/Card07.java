package cards;

import enums.ESuit;

public class Card07 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(7).eSuit(ESuit.CROSS).strength(2).hasScull(true)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(7).eSuit(ESuit.CROSS).strength(1).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.SUN).build();
	}

}
