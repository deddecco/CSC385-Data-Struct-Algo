package card.myNFLCard;

import card.util.Card;

public class NFLCard extends Card {
    public String playerName;
    public String playerTeam;
    public int jerseyNumber;
    public int touchdowns;
    public int interceptions;


    public NFLCard(String playerName, String playerTeam, int jerseyNumber, int touchdowns, int interceptions) {
        this.playerName = playerName;
        this.playerTeam = playerTeam;
        this.jerseyNumber = jerseyNumber;
        this.touchdowns = touchdowns;
        this.interceptions = interceptions;
    }


    /**
     * the implementation of toString() for a SoccerCard takes it back to the row in the CSV record-- copied and pasted in from Atlanta United's rostter on tehir Wikipedia page--
     * from which the SoccerCard for the player was created
     */
    public String toString() {
        return "#" + this.jerseyNumber + "\t" + this.playerName + "\t" + this.touchdowns + "TD - " + this.interceptions + "INT";
    }


    /**
     * SoccerCards are defined as equal if their names, jerseys, and positions all match, and not equal otherwise.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof card.myNFLCard.NFLCard)) {
            return false;
        }
        if (this == other) {
            return true;
        }


        boolean sameName = this.playerName.equals(((NFLCard) other).playerName);
        boolean sameJersey = this.jerseyNumber == ((NFLCard) other).jerseyNumber;
        boolean sameTouchdowns = this.touchdowns == ((NFLCard) other).touchdowns;
        boolean sameInterceptions = this.interceptions == ((NFLCard) other).interceptions;

        return sameJersey && sameName && sameTouchdowns && sameInterceptions;

    }
}