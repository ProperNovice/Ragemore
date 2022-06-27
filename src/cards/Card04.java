package cards;

import enums.ESuit;

public class Card04 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(4).eSuit(ESuit.CROWN).strength(3).hasScull(true)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(4).eSuit(ESuit.CROWN).strength(2).hasPlusIcon(true)
				.skills(ESuit.ROAD).build();
	}

}
