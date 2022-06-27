package gameStates;

import cards.ACard;
import cards.Card08;

public class JUnit extends AGameState {

	@Override
	public void execute() {

		new Card08().getSideEnemy().print();

		ACard card = new Card08();
		card.getImageView().relocateTopLeft(900, 0);
		card.flipSideHero();
		card.getSideHero().print();

	}

}
