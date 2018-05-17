package organizational.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Employee;
import organizational.service.EmployeeDAO;
import organizational.service.ServiceEmployee;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RestControllerEmployee {

    @Autowired
    private ServiceEmployee serviceEmployee;


    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return serviceEmployee.getAllEmployee();
    }

    @GetMapping("/addEmployee")
    public int addEmployee(Employee employee){
        return serviceEmployee.insert(employee);
    }
}
