package cards;

import enums.ESuit;

public class Card09 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(9).eSuit(ESuit.CROSS).strength(3).hasScull(true)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(9).eSuit(ESuit.CROSS).strength(2).hasPlusIcon(false)
				.skills(ESuit.SUN).build();
	}

}
