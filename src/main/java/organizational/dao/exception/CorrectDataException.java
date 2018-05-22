package organizational.dao.exception;

public class CorrectDataException extends Exception {
    private static final String message = "Не корректные данные: В департаменте уже есть руководитель или зарплата" +
            " не соответствует сотруднику (зарплата руководителя > обычного сотрудника)";

    public CorrectDataException() {
        super(message);
    }
}
