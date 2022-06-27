package cards;

import controllers.Ability;
import enums.ESuit;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card03 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(3).eSuit(ESuit.CROWN).strength(3).hasScull(false)
				.ability(() -> Ability.INSTANCE.killNextCardIfItIsCrossOrRoad()).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(3).eSuit(ESuit.CROWN).strength(2).hasPlusIcon(false)
				.skills(ESuit.CROSS).build();
	}

}
