package card.poker.test;

import card.util.PokerCard;
import card.util.PokerDeck;
import card.util.Suit;
import card.util.Value;

public class PokerTest {
    public static void main(String[] args) {
        PokerDeck pd = new PokerDeck();
        //should print the deck in Suit order
        System.out.println(pd);
        pd.shuffle();
        //Deck should print in random order
        System.out.println(pd);
        PokerCard yourCard = new PokerCard(Value.Ace, Suit.Spades);
        int depth = 0;
        while (!pd.isEmpty()) {
            depth += 1;
            PokerCard pc = (PokerCard) pd.draw();
            if (pc.equals(yourCard)) {
                System.out.println("The " + yourCard + " was " + depth + " cards in the deck.");
                break;
            }
        }
        //Should be missing at least 1 card and at most all cards.
        System.out.println(pd);
    }
}