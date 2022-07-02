package cards;

import enums.ESuit;
import gameStatesAbilities.ShuffleTheDeck;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card13 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(13).eSuit(ESuit.ROAD).strength(2).hasScull(false)
				.ability(ShuffleTheDeck.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(13).eSuit(ESuit.ROAD).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROWN, ESuit.SUN).build();
	}

}
