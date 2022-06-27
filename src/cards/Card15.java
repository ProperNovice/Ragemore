package cards;

import controllers.Ability;
import enums.ESuit;

public class Card15 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(15).eSuit(ESuit.SUN).strength(1).hasScull(true)
				.ability(() -> Ability.INSTANCE.playNextCard()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(15).eSuit(ESuit.SUN).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROWN, ESuit.CROSS).build();
	}

}
