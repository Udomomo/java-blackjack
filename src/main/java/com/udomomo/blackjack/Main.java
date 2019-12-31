package com.udomomo.blackjack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.udomomo.blackjack.card.Deck;
import com.udomomo.blackjack.card.Score;

public class Main {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	public static void main(String[] args) throws IOException {
		Deck.init();
		System.out.println("Game Start");
		Hand player = new Hand("Player");
		Hand dealer = new Hand("Dealer");

		dealer.draw();
		System.out.println("Dealer's cards: " + dealer.showCurrentCards());
		dealer.draw();
		System.out.println("Dealer has drew one more card");
		// Dealer's 2nd card is not shown yet

		player.draw();
		System.out.println("Player's cards: " + player.showCurrentCards());
		player.draw();

		while (true) {
			System.out.println("Player's cards: " + player.showCurrentCards());
			if (Score.isBlackJack(player.getCards())) {
				System.out.println("BlackJack! You win.");
				System.exit(0);
			}
			if (Score.isBusted(player.getCards())) {
				System.out.println("Busted! You lose.");
				System.exit(0);
			}

			System.out.println("Draw card? (yes/no)");
			String s = Main.br.readLine();
			if (s.equals("yes")) {
				player.draw();
			} else if (s.equals("no")) {
				break;
			} else {
				System.out.println("Type yes/no.");
			}
		}

		System.out.println("Player's cards: " + player.showCurrentCards());

		System.out.println("Dealer's turn.");
		System.out.println("Dealer's cards: " + dealer.showCurrentCards());
		while (Score.totalScore(dealer.getCards()).stream().noneMatch((s -> s >= 17))) {
			dealer.draw();
			System.out.println("Dealer's cards: " + dealer.showCurrentCards());
			if (Score.isBlackJack(dealer.getCards())) {
				System.out.println("Dealer BlackJack! You lose.");
				System.exit(0);
			}
			if (Score.isBusted(dealer.getCards())) {
				System.out.println("Dealer Busted! You win.");
				System.exit(0);
			}
		}

		System.out.println("Dealer stopped.");

		int playerScore = Score.highestScore(player.getCards());
		int dealerScore = Score.highestScore(dealer.getCards());
		System.out.println("Player score: " + playerScore);
		System.out.println("Dealer score: " + dealerScore);

		if (playerScore > dealerScore) {
			System.out.println("You win!");
		}
		else if (playerScore < dealerScore) {
			System.out.println("You lose.");
		}
		else {
			System.out.println("Draw.");
		}
	}
}
