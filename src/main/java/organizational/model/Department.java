package organizational.model;

import io.swagger.annotations.ApiParam;
import organizational.model.exception.DataFormatException;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Department {
    @ApiParam(value = "Identifier department",hidden = true)
    private int id;
    @ApiParam(value = "Name department",required = true)
    private String name;
    @ApiParam(value = "Identifier parent department")
    private int idParentDepartment;
    //В условиях не было сказано что дату создания могли вводить сами или же берется текущая дата
    //Я сделал именно так что дату мы можем ввести сами
    @ApiParam(value = "Date creation department", required = true)
    private String dateCreation;
    private static final String DEFAULT_DATE_SPLIT_CHAR = "-";

    public Department() {
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

    public String getDateCreation() throws DataFormatException {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) throws DataFormatException {
        try {
            String[] date = dateCreation.split(DEFAULT_DATE_SPLIT_CHAR);
            this.dateCreation = LocalDate.of(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2])).toString();
        } catch (Exception ex){
            throw new DataFormatException();
        }
    }

    public int getIdParentDepartment() {
        return idParentDepartment;
    }

    public void setIdParentDepartment(int idParentDepartment) {
        this.idParentDepartment = idParentDepartment;
    }
}