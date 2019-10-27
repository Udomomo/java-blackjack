package com.udomomo.blackjack.card;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Score {
	public static List<Integer> totalScore(List<Card> cards) {
		int scoreExceptAce = cards.stream().mapToInt(c -> c.getScoreExceptAce()).sum();

		int aceAmount = countAce(cards);
		return IntStream.rangeClosed(0, aceAmount).map(i -> 11 * i + 1 * (aceAmount - i) + scoreExceptAce)
				.filter(i -> i <= 21).boxed().collect(Collectors.toList());
	}

	private static int countAce(List<Card> cards) {
		return (int) cards.stream().filter(c -> c.getRank() == 1).count();
	}
}
