package cards;

import enums.ESuit;

public class Card03 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(3).eSuit(ESuit.CROWN).strength(3).hasScull(false)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(3).eSuit(ESuit.CROWN).strength(2).hasPlusIcon(false)
				.skills(ESuit.CROSS).build();
	}

}
