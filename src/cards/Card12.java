package cards;

import enums.ESuit;
import gameStatesAbilities.KillNextCard;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card12 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(12).eSuit(ESuit.ROAD).strength(2).hasScull(true)
				.ability(KillNextCard.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(12).eSuit(ESuit.ROAD).strength(1).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.SUN).build();
	}

}
