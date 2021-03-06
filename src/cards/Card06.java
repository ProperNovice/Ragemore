package cards;

import enums.ESuit;
import gameStatesAbilities.MoveTopCardToTheBottom;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card06 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(6).eSuit(ESuit.CROSS).strength(1).hasScull(false)
				.ability(MoveTopCardToTheBottom.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(6).eSuit(ESuit.CROSS).strength(0).hasPlusIcon(false)
				.skills(ESuit.ROAD, ESuit.ROAD).build();
	}

}
