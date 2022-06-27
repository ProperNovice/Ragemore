package cards;

import controllers.Ability;
import enums.ESuit;

public class Card16 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(16).eSuit(ESuit.SUN).strength(2).hasScull(false)
				.ability(() -> Ability.INSTANCE.gainNextCardIfItIsCrossOrRoad()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(16).eSuit(ESuit.SUN).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROSS, ESuit.ROAD).build();
	}

}
