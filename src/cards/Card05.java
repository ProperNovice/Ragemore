package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card05 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(5).eSuit(ESuit.CROSS).strength(1).hasScull(true)
				.ability(() -> Ability.INSTANCE.moveBottomCardToTheTop()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(5).eSuit(ESuit.CROSS).strength(0).hasPlusIcon(false)
				.skills(ESuit.CROWN, ESuit.CROWN).build();
	}

}
