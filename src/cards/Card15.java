package cards;

import enums.ESuit;
import gameStatesAbilities.PlayNextCard;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card15 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(15).eSuit(ESuit.SUN).strength(1).hasScull(true)
				.ability(PlayNextCard.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(15).eSuit(ESuit.SUN).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROWN, ESuit.CROSS).build();
	}

}
