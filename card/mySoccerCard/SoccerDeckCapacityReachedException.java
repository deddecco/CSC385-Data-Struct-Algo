package card.mySoccerCard;

public class SoccerDeckCapacityReachedException extends RuntimeException {

    /**
     * generate an exception with no message
     */
    public SoccerDeckCapacityReachedException() {
        super();
    }

    /**
     * generate an exception with a message shown to the user supplied to the exception as the argument it took in
     */
    public SoccerDeckCapacityReachedException(String msg) {
        super(msg);
    }
}
