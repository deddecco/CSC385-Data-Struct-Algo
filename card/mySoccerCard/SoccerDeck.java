package card.mySoccerCard;

import card.util.Deck;

public class SoccerDeck extends Deck {


    /**
     * Rather than reading the information about the team (each player's info-- number, position, and name)
     * from a CSV or TSV and introducing new parameters, exceptions, or outputs to the method signature,
     * thus disrupting the inheritance hierarchy, the contents of these rows in the CSV/TSV containing the
     * team's roster was instead entered manually into several dozen calls to the constructor for a SoccerCard.
     * Notice that SoccerCards are different from PokerCards in that for the PokerCard, every possible suit matches
     * with every possible value, such that the complete bipartite graph k4,13 is an effective model of the way
     * cards are created; the for-each loop there covers every edge of k4,13, which is simply 4*13 = 52,
     * which is indeed the number of cards in a standard playing deck.
     * In general, a complete bipartite graph k_m,n has m*n edges, which, when n=m reduces to n^2,
     * However, when building a SoccerDeck, we do not want every possible one of the maximum 26 names
     * on a roster to match with every possible one of 26 jerseys, since that produces nearly 700 player-jersey tuples.
     * Only the 26 name-jersey tuples actually seen in real life are relevant, so it is not too much effort to make
     * those 26 calls even by hand, that is, without making use of a loop.
     */
    @Override
    protected void initialize() {
        add(new SoccerCard(1, "GK", "BRAD GUZAN"));
        add(new SoccerCard(2, "DF", "RONALD HERNANDEZ"));
        add(new SoccerCard(4, "DF", "LUIZ ABRAM"));
        add(new SoccerCard(5, "MF", "SANTIAGO SOUZA"));
        add(new SoccerCard(6, "MF", "OSVALDO ALONSO"));
        add(new SoccerCard(7, "FW", "GIORGOS GIAKOUMAKIS"));
        add(new SoccerCard(8, "MF", "TRISTAN MUYUMBA"));
        add(new SoccerCard(9, "FW", "SABA LOBZHANIDZE"));
        add(new SoccerCard(10, "MF", "THIAGO ALMANDA"));
        add(new SoccerCard(11, "DF", "BROOKS LENNON"));
        add(new SoccerCard(12, "DF", "MILES ROBINSON"));
        add(new SoccerCard(13, "MF", "AMAR SEJDIC"));
        add(new SoccerCard(16, "FW", "XANDE SILVA"));
        add(new SoccerCard(18, "FW", "DERRICK ETIENNE"));
        add(new SoccerCard(19, "FW", "MIGUEL BERRY"));
        add(new SoccerCard(20, "MF", "MATHEUS ROSSETTO"));
        add(new SoccerCard(21, "MF", "EDWIN MOSQUERA"));
        add(new SoccerCard(22, "DF", "JUANJO PURATA"));
        add(new SoccerCard(24, "DF", "NOAH COBB"));
        add(new SoccerCard(25, "GK", "CLEMENT DIOP"));
        add(new SoccerCard(26, "DF", "CALEB WILEY"));
        add(new SoccerCard(29, "FW", "JAMAL THIARE"));
        add(new SoccerCard(30, "FW", "MACHOP CHOL"));
        add(new SoccerCard(28, "FW", "TYLER WOLFF"));
        add(new SoccerCard(31, "GK", "QUENTIN WESTBERG"));
        add(new SoccerCard(35, "MF", "AJANI FORTUNE"));
    }

}
