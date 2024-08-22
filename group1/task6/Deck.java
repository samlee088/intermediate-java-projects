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

    public void print() {
        for(Card card: cards) {
            card.print();
        }
    }

    public Card draw() {
        return cards.remove(cards.size() -1);
    }

    public void shuffle() {
        for(int i = 0; i < cards.size(); i++) {
            int j =random.nextInt(51);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }
}
