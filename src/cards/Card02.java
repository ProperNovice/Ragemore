package cards;

import enums.ESuit;

public class Card02 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(2).eSuit(ESuit.CROWN).strength(2).hasScull(true)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(2).eSuit(ESuit.CROWN).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROSS, ESuit.SUN).build();
	}

}
