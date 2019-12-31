package com.udomomo.blackjack.card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreTest {
	@Test
	void totalScoreWithoutFace() {
		List<Card> cards = new ArrayList<>(Arrays.asList(new Card(Suit.Club, 7), new Card(Suit.Heart, 5)));
		List<Integer> totalScore = Score.totalScore(cards);
		assertEquals(1, totalScore.size());
		assertTrue(totalScore.contains(Integer.parseInt("12")));
	}

	@Test
	void totalScoreWithFace() {
		// The rank of 11, 12, 13 are regarded as 10 points.
		List<Card> cards = new ArrayList<>(Arrays.asList(new Card(Suit.Club, 3), new Card(Suit.Heart, 12)));
		List<Integer> totalScore = Score.totalScore(cards);
		assertEquals(1, totalScore.size());
		assertTrue(totalScore.contains(Integer.parseInt("13")));
	}

	@Test
	void totalScoreWithAce() {
		// The rank of Ace is regarded as 1 or 11 points.
		// totalScore() returns all possible scores, except busting ones.
		List<Card> cards = new ArrayList<>(
				Arrays.asList(new Card(Suit.Club, 3), new Card(Suit.Heart, 1), new Card(Suit.Diamond, 1)));
		List<Integer> totalScore = Score.totalScore(cards);
		assertEquals(2, totalScore.size());
		assertTrue(totalScore.contains(Integer.parseInt("5")));
		assertTrue(totalScore.contains(Integer.parseInt("15")));
	}

	@Test
	void totalScoreWithAllBust() {
		// If the score is busting in any case, totalScore() returns an empty list.
		List<Card> cards = new ArrayList<>(
				Arrays.asList(new Card(Suit.Club, 10), new Card(Suit.Heart, 9), new Card(Suit.Diamond, 8)));
		List<Integer> totalScore = Score.totalScore(cards);
		assertTrue(totalScore.isEmpty());
	}
}
