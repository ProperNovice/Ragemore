package cards;

import enums.ESuit;

public class Card13 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(13).eSuit(ESuit.ROAD).strength(2).hasScull(false)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(13).eSuit(ESuit.ROAD).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROWN, ESuit.SUN).build();
	}

}
