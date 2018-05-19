package organizational.service.exception;

public class NullColumnException extends NullPointerException {
    private static final String message = "Не все пармаетры заполнены";

    public NullColumnException (String message) {
        super(message);
    }

    public NullColumnException() {
        super(message);
    }
}
