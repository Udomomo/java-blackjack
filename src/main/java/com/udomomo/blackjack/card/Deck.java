package com.udomomo.blackjack.card;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.udomomo.blackjack.Util.Suit;

public class Deck {
	private static List<Card> deck;

	private Deck() {
	}

	public static void init() {
		deck = Stream.of(Suit.values())
				.flatMap(suit -> IntStream.rangeClosed(1, 13).boxed().map(i -> new Card(suit, i))).collect(toList());
		Collections.shuffle(deck);
	}

	public static Card takeCard() {
		return deck.remove(0);
	}

	public static int countAmount() {
		return deck.size();
	}
}
