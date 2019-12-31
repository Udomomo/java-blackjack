package com.udomomo.blackjack.card;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Score {
	public static List<Integer> totalScore(List<Card> cards) {
		int scoreExceptAce = cards.stream().mapToInt(Card::getScoreExceptAce).sum();

		int aceAmount = countAce(cards);
		return IntStream.rangeClosed(0, aceAmount).map(i -> 11 * i + 1 * (aceAmount - i) + scoreExceptAce)
				.filter(i -> i <= 21).boxed().collect(Collectors.toList());
	}

	public static boolean isBlackJack(List<Card> cards) {
		return totalScore(cards).contains(21);
	}

	public static boolean isBusted(List<Card> cards) {
		return totalScore(cards).isEmpty();
	}

	private static int countAce(List<Card> cards) {
		return (int) cards.stream().filter(c -> c.getRank() == 1).count();
	}

	public static int highestScore(List<Card> cards) {
		List<Integer> scores = totalScore(cards);
		return scores.stream().max(Comparator.naturalOrder()).get();
	}
}
