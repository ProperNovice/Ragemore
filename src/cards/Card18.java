package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card18 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(18).eSuit(ESuit.SUN).strength(3).hasScull(false)
				.ability(() -> Ability.INSTANCE.killOneCardInTheQuestTableauWithTheLeastCards())
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(18).eSuit(ESuit.SUN).strength(2).hasPlusIcon(true)
				.skills(ESuit.CROSS).build();
	}

}
