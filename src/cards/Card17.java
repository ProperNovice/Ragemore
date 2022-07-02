package cards;

import enums.ESuit;
import gameStatesAbilities.MoveOneCardFromFinishedQuestsToTheBottom;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card17 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(17).eSuit(ESuit.SUN).strength(3).hasScull(true)
				.ability(MoveOneCardFromFinishedQuestsToTheBottom.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(17).eSuit(ESuit.SUN).strength(2).hasPlusIcon(false)
				.skills(ESuit.CROWN, ESuit.CROSS).build();
	}

}
