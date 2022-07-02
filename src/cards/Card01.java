package cards;

import enums.ESuit;
import gameStatesAbilities.PlayNextCard;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card01 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(1).eSuit(ESuit.CROWN).strength(1).hasScull(false)
				.ability(PlayNextCard.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(1).eSuit(ESuit.CROWN).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROSS, ESuit.ROAD).build();
	}

}
