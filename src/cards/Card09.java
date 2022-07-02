package cards;

import enums.ESuit;
import gameStatesAbilities.MoveOneCardFromTheGraveyardToTheBottom;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card09 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(9).eSuit(ESuit.CROSS).strength(3).hasScull(true)
				.ability(MoveOneCardFromTheGraveyardToTheBottom.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(9).eSuit(ESuit.CROSS).strength(2).hasPlusIcon(false)
				.skills(ESuit.SUN).build();
	}

}
