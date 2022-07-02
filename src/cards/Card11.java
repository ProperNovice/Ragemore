package cards;

import enums.ESuit;
import gameStatesAbilities.MoveBottomCardToTheTop;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card11 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(11).eSuit(ESuit.ROAD).strength(1).hasScull(false)
				.ability(MoveBottomCardToTheTop.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(11).eSuit(ESuit.ROAD).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROSS, ESuit.CROSS).build();
	}

}
