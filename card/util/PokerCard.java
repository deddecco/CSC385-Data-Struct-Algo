package card.util;

public class PokerCard extends Card {

    /**
     * ace, 2, 3, 4, etc.
     */
    public final Value value;

    /**
     * clubs, hearts, spades, diamonds
     */
    public final Suit suit;


    /**
     * PokerCards have 2 attributes: their value and their suit. This constructor creates a card assigning to it the suit and value passed into the constructor
     */
    public PokerCard(Value value, Suit suit) {
        this.suit = suit;
        this.value = value;
    }


    public String toString() {
        return this.value + " of " + this.suit;
    }


    /**
     * You can only check for equality with == with primitives, so you need an equals() method to check for equality among non-primiives.
     * This equals() method compares two objects and returns true if they're the same object or have the same suit and the same value, and false otherwise
     */
    public boolean equals(Object other) {
        // if one compared object is null, that and a PokerCard can't be equal
        if (other == null) {
            return false;
        }
        // if one object is a PokerCard and the other isn't, they can't be equal
        if (!(other instanceof PokerCard)) {
            return false;
        }
        // if two objects are the same object, they are equal
        if (this == other) {
            return true;
        }

        // if they are different objects, but their suits AND values match, consider them equal
        if (this.suit.equals(((PokerCard) other).suit)) {
            return this.value == ((PokerCard) other).value;
        }

        // if all these conditionals run and nothing returns, fall out and return false
        return false;
    }
}
