package cards;

import enums.ESuit;
import gameStatesAbilities.MoveOneCardFromFinishedQuestsToTheBottom;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card14 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(14).eSuit(ESuit.ROAD).strength(3).hasScull(true)
				.ability(MoveOneCardFromFinishedQuestsToTheBottom.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(14).eSuit(ESuit.ROAD).strength(2).hasPlusIcon(false)
				.skills(ESuit.CROWN).build();
	}

}
