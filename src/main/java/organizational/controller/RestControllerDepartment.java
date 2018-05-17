package organizational.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Department;
import organizational.service.ServiceDepartment;
import organizational.service.exception.DeleteDepartmentException;
import organizational.service.exception.UniqueException;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class RestControllerDepartment {

    @Autowired
    private ServiceDepartment serviceDepartment;


    @GetMapping("allDepartments")
    public List<Department> getAllEmployee() {
        return serviceDepartment.getAllDepartment();
    }

    @GetMapping("addDepartment")
    public int addEmployee(Department department) throws UniqueException {
        return serviceDepartment.insert(department);
    }

    @GetMapping("updateNameDepartment")
    public void updateName(Department department) throws UniqueException {
        serviceDepartment.updateName(department);
    }

    @GetMapping("deleteDepartment")
    public void deleteDepartment(int id) throws DeleteDepartmentException {
        serviceDepartment.delete(id);
    }

    @GetMapping("infoDepartment")
    public String infoDepartment(int id) {
        return serviceDepartment.getInfoByDepartment(id);
    }
}
