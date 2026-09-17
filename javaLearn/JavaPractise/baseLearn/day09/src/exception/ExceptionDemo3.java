package exception;

import java.awt.event.FocusEvent;

public class ExceptionDemo3 extends RuntimeException{
    private final int code;

    public ExceptionDemo3(String message, int code, Throwable cause) {
        super(message);
        this.code = code;
    }
}
