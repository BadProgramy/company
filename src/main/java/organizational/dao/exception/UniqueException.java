package organizational.dao.exception;

public class UniqueException extends Exception {
    private static final String message = "Значение name не уникально!";

    public UniqueException(){
        super(message);
    }
}
