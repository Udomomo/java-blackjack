package com.udomomo.blackjack.card;

import lombok.Getter;

@Getter
public class Card {
	private Suit suit;
	private int rank;

	Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String showDetail() {
		return suit.toString() + ' ' + rank;
	}

	public int getScoreExceptAce() {
		if (rank == 1) {
			// Ace is a special card which can be both 1 point or 11 points,
			// so it will be calculated later.
			return 0;
		} else if (rank >= 10) {
			return 10;
		} else {
			return rank;
		}
	}
}