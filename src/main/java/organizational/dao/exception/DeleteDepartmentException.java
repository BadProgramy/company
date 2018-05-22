package organizational.dao.exception;

public class DeleteDepartmentException extends Exception {
    private static final String message = "Невозможно удалить, т.к в департаменте есть сотрудники";

    public DeleteDepartmentException(){
        super(message);
    }
}
