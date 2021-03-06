package cards;

import enums.ESuit;
import gameStatesAbilities.IfThereIsAtLeastOneCardInTheGraveyardAddThisCardToTheGraveyard;
import models.ACard;
import models.SideEnemy;
import models.SideEnemyBuilder;
import models.SideHero;
import models.SideHeroBuilder;

public class Card02 extends ACard {

	@Override
	protected SideEnemy createSideEnemy() {
		return new SideEnemyBuilder().cardNumber(2).eSuit(ESuit.CROWN).strength(2).hasScull(true)
				.ability(IfThereIsAtLeastOneCardInTheGraveyardAddThisCardToTheGraveyard.class)
				.build();
	}

	@Override
	protected SideHero createSideHero() {
		return new SideHeroBuilder().cardNumber(2).eSuit(ESuit.CROWN).strength(1).hasPlusIcon(true)
				.skills(ESuit.CROSS, ESuit.SUN).build();
	}

}
