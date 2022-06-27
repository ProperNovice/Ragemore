package cards;

import enums.ESuit;

public class Card01 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(1).eSuit(ESuit.CROWN).strength(1).hasScull(false)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(1).eSuit(ESuit.CROWN).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROSS, ESuit.ROAD).build();
	}

}
