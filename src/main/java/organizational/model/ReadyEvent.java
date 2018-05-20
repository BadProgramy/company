package organizational.model;

public abstract class ReadyEvent {
    public static Event createDepartment = new Event("Создание департамента: ",EventEnum.СОЗДАНИЕ.name());
    public static Event renameDepartment = new Event("Переименование департамента: ",EventEnum.ПЕРЕИМЕНОВАНИЕ.name());
    public static Event moveDepartment = new Event("Перемещение департамента: ",EventEnum.ПЕРЕМЕЩЕНИЕ.name());
}
