package com.udomomo.blackjack.card;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CardTest {
	@Test
	void testShowDetail() {
		Card card = new Card(Suit.Heart, 3);
		assertEquals("Heart 3", card.showDetail());
	}
}
