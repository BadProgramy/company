package organizational.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;
import organizational.service.ServiceEmployee;
import organizational.service.exception.CorrectDataException;

import java.util.List;

@RestController
@RequestMapping("employees")
public class RestControllerEmployee {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @GetMapping("getAll")//++
    public List<Employee> getAllEmployee(){
        return serviceEmployee.getAllEmployee();
    }

    @GetMapping("addEmployee")//++
    public int addEmployee(Employee employee) throws CorrectDataException {
        return serviceEmployee.insert(employee);
    }

    @GetMapping("employeesByIdDepartment")//++
    public List<Employee> getEmployeesByIdDepartment(int idDepartment) {
        return serviceEmployee.getEmployeesByIdDepartment(idDepartment);
    }

    @GetMapping("updateEmployee")//++
    public void updateEmployee(Employee employee) {
        serviceEmployee.update(employee);
    }

    @GetMapping("layoffEmployee")//++
    public void layoffEmployee(int id, String layoff) throws DataFormatException {
        serviceEmployee.layoffEmployee(id, layoff);
    }

    @GetMapping("findEmployee")//++
    public Employee findEmployeeById(int id) {
        return serviceEmployee.findEmployeeById(id);
    }

    @GetMapping("moveEmployeeInDepartment")//++
    public void moveEmployeeInDepartment(Employee employee) {
        serviceEmployee.moveEmployeeInDepartment(employee);
    }

    @GetMapping("moveAllEmployeesInDepartment")//++
    public void moveAllEmployeesInDepartment(int idCurrentDepartment, int idNextDepartment){
        serviceEmployee.moveAllEmployeesInDepartment(idCurrentDepartment,idNextDepartment);
    }

    @GetMapping("headEmployeeByEmployee")//++
    public Employee getHeadEmployeeByEmployee(int id) {
        return serviceEmployee.getHeadEmployeeByEmployee(id);
    }

    @GetMapping("employeeByName")//++
    public Employee getEmployeeByName(String firstName, String secondName) {
        return serviceEmployee.findEmployee(firstName,secondName);
    }
}
