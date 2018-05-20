package organizational.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import organizational.model.Department;
import organizational.model.Event;
import organizational.service.ServiceDepartment;
import organizational.service.exception.DeleteDepartmentException;
import organizational.service.exception.UniqueException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class RestControllerDepartment {

    @Autowired
    private ServiceDepartment serviceDepartment;


    @GetMapping("allDepartments")//++
    public List<Department> getAllEmployee() {
        return serviceDepartment.getAllDepartment();
    }

    @GetMapping("addDepartment")//++
    public int addEmployee(Department department) throws UniqueException {
        return serviceDepartment.insert(department);
    }

    @GetMapping("updateNameDepartment")//++
    public void updateName(Department department) throws UniqueException {
        serviceDepartment.updateName(department);
    }

    @GetMapping("delete")//++
    public void deleteDepartment(int id) throws DeleteDepartmentException {
        serviceDepartment.delete(id);
    }

    @GetMapping("info")//++
    public Map<String,Object> infoDepartment(int id) {
        return serviceDepartment.getInfoByDepartment(id);
    }

    @GetMapping("subordinatedDepartments")//++
    public List<Department> getSubordinatedDepartments(int id){
        return serviceDepartment.getSubordinatedDepartments(id);
    }

    @GetMapping("allSubordinatedDepartments")//++
    public List<Department> getAllSubordinatedDepartments(int id) {
        return serviceDepartment.getAllSubordinatedDepartments(id);
    }

    @GetMapping("standingDepartment")//++
    public List<Department> getByIdAboveStandingDepartment(int id) {
        return serviceDepartment.getByIdAboveStandingDepartments(id);
    }

    @GetMapping("moveDepartment")//++
    public void updateIdParentDepartmentById(Department department) {
        serviceDepartment.moveDepartment(department);
    }

    @GetMapping("findDepartmentByName")//++
    public Department findDepartmentByName(String name) {
        return serviceDepartment.findDepartmentByName(name);
    }

    @GetMapping("salaryAllEmployeesByDepartment")//++
    public float getSalaryAllEmployeesByDepartment(int id) {
        return serviceDepartment.getSalaryAllEmployeesByDepartment(id);
    }

    @GetMapping("events")//++
    public List<Event> getEvents() {
        return serviceDepartment.getAllEvents();
    }
}
