package by.javatr.task1.exception;

public class NoSuchProductInBasketException extends Exception {

    public NoSuchProductInBasketException(String message) {
        super(message);
    }

    public NoSuchProductInBasketException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchProductInBasketException(Throwable cause) {
        super(cause);
    }

    protected NoSuchProductInBasketException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
