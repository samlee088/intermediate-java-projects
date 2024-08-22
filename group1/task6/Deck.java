package group1.task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private Random random = new Random();

    public Deck () {
        cards = new ArrayList<>();
        for(CardSuit suit: CardSuit.values()) {
            for(int value = 1; value <= 13; value++) {
                cards.add(new Card(suit, Math.min(value, 10)));
            }
        }
    }

    
}
