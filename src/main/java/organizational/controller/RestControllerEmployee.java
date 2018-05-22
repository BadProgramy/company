package organizational.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Employee;
import organizational.model.exception.DataFormatException;
import organizational.service.ServiceEmployee;
import organizational.dao.exception.CorrectDataException;
import java.util.List;

@RestController

@RequestMapping(path = "organization/employees/")
public class RestControllerEmployee {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @RequestMapping(value = "getAll",method = RequestMethod.POST)//++
    @ApiOperation("Get all employees")
    //@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Employee.class)})
    public List<Employee> getAllEmployee(){
        return serviceEmployee.getAllEmployee();
    }

    @RequestMapping(value = "addEmployee",method = RequestMethod.GET)//++
    @ApiOperation("To add the employee")
    public int addEmployee(Employee employee) throws CorrectDataException {
        return serviceEmployee.insert(employee);
    }

    @RequestMapping(value = "employeesByIdDepartment",method = RequestMethod.GET)//++
    @ApiOperation("Will receive all employees from department")
    public List<Employee> getEmployeesByIdDepartment(int idDepartment) {
        return serviceEmployee.getEmployeesByIdDepartment(idDepartment);
    }

    @RequestMapping(value = "updateEmployee",method = RequestMethod.GET)//++
    @ApiOperation("To edit the employee")
    public void updateEmployee(int id, Employee employee) throws CorrectDataException {
        serviceEmployee.update(id,employee);
    }

    @RequestMapping(value = "layoffEmployee",method = RequestMethod.GET)//++
    @ApiOperation("To dismiss the employee")
    public void layoffEmployee(int id, String layoffDate) throws DataFormatException {
        serviceEmployee.layoffEmployee(id, layoffDate);
    }

    @RequestMapping(value = "findEmployee",method = RequestMethod.GET)//++
    @ApiOperation("To find the employee on his identifier")
    public Employee findEmployeeById(int id) {
        return serviceEmployee.findEmployeeById(id);
    }

    @RequestMapping(value = "moveEmployeeInDepartment",method = RequestMethod.GET)//++
    @ApiOperation("The translation of the employee from one department in another")
    public void moveEmployeeInDepartment(int id, int idDepartment) {
        serviceEmployee.moveEmployeeInDepartment(id, idDepartment);
    }

    @RequestMapping(value = "moveAllEmployeesInDepartment",method = RequestMethod.GET)//++
    @ApiOperation("Transfer of all staff of department to other department")
    public void moveAllEmployeesInDepartment(int idCurrentDepartment, int idNextDepartment){
        serviceEmployee.moveAllEmployeesInDepartment(idCurrentDepartment,idNextDepartment);
    }

    @RequestMapping(value = "headEmployeeByEmployee",method = RequestMethod.GET)//++
    @ApiOperation("To receive the head of this employee")
    public Employee getHeadEmployeeByEmployee(int id) {
        return serviceEmployee.getHeadEmployeeByEmployee(id);
    }

    @RequestMapping(value = "employeeByName",method = RequestMethod.GET)//++
    @ApiOperation("To receive the employee on his initial")
    public Employee getEmployeeByName(String firstName, String secondName) {
        return serviceEmployee.findEmployee(firstName,secondName);
    }
}
