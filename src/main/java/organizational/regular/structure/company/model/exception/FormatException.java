package organizational.regular.structure.company.model.exception;

public class FormatException extends Exception {
    private static final String message = "Неправильный формат ввода: ";

    public FormatException(String message, String correctFormat){
        super(message.concat(" Пример: ").concat(correctFormat));
    }

    public FormatException(String correctFormat){
        super(message.concat(correctFormat));
    }
}
