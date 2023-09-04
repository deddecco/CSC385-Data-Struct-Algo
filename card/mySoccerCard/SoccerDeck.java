package card.mySoccerCard;

import card.util.Deck;
import static card.mySoccerCard.SoccerPositions.*;

public class SoccerDeck extends Deck {

    @Override
    protected void initialize() {
        add(new SoccerCard(1, GK.name(), "BRAD GUZAN"));
        add(new SoccerCard(2, DF.name(), "RONALD HERNANDEZ"));
        add(new SoccerCard(4, DF.name(), "LUIZ ABRAM"));
        add(new SoccerCard(5, MF.name(), "SANTIAGO SOUZA"));
        add(new SoccerCard(6, MF.name(), "OSVALDO ALONSO"));
        add(new SoccerCard(7, FW.name(), "GIORGOS GIAKOUMAKIS"));
        add(new SoccerCard(8, MF.name(), "TRISTAN MUYUMBA"));
        add(new SoccerCard(9, FW.name(), "SABA LOBZHANIDZE"));
        add(new SoccerCard(10, MF.name(), "THIAGO ALMANDA"));
        add(new SoccerCard(11, DF.name(), "BROOKS LENNON"));
        add(new SoccerCard(12, DF.name(), "MILES ROBINSON"));
        add(new SoccerCard(13, MF.name(), "AMAR SEJDIC"));
        add(new SoccerCard(16, FW.name(), "XANDE SILVA"));
        add(new SoccerCard(18, FW.name(), "DERRICK ETIENNE"));
        add(new SoccerCard(19, FW.name(), "MIGUEL BERRY"));
        add(new SoccerCard(20, MF.name(), "MATHEUS ROSSETTO"));
        add(new SoccerCard(21, MF.name(), "EDWIN MOSQUERA"));
        add(new SoccerCard(22, DF.name(), "JUANJO PURATA"));
        add(new SoccerCard(24, DF.name(), "NOAH COBB"));
        add(new SoccerCard(25, GK.name(), "CLEMENT DIOP"));
        add(new SoccerCard(26, DF.name(), "CALEB WILEY"));
        add(new SoccerCard(29, FW.name(), "JAMAL THIARE"));
        add(new SoccerCard(30, FW.name(), "MACHOP CHOL"));
        add(new SoccerCard(28, FW.name(), "TYLER WOLFF"));
        add(new SoccerCard(31, GK.name(), "QUENTIN WESTBERG"));
        add(new SoccerCard(35, MF.name(), "AJANI FORTUNE"));
    }

}
