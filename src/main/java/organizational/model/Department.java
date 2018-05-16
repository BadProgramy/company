package organizational.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private LocalDate dateCreation;
    private int idParentDepartment;
    private List<Integer> idEmployees;

    public Department(String name, LocalDate dateCreation, int idParentDepartment) {
        this.name = name;
        this.dateCreation = dateCreation;
        this.idParentDepartment = idParentDepartment;
        idEmployees = new ArrayList<>();
    }

    public Department(String name, LocalDate dateCreation) {
        this.name = name;
        this.dateCreation = dateCreation;
        idParentDepartment = id;
        idEmployees = new ArrayList<>();
    }

    public int[] getIdEmployeesToArray(){
        return idEmployees.stream().mapToInt(i -> i).toArray();
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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getIdParentDepartment() {
        return idParentDepartment;
    }

    public void setIdParentDepartment(int idParentDepartment) {
        this.idParentDepartment = idParentDepartment;
    }

    public List<Integer> getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(List<Integer> idEmployees) {
        this.idEmployees = idEmployees;
    }
}