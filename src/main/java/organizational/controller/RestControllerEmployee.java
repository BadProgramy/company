package organizational.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Employee;
import organizational.service.ServiceEmployee;

import java.time.LocalDate;
import java.util.List;

@RestController
public class RestControllerEmployee {

    @Autowired
    private ServiceEmployee serviceEmployee;

    @GetMapping("/persons")
    public List<Employee> getAllEmployee() throws Exception {
        return serviceEmployee.getAllEmployee();
    }

    @GetMapping("/get")
    public int addEmployee(Employee employee) throws Exception {
        //Employee employee = new Employee("1", "2", "ж", LocalDate.now(), "2", "2", LocalDate.now(), 2, false);
        //employee.setIdPost(1);
        return serviceEmployee.insert(employee);
    }
}
