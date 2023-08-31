package card.mySoccerCard;

public class EmptySoccerDeckException extends RuntimeException {

    /**
     * generate an exception with no message
     */
    public EmptySoccerDeckException() {
        super();
    }

    /**
     * generate an exception with a message shown to the user supplied to the exception as the argument it took in
     */
    public EmptySoccerDeckException(String msg) {
        super(msg);
    }
}



