package organizational.regular.structure.company.model.exception;

public class DataFormatException extends Exception {
    private static final String message = "Неправильно указана дата: ";

    public DataFormatException(){
        super(message);
    }

    public DataFormatException(String description){
        super(message.concat(description));
    }
}
