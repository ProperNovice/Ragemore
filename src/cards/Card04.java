package cards;

import enums.ESuit;
import gameStatesAbilities.MoveOneCardFromFinishedQuestsToTheBottom;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card04 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(4).eSuit(ESuit.CROWN).strength(3).hasScull(true)
				.ability(MoveOneCardFromFinishedQuestsToTheBottom.class).build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(4).eSuit(ESuit.CROWN).strength(2).hasPlusIcon(true)
				.skills(ESuit.ROAD).build();
	}

}
