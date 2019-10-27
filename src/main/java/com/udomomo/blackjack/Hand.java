package com.udomomo.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.udomomo.blackjack.card.Card;
import com.udomomo.blackjack.card.Deck;

public class Hand {
	private String playerName;
	private List<Card> cards;

	Hand(String name) {
		playerName = name;
		cards = new ArrayList<Card>();
	}

	public void draw(boolean showCard) {
		Card card = Deck.takeCard();
		cards.add(card);
		if (showCard) {
			System.out.println(playerName + ": " + card.showDetail());
		}
		else {
			System.out.println(playerName + ": " + "Card Unknown");
		}
	}

	public List<Card> getCards() {
		return cards;
	}
}
