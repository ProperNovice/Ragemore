package controllers;

import cards.Card01;
import cards.Card02;
import cards.Card03;
import cards.Card04;
import cards.Card05;
import cards.Card06;
import cards.Card07;
import cards.Card08;
import cards.Card09;
import cards.Card10;
import cards.Card11;
import cards.Card12;
import cards.Card13;
import cards.Card14;
import cards.Card15;
import cards.Card16;
import cards.Card17;
import cards.Card18;

public enum InstantiateComponents {

	INSTANCE;

	public void instantiate() {

		Lists.INSTANCE.deck.getArrayList().addLast(new Card01());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card02());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card03());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card04());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card05());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card06());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card07());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card08());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card09());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card10());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card11());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card12());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card13());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card14());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card15());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card16());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card17());
		Lists.INSTANCE.deck.getArrayList().addLast(new Card18());

		Lists.INSTANCE.deck.getArrayList().saveOriginal();
		Lists.INSTANCE.deck.getArrayList().shuffle();
		Lists.INSTANCE.deck.relocateImageViews();

	}

}
