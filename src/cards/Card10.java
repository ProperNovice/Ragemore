package cards;

import enums.ESuit;
import gameStatesAbilities.MoveTopCardToTheBottom;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card10 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(10).eSuit(ESuit.ROAD).strength(1).hasScull(true)
				.ability(MoveTopCardToTheBottom.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(10).eSuit(ESuit.ROAD).strength(0).hasPlusIcon(false)
				.skills(ESuit.SUN, ESuit.SUN).build();
	}

}
