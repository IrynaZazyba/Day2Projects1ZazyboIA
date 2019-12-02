package by.javatr.task1.exception;

public class NegativeWeightException extends Exception {

    public NegativeWeightException(String message) {
        super(message);
    }

    public NegativeWeightException(String message, Throwable cause) {
        super(message, cause);
    }

    public NegativeWeightException(Throwable cause) {
        super(cause);
    }

    protected NegativeWeightException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
