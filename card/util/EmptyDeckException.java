package card.util;

public class EmptyDeckException extends RuntimeException {

    /**
     * generate an exception with no message
     */
    public EmptyDeckException() {
        super();
    }

    /**
     * generate an exception with a message shown to the user supplied to the exception as the argument it took in
     */
    public EmptyDeckException(String msg) {
        super(msg);
    }
}