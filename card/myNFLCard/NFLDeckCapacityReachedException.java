package card.myNFLCard;

public class NFLDeckCapacityReachedException extends RuntimeException {
    /**
     * generate an exception with no message
     */
    public NFLDeckCapacityReachedException() {
        super();
    }

    /**
     * generate an exception with a message shown to the user supplied to the exception as the argument it took in
     */
    public NFLDeckCapacityReachedException(String msg) {
        super(msg);
    }
}
