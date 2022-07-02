package cards;

import enums.ESuit;
import gameStatesAbilities.GainNextCardIfItIsCrossOrRoad;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card16 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(16).eSuit(ESuit.SUN).strength(2).hasScull(false)
				.ability(GainNextCardIfItIsCrossOrRoad.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(16).eSuit(ESuit.SUN).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROSS, ESuit.ROAD).build();
	}

}
