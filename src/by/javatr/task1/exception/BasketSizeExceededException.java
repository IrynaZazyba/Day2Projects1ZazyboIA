package by.javatr.task1.exception;

public class BasketSizeExceededException extends Exception {

    public BasketSizeExceededException(String message) {
        super(message);
    }

    public BasketSizeExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public BasketSizeExceededException(Throwable cause) {
        super(cause);
    }

    protected BasketSizeExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
