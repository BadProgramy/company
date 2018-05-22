package organizational.dao.employee;

import org.apache.ibatis.annotations.Mapper;
import organizational.dao.exception.CorrectDataException;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;

import java.util.List;

@Mapper
public interface DAOEmployee {
    int insert(Employee employee) throws CorrectDataException;
    void update(int id, Employee employee) throws CorrectDataException;
    List<Employee> getAllEmployee();
    List<Employee> getEmployeesByIdDepartment(int idDepartment);
    void layoffEmployee(int id, String dateLayoff) throws DataFormatException;
    Employee findEmployeeById(int id);
    void moveEmployeeInDepartment(int id, int idDepartment);
    void moveAllEmployeesInDepartment(int idCurrentDepartment, int idNextDepartment);
    Employee getHeadEmployeeByEmployee(int id);
    Employee findEmployee(String firstName, String secondName);
}
