package card.util;

public class DeckCapacityReachedException extends RuntimeException {

    /**
     * generate an exception with no message
     */
    public DeckCapacityReachedException() {
        super();
    }

    /**
     * generate an exception with a message shown to the user supplied to the exception as the argument it took in
     */
    public DeckCapacityReachedException(String msg) {
        super(msg);
    }
}
