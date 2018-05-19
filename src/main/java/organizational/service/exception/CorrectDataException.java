package organizational.service.exception;

public class CorrectDataException extends Exception {
    private static final String message = "Не корректные данные";

    public CorrectDataException() {
        super(message);
    }
}
