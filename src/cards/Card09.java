package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card09 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(9).eSuit(ESuit.CROSS).strength(3).hasScull(true)
				.ability(() -> Ability.INSTANCE.moveOneCardFromTheGraveyardToTheBottom()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(9).eSuit(ESuit.CROSS).strength(2).hasPlusIcon(false)
				.skills(ESuit.SUN).build();
	}

}
