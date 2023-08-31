package card.myNFLCard;

public class EmptyNFLDeckException extends RuntimeException{

    /**
     * generate an exception with no message
     */
    public EmptyNFLDeckException() {
        super();
    }

    /**
     * generate an exception with a message shown to the user supplied to the exception as the argument it took in
     */
    public EmptyNFLDeckException(String msg) {
        super(msg);
    }
}
