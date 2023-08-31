package card.NFL.Test;

import card.myNFLCard.NFLCard;
import card.myNFLCard.NFLDeck;

public class NFLTest {
    public static void main(String[] args) {
        NFLDeck starters = new NFLDeck();
        //should print the deck in roster order
        System.out.println(starters);
        starters.shuffle();
        //Deck should print in random order
        System.out.println(starters);
        NFLCard yourCard = new NFLCard("Aaron Rodgers", "NY Jets", 8, 475, 105);
        int depth = 0;
        while (!starters.isEmpty()) {
            depth += 1;
            NFLCard pc = (NFLCard) starters.draw();
            if (pc.equals(yourCard)) {
                System.out.println("The " + yourCard + " was " + depth + " cards in the deck.");
                break;
            }
        }
        //Should be missing at least 1 card and at most all cards.
        System.out.println(starters);
    }
}


