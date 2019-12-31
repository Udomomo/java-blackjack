package com.udomomo.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.udomomo.blackjack.card.Card;
import com.udomomo.blackjack.card.Deck;

public class Hand {
    private String playerName;
    private List<Card> cards;

    Hand(String name) {
        playerName = name;
        cards = new ArrayList<Card>();
    }

    public void draw() {
        Card card = Deck.takeCard();
        cards.add(card);
    }

    public String showCurrentCards() {
		List<String> details = cards.stream().map(Card::showDetail).collect(Collectors.toList());
        return String.join(",", details);
    }

    public List<Card> getCards() {
        return cards;
    }
}
