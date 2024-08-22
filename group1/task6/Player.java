package group1.task6;

abstract class Player {
    private Hand hand;

    public Player(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return this.hand;
    }

    public void clearHand() {
        this.hand = new Hand();
    }

    public void addCard(Card card) {
        this.hand.addCard(card);
    }

    abstract boolean makeMove();
}
