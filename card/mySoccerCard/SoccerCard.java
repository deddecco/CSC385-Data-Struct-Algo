package card.mySoccerCard;


import card.util.Card;

public class SoccerCard extends Card {

    public String playerName;
    public int jerseyNumber;
    public String playerPosition;

    /**
     * Soccer Cards have 3 attributes: a player name, a jersey number, and a player position.
     */
    public SoccerCard(int jerseyNumber, String playerPosition, String playerName) {
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.playerPosition = playerPosition;
    }


    /**
     * the implementation of toString() for a SoccerCard takes it back to the row in the CSV record-- copied and pasted in from Atlanta United's rostter on tehir Wikipedia page--
     * from which the SoccerCard for the player was created
     */
    public String toString() {
        return this.jerseyNumber + " \t " + this.playerPosition + "\t" + this.playerName;
    }


    /**
     * SoccerCards are defined as equal if their names, jerseys, and positions all match, and not equal otherwise.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof SoccerCard)) {
            return false;
        }
        if (this == other) {
            return true;
        }


        boolean samePosition = this.playerPosition.equals(((SoccerCard) other).playerPosition);
        boolean sameName = this.playerName.equals(((SoccerCard) other).playerName);
        boolean sameJersey = this.jerseyNumber == ((SoccerCard) other).jerseyNumber;

        return sameJersey && sameName && samePosition;

    }
}
