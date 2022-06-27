package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card14 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(14).eSuit(ESuit.ROAD).strength(3).hasScull(true)
				.ability(() -> Ability.INSTANCE.moveOneCardFromFinishedQuestsToTheBottom()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(14).eSuit(ESuit.ROAD).strength(2).hasPlusIcon(false)
				.skills(ESuit.CROWN).build();
	}

}
