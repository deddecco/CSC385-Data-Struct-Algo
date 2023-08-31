package card.soccer.test;

import card.mySoccerCard.SoccerCard;
import card.mySoccerCard.SoccerDeck;

public class SoccerTest {

    public static void main(String[] args) {
        SoccerDeck soccerDeck = new SoccerDeck();
        //should print the deck in roster order
        System.out.println(soccerDeck);
        soccerDeck.shuffle();
        //Deck should print in random order
        System.out.println(soccerDeck);
        SoccerCard yourCard = new SoccerCard(7, "FW", "GIORGOS GIAKOUMAKIS");
        int depth = 0;
        while (!soccerDeck.isEmpty()) {
            depth += 1;
            SoccerCard pc = (SoccerCard) soccerDeck.draw();
            if (pc.equals(yourCard)) {
                System.out.println("The " + yourCard + " was " + depth + " cards in the deck.");
                break;
            }
        }
        //Should be missing at least 1 card and at most all cards.
        System.out.println(soccerDeck);
    }
}
