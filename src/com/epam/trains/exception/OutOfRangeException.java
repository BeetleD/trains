package com.epam.trains.exception;

/**
 * Created by Dmitry on 25.06.2014.
 */
public class OutOfRangeException extends Exception {
    public OutOfRangeException() {
        super();
    }
    public OutOfRangeException(String message) {
        super(message);
    }
    public OutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }
    public OutOfRangeException(Throwable cause) {
        super(cause);
    }
}
