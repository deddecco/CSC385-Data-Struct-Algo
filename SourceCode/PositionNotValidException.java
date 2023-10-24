package SourceCode;

import java.io.Serial;

public class PositionNotValidException extends RuntimeException {

    public PositionNotValidException() {
        super();
    }

    public PositionNotValidException(String msg) {
        super(msg);
    }

    /**
     * 
     */
    @Serial
    private static final long serialVersionUID = 4006004488727731444L;

}
