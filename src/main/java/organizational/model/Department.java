package organizational.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private LocalDate date;
    private int idParentDepartment;
    private int level;
    private List<Employee> employees;
    private static final int DEFAULT_HEAD_LEVEL = 1;

    public Department(String name, LocalDate date, int idParentDepartment, int level) {
        this.name = name;
        this.date = date;
        this.idParentDepartment = idParentDepartment;
        this.level = level;
        employees = new ArrayList<>();
    }

    public Department(String name, LocalDate date) {
        this.name = name;
        this.date = date;
        idParentDepartment = id;
        level = DEFAULT_HEAD_LEVEL;
        employees = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getIdParentDepartment() {
        return idParentDepartment;
    }

    public void setIdParentDepartment(int idParentDepartment) {
        this.idParentDepartment = idParentDepartment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}