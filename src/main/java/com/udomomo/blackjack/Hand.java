package com.udomomo.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.udomomo.blackjack.card.Card;
import com.udomomo.blackjack.card.Deck;

public class Hand {
	private List<Card> cards;

	Hand() {
		cards = new ArrayList<Card>();
	}

	public void draw(boolean showCard) {
		Card card = Deck.takeCard();
		cards.add(card);
		if (showCard) {
			System.out.println(card);
		}
	}
}
