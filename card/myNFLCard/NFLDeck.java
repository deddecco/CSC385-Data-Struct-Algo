package card.myNFLCard;

import card.util.Deck;

public class NFLDeck extends Deck {
    @Override
    protected void initialize() {
        add(new NFLCard("Josh Allen", "Buffalo", 17, 138, 60));
        add(new NFLCard("Tua Tagovailoa", "Miami", 1, 52, 23));
        add(new NFLCard("Mac Jones", "New England", 10, 36, 24));
        add(new NFLCard("Aaron Rodgers", "NY Jets", 8, 475, 105));

        add(new NFLCard("Lamar Jackson", "Baltimore", 8, 101, 38));
        add(new NFLCard("Joe Burrow", "Cincinnati", 9, 82, 31));
        add(new NFLCard("Deshaun Watson", "Cleveland", 4, 111, 41));
        add(new NFLCard("Kenny Pickett", "Pittsburgh", 8, 7, 9));

        add(new NFLCard("CJ Stroud", "Houston", 7, 0, 0));
        add(new NFLCard("Anthony Richardson", "Indianapolis", 5, 0, 0));
        add(new NFLCard("Trevor Lawrence", "Jacksonville", 16, 37, 25));
        add(new NFLCard("Ryan Tannehill", "Tennessee", 17, 212, 108));

        add(new NFLCard("Russell Wilson", "Denver", 3, 308, 98));
        add(new NFLCard("Patrick Mahomes", "Kansas City", 15, 192, 49));
        add(new NFLCard("Jimmy Garoppolo", "San Francisco", 10, 87, 42));
        add(new NFLCard("Justin Herbert", "LA Chargers", 10, 94, 35));

        add(new NFLCard("Dak Prescott", "Dallas", 4, 166, 65));
        add(new NFLCard("Daniel Jones", "NY Giants", 8, 60, 34));
        add(new NFLCard("Jalen Hurts", "Philadelphia", 1, 44, 19));
        add(new NFLCard("Sam Howell", "Washington", 14, 3, 0));

        add(new NFLCard("Justin Fields", "Chicago", 1, 24, 21));
        add(new NFLCard("Jared Goff", "Detroit", 16, 155, 70));
        add(new NFLCard("Jordan Love", "Green Bay", 10, 3, 3));
        add(new NFLCard("Kirk Cousins", "Minnesota", 8, 252, 105));

        add(new NFLCard("Desmond Ridder", "Atlanta", 8, 2, 0));
        add(new NFLCard("Bryce Young", "Carolina", 9, 0, 0));
        add(new NFLCard("Derek Carr", "New Orleans", 17, 217, 99));
        add(new NFLCard("Baker Mayfield", "Tampa Bay", 6, 102, 64));

        add(new NFLCard("Kyler Murray", "Arizona", 1, 84, 41));
        add(new NFLCard("Matthew Stafford", "LA Rams", 17, 333, 169));
        add(new NFLCard("Brock Purdy", "San Francisco", 17, 13, 4));
        add(new NFLCard("Geno Smith", "Seattle", 7, 64, 48));
    }

}