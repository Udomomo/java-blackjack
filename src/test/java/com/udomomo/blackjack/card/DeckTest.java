package com.udomomo.blackjack.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DeckTest {
	@Test
	void deckInit() {
		Deck.init();
		assertEquals(52, Deck.countAmount());
		@SuppressWarnings("unused")
		Card card = Deck.takeCard();
		assertEquals(51, Deck.countAmount());
	}
}
