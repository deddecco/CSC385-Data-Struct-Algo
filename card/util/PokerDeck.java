package card.util;

public class PokerDeck extends Deck {

    /**
     * Because PokerDeck extends deck, it must implement the abstract method initialize it inherited from Deck.
     * This method for the PokerDeck serves as a constructor for a new deck, which creates a set of cards with all possible
     * values and all possible suits
     */
    @Override
    public void initialize() {
        for (Suit suit : Suit.values()) {
            for (Value value : Value.values()) {
                //Create new Card with value and suit
                PokerCard newCard = new PokerCard(value, suit);
                //Add card to deck
                add(newCard);
            }
        }

    }
}