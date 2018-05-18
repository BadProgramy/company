package organizational.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Department {
    private int id;
    private String name;
    private int idParentDepartment;
    private LocalDate dateCreation;
    //private  List<Integer> idEmployees; //сначало сделал так, но потом передумал (
    //private static final String DEFAULT_SPLIT_REGISTER = ",";
    private static final String DEFAULT_DATE_SPLIT_CHAR = "-";

    public Department() {
        //idEmployees = new ArrayList<>();
    }

    /*public String getIdEmployees() {
        *//*StringBuilder idEmployees = new StringBuilder();
        for (int i = 0; i < this.idEmployees.size(); i++) {
            if (i+1!=this.idEmployees.size())
                idEmployees.append(this.idEmployees.get(i)).append(DEFAULT_SPLIT_REGISTER);
            else idEmployees.append(this.idEmployees.get(i));
        }*//*
        return idEmployees.toString().replace("[","")
                .replace("]","")
                .replace("{","")
                .replace("}","");
    }*/

    /*public void setIdEmployees(String idEmployees) {
        idEmployees = idEmployees.replace("[","")
                .replace("]","")
                .replace("{","")
                .replace("}","");
        for (String id: idEmployees.split(DEFAULT_SPLIT_REGISTER)) {
            this.idEmployees.add((Integer.parseInt(id)));
        }
    }*/

/*    public int sizeEmployees(){
        return idEmployees.size();
    }

    public List<Integer> employees(){
        return idEmployees;
    }*/

    /*public void addIdEmployee(Integer id){
        idEmployeesList.add(id);
    }*/

    /*public List<Integer> getIdEmployeesList() {
        return Arrays.stream(getIdEmployeesIntArray()).boxed().collect(Collectors.toList());
    }*/

    /*private int[] getIdEmployeesIntArray(){
        List<Integer> tempList = new ArrayList<>();
        for (String item: idEmployees.split(DEFAULT_SPLIT_REGISTER)) {
            tempList.add(Integer.parseInt(item));
        }
        return tempList.stream().mapToInt(i -> i).toArray();
    }*/

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

    public void setDateCreation(String dateCreation) {
        try {
            String[] date = dateCreation.split(DEFAULT_DATE_SPLIT_CHAR);
            this.dateCreation = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public int getIdParentDepartment() {
        return idParentDepartment;
    }

    public void setIdParentDepartment(int idParentDepartment) {
        this.idParentDepartment = idParentDepartment;
    }
}